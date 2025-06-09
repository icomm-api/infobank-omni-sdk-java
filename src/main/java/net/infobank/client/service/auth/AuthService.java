package net.infobank.client.service.auth;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.BasicResponseHandler;

import net.infobank.client.core.HttpConfig;
import net.infobank.client.core.Util;
import net.infobank.client.core.exception.ErrorResponseException;
import net.infobank.client.data.response.AuthResponse;

/**
 * AuthService 클래스는 응용 프로그램 내에서 인증 작업을 처리하는 것을 담당합니다.
 * 이에는 인증 토큰 관리, 요청 초기화, 그리고 HTTP 클라이언트 상호작용을 포함합니다.
 * 이 클래스는 HTTP 작업을 처리하기 위해 Apache HttpComponents 라이브러리를 사용하고, 로깅을 위해 SLF4J를 사용합니다.
 *
 * @author OpenAI
 * @version 1.0
 * @since 2023-07-13
 */
public class AuthService {

    /**
     * 인증 토큰 경로를 나타내는 상수입니다.
     */
    private final String PATH = "/v1/auth/token";

    /**
     * HTTP 응답을 처리하는 기본 응답 핸들러입니다.
     */
    private final BasicResponseHandler basicResponseHandler = new BasicResponseHandler();

    /**
     * HTTP 설정 정보를 관리하는 객체입니다.
     */
    private HttpConfig httpConfig;

    /**
     * HTTP 클라이언트 객체를 관리하는 변수입니다.
     */
    private HttpClient httpClient;

    /**
     * 클라이언트 ID를 저장하는 변수입니다.
     */
    private String clientId;

    /**
     * 클라이언트 비밀번호를 저장하는 변수입니다.
     */
    private String password;

    /**
     * 인증 토큰을 저장하는 변수입니다. 토큰은 정적으로 저장되며 필요에 따라 갱신됩니다.
     */
    private static String token;

    /**
     * 인증 토큰의 만료 시간을 저장하는 변수입니다.
     */
    private static LocalDateTime expireTime;

    /**
     * 새로운 AuthService 객체를 생성합니다.
     *
     * @param httpConfig HTTP 구성 객체입니다.
     * @param httpClient HTTP 클라이언트 객체입니다.
     * @param clientId   클라이언트 식별자입니다.
     * @param password   클라이언트 비밀번호입니다.
     */
    public AuthService(HttpConfig httpConfig, HttpClient httpClient, String clientId, String password) {
        this.httpConfig = httpConfig;
        this.httpClient = httpClient;
        this.clientId = clientId;
        this.password = password;
    }

    /**
     * 인증 헤더를 포함한 RequestBuilder 를 초기화합니다. 이 헤더에는 베어러 토큰이 포함되어 있습니다.
     * 토큰이 존재하지 않거나 만료된 경우 새 토큰을 가져오려고 시도합니다.
     *
     * @param request 초기화할 요청입니다.
     * @return 추가된 인증 헤더가 있는 RequestBuilder 객체를 반환합니다.
     */
    public RequestBuilder init(RequestBuilder request) throws IOException {
        if (token == null || (expireTime != null && expireTime.isBefore(LocalDateTime.now()))) getToken();

        return request.addHeader("Authorization", "Bearer " + token);
    }

    /**
     * HTTP 클라이언트 객체를 반환합니다. 이 객체가 존재하지 않는 경우 새로운 객체를 생성하려고 시도합니다.
     *
     * @return HttpClient 객체를 반환합니다.
     */
    public HttpClient getHttpClient() {
        if (httpClient == null) {
            httpClient = Util.createHttpClient(httpConfig);
        }
        return httpClient;
    }

    /**
     * 인증 엔드포인트에 POST 요청을 보내 새로운 인증 토큰을 가져옵니다.
     * 토큰과 그 만료 시간은 후속 사용을 위해 정적으로 저장됩니다.
     *
     * @return 인증 토큰과 다른 정보를 포함한 AuthResponse 객체를 반환합니다.
     */
    public AuthResponse getToken() throws IOException {
        HttpUriRequest httpRequest = RequestBuilder
                .post(httpConfig.getBaseUrl() + PATH)
                .setHeader("X-IB-Client-Id", clientId)
                .setHeader("X-IB-Client-Passwd", password)
                .setHeader("Accept", "application/json")
                .setHeader("User-Agent", httpConfig.getUserAgent())
                .setCharset(StandardCharsets.UTF_8)
                .build();

        AuthResponse authRes = new AuthResponse();
        HttpResponse response = getHttpClient().execute(httpRequest);

        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode == 200) {
            authRes = AuthResponse.fromJson(basicResponseHandler.handleResponse(response));
            token = authRes.getData().getToken();
            expireTime = LocalDateTime.now().plus(23, ChronoUnit.HOURS);
        }
        else {
            throw ErrorResponseException.fromHttpResponse(response);
        }
            
        return authRes;
    }
}

package net.infobank.client.core;

import java.io.IOException;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.RequestBuilder;

import net.infobank.client.service.auth.AuthService;

/**
 * HttpWrapper 클래스는 HTTP 통신을 지원하는 기능들을 제공하는 래퍼 클래스입니다.
 * 이 클래스는 HTTP 클라이언트, HttpConfig, 그리고 AuthService 객체들을 멤버 변수로 가지고 있습니다.
 *
 * @author OpenAI
 * @version 1.0
 * @since 2023-07-13
 */
public class HttpWrapper {

    /**
     * HttpClient 인스턴스.
     * Http 통신을 위한 클라이언트입니다.
     */
    private HttpClient httpClient;

    /**
     * HttpConfig 인스턴스.
     * Http 설정 정보를 가지고 있는 객체입니다.
     */
    private HttpConfig httpConfig;

    /**
     * AuthService 인스턴스.
     * 인증 정보 및 인증 관련 기능을 담당하는 객체입니다.
     */
    private AuthService authService;

    /**
     * HttpWrapper 생성자.
     * HttpConfig 와 AuthService 인스턴스를 입력받아 HttpWrapper 객체를 생성합니다.
     *
     * @param httpConfig  HTTP 작업 설정을 관리하는 HttpConfig 객체입니다.
     * @param authService 인증 관련 작업을 처리하는 AuthService 객체입니다.
     */
    public HttpWrapper(HttpConfig httpConfig, AuthService authService) {
        this.httpConfig = httpConfig;
        this.authService = authService;
    }

    /**
     * HttpClient 인스턴스를 반환합니다.
     * 만약 HttpClient 인스턴스가 아직 초기화되지 않았다면, HttpConfig를 통해 HttpClient 인스턴스를 생성하여 반환합니다.
     *
     * @return HttpClient 인스턴스를 반환합니다.
     */
    public HttpClient getHttpClient() {
        if (httpClient == null) {
            httpClient = Util.createHttpClient(httpConfig);
        }
        return httpClient;
    }

    /**
     * HttpClient 인스턴스를 설정합니다.
     * 외부에서 생성된 HttpClient 인스턴스를 현재 클래스의 httpClient 멤버 변수로 설정합니다.
     *
     * @param httpClient 외부에서 생성된 HttpClient 인스턴스입니다.
     */
    public void setHttpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    /**
     * 주어진 HTTP 요청에 인증 정보를 적용합니다.
     * AuthService 인스턴스를 이용하여 HTTP 요청에 필요한 인증 정보를 포함시킵니다.
     *
     * @param request 인증 정보를 적용할 HTTP 요청 객체입니다.
     * @return 인증 정보가 적용된 HTTP 요청 객체를 반환합니다.
     */
    public RequestBuilder applyAuth(RequestBuilder request) throws IOException {
        return authService.init(request);
    }

    /**
     * HttpConfig 인스턴스를 반환합니다.
     * 현재 객체의 HTTP 설정 정보를 담고 있는 HttpConfig 인스턴스를 반환합니다.
     *
     * @return HttpConfig 인스턴스를 반환합니다.
     */
    public HttpConfig getHttpConfig() {
        return httpConfig;
    }

    /**
     * AuthService 인스턴스를 반환합니다.
     * 현재 객체의 인증 정보 및 인증 관련 기능을 담당하는 AuthService 인스턴스를 반환합니다.
     *
     * @return AuthService 인스턴스를 반환합니다.
     */
    public AuthService getAuthService() {
        return authService;
    }

    /**
     * AuthService 인스턴스를 설정합니다.
     * 외부에서 생성된 AuthService 인스턴스를 현재 클래스의 authService 멤버 변수로 설정합니다.
     *
     * @param authService 외부에서 생성된 AuthService 인스턴스입니다.
     */
    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

}

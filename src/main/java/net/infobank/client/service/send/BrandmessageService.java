package net.infobank.client.service.send;

import net.infobank.client.core.AbstractMethod;
import net.infobank.client.core.HttpWrapper;
import net.infobank.client.core.exception.ErrorResponseException;
import net.infobank.client.data.request.BrandmessageRequest;
import net.infobank.client.data.request.FriendtalkRequest;
import net.infobank.client.data.response.BrandmessageResponse;
import net.infobank.client.data.response.FriendtalkResponse;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * BrandmessageService 클래스는 브랜드메세지 서비스와 관련된 작업을 처리합니다.
 * 이 클래스는 AbstractMethod를 확장하여 친구톡 요청을 처리하고 응답을 반환합니다.
 *
 * @author OpenAI
 * @version 1.0
 * @since 2023-07-13
 */
public class BrandmessageService extends AbstractMethod<BrandmessageRequest, BrandmessageResponse> {

    /**
     * 친구톡 서비스의 경로를 지정하는 상수입니다.
     */
    private static final String PATH = "/v1/send/brandmessage";

    /**
     * HttpWrapper 객체를 사용하여 brandmessage 객체를 생성합니다.
     *
     * @param httpWrapper HTTP 작업을 처리하는 데 사용되는 HttpWrapper 객체입니다.
     */
    public BrandmessageService(HttpWrapper httpWrapper) {
        super(httpWrapper);
    }

    /**
     * 주어진 브랜드메세지 요청을 바탕으로 HTTP 요청을 생성합니다.
     *
     * @param friendtalk 친구톡 요청을 포함하는 FriendtalkRequest 객체입니다.
     * @return 생성된 HTTP 요청을 반환합니다.
     * @throws UnsupportedEncodingException 지원하지 않는 인코딩을 사용하려는 경우 발생하는 예외입니다.
     */
    @Override
    public RequestBuilder makeRequest(BrandmessageRequest friendtalk) throws UnsupportedEncodingException {
        RequestBuilder request = RequestBuilder
                .post(httpWrapper.getHttpConfig().getBaseUrl() + PATH)
                .setHeader("Content-Type", "application/json")
                .setHeader("Accept", "application/json")
                .setEntity(new StringEntity(friendtalk.toJson(), ContentType.APPLICATION_JSON));
        return request;
    }

    /**
     * 주어진 HTTP 응답을 바탕으로 브랜드메세지 응답을 파싱합니다.
     *
     * @param response HTTP 응답을 포함하는 HttpResponse 객체입니다.
     * @return 파싱된 친구톡 응답을 반환합니다.
     * @throws IOException 읽기/쓰기 오류가 발생하는 경우 발생하는 예외입니다.
     */
    @Override
    public BrandmessageResponse parseResponse(HttpResponse response) throws IOException {
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode == 200) {
            return BrandmessageResponse.fromJson(basicResponseHandler.handleResponse(response));
        }
        else {
            throw ErrorResponseException.fromHttpResponse(response);
        }
    }

}

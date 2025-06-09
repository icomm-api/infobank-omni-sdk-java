package net.infobank.client.service.send;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;

import net.infobank.client.core.AbstractMethod;
import net.infobank.client.core.HttpWrapper;
import net.infobank.client.core.exception.ErrorResponseException;
import net.infobank.client.data.request.AlimtalkRequest;
import net.infobank.client.data.response.AlimtalkResponse;

/**
 * AlimtalkService 클래스는 알림톡 서비스와 관련된 작업을 처리합니다.
 * 이 클래스는 AbstractMethod 를 확장하여 알림톡 요청을 처리하고 응답을 반환합니다.
 *
 * @author OpenAI
 * @version 1.0
 * @since 2023-07-13
 */
public class AlimtalkService extends AbstractMethod<AlimtalkRequest, AlimtalkResponse> {

    /**
     * 알림톡 서비스의 경로를 지정하는 상수입니다.
     */
    private static final String PATH = "/v1/send/alimtalk";

    /**
     * HttpWrapper 객체를 사용하여 AlimtalkService 객체를 생성합니다.
     *
     * @param httpWrapper HTTP 작업을 처리하는 데 사용되는 HttpWrapper 객체입니다.
     */
    public AlimtalkService(HttpWrapper httpWrapper) {
        super(httpWrapper);
    }

    /**
     * 주어진 알림톡 요청을 바탕으로 HTTP 요청을 생성합니다.
     *
     * @param alimtalk 알림톡 요청을 포함하는 AlimtalkRequest 객체입니다.
     * @return 생성된 HTTP 요청을 반환합니다.
     * @throws UnsupportedEncodingException 지원하지 않는 인코딩을 사용하려는 경우 발생하는 예외입니다.
     */
    @Override
    public RequestBuilder makeRequest(AlimtalkRequest alimtalk) throws UnsupportedEncodingException {
        RequestBuilder request = RequestBuilder
                .post(httpWrapper.getHttpConfig().getBaseUrl() + PATH)
                .setHeader("Content-Type", "application/json")
                .setHeader("Accept", "application/json")
                .setEntity(new StringEntity(alimtalk.toJson(), ContentType.APPLICATION_JSON));
        return request;
    }

    /**
     * 주어진 HTTP 응답을 바탕으로 알림톡 응답을 파싱합니다.
     *
     * @param response HTTP 응답을 포함하는 HttpResponse 객체입니다.
     * @return 파싱된 알림톡 응답을 반환합니다.
     * @throws IOException 읽기/쓰기 오류가 발생하는 경우 발생하는 예외입니다.
     */
    @Override
    public AlimtalkResponse parseResponse(HttpResponse response) throws IOException {
        int statusCode = response.getStatusLine().getStatusCode();
		if (statusCode == 200) {
			return AlimtalkResponse.fromJson(basicResponseHandler.handleResponse(response));
		}
		else {
			throw ErrorResponseException.fromHttpResponse(response);
		}
    }

}

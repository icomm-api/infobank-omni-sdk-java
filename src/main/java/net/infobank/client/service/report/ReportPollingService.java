package net.infobank.client.service.report;

import net.infobank.client.core.AbstractMethod;
import net.infobank.client.core.HttpWrapper;
import net.infobank.client.core.exception.ErrorResponseException;
import net.infobank.client.data.request.ReportPollingRequest;
import net.infobank.client.data.response.ReportPollingResponse;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.RequestBuilder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * ReportPollingService 클래스는 보고서 풀링 서비스와 관련된 작업을 처리합니다.
 * 이 클래스는 AbstractMethod를 확장하여 보고서 풀링 요청을 처리하고 응답을 반환합니다.
 *
 * @author OpenAI
 * @version 1.0
 * @since 2023-07-13
 */
public class ReportPollingService extends AbstractMethod<ReportPollingRequest, ReportPollingResponse> {

    /**
     * 보고서 풀링 서비스의 경로를 지정하는 상수입니다.
     */
    private static final String PATH = "/v1/report/polling";

    /**
     * HttpWrapper 객체를 사용하여 ReportPollingService 객체를 생성합니다.
     *
     * @param httpWrapper HTTP 작업을 처리하는 데 사용되는 HttpWrapper 객체입니다.
     */
    public ReportPollingService(HttpWrapper httpWrapper) {
        super(httpWrapper);
    }

    /**
     * 주어진 보고서 풀링 요청을 바탕으로 HTTP 요청을 생성합니다.
     *
     * @param report 보고서 풀링 요청을 포함하는 ReportPollingRequest 객체입니다.
     * @return 생성된 HTTP 요청을 반환합니다.
     * @throws UnsupportedEncodingException 지원하지 않는 인코딩을 사용하려는 경우 발생하는 예외입니다.
     */
    @Override
    public RequestBuilder makeRequest(ReportPollingRequest report) throws UnsupportedEncodingException {

        String method = report.getMethod();

        RequestBuilder request = null;

        switch (method) {
            case "GET":
                request = RequestBuilder
                        .get(httpWrapper.getHttpConfig().getBaseUrl() + PATH)
                        .setHeader("Accept", "application/json");
                break;
            case "DELETE":
                request = RequestBuilder
                        .delete(httpWrapper.getHttpConfig().getBaseUrl() + PATH + "/" + report.getReportId())
                        .setHeader("Accept", "application/json");
                break;
            default:
                // etc
                break;
        }

        return request;
    }

    /**
     * 주어진 HTTP 응답을 바탕으로 보고서 풀링 응답을 파싱합니다.
     *
     * @param response HTTP 응답을 포함하는 HttpResponse 객체입니다.
     * @return 파싱된 보고서 풀링 응답을 반환합니다.
     * @throws IOException 읽기/쓰기 오류가 발생하는 경우 발생하는 예외입니다.
     */
    @Override
    public ReportPollingResponse parseResponse(HttpResponse response) throws IOException {
        int statusCode = response.getStatusLine().getStatusCode();
		if (statusCode == 200) {
			return ReportPollingResponse.fromJson(basicResponseHandler.handleResponse(response));
		}
		else {
			throw ErrorResponseException.fromHttpResponse(response);
		}
    }

}

package net.infobank.client.core;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.SocketConfig;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

/**
 * Util 클래스는 HTTP 통신을 위한 유틸리티 메서드들을 제공하는 클래스입니다.
 * HttpClient 객체 생성, URL 정리, 응답 로깅 등의 기능을 제공합니다.
 *
 * @author OpenAI
 * @version 1.0
 * @since 2023-07-13
 */
public class Util {

    /**
     * 주어진 HttpConfig를 기반으로 HttpClient 객체를 생성하는 메서드입니다.
     *
     * @param httpConfig HttpClient 객체 생성에 필요한 설정 정보를 담은 HttpConfig 객체입니다.
     * @return 생성된 HttpClient 객체를 반환합니다.
     */
    public static HttpClient createHttpClient(HttpConfig httpConfig) {
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setDefaultMaxPerRoute(100);
        connectionManager.setMaxTotal(100);
        connectionManager.setDefaultConnectionConfig(ConnectionConfig.custom().setCharset(StandardCharsets.UTF_8).build());
        connectionManager.setDefaultSocketConfig(SocketConfig.custom().setTcpNoDelay(true).build());

        RequestConfig requestConfig = RequestConfig.custom().build();

        return HttpClientBuilder.create()
                .setConnectionManager(connectionManager)
                .setUserAgent(httpConfig.getUserAgent())
                .setDefaultRequestConfig(requestConfig)
                .useSystemProperties()
                .build();
    }

    /**
     * 주어진 URL 문자열의 뒤쪽에 있는 '/'를 제거하는 메서드입니다.
     *
     * @param url 정리할 URL 문자열입니다.
     * @return 정리된 URL 문자열을 반환합니다.
     */
    public static String sanitizeUri(String url) {
        if (url != null && url.endsWith("/")) {
            return url.substring(0, url.length() - 1);
        }
        return url;
    }

    /**
     * HttpResponse 객체를 로깅하기 위한 메서드입니다.
     * 로깅 내용에는 응답 상태 코드, 상태 라인, 응답 본문이 포함됩니다.
     *
     * @param response 로깅할 HttpResponse 객체입니다.
     * @return 생성된 로그 문자열을 반환합니다.
     * @throws IOException 응답 본문을 문자열로 변환하는 도중 발생할 수 있는 예외입니다.
     */
    public static String logResponse(HttpResponse response) throws IOException {
        Objects.requireNonNull(response, "Response shouldn't be null");
        StringBuilder log = new StringBuilder();
        String responseBody = response.getEntity() != null ? EntityUtils.toString(response.getEntity()) : "";
        int statusCode = response.getStatusLine().getStatusCode();
        String statusLine = response.getStatusLine().getReasonPhrase();

        log.append("status_code: ")
                .append(statusCode)
                .append(", ")
                .append("status_line: ")
                .append(statusLine)
                .append(", ")
                .append(" body: ")
                .append(responseBody);

        response.setEntity(new StringEntity(responseBody, ContentType.get(response.getEntity())));

        return log.toString();
    }
}

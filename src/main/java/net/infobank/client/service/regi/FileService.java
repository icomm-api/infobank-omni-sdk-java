package net.infobank.client.service.regi;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.tika.Tika;

import net.infobank.client.core.AbstractMethod;
import net.infobank.client.core.HttpWrapper;
import net.infobank.client.core.exception.ErrorResponseException;
import net.infobank.client.data.request.FileRequest;
import net.infobank.client.data.response.FileResponse;

/**
 * FileService 클래스는 파일 서비스와 관련된 작업을 처리합니다.
 * 이 클래스는 AbstractMethod 를 확장하여 파일 요청을 처리하고 응답을 반환합니다.
 *
 * @author OpenAI
 * @version 1.0
 * @since 2023-07-13
 */
public class FileService extends AbstractMethod<FileRequest, FileResponse> {

    /**
     * 파일 서비스의 경로를 지정하는 상수입니다.
     */
    private static final String PATH = "/v1/file";

    /**
     * Tika 객체는 파일의 MIME 타입을 감지하는데 사용됩니다.
     */
    private final Tika tika = new Tika();

    /**
     * HttpWrapper 객체를 사용하여 FileService 객체를 생성합니다.
     *
     * @param httpWrapper HTTP 작업을 처리하는 데 사용되는 HttpWrapper 객체입니다.
     */
    public FileService(HttpWrapper httpWrapper) {
        super(httpWrapper);
    }

    /**
     * 주어진 파일 요청을 바탕으로 HTTP 요청을 생성합니다.
     *
     * @param file 파일 요청을 포함하는 FileRequest 객체입니다.
     * @return 생성된 HTTP 요청을 반환합니다.
     * @throws UnsupportedEncodingException 지원하지 않는 인코딩을 사용하려는 경우 발생하는 예외입니다.
     */
    @Override
    public RequestBuilder makeRequest(FileRequest file) throws UnsupportedEncodingException {
        String subPath = "/" + file.getServiceType().toString();

        if(file.getMsgType()!=null){
            subPath+="/"+file.getMsgType();
        }


        if(file.getSubType()!=null){
            subPath+="/"+file.getSubType();
        }

        RequestBuilder request;

        try {
            String mimeType = tika.detect(file.getFile());
            ContentType contentType = ContentType.create(mimeType == null ? "application/octet-stream" : mimeType);
            request = RequestBuilder
                    .post(httpWrapper.getHttpConfig().getBaseUrl() + PATH + subPath)
                    .setHeader("Accept", "application/json")
                    .setEntity(MultipartEntityBuilder.create()
                            .addPart("file", new FileBody(file.getFile(), contentType))
                            .build());
        } catch (IOException e) {
            throw new UnsupportedEncodingException();
        }
        return request;
    }

    /**
     * 주어진 HTTP 응답을 바탕으로 파일 응답을 파싱합니다.
     *
     * @param response HTTP 응답을 포함하는 HttpResponse 객체입니다.
     * @return 파싱된 파일 응답을 반환합니다.
     * @throws IOException 읽기/쓰기 오류가 발생하는 경우 발생하는 예외입니다.
     */
    @Override
    public FileResponse parseResponse(HttpResponse response) throws IOException {
        int statusCode = response.getStatusLine().getStatusCode();
		if (statusCode == 200) {
			return FileResponse.fromJson(basicResponseHandler.handleResponse(response));
		}
		else {
			throw ErrorResponseException.fromHttpResponse(response);
		}
    }

}

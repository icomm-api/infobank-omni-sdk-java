package net.infobank.client.core.exception;

import java.io.IOException;

import org.apache.http.HttpResponse;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class ErrorResponseException extends ApiResponseException {

	void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	void setReasonPhrase(String reasonPhrase) {
		this.reasonPhrase = reasonPhrase;
	}

	/**
	 * Creates an instance of this class from a JSON payload.
	 *
	 * @param json The JSON string to parse.
	 * @return An instance of this class with all known fields populated from the JSON payload, if present.
	 */
	@JsonCreator
	public static ErrorResponseException fromJson(String json) {
		return fromJson(ErrorResponseException.class, json);
	}

	public static ErrorResponseException fromHttpResponse(HttpResponse response) throws IOException {
		return fromHttpResponse(ErrorResponseException.class, response);
	}
}
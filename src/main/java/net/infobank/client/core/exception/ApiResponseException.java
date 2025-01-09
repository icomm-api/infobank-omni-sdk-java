package net.infobank.client.core.exception;

import java.io.IOException;
import java.util.Objects;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class ApiResponseException extends ClientException {
	protected String code;
	protected String result;
	@JsonIgnore protected int statusCode;
	@JsonIgnore protected String reasonPhrase;

	@JsonProperty("code")
	public String getCode() {
		return code;
	}
	@JsonProperty("result")
	public String getResult() {
		return result;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public String getReasonPhrase() {
		return reasonPhrase;
	}

	@JsonIgnore
	@Override
	public String getMessage() {
		if (statusCode > 0) {
			String message = "HTTP Code:" + statusCode;
			if (reasonPhrase != null) {
				message += "("+reasonPhrase+")";
			}
			if (code != null) {
				message += ", API Code: "+code;
			}
			if (result != null) {
				message += "("+result+")";
			}
			return message;
		}
		else return super.getMessage();
	}

	private static class IgnoreInheritedIntrospector extends JacksonAnnotationIntrospector {
		@Override
		public boolean hasIgnoreMarker(final AnnotatedMember m) {
			return m.getDeclaringClass().equals(Throwable.class) || super.hasIgnoreMarker(m);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ApiResponseException response = (ApiResponseException) o;
		return statusCode == response.statusCode &&
				Objects.equals(code, response.code) &&
				Objects.equals(result, response.result);
	}

	@Override
	public int hashCode() {
		return Objects.hash(code, result, statusCode);
	}

	/**
	 * Generates JSON from this object. Excludes fields inherited from superclasses.
	 *
	 * @return The JSON representation of this response object.
	 */
	public String toJson() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.setAnnotationIntrospector(new IgnoreInheritedIntrospector());
			return mapper.writeValueAsString(this);
		}
		catch (JsonProcessingException e) {
			throw new UnexpectedException("Failed to produce JSON from "+getClass().getSimpleName(), e);
		}
	}

	protected static <E extends ApiResponseException> E fromJson(Class<E> clazz, String json) {
		if (json == null || json.length() < 2) {
			try {
				return clazz.newInstance();
			}
			catch (InstantiationException | IllegalAccessException ex) {
				throw new UnexpectedException(ex);
			}
		}
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(json, clazz);
		}
		catch (IOException ex) {
			throw new UnexpectedException("response:"+ json +" Failed to produce "+clazz.getSimpleName()+" from json.", ex);
		}
	}

	protected static <E extends ApiResponseException> E fromHttpResponse(Class<E> clazz, HttpResponse response) throws IOException {
		String json = "";
		if((response.getEntity().getContentType().getValue()).startsWith("application/json")){
			json = EntityUtils.toString(response.getEntity());
		}
		E crx = fromJson(clazz,json);
		crx.statusCode = response.getStatusLine().getStatusCode();
		crx.reasonPhrase = response.getStatusLine().getReasonPhrase();
		return crx;
	}
}

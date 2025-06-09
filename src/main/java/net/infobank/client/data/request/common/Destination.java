package net.infobank.client.data.request.common;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.infobank.client.core.exception.MissingFieldException;
import net.infobank.client.core.exception.UnexpectedException;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public final class Destination {

	final String to;
	final HashMap<String, String> replaceWords;

	Destination(Builder builder) {
		this.to = builder.to;
		this.replaceWords = builder.replaceWords;
	}

	@JsonProperty("to")
	public String getTo() {
		return to;
	}

	@JsonProperty("replaceWords")
	public HashMap<String, String> getReplaceWords() {
		return replaceWords;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private String to;
		private HashMap<String, String> replaceWords = new HashMap<>();

		Builder() {}

		public Builder to(String to) {
            this.to = to;
            return this;
        }

		public Builder addReplaceWord(String key, String value) {
			replaceWords.put(key, value);
			return this;
		}

		public Destination build() {

			if(to==null){
				throw new MissingFieldException("to field must not be null");
			}

			return new Destination(this);
		}
	}

	public String toJson() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(this);
		}
		catch (JsonProcessingException jpe) {
			throw new UnexpectedException("Failed to produce JSON from "+getClass().getSimpleName()+" object.", jpe);
		}
	}
}

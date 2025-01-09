package net.infobank.client.data.request.common;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.infobank.client.core.exception.MissingFieldException;
import net.infobank.client.core.exception.UnexpectedException;
import net.infobank.client.data.code.FallbackType;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public final class Fallback {

	final String type;
	final String from;
	final String text;
	final String title;
	final List<String> fileKey;
	final String originCID;

	Fallback(Builder builder) {
		this.type = builder.type.toString();
		this.from = builder.from;
		this.text = builder.text;
		this.title = builder.title;
		this.fileKey = builder.fileKey;
		this.originCID = builder.originCID;
	}

	@JsonProperty("type")
	public String getType() {
		return type;
	}

	@JsonProperty("from")
	public String getFrom() {
		return from;
	}

	@JsonProperty("text")
	public String getText() {
		return text;
	}

	@JsonProperty("title")
	public String getTitle() {
		return title;
	}

	@JsonProperty("fileKey")
	public List<String> getFileKey() {
		return fileKey;
	}

	@JsonProperty("originCID")
	public String getOriginCID() {
		return originCID;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private FallbackType type;
		private String from;
		private String text;
		private String title;
		private List<String> fileKey = new ArrayList<>();
		private String originCID;

		Builder() {}

		public Builder type(FallbackType type) {
            this.type = type;
            return this;
        }

		public Builder from(String from) {
            this.from = from;
            return this;
        }

		public Builder text(String text) {
			this.text = text;
			return this;
		}

		public Builder title(String title) {
            this.title = title;
            return this;
        }

		public Builder addFileKey(String fileKey) {
            this.fileKey.add(fileKey);
            return this;
        }

		public Builder originCID(String originCID) {
            this.originCID = originCID;
            return this;
        }

		public Fallback build() {

			if(type==null){
				throw new MissingFieldException("type field must not be null");
			}
			if(text==null){
				throw new MissingFieldException("text field must not be null");
			}
			// if(from==null){
			// 	throw new MissingFieldException("from field must not be null");
			// }

			return new Fallback(this);
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

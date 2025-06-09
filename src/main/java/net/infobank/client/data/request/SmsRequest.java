package net.infobank.client.data.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.infobank.client.core.exception.MissingFieldException;
import net.infobank.client.core.exception.UnexpectedException;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public final class SmsRequest {
	
	final String from;
	final String to;
	final String text;
	final String ref;
	final String originCID;

	SmsRequest(Builder builder) {
		this.from = builder.from;
		this.to = builder.to;
		this.text = builder.text;
		this.ref = builder.ref;
		this.originCID = builder.originCID;
	}

	@JsonProperty("from")
	public String getFrom() {
		return from;
	}

	@JsonProperty("to")
	public String getTo() {
		return to;
	}

	@JsonProperty("text")
	public String getText() {
		return text;
	}

	@JsonProperty("ref")
	public String getRef() {
		return ref;
	}

	@JsonProperty("originCID")
	public String getOriginCID() {
		return originCID;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private String from;
		private String to;
		private String text;
		private String ref;
		private String originCID;

		Builder() {}

		public Builder from(String from) {
            this.from = from;
            return this;
        }

        public Builder to(String to) {
            this.to = to;
            return this;
        }

		public Builder text(String text) {
			this.text = text;
			return this;
		}

		public Builder ref(String ref) {
            this.ref = ref;
            return this;
        }

		public Builder originCID(String originCID) {
            this.originCID = originCID;
            return this;
        }

		public SmsRequest build() {

			if(from==null){
				throw new MissingFieldException("From field must not be null");
			}
			if(to==null){
				throw new MissingFieldException("to field must not be null");
			}
			if(text ==null){
				throw new MissingFieldException("text field must not be null");
			}

			return new SmsRequest(this);
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

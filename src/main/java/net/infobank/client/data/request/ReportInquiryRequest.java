package net.infobank.client.data.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.infobank.client.core.exception.MissingFieldException;
import net.infobank.client.core.exception.UnexpectedException;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public final class ReportInquiryRequest {
	
	final String msgKey;

	ReportInquiryRequest(Builder builder) {

		this.msgKey = builder.msgKey;
	}

	@JsonProperty("msgKey")
	public String getMsgKey() {
		return msgKey;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private String msgKey;

		Builder() {}

		public Builder msgKey(String msgKey) {
            this.msgKey = msgKey;
            return this;
        }

		public ReportInquiryRequest build() {

			if(msgKey==null){
				throw new MissingFieldException("msgKey field must not be null");
			}

			return new ReportInquiryRequest(this);
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

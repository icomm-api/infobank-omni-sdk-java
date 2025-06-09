package net.infobank.client.data.request.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.infobank.client.core.exception.MissingFieldException;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class SmsMessage{

    final SmsData sms;

    @JsonProperty("sms")
    public SmsData getSms() {
        return sms;
    }

    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    private class SmsData {
        String from;
        String text;
        String ttl;
        String originCID;

        @JsonProperty("from")
        public String getFrom() {
            return from;
        }

        @JsonProperty("text")
        public String getText() {
            return text;
        }

        @JsonProperty("ttl")
        public String getTtl() {
            return ttl;
        }

        @JsonProperty("originCID")
        public String getOriginCID() {
            return originCID;
        }

        SmsData(Builder builder) {
            this.from = builder.from;
            this.text = builder.text;
            this.ttl = builder.ttl;
            this.originCID = builder.originCID;
        }
    }

    SmsMessage(Builder builder) {
        sms = new SmsData(builder);        
    }

    public static Builder builder() {
		return new Builder();
	}

    public static class Builder {
        String from;
        String text;
        String ttl;
        String originCID;

        public Builder from(String from) {
            this.from = from;
            return this;
        }

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public Builder ttl(String ttl) {
            this.ttl = ttl;
            return this;
        }

        public Builder originCID(String originCID) {
            this.originCID = originCID;
            return this;
        }

        public SmsMessage build() {

            if(from==null){
				throw new MissingFieldException("from field must not be null");
			}
            if(text==null){
				throw new MissingFieldException("text field must not be null");
			}
            
            return new SmsMessage(this);
        }
    }
}
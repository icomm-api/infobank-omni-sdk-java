package net.infobank.client.data.request.message;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.infobank.client.core.exception.MissingFieldException;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY )
public class MmsMessage{

    final MmsData mms;

    @JsonProperty("mms")
    public MmsData getMms() {
        return mms;
    }

    MmsMessage(Builder builder) {
        mms = new MmsData(builder);        
    }

    @JsonInclude(value = JsonInclude.Include.NON_EMPTY )
    private class MmsData {
        String from;
        List<String> fileKey;
        String title;
        String text;
        String ttl;
        String originCID;

        MmsData(Builder builder) {
            from = builder.from;
            fileKey = builder.fileKey;
            title = builder.title;
            text = builder.text;
            ttl = builder.ttl;
            originCID = builder.originCID;
        }

        @JsonProperty("from")
        public String getFrom() {
            return from;
        }

        @JsonProperty("fileKey")
        public List<String> getFileKey() {
            return fileKey;
        }

        @JsonProperty("title")
        public String getTitle() {
            return title;
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
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        String from;
        List<String> fileKey = new ArrayList<>();
        String title;
        String text;
        String ttl;
        String originCID;

        public Builder from(String from) {
            this.from = from;
            return this;
        }

        public Builder addFileKey(String fileKey) {
            this.fileKey.add(fileKey);
            return this;
        }

        public Builder title(String title) {
            this.title = title;
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

        public MmsMessage build() {

            if(from==null){
				throw new MissingFieldException("from field must not be null");
			}
            if(text==null){
				throw new MissingFieldException("text field must not be null");
			}

            return new MmsMessage(this);
        }
    }
}
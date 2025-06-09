package net.infobank.client.data.request.kakao.carousel;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.infobank.client.data.request.kakao.attachment.Attachment;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class List {

    final String header;
    final String message;
    final String additionalContent;
    final Attachment attachment;

    public List(Builder builder) {
        this.header = builder.header;
        this.message = builder.message;
        this.additionalContent = builder.additionalContent;
        this.attachment = builder.attachment;
    }

    public static class Builder {

        private String header;
        private String message;
        private String additionalContent;
        private Attachment attachment;

        public Builder() {}

        public Builder header(String header) {
            this.header = header;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder additionalContent(String additionalContent) {
            this.additionalContent = additionalContent;
            return this;
        }

        public Builder attachment(Attachment attachment) {
            this.attachment = attachment;
            return this;
        }

        public List build() {
            return new List(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonProperty("header")
    public String getHeader() {
        return header;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("additionalContent")
    public String getAdditionalContent() {
        return additionalContent;
    }

    @JsonProperty("attachment")
    public Attachment getAttachment() {
        return attachment;
    }
}

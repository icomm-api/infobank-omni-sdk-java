package net.infobank.client.data.request.kakao.carousel;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Head {

    final String header;
    final String content;
    final String imageUrl;
    final String urlMobile;
    final String urlPc;
    final String schemeAndroid;
    final String schemeIOS;

    public Head(Builder builder) {
        this.header = builder.header;
        this.content = builder.content;
        this.imageUrl = builder.imageUrl;
        this.urlMobile = builder.urlMobile;
        this.urlPc = builder.urlPc;
        this.schemeAndroid = builder.schemeAndroid;
        this.schemeIOS = builder.schemeIOS;
    }

    public static class Builder {

        private String header;
        private String content;
        private String imageUrl;
        private String urlMobile;
        private String urlPc;
        private String schemeAndroid;
        private String schemeIOS;

        public Builder() {}

        public Builder header(String header) {
            this.header = header;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Builder imageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public Builder urlMobile(String urlMobile) {
            this.urlMobile = urlMobile;
            return this;
        }

        public Builder schemeAndroid(String schemeAndroid) {
            this.schemeAndroid = schemeAndroid;
            return this;
        }

        public Builder schemeIOS(String schemeIOS) {
            this.schemeIOS = schemeIOS;
            return this;
        }

        public Head build() {
            return new Head(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonProperty("header")
    public String getHeader() {
        return header;
    }

    @JsonProperty("content")
    public String getContent() {
        return content;
    }

    @JsonProperty("imageUrl")
    public String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("urlMobile")
    public String getUrlMobile() {
        return urlMobile;
    }

    @JsonProperty("urlPc")
    public String getUrlPc() {
        return urlPc;
    }

    @JsonProperty("schemeAndroid")
    public String getSchemeAndroid() {
        return schemeAndroid;
    }

    @JsonProperty("schemeIOS")
    public String getSchemeIOS() {
        return schemeIOS;
    }
}

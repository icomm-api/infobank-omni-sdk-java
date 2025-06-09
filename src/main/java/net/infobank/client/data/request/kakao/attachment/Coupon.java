package net.infobank.client.data.request.kakao.attachment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class Coupon {

    final String title;
    final String description;
    final String urlPc;
    final String urlMobile;
    final String schemeAndroid;
    final String schemeIOS;

    public Coupon(Builder builder) {
        this.title = builder.title;
        this.description = builder.description;
        this.urlPc = builder.urlPc;
        this.urlMobile = builder.urlMobile;
        this.schemeAndroid = builder.schemeAndroid;
        this.schemeIOS = builder.schemeIOS;
    }

    public static class Builder {

        private String title;
        private String description;
        private String urlPc;
        private String urlMobile;
        private String schemeAndroid;
        private String schemeIOS;

        public Builder() {}

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder urlPc(String urlPc) {
            this.urlPc = urlPc;
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

        public Coupon build() {
            return new Coupon(this);
        }
    }

    public static Image.Builder builder() {
        return new Image.Builder();
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("urlPc")
    public String getUrlPc() {
        return urlPc;
    }

    @JsonProperty("urlMobile")
    public String getUrlMobile() {
        return urlMobile;
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


package net.infobank.client.data.request.kakao.carousel;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Tail {

    final String urlPc;
    final String urlMobile;
    final String schemeIos;
    final String schemeAndroid;

    public Tail(Builder builder) {
        this.urlPc = builder.urlPc;
        this.urlMobile = builder.urlMobile;
        this.schemeIos = builder.schemeIos;
        this.schemeAndroid = builder.schemeAndroid;
    }

    public static class Builder {

        private String urlPc;
        private String urlMobile;
        private String schemeIos;
        private String schemeAndroid;

        public Builder() {}

        public Builder urlPc(String val) {
            this.urlPc = val;
            return this;
        }

        public Builder urlMobile(String val) {
            this.urlMobile = val;
            return this;
        }

        public Builder schemeIos(String val) {
            this.schemeIos = val;
            return this;
        }

        public Builder schemeAndroid(String val) {
            this.schemeAndroid = val;
            return this;
        }

        public Tail build() {
            return new Tail(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonProperty("title")
    public String getUrlPc() {
        return urlPc;
    }

    @JsonProperty("urlMobile")
    public String getUrlMobile() {
        return urlMobile;
    }

    @JsonProperty("schemeIos")
    public String getSchemeIos() {
        return schemeIos;
    }

    @JsonProperty("schemeAndroid")
    public String getSchemeAndroid() {
        return schemeAndroid;
    }
}
package net.infobank.client.data.request.kakao.quickreply;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.infobank.client.core.exception.MissingFieldException;
import net.infobank.client.data.code.KakaoQuickReplyType;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public final class WebLinkQuickReply implements QuickReply{

	final String type = KakaoQuickReplyType.WL.toString();
	final String name;
	final String urlMobile;
	final String urlPc;

	public WebLinkQuickReply(Builder builder) {
		this.name = builder.name;
		this.urlMobile = builder.urlMobile;
		this.urlPc = builder.urlPc;
	}

    public static class Builder {
        private String name;
        private String urlMobile;
		private String urlPc;

        public Builder() {}

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder urlMobile(String urlMobile) {
            this.urlMobile = urlMobile;
            return this;
        }

		public Builder urlPc(String urlPc) {
            this.urlPc = urlPc;
            return this;
        }

        public WebLinkQuickReply build() {

			if(name==null){
				throw new MissingFieldException("name field must not be null");
			}
			if(urlMobile==null){
				throw new MissingFieldException("urlMobile field must not be null");
			}
			
            return new WebLinkQuickReply(this);
        }
    }

	public static Builder builder() {
		return new Builder();
	}

	@Override
	@JsonProperty("type")
	public String getType() {
		return type;
	}

	@Override
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@Override
	@JsonProperty("urlPc")
	public String getUrlPc() {
		return urlPc;
	}

	@Override
	@JsonProperty("urlMobile")
	public String getUrlMobile() {
		return urlMobile;
	}

	@Override
	@JsonProperty("schemeIos")
	public String getSchemeIos() {
		return null;
	}

	@Override
	@JsonProperty("schemeAndroid")
	public String getSchemeAndroid() {
		return null;
	}

	@Override
	@JsonProperty("chatExtra")
	public String getChatExtra() {
		return null;
	}

	@Override
	@JsonProperty("chatEvent")
	public String getChatEvent() {
		return null;
	}

	@Override
	@JsonProperty("bizFormId")
	public String getBizFormId() {
		return null;
	}
}

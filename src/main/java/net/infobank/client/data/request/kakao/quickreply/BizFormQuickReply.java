package net.infobank.client.data.request.kakao.quickreply;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.infobank.client.core.exception.MissingFieldException;
import net.infobank.client.data.code.KakaoQuickReplyType;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public final class BizFormQuickReply implements QuickReply{

	final String type = KakaoQuickReplyType.BF.toString();
	final String bizFormId;
	final String name;

	public BizFormQuickReply(Builder builder) {
		this.bizFormId = builder.bizFormId;
		this.name = builder.name;
	}

    public static class Builder {

		private String bizFormId;
		private String name;

        public Builder() {}

		public Builder bizFormId(String bizFormId) {
            this.bizFormId = bizFormId;
            return this;
        }

		public Builder name(String name) {
            this.name = name;
            return this;
        }

        public BizFormQuickReply build() {

			if(name==null){
				throw new MissingFieldException("name field must not be null");
			}
			if(bizFormId==null){
				throw new MissingFieldException("bizFormId field must not be null");
			}

            return new BizFormQuickReply(this);
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
		return null;
	}

	@Override
	@JsonProperty("urlMobile")
	public String getUrlMobile() {
		return null;
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
		return bizFormId;
	}
}

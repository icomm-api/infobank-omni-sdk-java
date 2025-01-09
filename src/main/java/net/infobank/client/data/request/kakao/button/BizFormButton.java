package net.infobank.client.data.request.kakao.button;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.infobank.client.core.exception.MissingFieldException;
import net.infobank.client.data.code.KakaoButtonType;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public final class BizFormButton implements Button{

	final String type = KakaoButtonType.BF.toString();
	final String name;
	final String bizFormKey;
	final String bizFormId;

	public BizFormButton(Builder builder) {
		this.bizFormKey = builder.bizFormKey;
		this.bizFormId = builder.bizFormId;
		this.name = builder.name;
	}

    public static class Builder {

		private String bizFormKey;
		private String bizFormId;
		private String name;

        public Builder() {}

		public Builder name(String name) {
            this.name = name;
            return this;
        }

		public Builder bizFormKey(String bizFormKey) {
            this.bizFormKey = bizFormKey;
            return this;
        }

		public Builder bizFormId(String bizFormId) {
            this.bizFormId = bizFormId;
            return this;
        }

        public BizFormButton build() {

			if(name==null){
				throw new MissingFieldException("name field must not be null");
			}
			if(bizFormId==null){
				throw new MissingFieldException("bizFormId field must not be null");
			}

            return new BizFormButton(this);
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
	@JsonProperty("target")
	public String getTarget() {
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
	@JsonProperty("bizFormKey")
	public String getBizFormKey() {
		return bizFormKey;
	}

	@Override
	@JsonProperty("bizFormId")
	public String getBizFormId() {
		return bizFormId;
	}
}

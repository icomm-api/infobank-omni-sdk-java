package net.infobank.client.data.request.kakao.button;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.infobank.client.core.exception.MissingFieldException;
import net.infobank.client.data.code.KakaoButtonType;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public final class MessageDeliveryButton implements Button{

	final String type = KakaoButtonType.MD.toString();
	final String name;

	public MessageDeliveryButton(Builder builder) {
		this.name = builder.name;
	}

    public static class Builder {

		private String name;

		public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder() {}

        public MessageDeliveryButton build() {

			if(name==null){
				throw new MissingFieldException("name field must not be null");
			}

            return new MessageDeliveryButton(this);
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
		return null;
	}

	@Override
	@JsonProperty("bizFormId")
	public String getBizFormId() {
		return null;
	}
}

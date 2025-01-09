package net.infobank.client.data.request.kakao.button;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.infobank.client.core.exception.MissingFieldException;
import net.infobank.client.data.code.KakaoButtonType;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public final class ConsultingButton implements Button{

	final String type = KakaoButtonType.BC.toString();
	final String name;
	final String chatExtra;

	public ConsultingButton(Builder builder) {
		this.chatExtra = builder.chatExtra;
		this.name = builder.name;
	}

    public static class Builder {

		private String chatExtra;
		private String name;

        public Builder() {}

		public Builder chatExtra(String chatExtra) {
            this.chatExtra = chatExtra;
            return this;
        }

		public Builder name(String name) {
            this.name = name;
            return this;
        }

        public ConsultingButton build() {
			
			if(name==null){
				throw new MissingFieldException("name field must not be null");
			}

            return new ConsultingButton(this);
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
		return chatExtra;
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
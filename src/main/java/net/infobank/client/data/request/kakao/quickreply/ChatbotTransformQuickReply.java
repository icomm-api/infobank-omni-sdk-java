package net.infobank.client.data.request.kakao.quickreply;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.infobank.client.core.exception.MissingFieldException;
import net.infobank.client.data.code.KakaoQuickReplyType;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public final class ChatbotTransformQuickReply implements QuickReply{

	final String type = KakaoQuickReplyType.BT.toString();
	final String name;
	final String chatExtra;
	final String chatEvent;

	public ChatbotTransformQuickReply(Builder builder) {
		this.chatExtra = builder.chatExtra;
		this.chatEvent = builder.chatEvent;
		this.name = builder.name;
	}

    public static class Builder {

		private String chatExtra;
		private String chatEvent;
		private String name;

        public Builder() {}

		public Builder chatExtra(String chatExtra) {
            this.chatExtra = chatExtra;
            return this;
        }

		public Builder chatEvent(String chatEvent) {
            this.chatEvent = chatEvent;
            return this;
        }

		public Builder name(String name) {
            this.name = name;
            return this;
        }

        public ChatbotTransformQuickReply build() {

			if(name==null){
				throw new MissingFieldException("name field must not be null");
			}

            return new ChatbotTransformQuickReply(this);
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
		return chatExtra;
	}

	@Override
	@JsonProperty("chatEvent")
	public String getChatEvent() {
		return chatEvent;
	}

	@Override
	@JsonProperty("bizFormId")
	public String getBizFormId() {
		return null;
	}
}

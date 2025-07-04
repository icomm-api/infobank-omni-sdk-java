package net.infobank.client.data.request;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.infobank.client.core.exception.MissingFieldException;
import net.infobank.client.core.exception.UnexpectedException;
import net.infobank.client.core.exception.UnsupportedMessageException;
import net.infobank.client.data.code.MessageType;
import net.infobank.client.data.code.ServiceType;
import net.infobank.client.data.request.common.Fallback;
import net.infobank.client.data.request.kakao.button.Button;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public final class AlimtalkRequest {
	
	final String senderKey;
	final String msgType;
	final String to;
	final String templateCode;
	final String text;
	final List<Button> button;
	final String ref;
	final Fallback fallback;

	AlimtalkRequest(Builder builder) {

		this.senderKey = builder.senderKey;
		this.msgType = builder.msgType.toString();
		this.to = builder.to;
		this.templateCode = builder.templateCode;
		this.text = builder.text;
		this.button = builder.button;
		this.ref = builder.ref;
		this.fallback = builder.fallback;
	}

	@JsonProperty("senderKey")
	public String getSenderKey() {
		return senderKey;
	}

	@JsonProperty("msgType")
	public String getMsgType() {
		return msgType;
	}

	@JsonProperty("to")
	public String getTo() {
		return to;
	}

	@JsonProperty("templateCode")
	public String getTemplateCode() {
		return templateCode;
	}

	@JsonProperty("text")
	public String getText() {
		return text;
	}

	@JsonProperty("button")
	public List<Button> getButton() {
		return button;
	}

	@JsonProperty("ref")
	public String getRef() {
		return ref;
	}

	@JsonProperty("fallback")
	public Fallback getFallback() {
		return fallback;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private String senderKey;
		private MessageType msgType;
		private String to;
		private String templateCode;
		private String text;
		private String ref;
		private List<Button> button = new ArrayList<>();
		private Fallback fallback;

		Builder() {}

		public Builder senderKey(String senderKey) {
            this.senderKey = senderKey;
            return this;
        }

		public Builder msgType(MessageType msgType) {
            this.msgType = msgType;
            return this;
        }

        public Builder to(String to) {
            this.to = to;
            return this;
        }

		public Builder templateCode(String templateCode) {
            this.templateCode = templateCode;
            return this;
        }

		public Builder text(String text) {
			this.text = text;
			return this;
		}

		public Builder addButton(Button button) {
            this.button.add(button);
            return this;
        }

		public Builder ref(String ref) {
            this.ref = ref;
            return this;
        }

		public Builder fallback(Fallback fallback) {
            this.fallback = fallback;
            return this;
        }

		public AlimtalkRequest build() {

			if(senderKey==null){
				throw new MissingFieldException("senderKey field must not be null");
			}
			if(msgType==null){
				throw new MissingFieldException("msgType field must not be null");
			}
			if(to==null){
				throw new MissingFieldException("to field must not be null");
			}
			if(templateCode==null){
				throw new MissingFieldException("templateCode field must not be null");
			}
			if(text==null){
				throw new MissingFieldException("text field must not be null");
			}
			if(!ServiceType.ALIMTALK.supports(msgType)){
				throw new UnsupportedMessageException("This msgType is not supported by the ALIMTALK");
			}

			return new AlimtalkRequest(this);
		}
	}

	public String toJson() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(this);
		}
		catch (JsonProcessingException jpe) {
			throw new UnexpectedException("Failed to produce JSON from "+getClass().getSimpleName()+" object.", jpe);
		}
	}
}

package net.infobank.client.data.request;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.infobank.client.core.exception.UnexpectedException;
import net.infobank.client.data.request.message.AlimtalkMessage;
import net.infobank.client.data.request.message.FriendtalkMessage;
import net.infobank.client.data.request.message.MmsMessage;
import net.infobank.client.data.request.message.RcsMessage;
import net.infobank.client.data.request.message.SmsMessage;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public final class MessageFormRequest {
	
	final List<Object> messageForm;
	final String formId;
	String method;

	MessageFormRequest(Builder builder) {

		this.messageForm = builder.messageForm;
		this.formId = builder.formId;
	}

	@JsonProperty("messageForm")
	public List<Object> getMessageForm() {
		return messageForm;
	}

	@JsonIgnore
	public String getFormId() {
		return formId;
	}

	@JsonIgnore
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}


	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {

		private List<Object> messageForm = new ArrayList<>();
		private String formId;

		Builder() {}

		public Builder formId(String formId) {
            this.formId = formId;
            return this;
        }

		public Builder addMessage(SmsMessage sms) {
            messageForm.add(sms);
            return this;
        }

		public Builder addMessage(MmsMessage mms) {
            messageForm.add(mms);
            return this;
        }

		public Builder addMessage(RcsMessage rcs) {
            messageForm.add(rcs);
            return this;
        }

		public Builder addMessage(AlimtalkMessage alimtalk) {
            messageForm.add(alimtalk);
            return this;
        }

		public Builder addMessage(FriendtalkMessage friendtalk) {
            messageForm.add(friendtalk);
            return this;
        }

		public MessageFormRequest build() {

			//TODO validation
			//Parameter Exception?
			return new MessageFormRequest(this);
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

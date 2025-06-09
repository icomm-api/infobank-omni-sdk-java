package net.infobank.client.data.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.infobank.client.core.exception.MissingFieldException;
import net.infobank.client.core.exception.UnexpectedException;
import net.infobank.client.core.exception.UnsupportedMessageException;
import net.infobank.client.data.code.MessageType;
import net.infobank.client.data.code.ServiceType;
import net.infobank.client.data.request.common.Fallback;
import net.infobank.client.data.request.kakao.button.Button;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public final class BrandmessageRequest {

	final String senderKey;
	final String sendType;
	final String msgType;
	final String to;
	final String text;
	final String imgUrl;
	final String targeting;
	final String templateCode;
	final List<Button> button;
	final Fallback fallback;
	final String groupTagKey;
	final String adult;
	final String pushAlarm;
	final JsonNode messageVariable;
	final JsonNode buttonVariable;
	final JsonNode couponVariable;
	final JsonNode imageVariable;
	final JsonNode videoVariable;
	final JsonNode commerceVariable;
	final JsonNode carouselVariable;
	final String originCID;
	final String unsubscribePhoneNumber;
	final String unsubscribeAuthNumber;
	final String ref;



	BrandmessageRequest(Builder builder) {
		this.senderKey = builder.senderKey;
		this.sendType	= builder.sendType;
		this.msgType = builder.msgType.toString();
		this.to		= builder.to;
		this.text	= builder.text;
		this.imgUrl	= builder.imgUrl;
		this.targeting	= builder.targeting;
		this.templateCode	= builder.templateCode;
		this.button	= builder.button;
		this.fallback	= builder.fallback;
		this.groupTagKey	= builder.groupTagKey;
		this.adult = builder.adult;
		this.pushAlarm = builder.pushAlarm;
		this.messageVariable = builder.messageVariable;
		this.buttonVariable = builder.buttonVariable;
		this.couponVariable = builder.couponVariable;
		this.imageVariable = builder.imageVariable;
		this.videoVariable = builder.videoVariable;
		this.commerceVariable = builder.commerceVariable;
		this.carouselVariable = builder.carouselVariable;
		this.originCID = builder.originCID;
		this.unsubscribePhoneNumber = builder.unsubscribePhoneNumber;
		this.unsubscribeAuthNumber = builder.unsubscribeAuthNumber;
		this.ref		= builder.ref;
	}

	@JsonProperty("senderKey")
	public String getSenderKey() {
		return senderKey;
	}

	public String getSendType() {
		return sendType;
	}

	@JsonProperty("msgType")
	public String getMsgType() {
		return msgType;
	}

	@JsonProperty("to")
	public String getTo() {
		return to;
	}

	@JsonProperty("text")
	public String getText() {
		return text;
	}

	@JsonProperty("imgUrl")
	public String getImgUrl() {
		return imgUrl;
	}

	@JsonProperty("targeting")
	public String getTargeting() {
		return targeting;
	}
	@JsonProperty("templateCode")
	public String getTemplateCode() {
		return templateCode;
	}

	@JsonProperty("button")
	public List<Button> getButton() {
		return button;
	}

	@JsonProperty("fallback")
	public Fallback getFallback() {
		return fallback;
	}

	@JsonProperty("groupTagKey")
	public String getGroupTagKey() {
		return groupTagKey;
	}

	@JsonProperty("adults")
	public String getAdult() {
		return adult;
	}
	@JsonProperty("pushAlarm")
	public String getPushAlarm() {
		return pushAlarm;
	}
	@JsonProperty("messageVariable")
	public JsonNode getMessageVariable() {
		return messageVariable;
	}
	@JsonProperty("buttonVariable")
	public JsonNode getButtonVariable() {
		return buttonVariable;
	}

	@JsonProperty("couponVariable")
	public JsonNode getCouponVariable() {
		return couponVariable;
	}

	@JsonProperty("imageVariable")
	public JsonNode getImageVariable() {
		return imageVariable;
	}

	@JsonProperty("videoVariable")
	public JsonNode getVideoVariable() {
		return videoVariable;
	}

	@JsonProperty("commerceVariable")
	public JsonNode getCommerceVariable() {
		return commerceVariable;
	}

	@JsonProperty("carouselVariable")
	public JsonNode getCarouselVariable() {
		return carouselVariable;
	}

	@JsonProperty("originCID")
	public String getOriginCID() {
		return originCID;
	}

	@JsonProperty("unsubscribePhoneNumber")
	public String getUnsubscribePhoneNumber() {
		return unsubscribePhoneNumber;
	}
	@JsonProperty("unsubscribeAuthNumber")
	public String getUnsubscribeAuthNumber() {
		return unsubscribeAuthNumber;
	}

	@JsonProperty("ref")
	public String getRef() {
		return ref;
	}


	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private String senderKey;
		private String sendType;
		private MessageType msgType;
		private String to;
		private String text;
		private String imgUrl;
		private String targeting;
		private String templateCode;
		private List<Button> button = new ArrayList<>();
		private Fallback fallback;
		private String groupTagKey;
		private String adult;
		private String pushAlarm;
		private JsonNode messageVariable;
		private JsonNode buttonVariable;
		private JsonNode couponVariable;
		private JsonNode imageVariable;
		private JsonNode videoVariable;
		private JsonNode commerceVariable;
		private JsonNode carouselVariable;
		private String originCID;
		private String unsubscribePhoneNumber;
		private String unsubscribeAuthNumber;
		private String ref;

		Builder() {}

		public Builder senderKey(String senderKey) {
            this.senderKey = senderKey;
            return this;
        }

		public Builder sendType(String sendType) {
			this.sendType = sendType;
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

		public Builder text(String text) {
			this.text = text;
			return this;
		}

		public Builder imgUrl(String imgUrl) {
			this.imgUrl = imgUrl;
			return this;
		}

		public Builder targeting(String targeting) {
			this.targeting = targeting;
			return this;
		}

		public Builder templateCode(String templateCode) {
			this.templateCode = templateCode;
			return this;
		}

		public Builder addButton(Button button) {
            this.button.add(button);
            return this;
        }

		public Builder fallback(Fallback fallback) {
            this.fallback = fallback;
            return this;
        }

		public Builder groupTagKey(String groupTagKey) {
			this.groupTagKey = groupTagKey;
			return this;
		}

		public Builder adult(String adult) {
			this.adult = adult;
			return this;
		}

		public Builder pushAlarm(String pushAlarm) {
			this.pushAlarm = pushAlarm;
			return this;
		}

		public Builder messageVariable(JsonNode messageVariable) {
			this.messageVariable = messageVariable;
			return this;
		}

		public Builder buttonVariable(JsonNode buttonVariable) {
			this.buttonVariable = buttonVariable;
			return this;
		}

		public Builder couponVariable(JsonNode couponVariable) {
			this.couponVariable = couponVariable;
			return this;
		}

		public Builder imageVariable(JsonNode imageVariable) {
			this.imageVariable = imageVariable;
			return this;
		}

		public Builder videoVariable(JsonNode videoVariable) {
			this.videoVariable = videoVariable;
			return this;
		}

		public Builder commerceVariable(JsonNode commerceVariable) {
			this.commerceVariable = commerceVariable;
			return this;
		}

		public Builder carouselVariable(JsonNode carouselVariable) {
			this.carouselVariable = carouselVariable;
			return this;
		}

		public Builder originCID(String originCID) {
			this.originCID = originCID;
			return this;
		}

		public Builder unsubscribePhoneNumber(String unsubscribePhoneNumber) {
			this.unsubscribePhoneNumber = unsubscribePhoneNumber;
			return this;
		}

		public Builder unsubscribeAuthNumber(String unsubscribeAuthNumber) {
			this.unsubscribeAuthNumber = unsubscribeAuthNumber;
			return this;
		}

		public Builder ref(String ref) {
			this.ref = ref;
			return this;
		}

		public BrandmessageRequest build() {

			if(senderKey==null){
				throw new MissingFieldException("senderKey field must not be null");
			}

			if(sendType==null){
				throw new MissingFieldException("sendType field must not be null");
			}

			if(msgType==null){
				throw new MissingFieldException("msgType field must not be null");
			}
			if(to==null){
				throw new MissingFieldException("to field must not be null");
			}

			if(!ServiceType.FRIENDTALK.supports(msgType)){
				throw new UnsupportedMessageException("This msgType is not supported by the BRANDMESSAGE");
			}

			return new BrandmessageRequest(this);
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

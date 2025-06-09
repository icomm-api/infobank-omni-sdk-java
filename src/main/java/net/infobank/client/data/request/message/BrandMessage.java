package net.infobank.client.data.request.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import net.infobank.client.core.exception.MissingFieldException;
import net.infobank.client.core.exception.UnsupportedMessageException;
import net.infobank.client.data.code.MessageType;
import net.infobank.client.data.code.SendType;
import net.infobank.client.data.code.ServiceType;
import net.infobank.client.data.request.kakao.Carousel;
import net.infobank.client.data.request.kakao.attachment.Attachment;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY )
public class BrandMessage {

    final BrandMessageData brandMessage;

    @JsonProperty("brandmessage")
    public BrandMessageData getBrandMessage() {
        return brandMessage;
    }

    BrandMessage(Builder builder) {
        brandMessage = new BrandMessageData(builder);
    }

    @JsonInclude(value = JsonInclude.Include.NON_EMPTY )
    private class BrandMessageData {
        String senderKey;
        SendType sendType;
        MessageType msgType;
        String text;
        Carousel carousel;
        Attachment attachment;
        String header;
        String targeting;
        String templateCode;
        String addtionalContent;
        String groupTagKey;
        String adult;
        String pushAlarm;
        String adFlag;
        JsonNode messageVariable;
        JsonNode buttonVariable;
        JsonNode couponVariable;
        JsonNode imageVariable;
        JsonNode videoVariable;
        JsonNode commerceVariable;
        JsonNode carouselVariable;
        String originCID;
        String unsubscribePhoneNumber;
        String unsubscribeAuthNumber;


        BrandMessageData(Builder builder) {
            this.senderKey = builder.senderKey;
            this.sendType = builder.sendType;
            this.msgType = builder.msgType;
            this.text = builder.text;
            this.carousel = builder.carousel;
            this.attachment = builder.attachment;
            this.header = builder.header;
            this.targeting = builder.targeting;
            this.templateCode = builder.templateCode;
            this.addtionalContent = builder.addtionalContent;
            this.groupTagKey = builder.groupTagKey;
            this.adult = builder.adult;
            this.pushAlarm = builder.pushAlarm;
            this.adFlag = builder.adFlag;
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
        }

        @JsonProperty("senderKey")
        public String getSenderKey() {
            return senderKey;
        }

        @JsonProperty("sendType")
        public SendType getSendType() {
            return sendType;
        }

        @JsonProperty("msgType")
        public MessageType getMsgType() {
            return msgType;
        }

        @JsonProperty("text")
        public String getText() {
            return text;
        }
        @JsonProperty("carousel")
        public Carousel getCarousel() {
            return carousel;
        }
        @JsonProperty("attachment")
        public Attachment getAttachment() {
            return attachment;
        }
        @JsonProperty("header")
        public String getHeader() {
            return header;
        }
        @JsonProperty("targeting")
        public String getTargeting() {
            return targeting;
        }
        @JsonProperty("templateCode")
        public String getTemplateCode() {
            return templateCode;
        }
        @JsonProperty("addtionalContent")
        public String getAddtionalContent() {
            return addtionalContent;
        }
        @JsonProperty("groupTagKey")
        public String getGroupTagKey() {
            return groupTagKey;
        }
        @JsonProperty("adult")
        public String getAdult() {
            return adult;
        }
        @JsonProperty("pushAlarm")
        public String getPushAlarm() {
            return pushAlarm;
        }
        @JsonProperty("adFlag")
        public String getAdFlag() {
            return adFlag;
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
    }
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        String senderKey;
        SendType sendType;
        MessageType msgType;
        String text;
        Carousel carousel;
        Attachment attachment;
        String header;
        String targeting;
        String templateCode;
        String addtionalContent;
        String groupTagKey;
        String adult;
        String pushAlarm;
        String adFlag;
        JsonNode messageVariable;
        JsonNode buttonVariable;
        JsonNode couponVariable;
        JsonNode imageVariable;
        JsonNode videoVariable;
        JsonNode commerceVariable;
        JsonNode carouselVariable;
        String originCID;
        String unsubscribePhoneNumber;
        String unsubscribeAuthNumber;


        public Builder senderKey(String senderKey) {
            this.senderKey = senderKey;
            return this;
        }

        public Builder sendType(SendType sendType) {
            this.sendType = sendType;
            return this;
        }

        public Builder msgType(MessageType msgType) {
            this.msgType = msgType;
            return this;
        }

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public Builder carousel(Carousel carousel) {
            this.carousel = carousel;
            return this;
        }

        public Builder attachment(Attachment attachment) {
            this.attachment = attachment;
            return this;
        }

        public Builder header(String header) {
            this.header = header;
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

        public Builder addtionalContent(String addtionalContent) {
            this.addtionalContent = addtionalContent;
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

        public Builder adFlag(String adFlag) {
            this.adFlag = adFlag;
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


        public BrandMessage build() {

            if (senderKey == null) {
				throw new MissingFieldException("senderKey field must not be null");
			}

            if (sendType == null) {
                throw new MissingFieldException("sendType field must not be null");
            }
            if (msgType == null) {
				throw new MissingFieldException("msgType field must not be null");
			}

            if (!ServiceType.FRIENDTALK.supports(msgType)) {
				throw new UnsupportedMessageException("This msgType is not supported by the FRIENDTALK");
			}

            return new BrandMessage(this);
        }

    }


}
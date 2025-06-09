package net.infobank.client.data.request.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.infobank.client.core.exception.MissingFieldException;
import net.infobank.client.core.exception.UnsupportedMessageException;
import net.infobank.client.data.code.MessageType;
import net.infobank.client.data.code.ServiceType;
import net.infobank.client.data.request.kakao.attachment.Attachment;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY )
public class AlimtalkMessage{

    final AlimtalkData alimtalk;

    @JsonProperty("alimtalk")
    public AlimtalkData getAlimtalk() {
        return alimtalk;
    }

    AlimtalkMessage(Builder builder) {
        alimtalk = new AlimtalkData(builder);        
    }

    @JsonInclude(value = JsonInclude.Include.NON_EMPTY )
    private class AlimtalkData {
        String senderKey;
        String msgType;
        String templateCode;
        String text;
        String title;
        Attachment attachment;
        Object supplement;
        String price;
        String currencyType;

        AlimtalkData(Builder builder) {
            senderKey = builder.senderKey;
            msgType = builder.msgType.toString();
            templateCode = builder.templateCode;
            text = builder.text;
            title = builder.title;
            attachment = builder.attachment;
            supplement = builder.supplement;
            price = builder.price;
            currencyType = builder.currencyType;
        }

        @JsonProperty("senderKey")
        public String getSenderKey() {
            return senderKey;
        }

        @JsonProperty("msgType")
        public String getMsgType() {
            return msgType;
        }

        @JsonProperty("templateCode")
        public String getTemplateCode() {
            return templateCode;
        }

        @JsonProperty("text")
        public String getText() {
            return text;
        }
        
        @JsonProperty("title")
        public String getTitle() {
            return title;
        }

        @JsonProperty("attachment")
        public Attachment getAttachment() {
            return attachment;
        }

        @JsonProperty("supplement")
        public Object getSupplement() {
            return supplement;
        }

        @JsonProperty("price")
        public String getPrice() {
            return price;
        }

        @JsonProperty("currencyType")
        public String getCurrencyType() {
            return currencyType;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        String senderKey;
        MessageType msgType;
        String templateCode;
        String text;
        String title;
        Attachment attachment;
        Object supplement;
        String price;
        String currencyType;

        public Builder senderKey(String senderKey) {
            this.senderKey = senderKey;
            return this;
        }

        public Builder msgType(MessageType msgType) {
            this.msgType = msgType;
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

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder attachment(Attachment attachment) {
            this.attachment = attachment;
            return this;
        }

        public Builder supplement(Object supplement) {
            this.supplement = supplement;
            return this;
        }

        public Builder price(String price) {
            this.price = price;
            return this;
        }

        public Builder currencyType(String currencyType) {
            this.currencyType = currencyType;
            return this;
        }

        public AlimtalkMessage build() {

            if(senderKey==null){
				throw new MissingFieldException("senderKey field must not be null");
			}
            if(msgType==null){
				throw new MissingFieldException("msgType field must not be null");
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

            return new AlimtalkMessage(this);
        }
    }
}
package net.infobank.client.data.request.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.infobank.client.core.exception.MissingFieldException;
import net.infobank.client.core.exception.UnsupportedMessageException;
import net.infobank.client.data.code.MessageType;
import net.infobank.client.data.code.ServiceType;
import net.infobank.client.data.request.kakao.attachment.Attachment;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY )
public class FriendtalkMessage{

    final FriendtalkData friendtalk;

    @JsonProperty("friendtalk")
    public FriendtalkData getFriendtalk() {
        return friendtalk;
    }

    FriendtalkMessage(Builder builder) {
        friendtalk = new FriendtalkData(builder);        
    }

    @JsonInclude(value = JsonInclude.Include.NON_EMPTY )
    private class FriendtalkData {
        String senderKey;
        String msgType;
        String text;
        Attachment attachment;
        String adFlag;

        FriendtalkData(Builder builder) {
            senderKey = builder.senderKey;
            msgType = builder.msgType.toString();
            text = builder.text;
            attachment = builder.attachment;
            adFlag = builder.adFlag;
        }

        @JsonProperty("senderKey")
        public String getSenderKey() {
            return senderKey;
        }

        @JsonProperty("msgType")
        public String getMsgType() {
            return msgType;
        }

        @JsonProperty("text")
        public String getText() {
            return text;
        }
        
        @JsonProperty("attachment")
        public Attachment getAttachment() {
            return attachment;
        }

        @JsonProperty("adFlag")
        public String getAdFlag() {
            return adFlag;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        String senderKey;
        MessageType msgType;
        String text;
        Attachment attachment;
        String adFlag;

        public Builder senderKey(String senderKey) {
            this.senderKey = senderKey;
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

        public Builder attachment(Attachment attachment) {
            this.attachment = attachment;
            return this;
        }

        public Builder adFlag(String adFlag) {
            this.adFlag = adFlag;
            return this;
        }

        public FriendtalkMessage build() {

            if(senderKey==null){
				throw new MissingFieldException("senderKey field must not be null");
			}
            if(msgType==null){
				throw new MissingFieldException("msgType field must not be null");
			}
            if(text==null){
				throw new MissingFieldException("text field must not be null");
			}
            if(!ServiceType.FRIENDTALK.supports(msgType)){
				throw new UnsupportedMessageException("This msgType is not supported by the FRIENDTALK");
			}

            return new FriendtalkMessage(this);
        }
    }
}
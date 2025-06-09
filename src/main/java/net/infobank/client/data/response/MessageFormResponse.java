package net.infobank.client.data.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.infobank.client.core.exception.ResponseParseException;
import net.infobank.client.data.response.common.ApiResponse;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageFormResponse extends ApiResponse{

    MessageFormData data;

    public MessageFormData getData() {
        return data;
    }

    public void setData(MessageFormData data) {
        this.data = data;
    }

    public class MessageFormData {

        private String formId;
        private List<Object> messageForm;
        private String expired;
        public String getFormId() {
            return formId;
        }
        public void setFormId(String formId) {
            this.formId = formId;
        }
        public List<Object> getMessageForm() {
            return messageForm;
        }
        public void setMessageForm(List<Object> messageForm) {
            this.messageForm = messageForm;
        }
        public String getExpired() {
            return expired;
        }
        public void setExpired(String expired) {
            this.expired = expired;
        }

        @Override
    public String toString() {
        return "formId='" + formId + "\'" +
                ", messageForm=" + messageForm +
                ", expired='" + expired + "\'";
    }
        
    }

    public static MessageFormResponse fromJson(String json) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json, MessageFormResponse.class);
        } catch (JsonProcessingException e) {
            throw new ResponseParseException("Failed to produce MessageFormResponse from json.", e);
        }
    }

    @Override
    public String toString() {
        return super.toString() + 
                ", data={" + data + "}";
    }

}
package net.infobank.client.data.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.infobank.client.core.exception.ResponseParseException;
import net.infobank.client.data.response.common.ApiResponse;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MmsResponse extends ApiResponse{

    String msgKey;
    String ref;

    public String getMsgKey() {
        return msgKey;
    }

    public void setMsgKey(String msgKey) {
        this.msgKey = msgKey;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public static MmsResponse fromJson(String json) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json, MmsResponse.class);
        } catch (JsonProcessingException e) {
            throw new ResponseParseException("Failed to produce MmsResponse from json.", e);
        }
    }

    @Override
    public String toString() {
        return super.toString() + 
                ", msgKey='" + msgKey + "\'" +
                ", ref='" + ref + "\'";
    }

}
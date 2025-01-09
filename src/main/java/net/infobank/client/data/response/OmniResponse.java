package net.infobank.client.data.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.infobank.client.core.exception.ResponseParseException;
import net.infobank.client.data.response.common.ApiResponse;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OmniResponse extends ApiResponse{

    OmniResponseData data;
    String ref;

    public OmniResponseData getData() {
        return data;
    }

    public void setData(OmniResponseData data) {
        this.data = data;
    }
    
    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public class OmniResponseData {

        private List<DestinationResponse> destinations;

        public List<DestinationResponse> getDestinations() {
            return destinations;
        }

        public void setDestinations(List<DestinationResponse> destinations) {
            this.destinations = destinations;
        }

        @Override
        public String toString() {
            return "destinations=" + destinations;
        }
        
    }

    public static class DestinationResponse {

        public DestinationResponse() {}
        
        private String to;
        private String msgKey;
        private String code;
        private String result;

        public String getTo() {
            return to;
        }
        public void setTo(String to) {
            this.to = to;
        }
        public String getMsgKey() {
            return msgKey;
        }
        public void setMsgKey(String msgKey) {
            this.msgKey = msgKey;
        }
        public String getCode() {
            return code;
        }
        public void setCode(String code) {
            this.code = code;
        }
        public String getResult() {
            return result;
        }
        public void setResult(String result) {
            this.result = result;
        }

        @Override
        public String toString() {
            
            return "to='" + to + "\'" +
                    ", msgKey='" + msgKey + "\'" +
                    ", code='" + code + "\'" +
                    ", result='" + result + "\'";
        }
    }

    public static OmniResponse fromJson(String json) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json, OmniResponse.class);
        } catch (JsonProcessingException e) {
            throw new ResponseParseException("Failed to produce OmniResponse from json.", e);
        }
    }

    @Override
    public String toString() {
        return super.toString() + 
                ", data={" + data + "}" +
                ", ref='" + ref + "\'";
    }
}
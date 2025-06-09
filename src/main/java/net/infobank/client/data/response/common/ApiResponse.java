package net.infobank.client.data.response.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.infobank.client.core.exception.ResponseParseException;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse {

    private String code;
    private String result;

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

    public static ApiResponse fromJson(String json) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json, ApiResponse.class);
        } catch (JsonProcessingException e) {
            throw new ResponseParseException("Failed to produce ApiResponse from json.", e);
        }
    }

    @Override
    public String toString() {
        return "code='" + code + "\'" +
               ", result='" + result + "\'" ;
    }
    
}

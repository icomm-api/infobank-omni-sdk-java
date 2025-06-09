package net.infobank.client.data.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.infobank.client.core.exception.ResponseParseException;
import net.infobank.client.data.response.common.ApiResponse;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthResponse extends ApiResponse{

    private AuthData data;

    public AuthData getData() {
        return data;
    }

    public void setData(AuthData data) {
        this.data = data;
    }

    public class AuthData {

        private String token;
        private String schema;
        private String expired;
        public String getToken() {
            return token;
        }
        public void setToken(String token) {
            this.token = token;
        }
        public String getSchema() {
            return schema;
        }
        public void setSchema(String schema) {
            this.schema = schema;
        }
        public String getExpired() {
            return expired;
        }
        public void setExpired(String expired) {
            this.expired = expired;
        }

        @Override
        public String toString() {
            return "token='" + token + "\'" +
                    ", schema='" + schema + "\'" +
                    ", expired='" + expired + "\'";
        }
    }

    public static AuthResponse fromJson(String json) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json, AuthResponse.class);
        } catch (JsonProcessingException e) {
            throw new ResponseParseException("Failed to produce AuthResponse from json.", e);
        }
    }

    @Override
    public String toString() {
        return super.toString() + 
                ", data={" + data + "}";
    }
}
package net.infobank.client.data.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.infobank.client.core.exception.ResponseParseException;
import net.infobank.client.data.response.common.ApiResponse;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FileResponse extends ApiResponse{

    private FileData data;

    public FileData getData() {
        return data;
    }

    public void setData(FileData data) {
        this.data = data;
    }

    public class FileData {

        private String imgUrl;
        private String fileKey;
        private String media;
        private String expired;
        
        public String getImgUrl() {
            return imgUrl;
        }
        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }
        public String getFileKey() {
            return fileKey;
        }
        public void setFileKey(String fileKey) {
            this.fileKey = fileKey;
        }
        public String getMedia() {
            return media;
        }
        public void setMedia(String media) {
            this.media = media;
        }
        public String getExpired() {
            return expired;
        }
        public void setExpired(String expired) {
            this.expired = expired;
        }

        @Override
        public String toString() {
            
            return "fileKey='" + fileKey + "\'" +
                    ", media='" + media + "\'" +
                    ", imgUrl='" + imgUrl + "\'" +
                    ", expired='" + expired + "\'";
        }
    }

    public static FileResponse fromJson(String json) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(json, FileResponse.class);
        } catch (JsonProcessingException e) {
            throw new ResponseParseException("Failed to produce FileResponse from json.", e);
        }
    }

    @Override
    public String toString() {
        return super.toString() + 
                ", data={" + data + "}";
    }
}
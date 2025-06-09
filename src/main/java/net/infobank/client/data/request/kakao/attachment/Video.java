package net.infobank.client.data.request.kakao.attachment;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class Video {

    final String videoUrl;
    final String thumbnailUrl ;

    public Video(Builder builder) {
        this.videoUrl = builder.videoUrl;
        this.thumbnailUrl = builder.thumbnailUrl;
    }

    public static class Builder {

        private String videoUrl;
        private String thumbnailUrl;

        public Builder() {}

        public Builder videoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
            return this;
        }

        public Builder thumbnailUrl(String thumbnailUrl) {
            this.thumbnailUrl = thumbnailUrl;
            return this;
        }

        public Video build() {
            return new Video(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonProperty("videoUrl")
    public String getVideoUrl() {
        return videoUrl;
    }

    @JsonProperty("thumbnailUrl")
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }
}

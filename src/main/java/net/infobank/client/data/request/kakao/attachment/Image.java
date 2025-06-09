package net.infobank.client.data.request.kakao.attachment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public final class Image {

	final String imgUrl;
	final String imgLink;

	public Image(Builder builder) {
		this.imgUrl = builder.imgUrl;
		this.imgLink = builder.imgLink;
	}

    public static class Builder {

		private String imgUrl;
		private String imgLink;

        public Builder() {}

		public Builder imgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
            return this;
        }

		public Builder imgLink(String imgLink) {
            this.imgLink = imgLink;
            return this;
        }

        public Image build() {
            return new Image(this);
        }
    }

	public static Builder builder() {
		return new Builder();
	}

	@JsonProperty("imgUrl")
	public String getImgUrl() {
		return imgUrl;
	}

	@JsonProperty("imgLink")
	public String getImgLink() {
		return imgLink;
	}

}

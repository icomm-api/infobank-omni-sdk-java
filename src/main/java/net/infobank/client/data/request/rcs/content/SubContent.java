package net.infobank.client.data.request.rcs.content;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public final class SubContent {
    final String subTitle;
    final String subDesc;
    final String subMedia;
    final String subUrl;

	@JsonProperty("subTitle")
    public String getSubTitle() {
		return subTitle;
	}

	@JsonProperty("subDesc")
	public String getSubDesc() {
		return subDesc;
	}

	@JsonProperty("subMedia")
	public String getSubMedia() {
		return subMedia;
	}

	@JsonProperty("subUrl")
	public String getSubUrl() {
		return subUrl;
	}

	private SubContent(Builder builder) {
        this.subTitle = builder.subTitle;
        this.subDesc = builder.subDesc;
        this.subMedia = builder.subMedia;
        this.subUrl = builder.subUrl;
    }

	public static Builder builder() {
		return new Builder();
	}

    public static class Builder {
        private String subTitle;
        private String subDesc;
        private String subMedia;
        private String subUrl;

        public Builder() {}

        public Builder subTitle(String subTitle) {
            this.subTitle = subTitle;
            return this;
        }

        public Builder subDesc(String subDesc) {
            this.subDesc = subDesc;
            return this;
        }

        public Builder subMedia(String subMedia) {
            this.subMedia = subMedia;
            return this;
        }

        public Builder subUrl(String subUrl) {
            this.subUrl = subUrl;
            return this;
        }

        public SubContent build() {
            return new SubContent(this);
        }
    }
}


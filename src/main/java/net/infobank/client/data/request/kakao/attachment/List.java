package net.infobank.client.data.request.kakao.attachment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public final class List {

	final String title;
	final String description;
	final String imgUrl;
	final String schemeAndroid;
	final String schemeIos;
	final String urlMobile;
	final String urlPc;


	public List(Builder builder) {
		this.title = builder.title;
		this.description = builder.description;
		this.imgUrl = builder.imgUrl;
		this.schemeAndroid = builder.schemeAndroid;
		this.schemeIos = builder.schemeIos;
		this.urlMobile = builder.urlMobile;
		this.urlPc = builder.urlPc;
	}

	public static class Builder {

		private String title;
		private String description;
		private String imgUrl;
		private String schemeAndroid;
		private String schemeIos;
		private String urlMobile;
		private String urlPc;

		public Builder() {}

		public Builder title(String title) {
			this.title = title;
			return this;
		}

		public Builder description(String description) {
			this.description = description;
			return this;
		}

		public Builder imgUrl(String imgUrl) {
			this.imgUrl = imgUrl;
			return this;
		}

		public Builder schemeAndroid(String schemeAndroid) {
			this.schemeAndroid = schemeAndroid;
			return this;
		}


		public Builder schemeIos(String schemeIos) {
			this.schemeIos = schemeIos;
			return this;
		}

		public Builder urlMobile(String urlMobile) {
			this.urlMobile = urlMobile;
			return this;
		}


		public Builder urlPc(String urlPc) {
			this.urlPc = urlPc;
			return this;
		}

		public List build() {
			return new List(this);
		}
	}

	public static Builder builder() {
		return new Builder();
	}

	@JsonProperty("title")
	public String getTitle() {
		return title;
	}

	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	@JsonProperty("imgUrl")
	public String getImgUrl() {
		return imgUrl;
	}

	@JsonProperty("schemeAndroid")
	public String getSchemeAndroid() {
		return schemeAndroid;
	}

	@JsonProperty("schemeIos")
	public String getSchemeIos() {
		return schemeIos;
	}

	@JsonProperty("urlMobile")
	public String getUrlMobile() {
		return urlMobile;
	}

	@JsonProperty("urlPc")
	public String getUrlPc() {
		return urlPc;
	}

}

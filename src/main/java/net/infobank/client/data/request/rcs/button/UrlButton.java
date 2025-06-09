package net.infobank.client.data.request.rcs.button;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.infobank.client.core.exception.MissingFieldException;
import net.infobank.client.data.code.RcsButtonType;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public final class UrlButton implements Button{

	final String type = RcsButtonType.URL.toString();
	final String name;
	final String url;

	public UrlButton(Builder builder) {
		this.name = builder.name;
		this.url = builder.url;
	}

    public static class Builder {
        private String name;
        private String url;

        public Builder() {}

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public UrlButton build() {

			if(name==null){
				throw new MissingFieldException("name field must not be null");
			}
			if(url==null){
				throw new MissingFieldException("url field must not be null");
			}

            return new UrlButton(this);
        }
    }

	public static Builder builder() {
		return new Builder();
	}

	@Override
	@JsonProperty("type")
	public String getType() {
		return type;
	}

	@Override
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@Override
	@JsonProperty("url")
	public String getUrl() {
		return url;
	}

	@Override
	public String getLabel() {
		return null;
	}

	@Override
	public String getLatitude() {
		return null;
	}

	@Override
	public String getLongitude() {
		return null;
	}

	@Override
	public String getFallbackUrl() {
		return null;
	}

	@Override
	public String getQuery() {
		return null;
	}

	@Override
	public String getStartTime() {
		return null;
	}

	@Override
	public String getEndTime() {
		return null;
	}

	@Override
	public String getTitle() {
		return null;
	}

	@Override
	public String getDescription() {
		return null;
	}

	@Override
	public String getText() {
		return null;
	}

	@Override
	public String getPhoneNumber() {
		return null;
	}
}

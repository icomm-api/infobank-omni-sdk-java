package net.infobank.client.data.request.rcs.button;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.infobank.client.core.exception.MissingFieldException;
import net.infobank.client.data.code.RcsButtonType;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public final class CopyButton implements Button{

	final String type = RcsButtonType.COPY.toString();
	final String name;
	final String text;

	public CopyButton(Builder builder) {
		this.name = builder.name;
		this.text = builder.text;
	}

    public static class Builder {
        private String name;
        private String text;

        public Builder() {}

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public CopyButton build() {

			if(name==null){
				throw new MissingFieldException("name field must not be null");
			}
			if(text==null){
				throw new MissingFieldException("text field must not be null");
			}

            return new CopyButton(this);
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
		return null;
	}

	@Override
	@JsonProperty("label")
	public String getLabel() {
		return null;
	}

	@Override
	@JsonProperty("latitude")
	public String getLatitude() {
		return null;
	}

	@Override
	@JsonProperty("longitude")
	public String getLongitude() {
		return null;
	}

	@Override
	@JsonProperty("fallbackUrl")
	public String getFallbackUrl() {
		return null;
	}

	@Override
	@JsonProperty("query")
	public String getQuery() {
		return null;
	}

	@Override
	@JsonProperty("startTime")
	public String getStartTime() {
		return null;
	}

	@Override
	@JsonProperty("endTime")
	public String getEndTime() {
		return null;
	}

	@Override
	@JsonProperty("title")
	public String getTitle() {
		return null;
	}

	@Override
	@JsonProperty("description")
	public String getDescription() {
		return null;
	}

	@Override
	@JsonProperty("text")
	public String getText() {
		return text;
	}

	@Override
	@JsonProperty("phoneNumber")
	public String getPhoneNumber() {
		return null;
	}
}

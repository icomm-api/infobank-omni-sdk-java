package net.infobank.client.data.request.rcs.button;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.infobank.client.core.exception.MissingFieldException;
import net.infobank.client.data.code.RcsButtonType;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public final class DialButton implements Button{

	final String type = RcsButtonType.DIAL.toString();
	final String name;
	final String phoneNumber;

	public DialButton(Builder builder) {
		this.name = builder.name;
		this.phoneNumber = builder.phoneNumber;
	}

    public static class Builder {
        private String name;
		private String phoneNumber;

        public Builder() {}

        public Builder name(String name) {
            this.name = name;
            return this;
        }

		public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public DialButton build() {

			if(name==null){
				throw new MissingFieldException("name field must not be null");
			}
			if(phoneNumber==null){
				throw new MissingFieldException("phoneNumber field must not be null");
			}

            return new DialButton(this);
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
		return null;
	}

	@Override
	@JsonProperty("phoneNumber")
	public String getPhoneNumber() {
		return phoneNumber;
	}
}

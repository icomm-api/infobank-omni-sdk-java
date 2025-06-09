package net.infobank.client.data.request.rcs.button;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.infobank.client.core.exception.MissingFieldException;
import net.infobank.client.data.code.RcsButtonType;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public final class CalendarButton implements Button{

	final String type = RcsButtonType.CALENDAR.toString();
	final String name;
	final String startTime;
	final String endTime;
	final String title;
	final String description;

	public CalendarButton(Builder builder) {
		this.name = builder.name;
		this.startTime = builder.startTime;
		this.endTime = builder.endTime;
		this.title = builder.title;
		this.description = builder.description;
	}

    public static class Builder {
        private String name;
		private String startTime;
		private String endTime;
		private String title;
		private String description;

        public Builder() {}

        public Builder name(String name) {
            this.name = name;
            return this;
        }

		public Builder startTime(String startTime) {
            this.startTime = startTime;
            return this;
        }

		public Builder endTime(String endTime) {
            this.endTime = endTime;
            return this;
        }

		public Builder title(String title) {
            this.title = title;
            return this;
        }

		public Builder description(String description) {
            this.description = description;
            return this;
        }

        public CalendarButton build() {

			if(name==null){
				throw new MissingFieldException("name field must not be null");
			}
			if(startTime==null){
				throw new MissingFieldException("startTime field must not be null");
			}
			if(endTime==null){
				throw new MissingFieldException("endTime field must not be null");
			}
			if(title==null){
				throw new MissingFieldException("title field must not be null");
			}
			if(description==null){
				throw new MissingFieldException("description field must not be null");
			}

            return new CalendarButton(this);
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
		return startTime;
	}

	@Override
	@JsonProperty("endTime")
	public String getEndTime() {
		return endTime;
	}

	@Override
	@JsonProperty("title")
	public String getTitle() {
		return title;
	}

	@Override
	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	@Override
	@JsonProperty("text")
	public String getText() {
		return null;
	}

	@Override
	@JsonProperty("phoneNumber")
	public String getPhoneNumber() {
		return null;
	}
}

package net.infobank.client.data.request.rcs.button;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.infobank.client.core.exception.MissingFieldException;
import net.infobank.client.data.code.RcsButtonType;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public final class MapLocationButton implements Button{

	final String type = RcsButtonType.MAP_LOC.toString();
	final String name;
	final String label;
	final String latitude;
	final String longitude;
	final String fallbackUrl;

	public MapLocationButton(Builder builder) {
		this.name = builder.name;
		this.label = builder.label;
		this.latitude = builder.latitude;
		this.longitude = builder.longitude;
		this.fallbackUrl = builder.fallbackUrl;
	}

    public static class Builder {
        private String name;
        private String label;
		private String latitude;
		private String longitude;
		private String fallbackUrl;

        public Builder() {}

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder label(String label) {
            this.label = label;
            return this;
        }

		public Builder latitude(String latitude) {
            this.latitude = latitude;
            return this;
        }

		public Builder longitude(String longitude) {
            this.longitude = longitude;
            return this;
        }

		public Builder fallbackUrl(String fallbackUrl) {
            this.fallbackUrl = fallbackUrl;
            return this;
        }

        public MapLocationButton build() {

			if(name==null){
				throw new MissingFieldException("name field must not be null");
			}
			if(label==null){
				throw new MissingFieldException("label field must not be null");
			}
			if(latitude==null){
				throw new MissingFieldException("latitude field must not be null");
			}
			if(longitude==null){
				throw new MissingFieldException("longitude field must not be null");
			}
			if(fallbackUrl==null){
				throw new MissingFieldException("fallbackUrl field must not be null");
			}

            return new MapLocationButton(this);
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
		return label;
	}

	@Override
	@JsonProperty("latitude")
	public String getLatitude() {
		return latitude;
	}

	@Override
	@JsonProperty("longitude")
	public String getLongitude() {
		return longitude;
	}

	@Override
	@JsonProperty("fallbackUrl")
	public String getFallbackUrl() {
		return fallbackUrl;
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
		return null;
	}
}

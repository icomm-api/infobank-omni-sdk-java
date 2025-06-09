package net.infobank.client.data.request.rcs.button;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.infobank.client.core.exception.MissingFieldException;
import net.infobank.client.data.code.RcsButtonType;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public final class MapQueryButton implements Button{

	final String type = RcsButtonType.MAP_QRY.toString();
	final String name;
	final String label;
	final String query;
	final String fallbackUrl;

	public MapQueryButton(Builder builder) {
		this.name = builder.name;
		this.label = builder.label;
		this.query = builder.query;
		this.fallbackUrl = builder.fallbackUrl;
	}

    public static class Builder {
        private String name;
        private String label;
		private String query;
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

		public Builder query(String query) {
            this.query = query;
            return this;
        }

		public Builder fallbackUrl(String fallbackUrl) {
            this.fallbackUrl = fallbackUrl;
            return this;
        }

        public MapQueryButton build() {

			if(name==null){
				throw new MissingFieldException("name field must not be null");
			}
			if(label==null){
				throw new MissingFieldException("label field must not be null");
			}
			if(query==null){
				throw new MissingFieldException("query field must not be null");
			}
			if(fallbackUrl==null){
				throw new MissingFieldException("fallbackUrl field must not be null");
			}

            return new MapQueryButton(this);
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
		return fallbackUrl;
	}

	@Override
	@JsonProperty("query")
	public String getQuery() {
		return query;
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

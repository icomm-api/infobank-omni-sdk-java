package net.infobank.client.data.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.infobank.client.core.exception.MissingFieldException;
import net.infobank.client.core.exception.UnexpectedException;
import net.infobank.client.data.request.common.Fallback;
import net.infobank.client.data.request.rcs.content.Carousel;
import net.infobank.client.data.request.rcs.content.Standalone;
import net.infobank.client.data.request.rcs.content.Template;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public final class RcsRequest {
    private final Object content;
    private final String from;
    private final String to;
    private final String formatId;
    private final String brandKey;
    private final String brandId;
    private final String expiryOption;
    private final String header;
    private final String footer;
    private final String ref;
    private final Fallback fallback;

	@JsonProperty("content")
    public Object getContent() {
		return content;
	}

	@JsonProperty("from")
	public String getFrom() {
		return from;
	}

	@JsonProperty("to")
	public String getTo() {
		return to;
	}

	@JsonProperty("formatId")
	public String getFormatId() {
		return formatId;
	}

	@JsonProperty("brandKey")
	public String getBrandKey() {
		return brandKey;
	}

	@JsonProperty("brandId")
	public String getBrandId() {
		return brandId;
	}

	@JsonProperty("expiryOption")
	public String getExpiryOption() {
		return expiryOption;
	}

	@JsonProperty("header")
	public String getHeader() {
		return header;
	}

	@JsonProperty("footer")
	public String getFooter() {
		return footer;
	}

	@JsonProperty("ref")
	public String getRef() {
		return ref;
	}

	@JsonProperty("fallback")
	public Fallback getFallback() {
		return fallback;
	}

	private RcsRequest(Builder builder) {
        content = builder.content;
        from = builder.from;
        to = builder.to;
        formatId = builder.formatId;
        brandKey = builder.brandKey;
        brandId = builder.brandId;
        expiryOption = builder.expiryOption;
        header = builder.header;
        footer = builder.footer;
        ref = builder.ref;
        fallback = builder.fallback;
    }

	public static Builder builder() {
		return new Builder();
	}
    
    public static class Builder {
        private Object content;
        private String from;
        private String to;
        private String formatId;
        private String brandKey;
        private String brandId;
        private String expiryOption;
        private String header;
        private String footer;
        private String ref;
        private Fallback fallback;

        public Builder content(Standalone standalone) {
            this.content = standalone;
            return this;
        }

        public Builder content(Carousel carousel) {
            this.content = carousel;
            return this;
        }

        public Builder content(Template template) {
            this.content = template;
            return this;
        }

        public Builder from(String from) {
            this.from = from;
            return this;
        }

        public Builder to(String to) {
            this.to = to;
            return this;
        }

        public Builder formatId(String formatId) {
            this.formatId = formatId;
            return this;
        }

        public Builder brandKey(String brandKey) {
            this.brandKey = brandKey;
            return this;
        }

        public Builder brandId(String brandId) {
            this.brandId = brandId;
            return this;
        }

        public Builder expiryOption(String expiryOption) {
            this.expiryOption = expiryOption;
            return this;
        }

        public Builder header(String header) {
            this.header = header;
            return this;
        }

        public Builder footer(String footer) {
            this.footer = footer;
            return this;
        }

        public Builder ref(String ref) {
            this.ref = ref;
            return this;
        }

        public Builder fallback(Fallback fallback) {
            this.fallback = fallback;
            return this;
        }

        public RcsRequest build() {

            if(content==null){
				throw new MissingFieldException("content field must not be null");
			}
            if(from==null){
				throw new MissingFieldException("from field must not be null");
			}
            if(to==null){
				throw new MissingFieldException("to field must not be null");
			}
            if(formatId==null){
				throw new MissingFieldException("formatId field must not be null");
			}
            if(brandKey==null){
				throw new MissingFieldException("brandKey field must not be null");
			}
            
            return new RcsRequest(this);
        }
    }

	public String toJson() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(this);
		}
		catch (JsonProcessingException jpe) {
			throw new UnexpectedException("Failed to produce JSON from "+getClass().getSimpleName()+" object.", jpe);
		}
	}
}

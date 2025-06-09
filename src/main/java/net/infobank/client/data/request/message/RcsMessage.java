package net.infobank.client.data.request.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.infobank.client.core.exception.MissingFieldException;
import net.infobank.client.data.request.rcs.content.Carousel;
import net.infobank.client.data.request.rcs.content.Standalone;
import net.infobank.client.data.request.rcs.content.Template;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY )
public class RcsMessage{

    final RcsData rcs;

    @JsonProperty("rcs")
    public RcsData getRcs() {
        return rcs;
    }

    RcsMessage(Builder builder) {
        rcs = new RcsData(builder);        
    }

    @JsonInclude(value = JsonInclude.Include.NON_EMPTY )
    private class RcsData {
        private Object content;
        private String from;
        private String formatId;
        private String brandKey;
        private String brandId;
        private String groupId;
        private String expiryOption;
        private String copyAllowed;
        private String header;
        private String footer;
        private String agencyId;
        private String agencyKey;
        private String ttl;

        RcsData(Builder builder) {
            content = builder.content;
            from = builder.from;
            formatId = builder.formatId;
            brandKey = builder.brandKey;
            brandId = builder.brandId;
            groupId = builder.groupId;
            expiryOption = builder.expiryOption;
            copyAllowed = builder.copyAllowed;
            header = builder.header;
            footer = builder.footer;
            agencyId = builder.agencyId;
            agencyKey = builder.agencyKey;
            ttl = builder.ttl;
        }

        @JsonProperty("content")
        public Object getContent() {
            return content;
        }

        @JsonProperty("from")
        public String getFrom() {
            return from;
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

        @JsonProperty("groupId")
        public String getGroupId() {
            return groupId;
        }

        @JsonProperty("expiryOption")
        public String getExpiryOption() {
            return expiryOption;
        }

        @JsonProperty("copyAllowed")
        public String getCopyAllowed() {
            return copyAllowed;
        }

        @JsonProperty("header")
        public String getHeader() {
            return header;
        }

        @JsonProperty("footer")
        public String getFooter() {
            return footer;
        }

        @JsonProperty("agencyId")
        public String getAgencyId() {
            return agencyId;
        }

        @JsonProperty("agencyKey")
        public String getAgencyKey() {
            return agencyKey;
        }

        @JsonProperty("ttl")
        public String getTtl() {
            return ttl;
        }

    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Object content;
        private String from;
        private String formatId;
        private String brandKey;
        private String brandId;
        private String groupId;
        private String expiryOption;
        private String copyAllowed;
        private String header;
        private String footer;
        private String agencyId;
        private String agencyKey;
        private String ttl;

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

        public Builder groupId(String groupId) {
            this.groupId = groupId;
            return this;
        }

        public Builder copyAllowed(String copyAllowed) {
            this.copyAllowed = copyAllowed;
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

        public Builder agencyId(String agencyId) {
            this.agencyId = agencyId;
            return this;
        }

        public Builder agencyKey(String agencyKey) {
            this.agencyKey = agencyKey;
            return this;
        }

        public Builder ttl(String ttl) {
            this.ttl = ttl;
            return this;
        }

        public RcsMessage build() {

            if(from==null){
				throw new MissingFieldException("from field must not be null");
			}
            if(content==null){
				throw new MissingFieldException("content field must not be null");
			}
            if(formatId==null){
				throw new MissingFieldException("formatId field must not be null");
			}
            if(brandKey==null){
				throw new MissingFieldException("brandKey field must not be null");
			}

            return new RcsMessage(this);
        }
    }
}
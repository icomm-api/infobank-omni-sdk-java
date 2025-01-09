package net.infobank.client.data.request.kakao.attachment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public final class ListNode {

	final String title;
	final String description;

	public ListNode(Builder builder) {
		this.title = builder.title;
		this.description = builder.description;
	}

    public static class Builder {

		private String title;
		private String description;

        public Builder() {}

		public Builder title(String title) {
            this.title = title;
            return this;
        }

		public Builder description(String description) {
            this.description = description;
            return this;
        }

        public ListNode build() {
            return new ListNode(this);
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

}
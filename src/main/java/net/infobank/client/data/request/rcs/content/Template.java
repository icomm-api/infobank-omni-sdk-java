package net.infobank.client.data.request.rcs.content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public final class Template {
    private Card template;
 
    @JsonProperty("template")
    public Card getTemplate() {
        return template;
    }

	Template(Builder builder) {
        template = new Card(builder);
    }

	public static Builder builder() {
		return new Builder();
	}

    public static class Builder {
        String title;
        String description;
        HashMap<String, String> userJson = new HashMap<String, String>();
        List<SubContent> subContent = new ArrayList<>();

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder addSubContent(SubContent subContent) {
            this.subContent.add(subContent);
            return this;
        }

        public Builder put(String key, String value) {
            this.userJson.put(key, value);
            return this;
        }

        public Template build() {
            return new Template(this);
        }
    }
}


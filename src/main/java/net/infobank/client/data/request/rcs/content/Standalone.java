package net.infobank.client.data.request.rcs.content;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.infobank.client.data.request.rcs.button.Button;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public final class Standalone {
    private Card standalone;

    @JsonProperty("standalone")
    public Card getStandalone() {
        return standalone;
    }
	
	Standalone(Builder builder) {
        standalone = new Card(builder);
    }

	public static Builder builder() {
		return new Builder();
	}

    public static class Builder {
        String text;
        String title;
        String media;
        String mediaUrl;
        List<Button> button = new ArrayList<>();
        List<SubContent> subContent = new ArrayList<>();

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder media(String media) {
            this.media = media;
            return this;
        }

        public Builder mediaUrl(String mediaUrl) {
            this.mediaUrl = mediaUrl;
            return this;
        }

        public Builder addButton(Button button) {
            this.button.add(button);
            return this;
        }

        public Builder addSubContent(SubContent subContent) {
            this.subContent.add(subContent);
            return this;
        }

        public Standalone build() {
            return new Standalone(this);
        }
    }
}


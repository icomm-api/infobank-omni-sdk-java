package net.infobank.client.data.request.rcs.content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.infobank.client.data.request.rcs.button.Button;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY )
public class Card{
    private String text;
    private String title;
    private String media;   
    private String mediaUrl;
    private String description;
    private HashMap<String, String> userJson;
    private List<Button> button;
    private List<SubContent> subContent;

    Card(net.infobank.client.data.request.rcs.content.Standalone.Builder builder) {
        text = builder.text;
        title = builder.title;
        media = builder.media;
        button = builder.button;
        subContent = builder.subContent;
    }

    Card(Builder builder) {
        text = builder.text;
        title = builder.title;
        media = builder.media;
        mediaUrl = builder.mediaUrl;
        button = builder.button;
    }

    Card(net.infobank.client.data.request.rcs.content.Template.Builder builder) {
        description = builder.description;
        userJson = builder.userJson;
        subContent = builder.subContent;
    }

    public static Builder builder() {
		return new Builder();
	}

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("media")
    public String getMedia() {
        return media;
    }

    @JsonProperty("mediaUrl")
    public String getMediaUrl() {
        return mediaUrl;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("button")
    public List<Button> getButton() {
        return button;
    }

    @JsonAnyGetter
    public HashMap<String,String> getUserJson() {
        return userJson;
    }

    @JsonProperty("subContent")
    public List<SubContent> getSubContent() {
        return subContent;
    }

    public static class Builder {
        String text;
        String title;
        String media;
        String mediaUrl;
        List<Button> button = new ArrayList<>();

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

        public Card build() {
            return new Card(this);
        }
    }
}
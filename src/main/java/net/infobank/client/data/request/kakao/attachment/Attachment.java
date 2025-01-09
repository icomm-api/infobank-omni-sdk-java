package net.infobank.client.data.request.kakao.attachment;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.infobank.client.data.request.kakao.button.Button;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public final class Attachment {

	final List<Button> button;
	final Item item;
	final ItemHighlight itemHighlight;
	final Image image;

	public Attachment(Builder builder) {
		this.button = builder.button;
		this.item = builder.item;
		this.itemHighlight = builder.itemHighlight;
		this.image = builder.image;
	}

    public static class Builder {

		private List<Button> button = new ArrayList<>();
		private Item item;
		private ItemHighlight itemHighlight;
		private Image image;

        public Builder() {}

		public Builder addButton(Button button) {
            this.button.add(button);
            return this;
        }

		public Builder item(Item item) {
            this.item = item;
            return this;
        }

		public Builder itemHighlight(ItemHighlight itemHighlight) {
            this.itemHighlight = itemHighlight;
            return this;
        }

		public Builder image(Image image) {
            this.image = image;
            return this;
        }

        public Attachment build() {
            return new Attachment(this);
        }
    }

	public static Builder builder() {
		return new Builder();
	}

	@JsonProperty("button")
	public List<Button> getButton() {
		return button;
	}

	@JsonProperty("item")
	public Item getItem() {
		return item;
	}

	@JsonProperty("itemHighlight")
	public ItemHighlight getItemHighlight() {
		return itemHighlight;
	}

	@JsonProperty("image")
	public Image getImage() {
		return image;
	}

}

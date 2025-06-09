package net.infobank.client.data.request.kakao.attachment;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import net.infobank.client.data.request.kakao.button.Button;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public final class Attachment {

	final List<Button> button;
	final Item item;
	final ItemHighlight itemHighlight;
	final Image image;
	final Coupon coupon;
	final Commerce commerce;
	final Video video;


	public Attachment(Builder builder) {
		this.button = builder.button;
		this.item = builder.item;
		this.itemHighlight = builder.itemHighlight;
		this.image = builder.image;
		this.coupon = builder.coupon;
		this.commerce = builder.commerce;
		this.video = builder.video;
	}

	public static class Builder {

		private List<Button> button = new ArrayList<>();
		private Item item;
		private ItemHighlight itemHighlight;
		private Image image;
		private Coupon coupon;
		private Commerce commerce;
		private Video video;


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

		public Builder coupon(Coupon coupon) {
			this.coupon = coupon;
			return this;
		}

		public Builder commerce(Commerce commerce) {
			this.commerce = commerce;
			return this;
		}

		public Builder video(Video video) {
			this.video = video;
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

	@JsonProperty("coupon")
	public Coupon getCoupon() {
		return coupon;
	}

	@JsonProperty("commerce")
	public Commerce getCommerce() {
		return commerce;
	}

	@JsonProperty("video")
	public Video getVideo() {
		return video;
	}

}

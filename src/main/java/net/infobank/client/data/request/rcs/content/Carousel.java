package net.infobank.client.data.request.rcs.content;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public final class Carousel {
    private List<Card> carousel;

    @JsonProperty("carousel")
    public List<Card> getCarousel() {
        return carousel;
    }
	
	Carousel(Builder builder) {
        carousel = builder.carousel;
    }

	public static Builder builder() {
		return new Builder();
	}

    public static class Builder {

        List<Card> carousel = new ArrayList<>();

        public Builder addCard(Card card){
            carousel.add(card);
            return this;
        }

        public Carousel build() {
            return new Carousel(this);
        }
    }
}


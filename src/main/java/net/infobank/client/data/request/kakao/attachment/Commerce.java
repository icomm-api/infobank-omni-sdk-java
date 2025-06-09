package net.infobank.client.data.request.kakao.attachment;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Commerce {

    final String title;
    final int regularPrice;
    final int discountPrice;
    final int discountRate;
    final int discountFixed;

    public Commerce(Builder builder) {
        this.title = builder.title;
        this.regularPrice = builder.regularPrice;
        this.discountPrice = builder.discountPrice;
        this.discountRate = builder.discountRate;
        this.discountFixed = builder.discountFixed;
    }

    public static class Builder {

        private String title;
        private int regularPrice;
        private int discountPrice;
        private int discountRate;
        private int discountFixed;

        public Builder() {}

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder regularPrice(int regularPrice) {
            this.regularPrice = regularPrice;
            return this;
        }

        public Builder discountPrice(int discountPrice) {
            this.discountPrice = discountPrice;
            return this;
        }

        public Builder discountRate(int discountRate) {
            this.discountRate = discountRate;
            return this;
        }

        public Builder discountFixed(int discountFixed) {
            this.discountFixed = discountFixed;
            return this;
        }

        public Commerce build() {
            return new Commerce(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("regularPrice")
    public int getRegularPrice() {
        return regularPrice;
    }

    @JsonProperty("discountPrice")
    public int getDiscountPrice() {
        return discountPrice;
    }

    @JsonProperty("discountRate")
    public int getDiscountRate() {
        return discountRate;
    }

    @JsonProperty("discountFixed")
    public int getDiscountFixed() {
        return discountFixed;
    }

}

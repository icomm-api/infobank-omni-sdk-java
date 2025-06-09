package net.infobank.client.data.request.kakao;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.infobank.client.data.request.kakao.attachment.Attachment;
import net.infobank.client.data.request.kakao.carousel.List;
import net.infobank.client.data.request.kakao.carousel.Head;
import net.infobank.client.data.request.kakao.carousel.Tail;

import java.util.ArrayList;

public class Carousel {

    final Head head;
    final java.util.List<List> list;
    final Tail tail;

    public Carousel(Carousel.Builder builder) {
        this.head = builder.head;
        this.list = builder.list;
        this.tail = builder.tail;
    }

    public static class Builder {

        private Head head;
        private java.util.List<List> list = new ArrayList<List>();
        private Tail tail;

        public Builder() {}

        public Builder head(Head head) {
            this.head = head;
            return this;
        }

        public Builder addList(List carouselList) {
            this.list.add(carouselList);
            return this;
        }

        public Builder tail(Tail tail) {
            this.tail = tail;
            return this;
        }

        public Carousel build() {
            return new Carousel(this);
        }
    }

    public static Builder builder() {
        return new Carousel.Builder();
    }

    @JsonProperty("head")
    public Head getHead() {
        return head;
    }

    @JsonProperty("list")
    public java.util.List<List> getList() {
        return list;
    }

    @JsonProperty("tail")
    public Tail getTail() {
        return tail;
    }
}

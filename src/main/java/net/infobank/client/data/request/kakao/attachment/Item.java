package net.infobank.client.data.request.kakao.attachment;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Item {

    final java.util.List<List> list;
    final Summary summary;

    public Item(Builder builder) {
        this.list = builder.list;
        this.summary = builder.summary;
    }

    public static class Builder {

        private java.util.List<List> list = new ArrayList<>();
        private Summary summary;

        public Builder() {}

        public Builder addList(List obj) {
            this.list.add(obj);
            return this;
        }

        public Builder summary(Summary summary) {
            this.summary = summary;
            return this;
        }

        public Item build() {
            return new Item(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonProperty("list")
    public java.util.List<List> getList() {
        return list;
    }

    @JsonProperty("summary")
    public Summary getSummary() {
        return summary;
    }

}

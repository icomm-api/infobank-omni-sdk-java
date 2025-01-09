package net.infobank.client.data.request.kakao.attachment;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public final class Item {

	final List<ListNode> list;
	final Summary summary;

	public Item(Builder builder) {
		this.list = builder.list;
		this.summary = builder.summary;
	}

    public static class Builder {

		private List<ListNode> list = new ArrayList<>();
		private Summary summary;

        public Builder() {}

		public Builder addList(ListNode obj) {
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
	public List<ListNode> getList() {
		return list;
	}

	@JsonProperty("summary")
	public Summary getSummary() {
		return summary;
	}

}

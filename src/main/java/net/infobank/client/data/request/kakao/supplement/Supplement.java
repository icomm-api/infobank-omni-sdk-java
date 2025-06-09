package net.infobank.client.data.request.kakao.supplement;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.infobank.client.data.request.kakao.quickreply.QuickReply;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public final class Supplement {

	final List<QuickReply> quickReply;

	public Supplement(Builder builder) {
		this.quickReply = builder.quickReply;
	}

    public static class Builder {

		private List<QuickReply> quickReply = new ArrayList<>();

        public Builder() {}

		public Builder addQuickReply(QuickReply quickReply) {
            this.quickReply.add(quickReply);
            return this;
        }

        public Supplement build() {
            return new Supplement(this);
        }
    }

	public static Builder builder() {
		return new Builder();
	}

	@JsonProperty("quickReply")
	public List<QuickReply> getQuickReply() {
		return quickReply;
	}

}

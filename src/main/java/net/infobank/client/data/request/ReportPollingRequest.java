package net.infobank.client.data.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import net.infobank.client.core.exception.UnexpectedException;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public final class ReportPollingRequest {
	
	final String reportId;
	String method;

	ReportPollingRequest(Builder builder) {

		this.reportId = builder.reportId;
	}

	@JsonProperty("reportId")
	public String getReportId() {
		return reportId;
	}

	@JsonIgnore
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private String reportId;

		Builder() {}

		public Builder reportId(String reportId) {
            this.reportId = reportId;
            return this;
        }

		public ReportPollingRequest build() {

			return new ReportPollingRequest(this);
		}
	}

	public String toJson() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(this);
		}
		catch (JsonProcessingException jpe) {
			throw new UnexpectedException("Failed to produce JSON from "+getClass().getSimpleName()+" object.", jpe);
		}
	}
}

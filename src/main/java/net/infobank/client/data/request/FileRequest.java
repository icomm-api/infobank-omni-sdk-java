package net.infobank.client.data.request;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import net.infobank.client.core.exception.MissingFieldException;
import net.infobank.client.core.exception.UnsupportedMessageException;
import net.infobank.client.data.code.MessageType;
import net.infobank.client.data.code.ServiceType;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public final class FileRequest {
	
	private final File file;
	private final String serviceType;
	private String msgType;

	FileRequest(Builder builder) {
		this.file = builder.file;
		this.serviceType = builder.serviceType.toString();
		try{
			this.msgType = builder.msgType.toString();
		}catch(NullPointerException e){
			this.msgType = "";
		}
	}

	@JsonProperty("file")
	public File getFile() {
		return file;
	}

	@JsonProperty("serviceType")
	public String getServiceType() {
		return serviceType;
	}

	@JsonProperty("msgType")
	public String getMsgType() {
		return msgType;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private File file;
		private ServiceType serviceType;
		private MessageType msgType;

		Builder() {}

		public Builder file(File file) {
            this.file = file;
            return this;
        }

		public Builder serviceType(ServiceType serviceType) {
            this.serviceType = serviceType;
            return this;
        }

		public Builder msgType(MessageType msgType) {
            this.msgType = msgType;
            return this;
        }

		public FileRequest build() {

			if(file==null){
				throw new MissingFieldException("file field must not be null");
			}
			if(serviceType==null){
				throw new MissingFieldException("serviceType field must not be null");
			}
			if(ServiceType.FRIENDTALK.equals(serviceType)){
				if(!serviceType.supports(msgType)){
					throw new UnsupportedMessageException("This msgType is not supported by the " + serviceType.toString());
				}
			}

			return new FileRequest(this);
		}
	}
}

package net.infobank.client.data.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Represents the type of the message.
 */
public enum SendType {

    basic,

	free;

    @JsonCreator
	public static SendType fromString(String value) {
		if (value == null) return null;
		return SendType.valueOf(value.toUpperCase());
	}

	@JsonValue
	@Override
	public String toString() {
		return name();
	}
}

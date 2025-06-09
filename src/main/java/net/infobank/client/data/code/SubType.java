package net.infobank.client.data.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Represents the type of the message.
 */
public enum SubType {

    first,

	middle,

	end;

    @JsonCreator
	public static SubType fromString(String value) {
		if (value == null) return null;
		return SubType.valueOf(value.toUpperCase());
	}

	@JsonValue
	@Override
	public String toString() {
		return name();
	}
}

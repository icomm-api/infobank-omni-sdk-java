package net.infobank.client.data.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Represents the services available for sending messages.
 */
public enum FallbackType {

    /**
     * SMS Fallback
     */
    SMS,
	/**
     * MMS Falback
     */
    MMS;

    @JsonCreator
	public static FallbackType fromString(String value) {
		if (value == null) return null;
		return FallbackType.valueOf(value.toUpperCase());
	}

	@JsonValue
	@Override
	public String toString() {
		return name();
	}
}

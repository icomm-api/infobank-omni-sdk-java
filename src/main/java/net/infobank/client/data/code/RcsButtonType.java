package net.infobank.client.data.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Represents the services available for sending messages.
 */
public enum RcsButtonType {

    /**
     * RCS Button(URL)
	 * <p>
	 * Connect to Web page or App.
     */
    URL,
	/**
     * RCS Button(MAP_LOC)
     */
    MAP_LOC,
	/**
     * RCS Button(MAP_QRY)
     */
    MAP_QRY,
	/**
     * RCS Button(MAP_SEND)
     */
    MAP_SEND,
	/**
     * RCS Button(CALENDAR)
     */
    CALENDAR,
	/**
     * RCS Button(COPY)
     */
    COPY,
	/**
     * RCS Button(COM_T)
     */
    COM_T,
	/**
     * RCS Button(COM_V)
     */
    COM_V,
	/**
     * RCS Button(DIAL)
     */
    DIAL;

    @JsonCreator
	public static RcsButtonType fromString(String value) {
		if (value == null) return null;
		return RcsButtonType.valueOf(value.toUpperCase());
	}

	@JsonValue
	@Override
	public String toString() {
		return name();
	}
}

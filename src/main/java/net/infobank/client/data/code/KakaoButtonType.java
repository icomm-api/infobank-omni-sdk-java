package net.infobank.client.data.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Represents the services available for sending messages.
 */
public enum KakaoButtonType {

    /**
     * Kakao Button(WL)
	 * <p>
	 * Connect to Web page.
     */
    WL,
	/**
     * Kakao Button(AL)
     */
    AL,
    /**
     * Kakao Button(BK)
     */
    BK,
    /**
     * Kakao Button(MD)
     */
    MD,
    /**
     * Kakao Button(DS)
     */
    DS,
    /**
     * Kakao Button(BC)
     */
    BC,
    /**
     * Kakao Button(BT)
     */
    BT,
    /**
     * Kakao Button(AC)
     */
    AC,
    /**
     * Kakao Button(BF)
     */
    BF;

    @JsonCreator
	public static KakaoButtonType fromString(String value) {
		if (value == null) return null;
		return KakaoButtonType.valueOf(value.toUpperCase());
	}

	@JsonValue
	@Override
	public String toString() {
		return name();
	}
}

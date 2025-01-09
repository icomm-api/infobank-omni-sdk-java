package net.infobank.client.data.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Represents the services available for sending messages.
 */
public enum KakaoQuickReplyType {

    /**
     * Kakao QuickReply Type(WL)
	 * <p>
	 * Connect to Web page.
     */
    WL,
	/**
     * Kakao QuickReply Type(AL)
     */
    AL,
    /**
     * Kakao QuickReply Type(BK)
     */
    BK,
    /**
     * Kakao QuickReply Type(MD)
     */
    MD,
    /**
     * Kakao QuickReply Type(BC)
     */
    BC,
    /**
     * Kakao QuickReply Type(BT)
     */
    BT,
    /**
     * Kakao QuickReply Type(BF)
     */
    BF;

    @JsonCreator
	public static KakaoQuickReplyType fromString(String value) {
		if (value == null) return null;
		return KakaoQuickReplyType.valueOf(value.toUpperCase());
	}

	@JsonValue
	@Override
	public String toString() {
		return name();
	}
}

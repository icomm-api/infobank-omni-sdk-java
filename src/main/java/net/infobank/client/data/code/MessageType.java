package net.infobank.client.data.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Represents the type of the message.
 */
public enum MessageType {
    /**
     * SMS(Short Message)
     */
    SM, 

	/**
	 * LMS(Long Message)
	 */
	LM,

	/**
	 * MMS(Multimedia Message)
	 */
	MM, 

	/**
	 * International Message
	 */
	IM,
	
	/**
	 * RCS SMS
	 * (Rich Commnuication,
	 *  Short Message)
	 */
	RS,

	/**
	 * RCS LMS
	 * (Rich Commnuication,
	 *  Long Message)
	 */
	RL, 

	/**
	 * RCS MMS
	 * (Rich Commnuication,
	 *  Multimedia Message)
	 */
	RM,

	/**
	 * RCS Free Template
	 */
	RF,

	/**
	 * RCS Description Template
	 */
	RD,
	
	/**
	 * RCS Cell Template
	 */
	RC,

	/**
	 * RCS Image Template
	 */
	RI,

	/**
	 * Kakao Alimtalk Text
	 */
	AT,

	/**
	 * Kakao Alimtalk Image
	 */
	AI,

	/**
	 * Kakao Friendtalk Text
	 */ 
	FT, 

	/**
	 * Kakao Friendtalk Image
	 */ 
	FI,
	
	/**
	 * Kakao Friendtalk Wideimage
	 */ 
	FW,

	/**
	 * Kakao Friendtalk Wideimage Itemlist
	 */ 
	FL,

	/**
	 * Kakao Friendtalk Carousel
	 */ 
	FC;

    @JsonCreator
	public static MessageType fromString(String value) {
		if (value == null) return null;
		return MessageType.valueOf(value.toUpperCase());
	}

	@JsonValue
	@Override
	public String toString() {
		return name();
	}
}

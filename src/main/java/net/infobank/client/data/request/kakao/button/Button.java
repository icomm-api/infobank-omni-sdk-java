package net.infobank.client.data.request.kakao.button;

public interface Button{
	public String getType();
	public String getName();
	public String getUrlPc();
	public String getUrlMobile();
	public String getSchemeIos();
	public String getSchemeAndroid();
	public String getTarget();
	public String getChatExtra();
	public String getChatEvent();
	public String getBizFormKey();
	public String getBizFormId();
}


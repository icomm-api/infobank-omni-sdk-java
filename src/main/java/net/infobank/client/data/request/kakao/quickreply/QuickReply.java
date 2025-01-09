package net.infobank.client.data.request.kakao.quickreply;

public interface QuickReply{
	public String getType();
	public String getName();
	public String getUrlPc();
	public String getUrlMobile();
	public String getSchemeIos();
	public String getSchemeAndroid();
	public String getChatExtra();
	public String getChatEvent();
	public String getBizFormId();
}


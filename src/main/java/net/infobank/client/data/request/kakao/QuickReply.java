package net.infobank.client.data.request.kakao;

import net.infobank.client.data.request.kakao.quickreply.AppLinkQuickReply;
import net.infobank.client.data.request.kakao.quickreply.BizFormQuickReply;
import net.infobank.client.data.request.kakao.quickreply.BotKeywordQuickReply;
import net.infobank.client.data.request.kakao.quickreply.ChatbotTransformQuickReply;
import net.infobank.client.data.request.kakao.quickreply.ConsultingQuickReply;
import net.infobank.client.data.request.kakao.quickreply.WebLinkQuickReply;

public class QuickReply {

    public static AppLinkQuickReply.Builder AppLinkQuickReplyBuilder(){
        return new AppLinkQuickReply.Builder();
    }

    public static BizFormQuickReply.Builder BizFormQuickReplyBuilder(){
        return new BizFormQuickReply.Builder();
    }

    public static BotKeywordQuickReply.Builder BotKeywordQuickReplyBuilder(){
        return new BotKeywordQuickReply.Builder();
    }

    public static ChatbotTransformQuickReply.Builder ChatbotTransformQuickReplyBuilder(){
        return new ChatbotTransformQuickReply.Builder();
    }

    public static ConsultingQuickReply.Builder ConsultingQuickReplyBuilder(){
        return new ConsultingQuickReply.Builder();
    }

    public static WebLinkQuickReply.Builder WebLinkQuickReplyBuilder(){
        return new WebLinkQuickReply.Builder();
    }


}

package net.infobank.client.data.request.kakao;

import net.infobank.client.data.request.kakao.button.AddChannelButton;
import net.infobank.client.data.request.kakao.button.AppLinkButton;
import net.infobank.client.data.request.kakao.button.BizFormButton;
import net.infobank.client.data.request.kakao.button.BotKeywordButton;
import net.infobank.client.data.request.kakao.button.ChatbotTransformButton;
import net.infobank.client.data.request.kakao.button.ConsultingButton;
import net.infobank.client.data.request.kakao.button.DeliverySearchButton;
import net.infobank.client.data.request.kakao.button.MessageDeliveryButton;
import net.infobank.client.data.request.kakao.button.WebLinkButton;

public class Button {

    public static AddChannelButton.Builder AddChannelButtonBuilder(){
        return new AddChannelButton.Builder();
    }

    public static AppLinkButton.Builder AppLinkButtonBuilder(){
        return new AppLinkButton.Builder();
    }

    public static BizFormButton.Builder BizFormButtonBuilder(){
        return new BizFormButton.Builder();
    }

    public static BotKeywordButton.Builder BotKeywordButtonBuilder(){
        return new BotKeywordButton.Builder();
    }

    public static ChatbotTransformButton.Builder ChatbotTransformButtonBuilder(){
        return new ChatbotTransformButton.Builder();
    }

    public static ConsultingButton.Builder ConsultingButtonBuilder(){
        return new ConsultingButton.Builder();
    }

    public static DeliverySearchButton.Builder DeliverySearchButtonBuilder(){
        return new DeliverySearchButton.Builder();
    }

    public static MessageDeliveryButton.Builder MessageDeliveryButtonBuilder(){
        return new MessageDeliveryButton.Builder();
    }

    public static WebLinkButton.Builder WeblinkButtonBuilder(){
        return new WebLinkButton.Builder();
    }

}

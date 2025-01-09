package net.infobank.client;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import net.infobank.client.core.HttpConfig;
import net.infobank.client.core.exception.MissingFieldException;
import net.infobank.client.data.code.FallbackType;
import net.infobank.client.data.code.MessageType;
import net.infobank.client.data.request.FriendtalkRequest;
import net.infobank.client.data.request.common.Fallback;
import net.infobank.client.data.request.kakao.Button;
import net.infobank.client.data.response.FriendtalkResponse;

public class Test09_SendFriendtalk {

    // Client정보
    private static final String BASE_URL = "http://172.16.0.73:7000";
    private static final String CLIENT_ID = "clo445";
    private static final String PASSWORD = "12345678";

    //친구톡 정보
    private static final String TO = "01000000000";
    private static final String TEXT = "테스트메시지1234";
    private static final String REF = "참조필드";
    private static final String NAME = "버튼명";
    private static final String SENDER_KEY = "senderKey";

    private static final String URL_MOBILE = "http://127.0.0.1";
    private static final String URL_PC = "http://127.0.0.1";

    private static final String SCHEME_IOS = "schemeIos";
    private static final String SCHEME_ANDROID = "schemeAndroid";

    private static final String CHAT_EXTRA = "chatExtra";
    private static final String CHAT_EVENT = "chatEvent";

    private static final String BIZ_FORM_ID = "bizFormId";
    private static final String BIZ_FORM_KEY = "bizFormKey";

    private static String IMG_URL = "http://127.0.0.1";

    //FALLBACK 정보
    private static final String FROM_FALLBACK = "0316281564";
    private static final String TEXT_FALLBACK = "fallback메시지123";
    private static final String ORIGIN_CID = "123456789";
    private static final String TITLE_FALLBACK = "fallback메시지제목123";

    InfobankClient client = InfobankClient.builder()
                                .clientId(CLIENT_ID)
                                .password(PASSWORD)
                                .httpConfig(HttpConfig.builder().baseUrl(BASE_URL).build())
                                .build();

    @Test
    public void OMNI_SDK_64_sendFriendtalkMandatory() throws Exception {
        FriendtalkRequest friendtalk = FriendtalkRequest.builder()
                                   .to(TO)
                                   .senderKey(SENDER_KEY)
                                   .text(TEXT)
                                   .msgType(MessageType.FT)
                                   .build();
        FriendtalkResponse res = client.send(friendtalk);
        assertEquals("A000", res.getCode());
    }

    @Test(expected = MissingFieldException.class)
    public void OMNI_SDK_65_sendFriendtalkMissingMandatory() throws Exception {
        FriendtalkRequest friendtalk = FriendtalkRequest.builder()
                                   .to(TO)
                                   .text(TEXT)
                                   .msgType(MessageType.FT)
                                   .build();
        FriendtalkResponse res = client.send(friendtalk);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_66_sendFriendtalkWithOption() throws Exception {
        FriendtalkRequest friendtalk = FriendtalkRequest.builder()
                                   .to(TO)
                                   .senderKey(SENDER_KEY)
                                   .text(TEXT)
                                   .msgType(MessageType.FI)
                                   .imgUrl(IMG_URL)
                                   .ref(REF)
                                   .build();
        FriendtalkResponse res = client.send(friendtalk);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_67_sendFriendtalkWithFallback() throws Exception {
        FriendtalkRequest friendtalk = FriendtalkRequest.builder()
                                   .to(TO)
                                   .senderKey(SENDER_KEY)
                                   .text(TEXT)
                                   .msgType(MessageType.FT)
                                   .ref(REF)
                                   .fallback(Fallback.builder().type(FallbackType.MMS).from(FROM_FALLBACK).title(TITLE_FALLBACK).text(TEXT_FALLBACK).originCID(ORIGIN_CID).build())
                                   .build();
        FriendtalkResponse res = client.send(friendtalk);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_68_sendFriendtalkButtonWeblink() throws Exception {
        FriendtalkRequest friendtalk = FriendtalkRequest.builder()
                                   .to(TO)
                                   .senderKey(SENDER_KEY)
                                   .text(TEXT)
                                   .msgType(MessageType.FT)
                                   .ref(REF)
                                   .addButton(Button.WeblinkButtonBuilder().name(NAME).urlPc(URL_PC).urlMobile(URL_MOBILE).build())
                                   .build();
        FriendtalkResponse res = client.send(friendtalk);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_69_sendFriendtalkButtonApplink() throws Exception {
        FriendtalkRequest friendtalk = FriendtalkRequest.builder()
                                   .to(TO)
                                   .senderKey(SENDER_KEY)
                                   .text(TEXT)
                                   .msgType(MessageType.FT)
                                   .ref(REF)
                                   .addButton(Button.AppLinkButtonBuilder().name(NAME).schemeAndroid(SCHEME_ANDROID).schemeIos(SCHEME_IOS).urlMobile(URL_MOBILE).urlPc(URL_PC).build())
                                   .build();
        FriendtalkResponse res = client.send(friendtalk);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_70_sendFriendtalkButtonBotkeyword() throws Exception {
        FriendtalkRequest friendtalk = FriendtalkRequest.builder()
                                   .to(TO)
                                   .senderKey(SENDER_KEY)
                                   .text(TEXT)
                                   .msgType(MessageType.FT)
                                   .ref(REF)
                                   .addButton(Button.BotKeywordButtonBuilder().name(NAME).build())
                                   .build();
        FriendtalkResponse res = client.send(friendtalk);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_71_sendFriendtalkButtonMessageDelivery() throws Exception {
        FriendtalkRequest friendtalk = FriendtalkRequest.builder()
                                   .to(TO)
                                   .senderKey(SENDER_KEY)
                                   .text(TEXT)
                                   .msgType(MessageType.FT)
                                   .ref(REF)
                                   .addButton(Button.MessageDeliveryButtonBuilder().name(NAME).build())
                                   .build();
        FriendtalkResponse res = client.send(friendtalk);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_72_sendFriendtalkButtonDeliverySearch() throws Exception {
        FriendtalkRequest friendtalk = FriendtalkRequest.builder()
                                   .to(TO)
                                   .senderKey(SENDER_KEY)
                                   .text(TEXT)
                                   .msgType(MessageType.FT)
                                   .ref(REF)
                                   .addButton(Button.DeliverySearchButtonBuilder().name(NAME).build())
                                   .build();
        FriendtalkResponse res = client.send(friendtalk);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_73_sendFriendtalkButtonConsulting() throws Exception {
        FriendtalkRequest friendtalk = FriendtalkRequest.builder()
                                   .to(TO)
                                   .senderKey(SENDER_KEY)
                                   .text(TEXT)
                                   .msgType(MessageType.FT)
                                   .ref(REF)
                                   .addButton(Button.ConsultingButtonBuilder().chatExtra(CHAT_EXTRA).name(NAME).build())
                                   .build();
        FriendtalkResponse res = client.send(friendtalk);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_74_sendFriendtalkButtonChatbotTransform() throws Exception {
        FriendtalkRequest friendtalk = FriendtalkRequest.builder()
                                   .to(TO)
                                   .senderKey(SENDER_KEY)
                                   .text(TEXT)
                                   .msgType(MessageType.FT)
                                   .ref(REF)
                                   .addButton(Button.ChatbotTransformButtonBuilder().chatEvent(CHAT_EVENT).chatExtra(CHAT_EXTRA).name(NAME).build())
                                   .build();
        FriendtalkResponse res = client.send(friendtalk);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_75_sendFriendtalkButtonAddChannel() throws Exception {
        FriendtalkRequest friendtalk = FriendtalkRequest.builder()
                                   .to(TO)
                                   .senderKey(SENDER_KEY)
                                   .text(TEXT)
                                   .msgType(MessageType.FT)
                                   .ref(REF)
                                   .addButton(Button.AddChannelButtonBuilder().build())
                                   .build();
        FriendtalkResponse res = client.send(friendtalk);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_76_sendFriendtalkButtonBizForm() throws Exception {
        FriendtalkRequest friendtalk = FriendtalkRequest.builder()
                                   .to(TO)
                                   .senderKey(SENDER_KEY)
                                   .text(TEXT)
                                   .msgType(MessageType.FT)
                                   .ref(REF)
                                   .addButton(Button.BizFormButtonBuilder().bizFormId(BIZ_FORM_ID).bizFormKey(BIZ_FORM_KEY).name(NAME).build())
                                   .build();
        FriendtalkResponse res = client.send(friendtalk);
        assertEquals("A000", res.getCode());
    }

}
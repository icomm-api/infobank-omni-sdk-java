package net.infobank.client;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import net.infobank.client.core.HttpConfig;
import net.infobank.client.core.exception.MissingFieldException;
import net.infobank.client.data.code.FallbackType;
import net.infobank.client.data.code.MessageType;
import net.infobank.client.data.request.AlimtalkRequest;
import net.infobank.client.data.request.common.Fallback;
import net.infobank.client.data.request.kakao.Button;
import net.infobank.client.data.response.AlimtalkResponse;

public class Test08_SendAlmtalk {

    // Client정보
    private static final String BASE_URL = "http://172.16.0.73:7000";
    private static final String CLIENT_ID = "clo445";
    private static final String PASSWORD = "12345678";

    //알림톡 정보
    private static final String TO = "01000000000";
    private static final String TEXT = "테스트메시지1234";
    private static final String REF = "참조필드";
    private static final String NAME = "버튼명";
    private static final String SENDER_KEY = "senderKey";
    private static final String TEMPLATE_CODE = "templateCode";
    
    private static final String URL_MOBILE = "http://127.0.0.1";
    private static final String URL_PC = "http://127.0.0.1";

    private static final String SCHEME_IOS = "schemeIos";
    private static final String SCHEME_ANDROID = "schemeAndroid";

    private static final String CHAT_EXTRA = "chatExtra";
    private static final String CHAT_EVENT = "chatEvent";

    private static final String BIZ_FORM_ID = "bizFormId";
    private static final String BIZ_FORM_KEY = "bizFormKey";


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
    public void OMNI_SDK_51_sendAlimtalkMandatory() throws Exception {

        AlimtalkRequest alimtalk = AlimtalkRequest.builder()
                                   .to(TO)
                                   .senderKey(SENDER_KEY)
                                   .templateCode(TEMPLATE_CODE)
                                   .text(TEXT)
                                   .msgType(MessageType.AT)
                                   .build();
        AlimtalkResponse res = client.send(alimtalk);
        assertEquals("A000", res.getCode());
    }

    @Test(expected = MissingFieldException.class)
    public void OMNI_SDK_52_sendAlimtalkMissingMandatory() throws Exception {

        AlimtalkRequest alimtalk = AlimtalkRequest.builder()
                                   .senderKey(SENDER_KEY)
                                   .templateCode(TEMPLATE_CODE)
                                   .text(TEXT)
                                   .msgType(MessageType.AT)
                                   .build();
        AlimtalkResponse res = client.send(alimtalk);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_53_sendAlimtalkWithOption() throws Exception {

        AlimtalkRequest alimtalk = AlimtalkRequest.builder()
                                   .senderKey(SENDER_KEY)
                                   .msgType(MessageType.AT)
                                   .to(TO)                                   
                                   .templateCode(TEMPLATE_CODE)
                                   .text(TEXT)
                                   .addButton(Button.WeblinkButtonBuilder().urlMobile(URL_MOBILE).urlPc(URL_PC).name(NAME).build())
                                   .ref(REF)
                                   .build();
        AlimtalkResponse res = client.send(alimtalk);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_54_sendAlimtalkWithFallback() throws Exception {

        AlimtalkRequest alimtalk = AlimtalkRequest.builder()
                                   .senderKey(SENDER_KEY)
                                   .msgType(MessageType.AT)
                                   .to(TO)                                   
                                   .templateCode(TEMPLATE_CODE)
                                   .text(TEXT)
                                   .addButton(Button.WeblinkButtonBuilder().urlMobile(URL_MOBILE).urlPc(URL_PC).name(NAME).build())
                                   .ref(REF)
                                   .fallback(Fallback.builder().type(FallbackType.MMS).from(FROM_FALLBACK).text(TEXT_FALLBACK).title(TITLE_FALLBACK).originCID(ORIGIN_CID).build())
                                   .build();
        AlimtalkResponse res = client.send(alimtalk);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_55_sendAlimtalkButtonWeblink() throws Exception {

        AlimtalkRequest alimtalk = AlimtalkRequest.builder()
                                   .senderKey(SENDER_KEY)
                                   .msgType(MessageType.AT)
                                   .to(TO)                                   
                                   .templateCode(TEMPLATE_CODE)
                                   .text(TEXT)
                                   .addButton(Button.WeblinkButtonBuilder().urlMobile(URL_MOBILE).urlPc(URL_PC).name(NAME).build())
                                   .ref(REF)
                                   .build();
        AlimtalkResponse res = client.send(alimtalk);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_56_sendAlimtalkButtonApplink() throws Exception {

        AlimtalkRequest alimtalk = AlimtalkRequest.builder()
                                   .senderKey(SENDER_KEY)
                                   .msgType(MessageType.AT)
                                   .to(TO)                                   
                                   .templateCode(TEMPLATE_CODE)
                                   .text(TEXT)
                                   .addButton(Button.AppLinkButtonBuilder().name(NAME).schemeAndroid(SCHEME_ANDROID).schemeIos(SCHEME_IOS).urlMobile(URL_MOBILE).urlPc(URL_PC).build())
                                   .ref(REF)
                                   .build();
        AlimtalkResponse res = client.send(alimtalk);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_57_sendAlimtalkButtonBotkeyword() throws Exception {

        AlimtalkRequest alimtalk = AlimtalkRequest.builder()
                                   .senderKey(SENDER_KEY)
                                   .msgType(MessageType.AT)
                                   .to(TO)                                   
                                   .templateCode(TEMPLATE_CODE)
                                   .text(TEXT)
                                   .addButton(Button.BotKeywordButtonBuilder().name(NAME).build())
                                   .ref(REF)
                                   .build();
        AlimtalkResponse res = client.send(alimtalk);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_58_sendAlimtalkButtonMessageDelivery() throws Exception {

        AlimtalkRequest alimtalk = AlimtalkRequest.builder()
                                   .senderKey(SENDER_KEY)
                                   .msgType(MessageType.AT)
                                   .to(TO)                                   
                                   .templateCode(TEMPLATE_CODE)
                                   .text(TEXT)
                                   .addButton(Button.MessageDeliveryButtonBuilder().name(NAME).build())
                                   .ref(REF)
                                   .build();
        AlimtalkResponse res = client.send(alimtalk);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_59_sendAlimtalkButtonDeliverySearch() throws Exception {

        AlimtalkRequest alimtalk = AlimtalkRequest.builder()
                                   .senderKey(SENDER_KEY)
                                   .msgType(MessageType.AT)
                                   .to(TO)                                   
                                   .templateCode(TEMPLATE_CODE)
                                   .text(TEXT)
                                   .addButton(Button.DeliverySearchButtonBuilder().name(NAME).build())
                                   .ref(REF)
                                   .build();
        AlimtalkResponse res = client.send(alimtalk);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_60_sendAlimtalkButtonConsulting() throws Exception {

        AlimtalkRequest alimtalk = AlimtalkRequest.builder()
                                   .senderKey(SENDER_KEY)
                                   .msgType(MessageType.AT)
                                   .to(TO)                                   
                                   .templateCode(TEMPLATE_CODE)
                                   .text(TEXT)
                                   .addButton(Button.ConsultingButtonBuilder().name(NAME).chatExtra(CHAT_EXTRA).build())
                                   .ref(REF)
                                   .build();
        AlimtalkResponse res = client.send(alimtalk);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_61_sendAlimtalkButtonChatbotTransform() throws Exception {

        AlimtalkRequest alimtalk = AlimtalkRequest.builder()
                                   .senderKey(SENDER_KEY)
                                   .msgType(MessageType.AT)
                                   .to(TO)                                   
                                   .templateCode(TEMPLATE_CODE)
                                   .text(TEXT)
                                   .addButton(Button.ChatbotTransformButtonBuilder().name(NAME).chatExtra(CHAT_EXTRA).chatEvent(CHAT_EVENT).build())
                                   .ref(REF)
                                   .build();
        AlimtalkResponse res = client.send(alimtalk);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_62_sendAlimtalkButtonAddChannel() throws Exception {

        AlimtalkRequest alimtalk = AlimtalkRequest.builder()
                                   .senderKey(SENDER_KEY)
                                   .msgType(MessageType.AT)
                                   .to(TO)                                   
                                   .templateCode(TEMPLATE_CODE)
                                   .text(TEXT)
                                   .addButton(Button.AddChannelButtonBuilder().build())
                                   .ref(REF)
                                   .build();
        AlimtalkResponse res = client.send(alimtalk);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_63_sendAlimtalkButtonBizForm() throws Exception {

        AlimtalkRequest alimtalk = AlimtalkRequest.builder()
                                   .senderKey(SENDER_KEY)
                                   .msgType(MessageType.AT)
                                   .to(TO)                                   
                                   .templateCode(TEMPLATE_CODE)
                                   .text(TEXT)
                                   .addButton(Button.BizFormButtonBuilder().bizFormId(BIZ_FORM_ID).bizFormKey(BIZ_FORM_KEY).name(NAME).build())
                                   .ref(REF)
                                   .build();
        AlimtalkResponse res = client.send(alimtalk);
        assertEquals("A000", res.getCode());
    }


}
package net.infobank.client;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import net.infobank.client.core.HttpConfig;
import net.infobank.client.data.code.MessageType;
import net.infobank.client.data.request.MessageFormRequest;
import net.infobank.client.data.request.message.AlimtalkMessage;
import net.infobank.client.data.request.message.SmsMessage;
import net.infobank.client.data.response.MessageFormResponse;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test02_Form {
    private static final String BASE_URL = "http://172.16.0.73:7000";
    private static final String CLIENT_ID = "clo445";
    private static final String PASSWORD = "12345678";

    private static final String FROM = "0316281564";
    private static final String TEXT_SMS = "테스트메시지123";

    private static final String SENDER_KEY = "senderKey";
    private static final String TEMPLATE_CODE = "templateCode";

    private static final String TTL = "100";

    private static String FORM_ID = "";
    

    InfobankClient client = InfobankClient.builder()
                                .clientId(CLIENT_ID)
                                .password(PASSWORD)
                                .httpConfig(HttpConfig.builder().baseUrl(BASE_URL).build())
                                .build();

    @Test
    public void OMNI_SDK_02_registerForm() throws Exception {
        MessageFormRequest form = MessageFormRequest.builder().addMessage(SmsMessage.builder().text(TEXT_SMS).ttl(TTL).from(FROM).build()).build();
        MessageFormResponse res = client.register(form);
        assertEquals("A000", res.getCode());
        FORM_ID = res.getData().getFormId();
    }

    @Test
    public void OMNI_SDK_03_getForm() throws Exception {
        MessageFormRequest form = MessageFormRequest.builder().formId(FORM_ID).build();
        MessageFormResponse res = client.get(form);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_04_modifyForm() throws Exception {
        MessageFormRequest form = MessageFormRequest.builder().formId(FORM_ID).addMessage(AlimtalkMessage.builder().senderKey(SENDER_KEY).templateCode(TEMPLATE_CODE).text(TEXT_SMS).msgType(MessageType.AI).build()).build();
        MessageFormResponse res = client.modify(form);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_05_removeForm() throws Exception {
        MessageFormRequest form = MessageFormRequest.builder().formId(FORM_ID).build();
        MessageFormResponse res = client.remove(form);
        assertEquals("A000", res.getCode());
    }

}
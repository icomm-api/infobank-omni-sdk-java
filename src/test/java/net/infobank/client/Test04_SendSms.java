package net.infobank.client;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import net.infobank.client.core.HttpConfig;
import net.infobank.client.core.exception.MissingFieldException;
import net.infobank.client.data.request.SmsRequest;
import net.infobank.client.data.response.SmsResponse;

public class Test04_SendSms {

    // Client정보
    private static final String BASE_URL = "http://172.16.0.73:7000";
    private static final String CLIENT_ID = "clo445";
    private static final String PASSWORD = "12345678";

    // SMS, MMS 전송
    private static final String FROM = "0316281564";
    private static final String TO = "01000000000";
    private static final String TEXT_SMS = "테스트메시지1234";
    private static final String REF = "참조필드";
    private static final String ORIGIN_CID = "123456789";

    InfobankClient client = InfobankClient.builder()
                                .clientId(CLIENT_ID)
                                .password(PASSWORD)
                                .httpConfig(HttpConfig.builder().baseUrl(BASE_URL).build())
                                .build();

    @Test
    public void OMNI_SDK_10_sendSmsMandatory() throws Exception {

        SmsRequest sms = SmsRequest.builder()
                                   .to(TO)
                                   .from(FROM)
                                   .text(TEXT_SMS)
                                   .build();
        SmsResponse res = client.send(sms);
        assertEquals("A000", res.getCode());
    }

    @Test(expected = MissingFieldException.class)
    public void OMNI_SDK_11_sendSmsMissingMandatory() throws Exception {

        SmsRequest sms = SmsRequest.builder()
                                   .from(FROM)
                                   .text(TEXT_SMS)
                                   .build();
        SmsResponse res = client.send(sms);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_12_sendSmsWithOption() throws Exception {

        SmsRequest sms = SmsRequest.builder()
                                   .to(TO)
                                   .from(FROM)
                                   .text(TEXT_SMS)
                                   .ref(REF)
                                   .originCID(ORIGIN_CID)
                                   .build();
        SmsResponse res = client.send(sms);
        assertEquals("A000", res.getCode());
    }
}
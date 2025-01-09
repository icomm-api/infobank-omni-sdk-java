package net.infobank.client;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import net.infobank.client.core.HttpConfig;
import net.infobank.client.core.exception.MissingFieldException;
import net.infobank.client.data.request.InternationalRequest;
import net.infobank.client.data.response.InternationalResponse;

public class Test06_SendInternational {

    // Client정보
    private static final String BASE_URL = "http://172.16.0.73:7000";
    private static final String CLIENT_ID = "clo445";
    private static final String PASSWORD = "12345678";

    // SMS, MMS 전송
    private static final String FROM = "0316281564";
    private static final String TO_INTERNATIONAL = "+821000000000";
    private static final String TEXT_SMS = "테스트메시지1234";
    private static final String REF = "참조필드";

    InfobankClient client = InfobankClient.builder()
                                .clientId(CLIENT_ID)
                                .password(PASSWORD)
                                .httpConfig(HttpConfig.builder().baseUrl(BASE_URL).build())
                                .build();

    @Test
    public void OMNI_SDK_17_sendInternationalMandatory() throws Exception {

        InternationalRequest inter = InternationalRequest.builder()
                                   .to(TO_INTERNATIONAL)
                                   .from(FROM)
                                   .text(TEXT_SMS)
                                   .build();
        InternationalResponse res = client.send(inter);
        assertEquals("A000", res.getCode());
    }

    @Test(expected = MissingFieldException.class)
    public void OMNI_SDK_18_sendInternationalMissingMandatory() throws Exception {

        InternationalRequest inter = InternationalRequest.builder()
                                   .to(TO_INTERNATIONAL)
                                   .from(FROM)
                                   .build();
        InternationalResponse res = client.send(inter);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_19_sendInternationalWithOption() throws Exception {

        InternationalRequest inter = InternationalRequest.builder()
                                   .to(TO_INTERNATIONAL)
                                   .from(FROM)
                                   .text(TEXT_SMS)
                                   .ref(REF)
                                   .build();
        InternationalResponse res = client.send(inter);
        assertEquals("A000", res.getCode());
    }


}
package net.infobank.client;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import net.infobank.client.core.HttpConfig;
import net.infobank.client.core.exception.MissingFieldException;
import net.infobank.client.data.request.MmsRequest;
import net.infobank.client.data.response.MmsResponse;

public class Test05_SendMms {

    // Client정보
    private static final String BASE_URL = "http://172.16.0.73:7000";
    private static final String CLIENT_ID = "clo445";
    private static final String PASSWORD = "12345678";

    // SMS, MMS 전송
    private static final String FROM = "0316281564";
    private static final String TO = "01000000000";
    private static final String TEXT_MMS = "테스트메시지1234테스트메시지1234테스트메시지1234테스트메시지1234테스트메시지1234테스트메시지1234테스트메시지1234테스트메시지1234테스트메시지1234테스트메시지1234";
    private static final String TITLE = "메시지 제목123";
    private static final String REF = "참조필드";
    private static final String ORIGIN_CID = "123456789";
    private static String FILE_KEY = "";

    InfobankClient client = InfobankClient.builder()
                                .clientId(CLIENT_ID)
                                .password(PASSWORD)
                                .httpConfig(HttpConfig.builder().baseUrl(BASE_URL).build())
                                .build();


    @Test
    public void OMNI_SDK_13_sendLmsMandatory() throws Exception {

        MmsRequest lms = MmsRequest.builder()
                                   .to(TO)
                                   .from(FROM)
                                   .text(TEXT_MMS)
                                   .build();
        MmsResponse res = client.send(lms);
        assertEquals("A000", res.getCode());
    }

    @Test(expected = MissingFieldException.class)
    public void OMNI_SDK_14_sendLmsMissingMandatory() throws Exception {

        MmsRequest lms = MmsRequest.builder()
                                   .from(FROM)
                                   .text(TEXT_MMS)
                                   .build();
        MmsResponse res = client.send(lms);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_15_sendLmsWithOption() throws Exception {

        MmsRequest lms = MmsRequest.builder()
                                   .to(TO)
                                   .from(FROM)
                                   .title(TITLE)                                   
                                   .text(TEXT_MMS)
                                   .ref(REF)
                                   .originCID(ORIGIN_CID)
                                   .build();
        MmsResponse res = client.send(lms);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_16_sendMms() throws Exception {

        MmsRequest mms = MmsRequest.builder()
                                   .to(TO)
                                   .from(FROM)
                                   .title(TITLE)                                   
                                   .text(TEXT_MMS)
                                   .addFileKey(FILE_KEY)
                                   .ref(REF)
                                   .originCID(ORIGIN_CID)
                                   .build();
        MmsResponse res = client.send(mms);
        assertEquals("A000", res.getCode());
    }
}
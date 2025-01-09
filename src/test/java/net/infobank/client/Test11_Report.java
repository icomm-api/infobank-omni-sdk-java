package net.infobank.client;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import net.infobank.client.core.HttpConfig;
import net.infobank.client.data.request.ReportInquiryRequest;
import net.infobank.client.data.request.ReportPollingRequest;
import net.infobank.client.data.request.SmsRequest;
import net.infobank.client.data.response.ReportInquiryResponse;
import net.infobank.client.data.response.ReportPollingResponse;
import net.infobank.client.data.response.SmsResponse;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test11_Report {
    private static final String BASE_URL = "http://172.16.0.73:7000";
    private static final String CLIENT_ID = "clo445";
    private static final String PASSWORD = "12345678";

    private static final String FROM = "0316281564";
    private static final String TO = "01000000000";
    private static final String TEXT_SMS = "테스트메시지1234";

    private static String REPORT_ID = "";
    private static String MSG_KEY = "";

    InfobankClient client = InfobankClient.builder()
                                .clientId(CLIENT_ID)
                                .password(PASSWORD)
                                .httpConfig(HttpConfig.builder().baseUrl(BASE_URL).build())
                                .build();

    @Test
    public void OMNI_SDK_147_getReportPolling() throws Exception {

        SmsRequest sms = SmsRequest.builder()
                                   .to(TO)
                                   .from(FROM)
                                   .text(TEXT_SMS)
                                   .build();
        SmsResponse smsResponse = client.send(sms);
        MSG_KEY = smsResponse.getMsgKey();

        ReportPollingRequest polling = ReportPollingRequest.builder().build();
        ReportPollingResponse res = client.get(polling);
        assertEquals("A000", res.getCode());
        REPORT_ID = res.getData().getReportId();
    }

    @Test
    public void OMNI_SDK_148_removeReportPolling() throws Exception {
        ReportPollingRequest polling = ReportPollingRequest.builder().reportId(REPORT_ID).build();
        ReportPollingResponse res = client.remove(polling);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_149_getReportInquiry() throws Exception {
        ReportInquiryRequest inquiry = ReportInquiryRequest.builder().msgKey(MSG_KEY).build();
        ReportInquiryResponse res = client.get(inquiry);
        assertEquals("A000", res.getCode());
    }

}
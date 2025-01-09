package net.infobank.client;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.net.URL;

import org.junit.Test;

import net.infobank.client.core.HttpConfig;
import net.infobank.client.core.exception.MissingFieldException;
import net.infobank.client.data.code.FallbackType;
import net.infobank.client.data.code.ServiceType;
import net.infobank.client.data.request.FileRequest;
import net.infobank.client.data.request.RcsRequest;
import net.infobank.client.data.request.common.Fallback;
import net.infobank.client.data.request.rcs.Button;
import net.infobank.client.data.request.rcs.Content;
import net.infobank.client.data.request.rcs.content.Card;
import net.infobank.client.data.request.rcs.content.Standalone;
import net.infobank.client.data.request.rcs.content.SubContent;
import net.infobank.client.data.response.FileResponse;
import net.infobank.client.data.response.RcsResponse;

public class Test07_SendRcs {

    // Client정보
    private static final String BASE_URL = "http://172.16.0.73:7000";
    private static final String CLIENT_ID = "clo445";
    private static final String PASSWORD = "12345678";

    //RCS 전송
    private static final String FORMAT_ID_SMS = "SS000000";
    private static final String FORMAT_ID_LMS = "SL000000";
    private static final String FORMAT_ID_MMS = "SMwThT00";
    private static final String FORMAT_ID_MMS_IMAGE = "OMHITV0001";
    private static final String FORMAT_ID_CAROUSEL3 = "CMwMhM0300";
    private static final String FORMAT_ID_TEMPLATE_FREE = "free";
    private static final String FORMAT_ID_TEMPLATE_DESCRIPTION = "description";
    private static final String FORMAT_ID_TEMPLATE_CELL = "cell";
    private static final String FORMAT_ID_TEMPLATE_IMAGE = "image";

    private static final String BRAND_KEY = "brandKey";
    private static final String BRAND_ID = "brandId";
    private static final String EXPIRY_OPTION = "1";
    private static final String HEADER = "1";
    private static final String FOOTER = "08000000000";
    private static final String NAME = "버튼명";

    private static final String URL = "http://127.0.0.1";
    private static final String LONGITUDE = "123";
    private static final String LATITUDE = "456";
    private static final String LABEL = "label";
    private static final String QUERY = "인포뱅크";
    private static final String FALLBACK_URL = "http://127.0.0.1";
    private static final String DESCRIPTION = "설명";
    private static final String START_TIME = "2023-07-01'T'08:00:00+09:00";
    private static final String END_TIME = "2023-07-02'T'09:30:00+09:00";

    private static final String KEY = "key";
    private static final String VALUE = "value";

    private static final String FROM = "0316281564";
    private static final String TO = "01000000000";
    
    private static final String TEXT_SMS = "테스트메시지1234";
    private static final String TEXT_MMS = "테스트메시지1234테스트메시지1234테스트메시지1234테스트메시지1234테스트메시지1234테스트메시지1234테스트메시지1234테스트메시지1234테스트메시지1234테스트메시지1234";
    private static final String TITLE = "메시지 제목123";
    private static final String REF = "참조필드";

     //FALLBACK 정보
     private static final String FROM_FALLBACK = "0316281564";
     private static final String TEXT_FALLBACK = "fallback메시지123";
     private static final String ORIGIN_CID = "123456789";
     private static final String TITLE_FALLBACK = "fallback메시지";

    InfobankClient client = InfobankClient.builder()
                                .clientId(CLIENT_ID)
                                .password(PASSWORD)
                                .httpConfig(HttpConfig.builder().baseUrl(BASE_URL).build())
                                .build();

    @Test
    public void OMNI_SDK_20_sendRcssmsMandatory() throws Exception {

        RcsRequest rcs = RcsRequest.builder()
                                   .to(TO)
                                   .from(FROM)
                                   .formatId(FORMAT_ID_SMS)
                                   .content(Standalone.builder().text(TEXT_SMS).build())
                                   .brandKey(BRAND_KEY)
                                   .build();
        RcsResponse res = client.send(rcs);
        assertEquals("A000", res.getCode());
    }

    @Test(expected = MissingFieldException.class)
    public void OMNI_SDK_21_sendRcssmsMissingMandatory() throws Exception {

        RcsRequest rcs = RcsRequest.builder()
                                   .to(TO)
                                   .from(FROM)
                                   .formatId(FORMAT_ID_SMS)
                                   .content(Standalone.builder().text(TEXT_SMS).build())
                                   .build();
        RcsResponse res = client.send(rcs);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_22_sendRcssmsWithOption() throws Exception {

        RcsRequest rcs = RcsRequest.builder()
                                   .to(TO)
                                   .from(FROM)
                                   .formatId(FORMAT_ID_SMS)
                                   .content(Standalone.builder().text(TEXT_SMS).build())
                                   .brandKey(BRAND_KEY)
                                   .brandId(BRAND_ID)
                                   .expiryOption(EXPIRY_OPTION)
                                   .header(HEADER)
                                   .footer(FOOTER)
                                   .ref(REF)
                                   .build();
        RcsResponse res = client.send(rcs);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_23_sendRcssmsWithFallback() throws Exception {

        RcsRequest rcs = RcsRequest.builder()
                                   .to(TO)
                                   .from(FROM)
                                   .formatId(FORMAT_ID_SMS)
                                   .content(Standalone.builder().text(TEXT_SMS).build())
                                   .brandKey(BRAND_KEY)
                                   .fallback(Fallback.builder().type(FallbackType.MMS).text(TEXT_FALLBACK).title(TITLE_FALLBACK).originCID(ORIGIN_CID).build())
                                   .build();
        RcsResponse res = client.send(rcs);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_24_sendRcssmsButtonURL() throws Exception {

        RcsRequest rcs = RcsRequest.builder()
                                   .to(TO)
                                   .from(FROM)
                                   .formatId(FORMAT_ID_SMS)
                                   .content(Standalone.builder().text(TEXT_SMS).addButton(Button.UrlButtonBuilder().name(NAME).url(URL).build()).build())
                                   .brandKey(BRAND_KEY)
                                   .build();
        RcsResponse res = client.send(rcs);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_25_sendRcssmsButtonMAP_LOC() throws Exception {

        RcsRequest rcs = RcsRequest.builder()
                                   .to(TO)
                                   .from(FROM)
                                   .formatId(FORMAT_ID_SMS)
                                   .content(Standalone.builder().text(TEXT_SMS).addButton(Button.MapLocationButtonBuilder().longitude(LONGITUDE).latitude(LATITUDE).label(LABEL).name(NAME).fallbackUrl(FALLBACK_URL).build()).build())
                                   .brandKey(BRAND_KEY)
                                   .build();
        RcsResponse res = client.send(rcs);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_26_sendRcssmsButtonMAP_SEND() throws Exception {

        RcsRequest rcs = RcsRequest.builder()
                                   .to(TO)
                                   .from(FROM)
                                   .formatId(FORMAT_ID_SMS)
                                   .content(Standalone.builder().text(TEXT_SMS).addButton(Button.MapSendButtonBuilder().name(NAME).build()).build())
                                   .brandKey(BRAND_KEY)
                                   .build();
        RcsResponse res = client.send(rcs);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_27_sendRcssmsButtonMAP_QRY() throws Exception {

        RcsRequest rcs = RcsRequest.builder()
                                   .to(TO)
                                   .from(FROM)
                                   .formatId(FORMAT_ID_SMS)
                                   .content(Standalone.builder().text(TEXT_SMS).addButton(Button.MapQueryButtonBuilder().label(LABEL).query(QUERY).name(NAME).fallbackUrl(FALLBACK_URL).build()).build())
                                   .brandKey(BRAND_KEY)
                                   .build();
        RcsResponse res = client.send(rcs);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_28_sendRcssmsButtonCARLENDAR() throws Exception {

        RcsRequest rcs = RcsRequest.builder()
                                   .to(TO)
                                   .from(FROM)
                                   .formatId(FORMAT_ID_SMS)
                                   .content(Standalone.builder().text(TEXT_SMS).addButton(Button.CarlendarButtonBuilder().description(DESCRIPTION).startTime(START_TIME).endTime(END_TIME).name(NAME).title(TITLE).build()).build())
                                   .brandKey(BRAND_KEY)
                                   .build();
        RcsResponse res = client.send(rcs);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_29_sendRcssmsButtonCOPY() throws Exception {

        RcsRequest rcs = RcsRequest.builder()
                                   .to(TO)
                                   .from(FROM)
                                   .formatId(FORMAT_ID_SMS)
                                   .content(Standalone.builder().text(TEXT_SMS).addButton(Button.CopyButtonBuilder().name(NAME).text(TEXT_MMS).build()).build())
                                   .brandKey(BRAND_KEY)
                                   .build();
        RcsResponse res = client.send(rcs);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_30_sendRcssmsButtonCOM_T() throws Exception {

        RcsRequest rcs = RcsRequest.builder()
                                   .to(TO)
                                   .from(FROM)
                                   .formatId(FORMAT_ID_SMS)
                                   .content(Standalone.builder().text(TEXT_SMS).addButton(Button.ComTextButtonBuilder().text(TEXT_MMS).name(NAME).phoneNumber(TO).build()).build())
                                   .brandKey(BRAND_KEY)
                                   .build();
        RcsResponse res = client.send(rcs);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_31_sendRcssmsButtonCOM_V() throws Exception {

        RcsRequest rcs = RcsRequest.builder()
                                   .to(TO)
                                   .from(FROM)
                                   .formatId(FORMAT_ID_SMS)
                                   .content(Standalone.builder().text(TEXT_SMS).addButton(Button.ComVideoButtonBuilder().name(NAME).phoneNumber(TO).build()).build())
                                   .brandKey(BRAND_KEY)
                                   .build();
        RcsResponse res = client.send(rcs);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_32_sendRcssmsButtonDIAL() throws Exception {

        RcsRequest rcs = RcsRequest.builder()
                                   .to(TO)
                                   .from(FROM)
                                   .formatId(FORMAT_ID_SMS)
                                   .content(Standalone.builder().text(TEXT_SMS).addButton(Button.DialButtonBuilder().name(NAME).phoneNumber(TO).build()).build())
                                   .brandKey(BRAND_KEY)
                                   .build();
        RcsResponse res = client.send(rcs);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_33_sendRcslms() throws Exception {

        RcsRequest rcs = RcsRequest.builder()
                                   .to(TO)
                                   .from(FROM)
                                   .formatId(FORMAT_ID_LMS)
                                   .content(Standalone.builder().text(TEXT_MMS).title(TITLE).build())
                                   .brandKey(BRAND_KEY)
                                   .build();
        RcsResponse res = client.send(rcs);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_34_sendRcsmms() throws Exception {

        ClassLoader classLoader = getClass().getClassLoader();
        URL fileURL = classLoader.getResource("infobank.jpg");
        FileRequest file = FileRequest.builder().file(new File(fileURL.getFile())).serviceType(ServiceType.RCS).build();
        FileResponse fileRes = client.register(file);
        
        String media = fileRes.getData().getMedia();

        RcsRequest rcs = RcsRequest.builder()
                                   .to(TO)
                                   .from(FROM)
                                   .formatId(FORMAT_ID_MMS)
                                   .content(Standalone.builder().text(TEXT_MMS).title(TITLE).media(media).build())
                                   .brandKey(BRAND_KEY)
                                   .build();
        RcsResponse res = client.send(rcs);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_35_sendRcsmmsImage() throws Exception {

        ClassLoader classLoader = getClass().getClassLoader();
        URL fileURL = classLoader.getResource("infobank.jpg");
        FileRequest file = FileRequest.builder().file(new File(fileURL.getFile())).serviceType(ServiceType.RCS).build();
        FileResponse fileRes = client.register(file);
        
        String media = fileRes.getData().getMedia();

        RcsRequest rcs = RcsRequest.builder()
                                   .to(TO)
                                   .from(FROM)
                                   .formatId(FORMAT_ID_MMS_IMAGE)
                                   .content(Standalone.builder().text(TEXT_MMS).title(TITLE).addSubContent(SubContent.builder().subDesc(DESCRIPTION).subMedia(media).subTitle(TITLE).build()).build())
                                   .brandKey(BRAND_KEY)
                                   .build();
        RcsResponse res = client.send(rcs);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_36_sendRcsmmsCarousel() throws Exception {

        RcsRequest rcs = RcsRequest.builder()
                                   .to(TO)
                                   .from(FROM)
                                   .formatId(FORMAT_ID_CAROUSEL3)
                                   .content(Content.CarouselBuilder().addCard(Card.builder().text(TEXT_SMS).build())
                                                                     .addCard(Card.builder().text(TEXT_SMS).build())
                                                                     .addCard(Card.builder().text(TEXT_SMS).build())
                                                                     .build())
                                   .brandKey(BRAND_KEY)
                                   .build();
        RcsResponse res = client.send(rcs);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_37_sendRcsmmsCarouselMedia() throws Exception {

        ClassLoader classLoader = getClass().getClassLoader();
        URL fileURL = classLoader.getResource("infobank.jpg");
        FileRequest file = FileRequest.builder().file(new File(fileURL.getFile())).serviceType(ServiceType.RCS).build();
        FileResponse fileRes = client.register(file);

        String media = fileRes.getData().getMedia();

        RcsRequest rcs = RcsRequest.builder()
                                   .to(TO)
                                   .from(FROM)
                                   .formatId(FORMAT_ID_CAROUSEL3)
                                   .content(Content.CarouselBuilder().addCard(Card.builder().text(TEXT_SMS).media(media).build())
                                                                     .addCard(Card.builder().text(TEXT_SMS).media(media).build())
                                                                     .addCard(Card.builder().text(TEXT_SMS).media(media).build())
                                                                     .build())
                                   .brandKey(BRAND_KEY)
                                   .build();
        RcsResponse res = client.send(rcs);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_38_sendRcsmmsCarouselButtonURL() throws Exception {
        RcsRequest rcs = RcsRequest.builder()
                                   .to(TO)
                                   .from(FROM)
                                   .formatId(FORMAT_ID_CAROUSEL3)
                                   .content(Content.CarouselBuilder().addCard(Card.builder().text(TEXT_SMS).addButton(Button.UrlButtonBuilder().name(NAME).url(URL).build()).build())
                                                                     .addCard(Card.builder().text(TEXT_SMS).addButton(Button.UrlButtonBuilder().name(NAME).url(URL).build()).build())
                                                                     .addCard(Card.builder().text(TEXT_SMS).addButton(Button.UrlButtonBuilder().name(NAME).url(URL).build()).build())
                                                                     .build())
                                   .brandKey(BRAND_KEY)
                                   .build();
        RcsResponse res = client.send(rcs);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_39_sendRcsmmsCarouselButtonMAP_LOC() throws Exception {
        RcsRequest rcs = RcsRequest.builder()
                                   .to(TO)
                                   .from(FROM)
                                   .formatId(FORMAT_ID_CAROUSEL3)
                                   .content(Content.CarouselBuilder().addCard(Card.builder().text(TEXT_SMS).addButton(Button.MapLocationButtonBuilder().longitude(LONGITUDE).latitude(LATITUDE).label(LABEL).name(NAME).fallbackUrl(FALLBACK_URL).build()).build())
                                                                     .addCard(Card.builder().text(TEXT_SMS).addButton(Button.MapLocationButtonBuilder().longitude(LONGITUDE).latitude(LATITUDE).label(LABEL).name(NAME).fallbackUrl(FALLBACK_URL).build()).build())
                                                                     .addCard(Card.builder().text(TEXT_SMS).addButton(Button.MapLocationButtonBuilder().longitude(LONGITUDE).latitude(LATITUDE).label(LABEL).name(NAME).fallbackUrl(FALLBACK_URL).build()).build())
                                                                     .build())
                                   .brandKey(BRAND_KEY)
                                   .build();
        RcsResponse res = client.send(rcs);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_40_sendRcsmmsCarouselButtonMAP_QRY() throws Exception {
        RcsRequest rcs = RcsRequest.builder()
                                   .to(TO)
                                   .from(FROM)
                                   .formatId(FORMAT_ID_CAROUSEL3)
                                   .content(Content.CarouselBuilder().addCard(Card.builder().text(TEXT_SMS).addButton(Button.MapQueryButtonBuilder().label(LABEL).query(QUERY).name(NAME).fallbackUrl(FALLBACK_URL).build()).build())
                                                                     .addCard(Card.builder().text(TEXT_SMS).addButton(Button.MapQueryButtonBuilder().label(LABEL).query(QUERY).name(NAME).fallbackUrl(FALLBACK_URL).build()).build())
                                                                     .addCard(Card.builder().text(TEXT_SMS).addButton(Button.MapQueryButtonBuilder().label(LABEL).query(QUERY).name(NAME).fallbackUrl(FALLBACK_URL).build()).build())
                                                                     .build())
                                   .brandKey(BRAND_KEY)
                                   .build();
        RcsResponse res = client.send(rcs);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_41_sendRcsmmsCarouselButtonMAP_SEND() throws Exception {
        RcsRequest rcs = RcsRequest.builder()
                                   .to(TO)
                                   .from(FROM)
                                   .formatId(FORMAT_ID_CAROUSEL3)
                                   .content(Content.CarouselBuilder().addCard(Card.builder().text(TEXT_SMS).addButton(Button.MapSendButtonBuilder().name(NAME).build()).build())
                                                                     .addCard(Card.builder().text(TEXT_SMS).addButton(Button.MapSendButtonBuilder().name(NAME).build()).build())
                                                                     .addCard(Card.builder().text(TEXT_SMS).addButton(Button.MapSendButtonBuilder().name(NAME).build()).build())
                                                                     .build())
                                   .brandKey(BRAND_KEY)
                                   .build();
        RcsResponse res = client.send(rcs);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_42_sendRcsmmsCarouselButtonCARLENDAR() throws Exception {
        RcsRequest rcs = RcsRequest.builder()
                                   .to(TO)
                                   .from(FROM)
                                   .formatId(FORMAT_ID_CAROUSEL3)
                                   .content(Content.CarouselBuilder().addCard(Card.builder().text(TEXT_SMS).addButton(Button.CarlendarButtonBuilder().description(DESCRIPTION).startTime(START_TIME).endTime(END_TIME).name(NAME).title(TITLE).build()).build())
                                                                     .addCard(Card.builder().text(TEXT_SMS).addButton(Button.CarlendarButtonBuilder().description(DESCRIPTION).startTime(START_TIME).endTime(END_TIME).name(NAME).title(TITLE).build()).build())
                                                                     .addCard(Card.builder().text(TEXT_SMS).addButton(Button.CarlendarButtonBuilder().description(DESCRIPTION).startTime(START_TIME).endTime(END_TIME).name(NAME).title(TITLE).build()).build())
                                                                     .build())
                                   .brandKey(BRAND_KEY)
                                   .build();
        RcsResponse res = client.send(rcs);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_43_sendRcsmmsCarouselButtonCOPY() throws Exception {
        RcsRequest rcs = RcsRequest.builder()
                                   .to(TO)
                                   .from(FROM)
                                   .formatId(FORMAT_ID_CAROUSEL3)
                                   .content(Content.CarouselBuilder().addCard(Card.builder().text(TEXT_SMS).addButton(Button.CopyButtonBuilder().name(NAME).text(TEXT_MMS).build()).build())
                                                                     .addCard(Card.builder().text(TEXT_SMS).addButton(Button.CopyButtonBuilder().name(NAME).text(TEXT_MMS).build()).build())
                                                                     .addCard(Card.builder().text(TEXT_SMS).addButton(Button.CopyButtonBuilder().name(NAME).text(TEXT_MMS).build()).build())
                                                                     .build())
                                   .brandKey(BRAND_KEY)
                                   .build();
        RcsResponse res = client.send(rcs);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_44_sendRcsmmsCarouselButtonCOM_T() throws Exception {
        RcsRequest rcs = RcsRequest.builder()
                                   .to(TO)
                                   .from(FROM)
                                   .formatId(FORMAT_ID_CAROUSEL3)
                                   .content(Content.CarouselBuilder().addCard(Card.builder().text(TEXT_SMS).addButton(Button.ComTextButtonBuilder().text(TEXT_MMS).name(NAME).phoneNumber(TO).build()).build())
                                                                     .addCard(Card.builder().text(TEXT_SMS).addButton(Button.ComTextButtonBuilder().text(TEXT_MMS).name(NAME).phoneNumber(TO).build()).build())
                                                                     .addCard(Card.builder().text(TEXT_SMS).addButton(Button.ComTextButtonBuilder().text(TEXT_MMS).name(NAME).phoneNumber(TO).build()).build())
                                                                     .build())
                                   .brandKey(BRAND_KEY)
                                   .build();
        RcsResponse res = client.send(rcs);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_45_sendRcsmmsCarouselButtonCOM_V() throws Exception {
        RcsRequest rcs = RcsRequest.builder()
                                   .to(TO)
                                   .from(FROM)
                                   .formatId(FORMAT_ID_CAROUSEL3)
                                   .content(Content.CarouselBuilder().addCard(Card.builder().text(TEXT_SMS).addButton(Button.ComVideoButtonBuilder().name(NAME).phoneNumber(TO).build()).build())
                                                                     .addCard(Card.builder().text(TEXT_SMS).addButton(Button.ComVideoButtonBuilder().name(NAME).phoneNumber(TO).build()).build())
                                                                     .addCard(Card.builder().text(TEXT_SMS).addButton(Button.ComVideoButtonBuilder().name(NAME).phoneNumber(TO).build()).build())
                                                                     .build())
                                   .brandKey(BRAND_KEY)
                                   .build();
        RcsResponse res = client.send(rcs);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_46_sendRcsmmsCarouselButtonDIAL() throws Exception {
        RcsRequest rcs = RcsRequest.builder()
                                   .to(TO)
                                   .from(FROM)
                                   .formatId(FORMAT_ID_CAROUSEL3)
                                   .content(Content.CarouselBuilder().addCard(Card.builder().text(TEXT_SMS).addButton(Button.DialButtonBuilder().name(NAME).phoneNumber(TO).build()).build())
                                                                     .addCard(Card.builder().text(TEXT_SMS).addButton(Button.DialButtonBuilder().name(NAME).phoneNumber(TO).build()).build())
                                                                     .addCard(Card.builder().text(TEXT_SMS).addButton(Button.DialButtonBuilder().name(NAME).phoneNumber(TO).build()).build())
                                                                     .build())
                                   .brandKey(BRAND_KEY)
                                   .build();
        RcsResponse res = client.send(rcs);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_47_sendRcsTemplateFree() throws Exception {
        RcsRequest rcs = RcsRequest.builder()
                                   .to(TO)
                                   .from(FROM)
                                   .formatId(FORMAT_ID_TEMPLATE_FREE)
                                   .content(Content.TemplateBuilder().description(TEXT_SMS).build())
                                   .brandKey(BRAND_KEY)
                                   .build();
        RcsResponse res = client.send(rcs);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_48_sendRcsTemplateDescription() throws Exception {
        RcsRequest rcs = RcsRequest.builder()
                                   .to(TO)
                                   .from(FROM)
                                   .formatId(FORMAT_ID_TEMPLATE_DESCRIPTION)
                                   .content(Content.TemplateBuilder().description(TEXT_SMS).build())
                                   .brandKey(BRAND_KEY)
                                   .build();
        RcsResponse res = client.send(rcs);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_49_sendRcsTemplateCell() throws Exception {
        RcsRequest rcs = RcsRequest.builder()
                                   .to(TO)
                                   .from(FROM)
                                   .formatId(FORMAT_ID_TEMPLATE_CELL)
                                   .content(Content.TemplateBuilder().put(KEY, VALUE).build())
                                   .brandKey(BRAND_KEY)
                                   .build();
        RcsResponse res = client.send(rcs);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_50_sendRcsTemplateImage() throws Exception {
        RcsRequest rcs = RcsRequest.builder()
                                   .to(TO)
                                   .from(FROM)
                                   .formatId(FORMAT_ID_TEMPLATE_IMAGE)
                                   .content(Content.TemplateBuilder().description(DESCRIPTION).title(TITLE).addSubContent(SubContent.builder().subDesc(TEXT_SMS).subTitle(TITLE).build()).build())
                                   .brandKey(BRAND_KEY)
                                   .build();
        RcsResponse res = client.send(rcs);
        assertEquals("A000", res.getCode());
    }
}
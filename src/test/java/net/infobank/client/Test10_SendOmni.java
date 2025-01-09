package net.infobank.client;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import net.infobank.client.core.HttpConfig;
import net.infobank.client.core.exception.MissingFieldException;
import net.infobank.client.data.code.MessageType;
import net.infobank.client.data.request.MessageFormRequest;
import net.infobank.client.data.request.OmniRequest;
import net.infobank.client.data.request.common.Destination;
import net.infobank.client.data.request.kakao.attachment.Attachment;
import net.infobank.client.data.request.kakao.attachment.Image;
import net.infobank.client.data.request.kakao.attachment.Item;
import net.infobank.client.data.request.kakao.attachment.ItemHighlight;
import net.infobank.client.data.request.kakao.attachment.ListNode;
import net.infobank.client.data.request.kakao.supplement.Supplement;
import net.infobank.client.data.request.message.AlimtalkMessage;
import net.infobank.client.data.request.message.FriendtalkMessage;
import net.infobank.client.data.request.message.MmsMessage;
import net.infobank.client.data.request.message.RcsMessage;
import net.infobank.client.data.request.message.SmsMessage;
import net.infobank.client.data.request.rcs.content.Card;
import net.infobank.client.data.request.rcs.content.Carousel;
import net.infobank.client.data.request.rcs.content.Standalone;
import net.infobank.client.data.request.rcs.content.SubContent;
import net.infobank.client.data.request.rcs.content.Template;
import net.infobank.client.data.response.MessageFormResponse;
import net.infobank.client.data.response.OmniResponse;

public class Test10_SendOmni {

    // Client정보
    private static final String BASE_URL = "http://172.16.0.73:7000";
    private static final String CLIENT_ID = "clo445";
    private static final String PASSWORD = "12345678";

    // SMS, MMS 전송
    private static final String FROM = "0316281564";
    private static final String TO = "01000000000";
    private static final String TEXT_SMS = "테스트메시지1234";
    private static final String TEXT_MMS = "테스트메시지1234테스트메시지1234테스트메시지1234테스트메시지1234테스트메시지1234테스트메시지1234테스트메시지1234테스트메시지1234테스트메시지1234테스트메시지1234";
    private static final String TITLE = "메시지 제목123";
    private static final String REF = "참조필드";
    private static final String ORIGIN_CID = "123456789";
    private static final String TTL = "100";
    private static String FILE_KEY = "";

    //RCS 전송
    private static final String FORMAT_ID_SMS = "SS000000";
    private static final String FORMAT_ID_LMS = "SL000000";
    private static final String FORMAT_ID_MMS = "SMwThT00";
    private static final String FORMAT_ID_CAROUSEL3 = "CMwMhM0300";
    private static final String FORMAT_ID_TEMPLATE_FREE = "free";
    private static final String FORMAT_ID_TEMPLATE_DESCRIPTION = "description";
    private static final String FORMAT_ID_TEMPLATE_CELL = "cell";
    private static final String FORMAT_ID_TEMPLATE_IMAGE = "image";
    private static final String AGENCY_ID = "agencyId";
    private static final String AGENCY_KEY = "agencyKey";
    private static final String BRAND_KEY = "brnadKey";
    private static final String BRAND_ID = "brandId";
    private static final String GROUP_ID = "groupId";
    private static final String FOOTER = "08000000000";
    private static final String NAME = "버튼명";
    private static String MEDIA = "";

    private static final String EXPIRY_OPTION = "1";
    private static final String HEADER = "1";
    private static final String COPY_ALLOWED = "1";

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
    
    
    //알림톡, 친구톡 전송
    private static final String SENDER_KEY = "senderKey";
    private static final String TEMPLATE_CODE = "templateCode";
    private static final String CURRENCY_TYPE = "KRW";

    private static final String URL_MOBILE = "http://127.0.0.1";
    private static final String URL_PC = "http://127.0.0.1";

    private static final String SCHEME_IOS = "schemeIos";
    private static final String SCHEME_ANDROID = "schemeAndroid";

    private static final String CHAT_EXTRA = "chatExtra";
    private static final String CHAT_EVENT = "chatEvent";

    private static final String BIZ_FORM_ID = "bizFormId";
    private static final String BIZ_FORM_KEY = "bizFormKey";

    private static final String PRICE = "1000";
    private static final String AD_FLAG = "Y";

    private static final String TARGET = "target";
    
    private static String IMG_URL = "http://127.0.0.1";

    InfobankClient client = InfobankClient.builder()
                                .clientId(CLIENT_ID)
                                .password(PASSWORD)
                                .httpConfig(HttpConfig.builder().baseUrl(BASE_URL).build())
                                .build();

    @Test
    public void OMNI_SDK_77_sendOmniSmsMandatory() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(SmsMessage.builder()
                                                        .from(FROM)
                                                        .text(TEXT_SMS)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test(expected = MissingFieldException.class)
    public void OMNI_SDK_78_sendOmniSmsMissingMandatory() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(SmsMessage.builder()
                                                        .from(FROM)
                                                        .originCID(ORIGIN_CID)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_79_sendOmniSmsWithOption() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(SmsMessage.builder()
                                                        .from(FROM)
                                                        .text(TEXT_SMS)
                                                        .originCID(ORIGIN_CID)
                                                        .ttl(TTL)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).addReplaceWord(KEY, VALUE).build())
                                    .ref(REF)
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_80_sendOmniLmsMandatory() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(MmsMessage.builder()
                                                        .from(FROM)
                                                        .text(TEXT_MMS)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test(expected = MissingFieldException.class)
    public void OMNI_SDK_81_sendOmniLmsMissingMandatory() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(MmsMessage.builder()
                                                        .from(FROM)
                                                        .originCID(ORIGIN_CID)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_82_sendOmniLmsWithOption() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(MmsMessage.builder()
                                                        .from(FROM)
                                                        .title(TITLE)
                                                        .text(TEXT_MMS)
                                                        .originCID(ORIGIN_CID)
                                                        .ttl(TTL)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).addReplaceWord(KEY, VALUE).build())
                                    .ref(REF)
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_83_sendOmniMmsMandatory() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(MmsMessage.builder()
                                                        .from(FROM)
                                                        .addFileKey(FILE_KEY)
                                                        .text(TEXT_MMS)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).addReplaceWord(KEY, VALUE).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_84_sendOmniRcssmsMandatory() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(RcsMessage.builder()
                                                        .from(FROM)
                                                        .content(Standalone.builder().text(TEXT_SMS).build())
                                                        .formatId(FORMAT_ID_SMS)
                                                        .brandKey(BRAND_KEY)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test(expected = MissingFieldException.class)
    public void OMNI_SDK_85_sendOmniRcssmsMissingMandatory() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(RcsMessage.builder()
                                                        .from(FROM)
                                                        .formatId(FORMAT_ID_SMS)
                                                        .brandKey(BRAND_KEY)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_86_sendOmniRcssmsWithOption() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(RcsMessage.builder()
                                                        .from(FROM)
                                                        .content(Standalone.builder().text(TEXT_SMS).build())
                                                        .formatId(FORMAT_ID_SMS)
                                                        .brandKey(BRAND_KEY)
                                                        .brandId(BRAND_ID)
                                                        .groupId(GROUP_ID)
                                                        .expiryOption(EXPIRY_OPTION)
                                                        .copyAllowed(COPY_ALLOWED)
                                                        .header(HEADER)
                                                        .footer(FOOTER)
                                                        .agencyId(AGENCY_ID)
                                                        .agencyKey(AGENCY_KEY)
                                                        .ttl(TTL)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .ref(REF)
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_87_sendOmniRcssmsButtonURL() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(RcsMessage.builder()
                                                        .from(FROM)
                                                        .content(Standalone.builder()
                                                                    .text(TEXT_SMS)
                                                                    .addButton(net.infobank.client.data.request.rcs.Button.UrlButtonBuilder().url(URL).name(NAME).build()).build())
                                                        .formatId(FORMAT_ID_SMS)
                                                        .brandKey(BRAND_KEY)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .ref(REF)
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_88_sendOmniRcssmsButtonMAP_LOC() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(RcsMessage.builder()
                                                        .from(FROM)
                                                        .content(Standalone.builder()
                                                                    .text(TEXT_SMS)
                                                                    .addButton(net.infobank.client.data.request.rcs.Button.MapLocationButtonBuilder().name(NAME).latitude(LATITUDE).longitude(LONGITUDE).fallbackUrl(FALLBACK_URL).label(LABEL).build()).build())
                                                        .formatId(FORMAT_ID_SMS)
                                                        .brandKey(BRAND_KEY)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .ref(REF)
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_89_sendOmniRcssmsButtonMAP_QRY() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(RcsMessage.builder()
                                                        .from(FROM)
                                                        .content(Standalone.builder()
                                                                    .text(TEXT_SMS)
                                                                    .addButton(net.infobank.client.data.request.rcs.Button.MapQueryButtonBuilder().fallbackUrl(FALLBACK_URL).name(NAME).label(LABEL).query(QUERY).build()).build())
                                                        .formatId(FORMAT_ID_SMS)
                                                        .brandKey(BRAND_KEY)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .ref(REF)
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_90_sendOmniRcssmsButtonMAP_SEND() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(RcsMessage.builder()
                                                        .from(FROM)
                                                        .content(Standalone.builder()
                                                                    .text(TEXT_SMS)
                                                                    .addButton(net.infobank.client.data.request.rcs.Button.MapSendButtonBuilder().name(NAME).build()).build())
                                                        .formatId(FORMAT_ID_SMS)
                                                        .brandKey(BRAND_KEY)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .ref(REF)
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_91_sendOmniRcssmsButtonCARLENDAR() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(RcsMessage.builder()
                                                        .from(FROM)
                                                        .content(Standalone.builder()
                                                                    .text(TEXT_SMS)
                                                                    .addButton(net.infobank.client.data.request.rcs.Button.CarlendarButtonBuilder().description(DESCRIPTION).startTime(START_TIME).endTime(END_TIME).name(NAME).title(TITLE).build()).build())
                                                        .formatId(FORMAT_ID_SMS)
                                                        .brandKey(BRAND_KEY)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .ref(REF)
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_92_sendOmniRcssmsButtonCOPY() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(RcsMessage.builder()
                                                        .from(FROM)
                                                        .content(Standalone.builder()
                                                                    .text(TEXT_SMS)
                                                                    .addButton(net.infobank.client.data.request.rcs.Button.CopyButtonBuilder().name(NAME).text(TEXT_MMS).build()).build())
                                                        .formatId(FORMAT_ID_SMS)
                                                        .brandKey(BRAND_KEY)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .ref(REF)
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_93_sendOmniRcssmsButtonCOM_T() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(RcsMessage.builder()
                                                        .from(FROM)
                                                        .content(Standalone.builder()
                                                                    .text(TEXT_SMS)
                                                                    .addButton(net.infobank.client.data.request.rcs.Button.ComTextButtonBuilder().name(NAME).phoneNumber(TO).text(TEXT_MMS).build()).build())
                                                        .formatId(FORMAT_ID_SMS)
                                                        .brandKey(BRAND_KEY)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .ref(REF)
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_94_sendOmniRcssmsButtonCOM_V() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(RcsMessage.builder()
                                                        .from(FROM)
                                                        .content(Standalone.builder()
                                                                    .text(TEXT_SMS)
                                                                    .addButton(net.infobank.client.data.request.rcs.Button.ComVideoButtonBuilder().name(NAME).phoneNumber(TO).build()).build())
                                                        .formatId(FORMAT_ID_SMS)
                                                        .brandKey(BRAND_KEY)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .ref(REF)
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_95_sendOmniRcssmsButtonDIAL() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(RcsMessage.builder()
                                                        .from(FROM)
                                                        .content(Standalone.builder()
                                                                    .text(TEXT_SMS)
                                                                    .addButton(net.infobank.client.data.request.rcs.Button.DialButtonBuilder().name(NAME).phoneNumber(TO).build()).build())
                                                        .formatId(FORMAT_ID_SMS)
                                                        .brandKey(BRAND_KEY)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .ref(REF)
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_96_sendOmniRcslmsWithOption() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(RcsMessage.builder()
                                                        .from(FROM)
                                                        .content(Standalone.builder().text(TEXT_MMS).title(TITLE).build())
                                                        .formatId(FORMAT_ID_LMS)
                                                        .brandKey(BRAND_KEY)
                                                        .brandId(BRAND_ID)
                                                        .groupId(GROUP_ID)
                                                        .expiryOption(EXPIRY_OPTION)
                                                        .copyAllowed(COPY_ALLOWED)
                                                        .header(HEADER)
                                                        .footer(FOOTER)
                                                        .agencyId(AGENCY_ID)
                                                        .agencyKey(AGENCY_KEY)
                                                        .ttl(TTL)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .ref(REF)
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_97_sendOmniRcsmmsWithOption() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(RcsMessage.builder()
                                                        .from(FROM)
                                                        .content(Standalone.builder().text(TEXT_MMS).title(TITLE).media(MEDIA).build())
                                                        .formatId(FORMAT_ID_MMS)
                                                        .brandKey(BRAND_KEY)
                                                        .brandId(BRAND_ID)
                                                        .groupId(GROUP_ID)
                                                        .expiryOption(EXPIRY_OPTION)
                                                        .copyAllowed(COPY_ALLOWED)
                                                        .header(HEADER)
                                                        .footer(FOOTER)
                                                        .agencyId(AGENCY_ID)
                                                        .agencyKey(AGENCY_KEY)
                                                        .ttl(TTL)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .ref(REF)
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_98_sendOmniRcsmmsImageWithOption() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(RcsMessage.builder()
                                                        .from(FROM)
                                                        .content(Standalone.builder().text(TEXT_MMS).title(TITLE).media(MEDIA).addSubContent(SubContent.builder().subDesc(DESCRIPTION).subTitle(TITLE).build()).build())
                                                        .formatId(FORMAT_ID_MMS)
                                                        .brandKey(BRAND_KEY)
                                                        .brandId(BRAND_ID)
                                                        .groupId(GROUP_ID)
                                                        .expiryOption(EXPIRY_OPTION)
                                                        .copyAllowed(COPY_ALLOWED)
                                                        .header(HEADER)
                                                        .footer(FOOTER)
                                                        .agencyId(AGENCY_ID)
                                                        .agencyKey(AGENCY_KEY)
                                                        .ttl(TTL)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .ref(REF)
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_99_sendOmniRcsCarousel() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(RcsMessage.builder()
                                                        .from(FROM)
                                                        .content(Carousel.builder().addCard(Card.builder().text(TEXT_MMS).title(TITLE).build())
                                                                                    .addCard(Card.builder().text(TEXT_MMS).title(TITLE).build())
                                                                                    .addCard(Card.builder().text(TEXT_MMS).title(TITLE).build()).build())
                                                        .formatId(FORMAT_ID_CAROUSEL3)
                                                        .brandKey(BRAND_KEY)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_100_sendOmniRcsCarouselMedia() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(RcsMessage.builder()
                                                        .from(FROM)
                                                        .content(Carousel.builder().addCard(Card.builder().text(TEXT_MMS).title(TITLE).media(MEDIA).build())
                                                                                    .addCard(Card.builder().text(TEXT_MMS).title(TITLE).media(MEDIA).build())
                                                                                    .addCard(Card.builder().text(TEXT_MMS).title(TITLE).mediaUrl(URL).build()).build())
                                                        .formatId(FORMAT_ID_CAROUSEL3)
                                                        .brandKey(BRAND_KEY)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_101_sendOmniRcsCarouselButtonURL() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(RcsMessage.builder()
                                                        .from(FROM)
                                                        .content(Carousel.builder().addCard(Card.builder().text(TEXT_MMS).title(TITLE)
                                                                                        .addButton(net.infobank.client.data.request.rcs.Button.UrlButtonBuilder().url(URL).name(NAME).build()).build())
                                                                                    .addCard(Card.builder().text(TEXT_MMS).title(TITLE).build())
                                                                                    .addCard(Card.builder().text(TEXT_MMS).title(TITLE).build()).build())
                                                        .formatId(FORMAT_ID_CAROUSEL3)
                                                        .brandKey(BRAND_KEY)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_102_sendOmniRcsCarouselButtonMAP_LOC() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(RcsMessage.builder()
                                                        .from(FROM)
                                                        .content(Carousel.builder().addCard(Card.builder().text(TEXT_MMS).title(TITLE)
                                                                                        .addButton(net.infobank.client.data.request.rcs.Button.MapLocationButtonBuilder().latitude(LATITUDE).longitude(LONGITUDE).label(LABEL).name(NAME).fallbackUrl(FALLBACK_URL).build()).build())
                                                                                    .addCard(Card.builder().text(TEXT_MMS).title(TITLE).build())
                                                                                    .addCard(Card.builder().text(TEXT_MMS).title(TITLE).build()).build())
                                                        .formatId(FORMAT_ID_CAROUSEL3)
                                                        .brandKey(BRAND_KEY)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_103_sendOmniRcsCarouselButtonMAP_QRY() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(RcsMessage.builder()
                                                        .from(FROM)
                                                        .content(Carousel.builder().addCard(Card.builder().text(TEXT_MMS).title(TITLE)
                                                                                        .addButton(net.infobank.client.data.request.rcs.Button.MapQueryButtonBuilder().query(QUERY).label(LABEL).name(NAME).fallbackUrl(FALLBACK_URL).build()).build())
                                                                                    .addCard(Card.builder().text(TEXT_MMS).title(TITLE).build())
                                                                                    .addCard(Card.builder().text(TEXT_MMS).title(TITLE).build()).build())
                                                        .formatId(FORMAT_ID_CAROUSEL3)
                                                        .brandKey(BRAND_KEY)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_104_sendOmniRcsCarouselButtonMAP_SEND() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(RcsMessage.builder()
                                                        .from(FROM)
                                                        .content(Carousel.builder().addCard(Card.builder().text(TEXT_MMS).title(TITLE)
                                                                                        .addButton(net.infobank.client.data.request.rcs.Button.MapSendButtonBuilder().name(NAME).build()).build())
                                                                                    .addCard(Card.builder().text(TEXT_MMS).title(TITLE).build())
                                                                                    .addCard(Card.builder().text(TEXT_MMS).title(TITLE).build()).build())
                                                        .formatId(FORMAT_ID_CAROUSEL3)
                                                        .brandKey(BRAND_KEY)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_105_sendOmniRcsCarouselButtonCARLENDAR() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(RcsMessage.builder()
                                                        .from(FROM)
                                                        .content(Carousel.builder().addCard(Card.builder().text(TEXT_MMS).title(TITLE)
                                                                                        .addButton(net.infobank.client.data.request.rcs.Button.CarlendarButtonBuilder().description(DESCRIPTION).endTime(END_TIME).startTime(START_TIME).title(TITLE).name(NAME).build()).build())
                                                                                    .addCard(Card.builder().text(TEXT_MMS).title(TITLE).build())
                                                                                    .addCard(Card.builder().text(TEXT_MMS).title(TITLE).build()).build())
                                                        .formatId(FORMAT_ID_CAROUSEL3)
                                                        .brandKey(BRAND_KEY)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_106_sendOmniRcsCarouselButtonCOPY() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(RcsMessage.builder()
                                                        .from(FROM)
                                                        .content(Carousel.builder().addCard(Card.builder().text(TEXT_MMS).title(TITLE)
                                                                                        .addButton(net.infobank.client.data.request.rcs.Button.CopyButtonBuilder().name(NAME).text(TEXT_MMS).build()).build())
                                                                                    .addCard(Card.builder().text(TEXT_MMS).title(TITLE).build())
                                                                                    .addCard(Card.builder().text(TEXT_MMS).title(TITLE).build()).build())
                                                        .formatId(FORMAT_ID_CAROUSEL3)
                                                        .brandKey(BRAND_KEY)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_107_sendOmniRcsCarouselButtonCOM_T() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(RcsMessage.builder()
                                                        .from(FROM)
                                                        .content(Carousel.builder().addCard(Card.builder().text(TEXT_MMS).title(TITLE)
                                                                                        .addButton(net.infobank.client.data.request.rcs.Button.ComTextButtonBuilder().name(NAME).phoneNumber(TO).text(TEXT_MMS).build()).build())
                                                                                    .addCard(Card.builder().text(TEXT_MMS).title(TITLE).build())
                                                                                    .addCard(Card.builder().text(TEXT_MMS).title(TITLE).build()).build())
                                                        .formatId(FORMAT_ID_CAROUSEL3)
                                                        .brandKey(BRAND_KEY)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_108_sendOmniRcsCarouselButtonCOM_V() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(RcsMessage.builder()
                                                        .from(FROM)
                                                        .content(Carousel.builder().addCard(Card.builder().text(TEXT_MMS).title(TITLE)
                                                                                        .addButton(net.infobank.client.data.request.rcs.Button.ComVideoButtonBuilder().name(NAME).phoneNumber(TO).build()).build())
                                                                                    .addCard(Card.builder().text(TEXT_MMS).title(TITLE).build())
                                                                                    .addCard(Card.builder().text(TEXT_MMS).title(TITLE).build()).build())
                                                        .formatId(FORMAT_ID_CAROUSEL3)
                                                        .brandKey(BRAND_KEY)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_109_sendOmniRcsCarouselButtonDIAL() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(RcsMessage.builder()
                                                        .from(FROM)
                                                        .content(Carousel.builder().addCard(Card.builder().text(TEXT_MMS).title(TITLE)
                                                                                        .addButton(net.infobank.client.data.request.rcs.Button.DialButtonBuilder().name(NAME).phoneNumber(TO).build()).build())
                                                                                    .addCard(Card.builder().text(TEXT_MMS).title(TITLE).build())
                                                                                    .addCard(Card.builder().text(TEXT_MMS).title(TITLE).build()).build())
                                                        .formatId(FORMAT_ID_CAROUSEL3)
                                                        .brandKey(BRAND_KEY)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_110_sendOmniRcsTeamplteFree() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(RcsMessage.builder()
                                                .from(FROM)
                                                .content(Template.builder().description(TEXT_SMS).build())
                                                .formatId(FORMAT_ID_TEMPLATE_FREE)
                                                .brandKey(BRAND_KEY)
                                                .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_111_sendOmniRcsTeamplteCell() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(RcsMessage.builder()
                                                .from(FROM)
                                                .content(Template.builder().put(KEY, VALUE).build())
                                                .formatId(FORMAT_ID_TEMPLATE_CELL)
                                                .brandKey(BRAND_KEY)
                                                .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_112_sendOmniRcsTeamplteDescription() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(RcsMessage.builder()
                                                .from(FROM)
                                                .content(Template.builder().description(TEXT_SMS).build())
                                                .formatId(FORMAT_ID_TEMPLATE_DESCRIPTION)
                                                .brandKey(BRAND_KEY)
                                                .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_113_sendOmniRcsTeamplteImage() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(RcsMessage.builder()
                                                .from(FROM)
                                                .content(Template.builder().description(TEXT_SMS).addSubContent(SubContent.builder().subDesc(DESCRIPTION).subTitle(TITLE).build()).build())
                                                .formatId(FORMAT_ID_TEMPLATE_IMAGE)
                                                .brandKey(BRAND_KEY)
                                                .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_114_sendOmniAlimtalkMandatory() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(AlimtalkMessage.builder().msgType(MessageType.AT).senderKey(SENDER_KEY).templateCode(TEMPLATE_CODE).text(TEXT_MMS).build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test(expected = MissingFieldException.class)
    public void OMNI_SDK_115_sendOmniAlimtalkMissingMandatory() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(AlimtalkMessage.builder().senderKey(SENDER_KEY).templateCode(TEMPLATE_CODE).text(TEXT_MMS).build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_116_sendOmniAlimtalkWithOption() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(AlimtalkMessage.builder()
                                                        .msgType(MessageType.AT)
                                                        .senderKey(SENDER_KEY)
                                                        .templateCode(TEMPLATE_CODE)
                                                        .text(TEXT_MMS)
                                                        .title(TITLE)
                                                        .currencyType(CURRENCY_TYPE)
                                                        .price(PRICE)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_117_sendOmniAlimtalkButtonWeblink() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(AlimtalkMessage.builder()
                                                        .msgType(MessageType.AT)
                                                        .senderKey(SENDER_KEY)
                                                        .templateCode(TEMPLATE_CODE)
                                                        .text(TEXT_MMS)
                                                        .title(TITLE)
                                                        .attachment(Attachment.builder().addButton(net.infobank.client.data.request.kakao.Button.WeblinkButtonBuilder().name(NAME).urlPc(URL_PC).urlMobile(URL_MOBILE)
                                                                                                .build())
                                                                                .build())
                                                        .currencyType(CURRENCY_TYPE)
                                                        .price(PRICE)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_118_sendOmniAlimtalkButtonApplink() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(AlimtalkMessage.builder()
                                                        .msgType(MessageType.AT)
                                                        .senderKey(SENDER_KEY)
                                                        .templateCode(TEMPLATE_CODE)
                                                        .text(TEXT_MMS)
                                                        .title(TITLE)
                                                        .attachment(Attachment.builder().addButton(net.infobank.client.data.request.kakao.Button.AppLinkButtonBuilder().name(NAME).urlPc(URL_PC).urlMobile(URL_MOBILE).schemeAndroid(SCHEME_ANDROID).schemeIos(SCHEME_IOS).build())
                                                                                .build())
                                                        .currencyType(CURRENCY_TYPE)
                                                        .price(PRICE)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_119_sendOmniAlimtalkButtonBotKeyword() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(AlimtalkMessage.builder()
                                                        .msgType(MessageType.AT)
                                                        .senderKey(SENDER_KEY)
                                                        .templateCode(TEMPLATE_CODE)
                                                        .text(TEXT_MMS)
                                                        .title(TITLE)
                                                        .attachment(Attachment.builder().addButton(net.infobank.client.data.request.kakao.Button.BotKeywordButtonBuilder().name(NAME).build())
                                                                                .build())
                                                        .currencyType(CURRENCY_TYPE)
                                                        .price(PRICE)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_120_sendOmniAlimtalkButtonMessageDelivery() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(AlimtalkMessage.builder()
                                                        .msgType(MessageType.AT)
                                                        .senderKey(SENDER_KEY)
                                                        .templateCode(TEMPLATE_CODE)
                                                        .text(TEXT_MMS)
                                                        .title(TITLE)
                                                        .attachment(Attachment.builder().addButton(net.infobank.client.data.request.kakao.Button.MessageDeliveryButtonBuilder().name(NAME).build())
                                                                                .build())
                                                        .currencyType(CURRENCY_TYPE)
                                                        .price(PRICE)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_121_sendOmniAlimtalkButtonDeliverySearch() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(AlimtalkMessage.builder()
                                                        .msgType(MessageType.AT)
                                                        .senderKey(SENDER_KEY)
                                                        .templateCode(TEMPLATE_CODE)
                                                        .text(TEXT_MMS)
                                                        .title(TITLE)
                                                        .attachment(Attachment.builder().addButton(net.infobank.client.data.request.kakao.Button.DeliverySearchButtonBuilder().name(NAME).build())
                                                                                .build())
                                                        .currencyType(CURRENCY_TYPE)
                                                        .price(PRICE)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_122_sendOmniAlimtalkButtonConsulting() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(AlimtalkMessage.builder()
                                                        .msgType(MessageType.AT)
                                                        .senderKey(SENDER_KEY)
                                                        .templateCode(TEMPLATE_CODE)
                                                        .text(TEXT_MMS)
                                                        .title(TITLE)
                                                        .attachment(Attachment.builder().addButton(net.infobank.client.data.request.kakao.Button.ConsultingButtonBuilder().chatExtra(CHAT_EXTRA).name(NAME).build())
                                                                                .build())
                                                        .currencyType(CURRENCY_TYPE)
                                                        .price(PRICE)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_123_sendOmniAlimtalkButtonChatbotTransform() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(AlimtalkMessage.builder()
                                                        .msgType(MessageType.AT)
                                                        .senderKey(SENDER_KEY)
                                                        .templateCode(TEMPLATE_CODE)
                                                        .text(TEXT_MMS)
                                                        .title(TITLE)
                                                        .attachment(Attachment.builder().addButton(net.infobank.client.data.request.kakao.Button.ChatbotTransformButtonBuilder().chatEvent(CHAT_EVENT).chatExtra(CHAT_EXTRA).name(NAME).build())
                                                                                .build())
                                                        .currencyType(CURRENCY_TYPE)
                                                        .price(PRICE)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_124_sendOmniAlimtalkButtonAddChannel() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(AlimtalkMessage.builder()
                                                        .msgType(MessageType.AT)
                                                        .senderKey(SENDER_KEY)
                                                        .templateCode(TEMPLATE_CODE)
                                                        .text(TEXT_MMS)
                                                        .title(TITLE)
                                                        .attachment(Attachment.builder().addButton(net.infobank.client.data.request.kakao.Button.AddChannelButtonBuilder().build())
                                                                                .build())
                                                        .currencyType(CURRENCY_TYPE)
                                                        .price(PRICE)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_125_sendOmniAlimtalkButtonBizForm() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(AlimtalkMessage.builder()
                                                        .msgType(MessageType.AT)
                                                        .senderKey(SENDER_KEY)
                                                        .templateCode(TEMPLATE_CODE)
                                                        .text(TEXT_MMS)
                                                        .title(TITLE)
                                                        .attachment(Attachment.builder().addButton(net.infobank.client.data.request.kakao.Button.BizFormButtonBuilder().bizFormId(BIZ_FORM_ID).bizFormKey(BIZ_FORM_KEY).name(NAME).build())
                                                                                .build())
                                                        .currencyType(CURRENCY_TYPE)
                                                        .price(PRICE)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_126_sendOmniAlimtalkReplyWeblink() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(AlimtalkMessage.builder()
                                                        .msgType(MessageType.AT)
                                                        .senderKey(SENDER_KEY)
                                                        .templateCode(TEMPLATE_CODE)
                                                        .text(TEXT_MMS)
                                                        .title(TITLE)
                                                        .supplement(Supplement.builder().addQuickReply(net.infobank.client.data.request.kakao.QuickReply.WebLinkQuickReplyBuilder().name(NAME).urlMobile(URL_MOBILE).urlPc(URL_PC).build())
                                                                                .build())
                                                        .currencyType(CURRENCY_TYPE)
                                                        .price(PRICE)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_127_sendOmniAlimtalkReplyApplink() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(AlimtalkMessage.builder()
                                                        .msgType(MessageType.AT)
                                                        .senderKey(SENDER_KEY)
                                                        .templateCode(TEMPLATE_CODE)
                                                        .text(TEXT_MMS)
                                                        .title(TITLE)
                                                        .supplement(Supplement.builder().addQuickReply(net.infobank.client.data.request.kakao.QuickReply.AppLinkQuickReplyBuilder().name(NAME).schemeAndroid(SCHEME_ANDROID).schemeIos(SCHEME_IOS).urlPc(URL_PC).urlMobile(URL_MOBILE).build())
                                                                                .build())
                                                        .currencyType(CURRENCY_TYPE)
                                                        .price(PRICE)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_128_sendOmniAlimtalkReplyBotKeyword() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(AlimtalkMessage.builder()
                                                        .msgType(MessageType.AT)
                                                        .senderKey(SENDER_KEY)
                                                        .templateCode(TEMPLATE_CODE)
                                                        .text(TEXT_MMS)
                                                        .title(TITLE)
                                                        .supplement(Supplement.builder().addQuickReply(net.infobank.client.data.request.kakao.QuickReply.BotKeywordQuickReplyBuilder().name(NAME).build())
                                                                                .build())
                                                        .currencyType(CURRENCY_TYPE)
                                                        .price(PRICE)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_129_sendOmniAlimtalkReplyConsulting() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(AlimtalkMessage.builder()
                                                        .msgType(MessageType.AT)
                                                        .senderKey(SENDER_KEY)
                                                        .templateCode(TEMPLATE_CODE)
                                                        .text(TEXT_MMS)
                                                        .title(TITLE)
                                                        .supplement(Supplement.builder().addQuickReply(net.infobank.client.data.request.kakao.QuickReply.ConsultingQuickReplyBuilder().chatExtra(CHAT_EXTRA).name(NAME).build())
                                                                                .build())
                                                        .currencyType(CURRENCY_TYPE)
                                                        .price(PRICE)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_130_sendOmniAlimtalkReplyChatbotTransform() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(AlimtalkMessage.builder()
                                                        .msgType(MessageType.AT)
                                                        .senderKey(SENDER_KEY)
                                                        .templateCode(TEMPLATE_CODE)
                                                        .text(TEXT_MMS)
                                                        .title(TITLE)
                                                        .supplement(Supplement.builder().addQuickReply(net.infobank.client.data.request.kakao.QuickReply.ChatbotTransformQuickReplyBuilder().chatEvent(CHAT_EVENT).chatExtra(CHAT_EXTRA).name(NAME).build())
                                                                                .build())
                                                        .currencyType(CURRENCY_TYPE)
                                                        .price(PRICE)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_131_sendOmniAlimtalkReplyBizform() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(AlimtalkMessage.builder()
                                                        .msgType(MessageType.AT)
                                                        .senderKey(SENDER_KEY)
                                                        .templateCode(TEMPLATE_CODE)
                                                        .text(TEXT_MMS)
                                                        .title(TITLE)
                                                        .supplement(Supplement.builder().addQuickReply(net.infobank.client.data.request.kakao.QuickReply.BizFormQuickReplyBuilder().bizFormId(BIZ_FORM_ID).name(NAME).build())
                                                                                .build())
                                                        .currencyType(CURRENCY_TYPE)
                                                        .price(PRICE)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_132_sendOmniAlimtalkWithItem() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(AlimtalkMessage.builder()
                                                        .msgType(MessageType.AT)
                                                        .senderKey(SENDER_KEY)
                                                        .templateCode(TEMPLATE_CODE)
                                                        .text(TEXT_MMS)
                                                        .title(TITLE)
                                                        .attachment(Attachment.builder().item(Item.builder().addList(ListNode.builder().description(DESCRIPTION).title(TITLE).build()).build()).build())
                                                        .currencyType(CURRENCY_TYPE)
                                                        .price(PRICE)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_133_sendOmniAlimtalkWithItemHighlight() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(AlimtalkMessage.builder()
                                                        .msgType(MessageType.AT)
                                                        .senderKey(SENDER_KEY)
                                                        .templateCode(TEMPLATE_CODE)
                                                        .text(TEXT_MMS)
                                                        .title(TITLE)
                                                        .attachment(Attachment.builder().itemHighlight(ItemHighlight.builder().description(DESCRIPTION).title(TITLE).build()).build())
                                                        .currencyType(CURRENCY_TYPE)
                                                        .price(PRICE)
                                                        .build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_134_sendOmniFriendtalkMandatory() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(FriendtalkMessage.builder().msgType(MessageType.FT).text(TEXT_MMS).senderKey(SENDER_KEY).build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test(expected = MissingFieldException.class)
    public void OMNI_SDK_135_sendOmniFriendtalkMissingMandatory() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(FriendtalkMessage.builder().text(TEXT_MMS).senderKey(SENDER_KEY).build())
                                    .addDestination(Destination.builder().to(TO).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_136_sendOmniFriendtalkWithOption() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(FriendtalkMessage.builder()
                                                .senderKey(SENDER_KEY)
                                                .msgType(MessageType.FT)
                                                .text(TEXT_MMS)
                                                .attachment(Attachment.builder().image(Image.builder().imgUrl(IMG_URL).build()).build())
                                                .adFlag(AD_FLAG)
                                                .build())
                                    .addDestination(Destination.builder().to(TO).addReplaceWord(KEY, VALUE).build())
                                    .ref(REF)
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_137_sendOmniFriendtalkButtonWeblink() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(FriendtalkMessage.builder()
                                                .senderKey(SENDER_KEY)
                                                .msgType(MessageType.FT)
                                                .text(TEXT_MMS)
                                                .attachment(Attachment.builder().addButton(net.infobank.client.data.request.kakao.Button.WeblinkButtonBuilder().name(NAME).target(TARGET).urlMobile(URL_MOBILE).urlPc(URL_PC).build()).build())
                                                .adFlag(AD_FLAG)
                                                .build())
                                    .addDestination(Destination.builder().to(TO).addReplaceWord(KEY, VALUE).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_138_sendOmniFriendtalkButtonApplink() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(FriendtalkMessage.builder()
                                                .senderKey(SENDER_KEY)
                                                .msgType(MessageType.FT)
                                                .text(TEXT_MMS)
                                                .attachment(Attachment.builder().addButton(net.infobank.client.data.request.kakao.Button.AppLinkButtonBuilder().name(NAME).schemeAndroid(SCHEME_ANDROID).schemeIos(SCHEME_IOS).urlMobile(URL_MOBILE).urlPc(URL_PC).build())
                                                            .build())
                                                .adFlag(AD_FLAG)
                                                .build())
                                    .addDestination(Destination.builder().to(TO).addReplaceWord(KEY, VALUE).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_139_sendOmniFriendtalkButtonBotKeyword() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(FriendtalkMessage.builder()
                                                .senderKey(SENDER_KEY)
                                                .msgType(MessageType.FT)
                                                .text(TEXT_MMS)
                                                .attachment(Attachment.builder().addButton(net.infobank.client.data.request.kakao.Button.BotKeywordButtonBuilder().name(NAME).build())
                                                            .build())
                                                .adFlag(AD_FLAG)
                                                .build())
                                    .addDestination(Destination.builder().to(TO).addReplaceWord(KEY, VALUE).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_140_sendOmniFriendtalkButtonMessageDelivery() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(FriendtalkMessage.builder()
                                                .senderKey(SENDER_KEY)
                                                .msgType(MessageType.FT)
                                                .text(TEXT_MMS)
                                                .attachment(Attachment.builder().addButton(net.infobank.client.data.request.kakao.Button.MessageDeliveryButtonBuilder().name(NAME).build())
                                                            .build())
                                                .adFlag(AD_FLAG)
                                                .build())
                                    .addDestination(Destination.builder().to(TO).addReplaceWord(KEY, VALUE).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_141_sendOmniFriendtalkButtonDeliverySearch() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(FriendtalkMessage.builder()
                                                .senderKey(SENDER_KEY)
                                                .msgType(MessageType.FT)
                                                .text(TEXT_MMS)
                                                .attachment(Attachment.builder().addButton(net.infobank.client.data.request.kakao.Button.DeliverySearchButtonBuilder().name(NAME).build())
                                                            .build())
                                                .adFlag(AD_FLAG)
                                                .build())
                                    .addDestination(Destination.builder().to(TO).addReplaceWord(KEY, VALUE).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_142_sendOmniFriendtalkButtonConsulting() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(FriendtalkMessage.builder()
                                                .senderKey(SENDER_KEY)
                                                .msgType(MessageType.FT)
                                                .text(TEXT_MMS)
                                                .attachment(Attachment.builder().addButton(net.infobank.client.data.request.kakao.Button.ConsultingButtonBuilder().chatExtra(CHAT_EXTRA).name(NAME).build())
                                                            .build())
                                                .adFlag(AD_FLAG)
                                                .build())
                                    .addDestination(Destination.builder().to(TO).addReplaceWord(KEY, VALUE).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_143_sendOmniFriendtalkButtonChatbotTransform() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(FriendtalkMessage.builder()
                                                .senderKey(SENDER_KEY)
                                                .msgType(MessageType.FT)
                                                .text(TEXT_MMS)
                                                .attachment(Attachment.builder().addButton(net.infobank.client.data.request.kakao.Button.ChatbotTransformButtonBuilder().chatEvent(CHAT_EVENT).chatExtra(CHAT_EXTRA).name(NAME).build())
                                                            .build())
                                                .adFlag(AD_FLAG)
                                                .build())
                                    .addDestination(Destination.builder().to(TO).addReplaceWord(KEY, VALUE).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_144_sendOmniFriendtalkButtonAddChannel() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(FriendtalkMessage.builder()
                                                .senderKey(SENDER_KEY)
                                                .msgType(MessageType.FT)
                                                .text(TEXT_MMS)
                                                .attachment(Attachment.builder().addButton(net.infobank.client.data.request.kakao.Button.AddChannelButtonBuilder().build())
                                                            .build())
                                                .adFlag(AD_FLAG)
                                                .build())
                                    .addDestination(Destination.builder().to(TO).addReplaceWord(KEY, VALUE).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_145_sendOmniFriendtalkButtonBizform() throws Exception {

        OmniRequest omni = OmniRequest.builder()
                                    .addMessage(FriendtalkMessage.builder()
                                                .senderKey(SENDER_KEY)
                                                .msgType(MessageType.FT)
                                                .text(TEXT_MMS)
                                                .attachment(Attachment.builder().addButton(net.infobank.client.data.request.kakao.Button.BizFormButtonBuilder().bizFormId(BIZ_FORM_ID).bizFormKey(BIZ_FORM_KEY).name(NAME).build())
                                                            .build())
                                                .adFlag(AD_FLAG)
                                                .build())
                                    .addDestination(Destination.builder().to(TO).addReplaceWord(KEY, VALUE).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_146_sendOmniMessageForm() throws Exception {

        MessageFormRequest form = MessageFormRequest.builder().addMessage(SmsMessage.builder().text(TEXT_SMS).ttl(TTL).from(FROM).build()).build();
        MessageFormResponse formRes = client.register(form);

        Thread.sleep(30000);

        OmniRequest omni = OmniRequest.builder()
                                    .messageForm(formRes.getData().getFormId()) 
                                    .addDestination(Destination.builder().to(TO).addReplaceWord(KEY, VALUE).build())
                                    .build();
                                   
        OmniResponse res = client.send(omni);
        assertEquals("A000", res.getCode());
    }

}
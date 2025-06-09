package net.infobank.client;

import net.infobank.client.data.request.*;
import net.infobank.client.data.response.*;
import net.infobank.client.service.send.*;
import org.apache.http.client.HttpClient;

import net.infobank.client.core.HttpConfig;
import net.infobank.client.core.HttpWrapper;
import net.infobank.client.service.auth.AuthService;
import net.infobank.client.service.regi.FileService;
import net.infobank.client.service.regi.MessageFormService;
import net.infobank.client.service.report.ReportInquiryService;
import net.infobank.client.service.report.ReportPollingService;

/**
 * Infobank OMNI API client Object.
 */
public class InfobankClient {

    private final HttpWrapper httpWrapper;
    private final SmsService smsService;
    private final MmsService mmsService;
    private final FileService fileService;
    private final RcsService rcsService;
    private final InternationalService internationalService;
    private final AlimtalkService alimtalkService;
    private final FriendtalkService friendtalkService;
    private final BrandmessageService brandmessageService;
    private final MessageFormService messageFormService;
    private final OmniService omniService;
    private final ReportInquiryService reportInquiryService;
    private final ReportPollingService reportPollingService;

    private InfobankClient(Builder builder) {
        httpWrapper = new HttpWrapper(builder.httpConfig, builder.authService);
        httpWrapper.setHttpClient(builder.httpClient);
        
        smsService = new SmsService(httpWrapper);
        mmsService = new MmsService(httpWrapper);
        fileService = new FileService(httpWrapper);
        rcsService = new RcsService(httpWrapper);
        internationalService = new InternationalService(httpWrapper);
        alimtalkService = new AlimtalkService(httpWrapper);
        friendtalkService = new FriendtalkService(httpWrapper);
        brandmessageService = new BrandmessageService(httpWrapper);
        messageFormService = new MessageFormService(httpWrapper);
        omniService = new OmniService(httpWrapper);
        reportInquiryService = new ReportInquiryService(httpWrapper);
        reportPollingService = new ReportPollingService(httpWrapper);
    }

    public SmsResponse send(SmsRequest sms) throws Exception {
        return smsService.execute(sms);
    }

    public MmsResponse send(MmsRequest mms) throws Exception {
        return mmsService.execute(mms);
    }

    public RcsResponse send(RcsRequest rcs) throws Exception {
        return rcsService.execute(rcs);
    }

    public InternationalResponse send(InternationalRequest msg) throws Exception {
        return internationalService.execute(msg);
    }

    public AlimtalkResponse send(AlimtalkRequest alimtalk) throws Exception {
        return alimtalkService.execute(alimtalk);
    }

    public FriendtalkResponse send(FriendtalkRequest friendtalk) throws Exception {
        return friendtalkService.execute(friendtalk);
    }

    public BrandmessageResponse send(BrandmessageRequest brandMessage) throws Exception {
        return brandmessageService.execute(brandMessage);
    }


    public OmniResponse send(OmniRequest omni) throws Exception {
        return omniService.execute(omni);
    }

    public FileResponse register(FileRequest file) throws Exception {
        return fileService.execute(file);
    }

    public MessageFormResponse register(MessageFormRequest form) throws Exception {
        form.setMethod("POST");
        return messageFormService.execute(form);
    }

    public MessageFormResponse get(MessageFormRequest form) throws Exception {
        form.setMethod("GET");
        return messageFormService.execute(form);
    }

    public MessageFormResponse modify(MessageFormRequest form) throws Exception {
        form.setMethod("PUT");
        return messageFormService.execute(form);
    }

    public MessageFormResponse remove(MessageFormRequest form) throws Exception {
        form.setMethod("DELETE");
        return messageFormService.execute(form);
    }

    public ReportInquiryResponse get(ReportInquiryRequest req) throws Exception {
        return reportInquiryService.execute(req);
    }

    public ReportPollingResponse get(ReportPollingRequest req) throws Exception {
        req.setMethod("GET");
        return reportPollingService.execute(req);
    }

    public ReportPollingResponse remove(ReportPollingRequest req) throws Exception {
        req.setMethod("DELETE");
        return reportPollingService.execute(req);
    }

    public static Builder builder() {
        return new Builder();
    }


    public static class Builder {

        private HttpConfig httpConfig = HttpConfig.defaultConfig();
        private HttpClient httpClient;
        private AuthService authService;
        private String clientId;
        private String password;

        public Builder httpConfig(HttpConfig httpConfig) {
            this.httpConfig = httpConfig;
            return this;
        }

        public Builder httpClient(HttpClient httpClient) {
            this.httpClient = httpClient;
            return this;
        }

        public Builder clientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

         public InfobankClient build() {
            authService = new AuthService(httpConfig, httpClient, clientId, password);
            return new InfobankClient(this);
        }
    }
}

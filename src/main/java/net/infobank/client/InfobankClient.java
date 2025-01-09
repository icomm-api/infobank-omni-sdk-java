package net.infobank.client;

import org.apache.http.client.HttpClient;

import net.infobank.client.core.HttpConfig;
import net.infobank.client.core.HttpWrapper;
import net.infobank.client.data.request.AlimtalkRequest;
import net.infobank.client.data.request.FileRequest;
import net.infobank.client.data.request.FriendtalkRequest;
import net.infobank.client.data.request.InternationalRequest;
import net.infobank.client.data.request.MessageFormRequest;
import net.infobank.client.data.request.MmsRequest;
import net.infobank.client.data.request.OmniRequest;
import net.infobank.client.data.request.RcsRequest;
import net.infobank.client.data.request.ReportInquiryRequest;
import net.infobank.client.data.request.ReportPollingRequest;
import net.infobank.client.data.request.SmsRequest;
import net.infobank.client.data.response.AlimtalkResponse;
import net.infobank.client.data.response.FileResponse;
import net.infobank.client.data.response.FriendtalkResponse;
import net.infobank.client.data.response.InternationalResponse;
import net.infobank.client.data.response.MessageFormResponse;
import net.infobank.client.data.response.MmsResponse;
import net.infobank.client.data.response.OmniResponse;
import net.infobank.client.data.response.RcsResponse;
import net.infobank.client.data.response.ReportInquiryResponse;
import net.infobank.client.data.response.ReportPollingResponse;
import net.infobank.client.data.response.SmsResponse;
import net.infobank.client.service.auth.AuthService;
import net.infobank.client.service.regi.FileService;
import net.infobank.client.service.regi.MessageFormService;
import net.infobank.client.service.report.ReportInquiryService;
import net.infobank.client.service.report.ReportPollingService;
import net.infobank.client.service.send.AlimtalkService;
import net.infobank.client.service.send.FriendtalkService;
import net.infobank.client.service.send.InternationalService;
import net.infobank.client.service.send.MmsService;
import net.infobank.client.service.send.OmniService;
import net.infobank.client.service.send.RcsService;
import net.infobank.client.service.send.SmsService;

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

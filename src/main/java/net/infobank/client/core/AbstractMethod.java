package net.infobank.client.core;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.infobank.client.core.exception.MethodFailedException;
import net.infobank.client.core.exception.ResponseParseException;
import net.infobank.client.core.exception.UnexpectedException;

public abstract class AbstractMethod<RequestT, ResponseT> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractMethod.class);
    protected static final BasicResponseHandler basicResponseHandler = new BasicResponseHandler();
    protected final HttpWrapper httpWrapper;

    public AbstractMethod(HttpWrapper httpWrapper) {
        this.httpWrapper = httpWrapper;
    }

    public ResponseT execute(RequestT request){
        try {
            HttpUriRequest httpRequest = applyAuth(makeRequest(request))
                    .setHeader("User-Agent", httpWrapper.getHttpConfig().getUserAgent())
                    .setCharset(StandardCharsets.UTF_8)
                    .build();

            LOGGER.debug("Request: " + httpRequest);
            if (LOGGER.isDebugEnabled() && httpRequest instanceof HttpEntityEnclosingRequestBase) {
                HttpEntityEnclosingRequestBase enclosingRequest = (HttpEntityEnclosingRequestBase) httpRequest;
                LOGGER.debug(EntityUtils.toString(enclosingRequest.getEntity()));
            }
            HttpResponse response = httpWrapper.getHttpClient().execute(httpRequest);

            LOGGER.debug("Response: " + Util.logResponse(response));
            
            try {
                return parseResponse(response);
            }
            catch (IOException io) {
                throw new ResponseParseException("Unable to parse response.", io);
            }
        } catch (UnsupportedEncodingException uee) {
            throw new UnexpectedException("UTF-8 encoding is not supported by this JVM.", uee);
        } catch (IOException io) {
            throw new MethodFailedException("Something went wrong while executing the HTTP request: " +
                    io.getMessage() + ".", io);
        }
    }

    protected RequestBuilder applyAuth(RequestBuilder request) throws IOException {
        return httpWrapper.applyAuth(request);
    }

    public void setHttpClient(HttpClient client) {
        httpWrapper.setHttpClient(client);
    }

    public abstract RequestBuilder makeRequest(RequestT request) throws UnsupportedEncodingException;

    public abstract ResponseT parseResponse(HttpResponse response) throws IOException;
}

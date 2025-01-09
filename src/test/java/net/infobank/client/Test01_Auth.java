package net.infobank.client;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import net.infobank.client.core.HttpConfig;
import net.infobank.client.data.response.AuthResponse;
import net.infobank.client.service.auth.AuthService;

public class Test01_Auth {
    private static final String BASE_URL = "http://172.16.0.73:7000/";
    private static final String CLIENT_ID = "clo445";
    private static final String PASSWORD = "12345678";

    @Test
    public void OMNI_SDK_01_getToken() throws IOException {
        HttpConfig config = HttpConfig.builder().baseUrl(BASE_URL).build();
        AuthService authService = new AuthService(config, null, CLIENT_ID, PASSWORD);
        AuthResponse res = authService.getToken();
        assertEquals("A000", res.getCode());
    }

}
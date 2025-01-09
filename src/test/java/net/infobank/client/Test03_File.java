package net.infobank.client;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.net.URL;

import org.junit.Test;

import net.infobank.client.core.HttpConfig;
import net.infobank.client.data.code.MessageType;
import net.infobank.client.data.code.ServiceType;
import net.infobank.client.data.request.FileRequest;
import net.infobank.client.data.response.FileResponse;

public class Test03_File {
    private static final String BASE_URL = "http://172.16.0.73:7000";
    private static final String CLIENT_ID = "clo445";
    private static final String PASSWORD = "12345678";

    InfobankClient client = InfobankClient.builder()
                                .clientId(CLIENT_ID)
                                .password(PASSWORD)
                                .httpConfig(HttpConfig.builder().baseUrl(BASE_URL).build())
                                .build();

    @Test
    public void OMNI_SDK_06_registerFileMMS() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        URL fileURL = classLoader.getResource("infobank.jpg");
        FileRequest file = FileRequest.builder().file(new File(fileURL.getFile())).serviceType(ServiceType.MMS).build();
        FileResponse res = client.register(file);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_07_registerFileRCS() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        URL fileURL = classLoader.getResource("infobank.jpg");
        FileRequest file = FileRequest.builder().file(new File(fileURL.getFile())).serviceType(ServiceType.RCS).build();
        FileResponse res = client.register(file);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_08_registerFileFI() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        URL fileURL = classLoader.getResource("infobank.jpg");
        FileRequest file = FileRequest.builder().file(new File(fileURL.getFile())).serviceType(ServiceType.FRIENDTALK).msgType(MessageType.FI).build();
        FileResponse res = client.register(file);
        assertEquals("A000", res.getCode());
    }

    @Test
    public void OMNI_SDK_09_registerFileFW() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        URL fileURL = classLoader.getResource("infobank.jpg");
        FileRequest file = FileRequest.builder().file(new File(fileURL.getFile())).serviceType(ServiceType.FRIENDTALK).msgType(MessageType.FW).build();
        FileResponse res = client.register(file);
        assertEquals("A000", res.getCode());
    }

}
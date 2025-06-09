package net.infobank.client.core;

/**
 * HttpConfig 클래스는 HTTP 설정 정보를 관리하는 클래스입니다.
 * 기본 Base URL, SDK 버전, Java 버전 등의 설정 정보를 가지고 있습니다.
 *
 * @author OpenAI
 * @version 1.0
 * @since 2023-07-13
 */
public class HttpConfig {

    /**
     * 기본 Base URL.
     */
    private static final String DEFAULT_BASE_URL = "https://omni.ibapi.kr";

    /**
     * SDK 버전.
     */
    private static final String SDK_VERSION = "1.0.0";

    /**
     * 시스템의 Java 버전.
     */
    private static final String JAVA_VERSION = System.getProperty("java.version");

    /**
     * User Agent 설정 값. SDK 버전과 Java 버전 정보를 포함합니다.
     */
    private static final String USER_AGENT = String.format("OmniApi Sdk Java %s java/%s", SDK_VERSION, JAVA_VERSION);

    /**
     * 설정된 Base URL.
     */
    private final String baseUrl;

    /**
     * HttpConfig 객체를 생성하는 빌더 클래스를 이용하는 생성자입니다.
     *
     * @param builder HttpConfig 객체를 생성하는 데 필요한 설정 정보를 가진 빌더 객체입니다.
     */
    private HttpConfig(Builder builder) {
        baseUrl = builder.baseUrl;
    }

    /**
     * 설정된 Base URL을 반환합니다.
     *
     * @return 설정된 Base URL 문자열을 반환합니다.
     */
    public String getBaseUrl() {
        return baseUrl;
    }

    /**
     * User Agent를 반환합니다.
     *
     * @return 설정된 User Agent 문자열을 반환합니다.
     */
    public String getUserAgent() {
        return USER_AGENT;
    }

    /**
     * 설정된 Base URL이 기본 Base URL인지 여부를 확인합니다.
     *
     * @return 기본 Base URL이면 true, 아니면 false를 반환합니다.
     */
    public boolean isDefaultBaseUrl() {
        return DEFAULT_BASE_URL.equals(baseUrl);
    }

    /**
     * 설정된 Base URL에 버전 정보를 추가하여 반환합니다.
     *
     * @param version 추가할 버전 정보입니다.
     * @return 버전 정보가 추가된 Base URL 문자열을 반환합니다.
     */
    public String getVersionedApiBaseUrl(String version) {
        return appendVersionToUrl(baseUrl, version);
    }

    /**
     * 주어진 URL에 버전 정보를 추가하는 내부 메소드입니다.
     *
     * @param url     기본이 되는 URL 입니다.
     * @param version 추가할 버전 정보입니다.
     * @return 버전 정보가 추가된 URL 문자열을 반환합니다.
     */
    private String appendVersionToUrl(String url, String version) {
        return url + "/" + version;
    }

    /**
     * 기본 설정으로 HttpConfig 객체를 생성하여 반환합니다.
     *
     * @return 기본 설정의 HttpConfig 객체를 반환합니다.
     */
    public static HttpConfig defaultConfig() {
        return new Builder().build();
    }

    /**
     * HttpConfig 객체를 생성하는 Builder 객체를 반환합니다.
     *
     * @return HttpConfig.Builder 객체를 반환합니다.
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * HttpConfig의 빌더 클래스입니다.
     * 빌더 패턴을 이용하여 HttpConfig 객체를 생성합니다.
     */
    public static class Builder {

        /**
         * 빌더 클래스에서 사용하는 Base URL.
         * 기본값은 DEFAULT_BASE_URL로 설정되어 있습니다.
         */
        private String baseUrl = DEFAULT_BASE_URL;

        /**
         * 빌더 객체의 Base URL을 설정하는 메소드입니다.
         *
         * @param baseUrl 설정할 Base URL입니다.
         * @return 현재의 빌더 객체를 반환합니다. 이를 통해 메소드 체이닝이 가능합니다.
         */
        public Builder baseUrl(String baseUrl) {
            this.baseUrl = Util.sanitizeUri(baseUrl);
            return this;
        }

        /**
         * 빌더 객체의 설정을 이용하여 HttpConfig 객체를 생성합니다.
         *
         * @return 새로운 HttpConfig 객체를 반환합니다.
         */
        public HttpConfig build() {
            return new HttpConfig(this);
        }

    }

}

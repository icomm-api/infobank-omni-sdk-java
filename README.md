# Infobank Omni API SDK for Java

이 레포지토리는 인포뱅크의 **OMNI API (통합 메시지 API)** 연동을 위한 **Java용 공식 SDK**입니다.  
Java 환경에서 쉽고 빠르게 통합 메시지 전송 기능(SMS, LMS, MMS, RCS, 알림톡, 친구톡 등)을 구현할 수 있도록 도와줍니다.

---

## 📚 Documentation

- 👉 [OMNI API 명세서 (GitBook)](https://infobank-guide.gitbook.io/omni_api)
- 📧 기술 문의: [support@infobank.net](mailto:support@infobank.net)

---

## ✅ Requirements

OMNI API 사용 전 다음을 준비해 주세요:

- [Bizgo 계정 생성](https://bizgo.io)
- 발신번호 등록 (SMS, LMS, RCS용)
- RCS BizCenter 가입 (RCS 메시지 전송 시)
- 카카오비즈니스 가입 (알림톡/친구톡 전송 시)
- 방화벽 설정: 명세서에 명시된 IP 허용 필요

---

## ☕ Supported Environment

- Java 8 이상
- TLS 1.2 이상

---

## 📦 Installation (Maven Central)

### Maven

```xml
<dependency>
    <groupId>io.github.icomm-api</groupId>
    <artifactId>infobank-omni-sdk-java</artifactId>
    <version>1.1.0</version>
</dependency>
```

### Gradle

```groovy
implementation 'io.github.icomm-api:infobank-omni-sdk-java:1.1.0'
```

🔍 [Maven Central 검색 바로가기](https://central.sonatype.com/artifact/io.github.icomm-api/infobank-omni-sdk-java)

---

## 🚀 Client Initialization

```java
InfobankClient client = InfobankClient.builder()
  .clientId(CLIENT_ID)
  .password(PASSWORD)
  .httpConfig(HttpConfig.builder().baseUrl(BASE_URL).build())
  .build();
```

---

## 💡 Usage Examples

### 1️⃣ 인증 토큰 발급

```java
HttpConfig config = HttpConfig.builder().baseUrl("https://omni.ibapi.kr").build();
AuthService authService = new AuthService(config, null, CLIENT_ID, PASSWORD);
AuthResponse res = authService.getToken();
System.out.println("AccessToken: " + res.getAccessToken());
```

---

### 2️⃣ 파일 등록 (MMS, RCS, 친구톡 등)

```java
File file = new File(getClass().getClassLoader().getResource("infobank.jpg").getFile());

FileRequest mmsFile = FileRequest.builder().file(file).serviceType(ServiceType.MMS).build();
FileRequest rcsFile = FileRequest.builder().file(file).serviceType(ServiceType.RCS).build();
FileRequest ftFile = FileRequest.builder().file(file)
  .serviceType(ServiceType.FRIENDTALK)
  .msgType(MessageType.FI)
  .build();

client.register(mmsFile);
client.register(rcsFile);
client.register(ftFile);
```

---

### 3️⃣ SMS / LMS 전송

```java
SmsRequest sms = SmsRequest.builder()
  .to("TO")
  .from("FROM")
  .text("SMS 메시지입니다.")
  .build();
SmsResponse smsRes = client.send(sms);

MmsRequest lms = MmsRequest.builder()
  .to("TO")
  .from("FROM")
  .text("LMS 메시지입니다.")
  .build();
MmsResponse lmsRes = client.send(lms);
```

---

### 4️⃣ 국제 메시지 전송

```java
InternationalRequest inter = InternationalRequest.builder()
  .to("TO")
  .from("FROM")
  .text("해외 메시지 테스트")
  .build();

InternationalResponse res = client.send(inter);
```

---

### 5️⃣ RCS SMS 전송

```java
RcsRequest rcs = RcsRequest.builder()
  .to("TO")
  .from("FROM")
  .formatId("FORMAT_ID_SMS")
  .content(Standalone.builder().text("RCS SMS 메시지").build())
  .brandKey("BRAND_KEY")
  .build();

RcsResponse res = client.send(rcs);
```

---

### 6️⃣ 알림톡 / 친구톡 / 브랜드 메시지

```java
// 알림톡
AlimtalkRequest alim = AlimtalkRequest.builder()
  .to("TO")
  .senderKey("SENDER_KEY")
  .templateCode("TEMPLATE_CODE")
  .text("알림톡 메시지입니다.")
  .msgType(MessageType.AT)
  .build();
client.send(alim);

// 친구톡
FriendtalkRequest friend = FriendtalkRequest.builder()
  .to("TO")
  .senderKey("SENDER_KEY")
  .text("친구톡 메시지입니다.")
  .msgType(MessageType.FT)
  .build();
client.send(friend);

// 브랜드 메시지
BrandmessageRequest brand = BrandmessageRequest.builder()
  .to("TO")
  .senderKey("SENDER_KEY")
  .sendType("free")
  .text("브랜드 메시지입니다.")
  .msgType(MessageType.FT)
  .build();
client.send(brand);
```

---

### 7️⃣ Omni 통합 메시지 전송

```java
OmniRequest omni = OmniRequest.builder()
  .addMessage(SmsMessage.builder().from("FROM").text("Omni 메시지 테스트").build())
  .addDestination(Destination.builder().to("01012345678").build())
  .build();

OmniResponse res = client.send(omni);
```

---

### 8️⃣ 전송 리포트 조회 / 삭제

```java
ReportPollingResponse pollRes = client.get(ReportPollingRequest.builder().build());
String reportId = pollRes.getData().getReportId();

client.remove(ReportPollingRequest.builder().reportId(reportId).build());
client.get(ReportInquiryRequest.builder().msgKey("MSG_KEY").build());
```

---

## 🧩 기능 요약

| 기능 항목               | 클래스 예시                        |
|------------------------|------------------------------------|
| SMS/LMS/MMS 전송       | `SmsRequest`, `MmsRequest`         |
| 국제 메시지            | `InternationalRequest`             |
| 알림톡 / 친구톡        | `AlimtalkRequest`, `FriendtalkRequest` |
| 브랜드 메시지          | `BrandmessageRequest`              |
| RCS 메시지             | `RcsRequest`                       |
| Omni 통합 메시지       | `OmniRequest`                      |
| 인증 토큰 발급         | `AuthService#getToken()`           |
| 파일 등록              | `FileRequest`                      |
| 전송 결과 리포트 관리  | `ReportPollingRequest`, `ReportInquiryRequest` |

---

## 📝 License

이 프로젝트는 [Apache2.0 라이선스](LICENSE.txt)를 따릅니다.

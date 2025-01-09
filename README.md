# Infobank Omni Api SDK for Java
[![SDK Documentation](https://img.shields.io/badge/SDK-Documentation-blue)]() [![Migration Guide](https://img.shields.io/badge/Migration-Guide-blue)]() [![API Reference](https://img.shields.io/badge/api-reference-blue.svg)]() [![Apache V2 License](https://img.shields.io/badge/license-Apache%20V2-blue.svg)]()

해당 Repository에는 인포뱅크의 OMNI API(통합메시지 API)용 JAVA client  오픈소스가 포함되어 있습니다.

SDK를 이용하면 JAVA 환경에서 편리하게 API 연동이 가능합니다.

## Documentation
OMNI API의 규격서는 [여기](https://omniapi.gitbook.io/omni-api-specification/)를 참조합니다.

## Requirements
- API사용을 위한 [계정 생성](https://bizgo.io)을 합니다.
- MT/RCS 발송을 위해 발신번호 등록을 합니다.
- RCS 전송을 위해 RCS BizCenter 가입합니다.
- 카카오 알림톡/친구톡 발송을 위해 카카오비즈니스 가입합니다.
- 규격서에 안내된 IP정보로 방화벽 허용합니다.


## Supported
- JAVA 8 이상
- TLS 1.2 


## Installation

#### Maven Central
POM.xml 파일 `dependencies` 아래 다음을 추가해주세요:
```xml
<dependency>
      <groupId>net.infobank.client</groupId>
      <artifactId>omniapi-sdk-java</artifactId>
      <version>1.0.0</version>
</dependency>
```

또는

#### Gradle
build.gradle 파일 `dependencies` 아래 다음을 추가해주세요:
```groovy
implementation "net.infobank.client:omniapi-sdk-java:1.0.0"
```

## Examples
#### Initialize the Client
- ID, PW로 SDK Client를 초기화 합니다.

```java
    InfobankClient client = InfobankClient.builder()
                                          .clientId(CLIENT_ID)
                                          .password(PASSWORD)
                                          .build();
```

#### Send SMS
- SMS 전송을 합니다.

```java
    SmsRequest sms = SmsRequest.builder()
                               .to(TO)
                               .from(FROM)
                               .text(TEXT_SMS)
                               .build();

    SmsResponse response = client.send(sms); 
```

## Contact
본 문서와 관련된 기술 문의는 아래 메일 주소로 연락 바랍니다. 😄
> support@infobank.net
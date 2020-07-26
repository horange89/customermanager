# Project Information

## 개발 환경 및 프레임워크
* IntelliJ IDEA Community
* Spring Boot 2.1.0
* MyBatis 2.1.0
* Open JDK 1.8
* H2Database
* JPA
* JUNIT4

## 문제해결 방법

* 데이터 적재 : 애플리케이션이 구동시에 CommnandLineRunner를 통하여 고객거래 내역 데이터, 고객 데이터, 지점 데이터를 파일 처리와 JPA 사용해서 적재하였습니다.
각 조회 요청 처리는 Get를 통해서 진행하였습니다.
* Data 조회 처리의 경우 JPA의 NativeQuery를 통해서 진행하였었지만, 통계에 관한 Query는 유동적으로 변할 수 있다고 판단하여 MyBatis를 사용해서 진행하였습니다.
* 단위 테스트 : JUnit4를 사용하여 Service와 Controller에서 로직별로 상황테스트를 진행하였습니다.
* Json 변환의 경우 Gson을 사용하여 변환하였습니다.

## 빌드 및 실행

### 빌드

1. IntelliJ에서 Git Clone으로 임포트 합니다.
2. Setting으로 들어가서 SDK11, Language 11, Gradle JVM 11, VCS 루트를 <None>로 설정해줍니다.
3. IntelliJ의 우측에 Gradle 탭의 Refresh 버튼을 통해서 라이브러리의 의존성을 임포트 해줍니다.
4. Gradle Project 패널 안에 있는 Tasks 의 build를 더블클릭합니다.
5. Gradle Project 패널 안에 있는 application의 booRun을 통해서 프로젝트를 실행합니다.

### 실행

#### 실행 순서
1. CustomermanagerApplication 실행
2. localhost:8080/test로 접속 후 각 버튼 클릭으로 테스트 진행

감사합니다.

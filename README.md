![첫페이지__1_](https://enjoy-trip-static-files.s3.ap-northeast-2.amazonaws.com/tripmoca_thumnail.png)

<br />

## 📌 목차

1. [프로젝트 소개](#-프로젝트-소개)
2. [팀 소개](#-팀-소개)
3. [주요 기능](#-주요-기능)
4. [소개 영상](#-소개-영상)
5. [주요 기술](#-주요-기술)
6. [기술 스택](#-기술-)
7. [기술 아키텍처](#-기술-아키텍처)
8. [프로젝트 구조](#-프로젝트-구조)
9. [산출물](#-산출물)
   <br />

## 🚀 프로젝트 소개

***SSAFY 12기 1학기 관통 프로젝트***

> ⌛ 프로젝트 기간 : 2024.10.27 ~ 2024.11.27 (4주)

> 📆 상세 기간 : 개발 4주

> 🔗 [노션 링크](https://messy-duckling-7d6.notion.site/A-Penetration-Project-1221453abf47801f86d4fe47332d69bd?source=copy_link)

> 📲 [배포 URL](https://trip-moca.netlify.app/)

🧳 "AI랑 여행 계획 뚝딱! 여행하고 카드 받고, TRIP MOCA(모으다 카드를!)✨"
✨ 더 이상 고민하지 마세요!<br />
여행 계획부터 일정 조정, 특별한 추억까지!<br />
AI가 알아서 여행 일정을 짜주고, 귀여운 지역 카드도 모을 수 있어요.<br />
여행의 시작과 끝, 트립모카 하나면 충분해요!<br />

🌍 이런 분들을 위한 AI 여행 플랫폼이에요<br />
막막한 여행 일정 때문에 떠나기를 망설이고 있는 분<br />
이왕 떠나는 여행, 효율적인 동선으로 알차게 보내고 싶은 분<br />
여행 중 추억도 남기고 특별한 보상도 받고 싶은 분<br />
귀찮은 일정 계획은 AI에게 맡기고 싶은 분<br />

🎒 트립모카만의 특별한 기능<br />
여행지와 기간만 입력하면 AI가 짜주는 맞춤 일정 추천<br />
지역마다 GET! 할 수 있는 귀엽고 개성 넘치는 캐릭터 카드<br />
내 일정에 맞는 동선을 자동으로 계산해주는 스마트 플래너<br />
여행의 추억을 모아보는 카드 컬렉션 시스템<br />

🚀 이렇게 사용해보세요!<br />
1️⃣ 여행지와 여행 기간을 입력해보세요<br />
2️⃣ AI가 최적의 일정을 자동으로 생성해드려요<br />
3️⃣ 일정이 마음에 안 들면 언제든지 수정 가능!<br />
4️⃣ 여행지에 도착하면 지역 캐릭터 카드를 모아보세요<br />

## 👥 팀 소개
## Team
|<img src="https://avatars.githubusercontent.com/u/165285610?v=4" width="150" height="150"/>|<img src="https://avatars.githubusercontent.com/u/127578678?v=4" width="150" height="150"/>|
|:-:|:-:|
|hyewon<br/>[@hyeOOO](https://github.com/hyeOOO)|서성우<br/>[@bamtol2](https://github.com/bamtol2)|
|풀스택 개발<br/>|프론트 개발<br/>|
|백엔드 전체 개발, UI/UX 디자인, 인기 여행 페이지, 회원가입/로그인 페이지, 마이페이지, 카드도감 페이지, 배포<br/>|메인 페이지, 여행 계획 페이지, AI 모카 페이지, 여행 계획 편집 페이지<br/>|

## ⌨️ 주요 기능

### 1. 간편한 AI 여행 계획 생성
- **간단한 입력으로 일정 생성**
  - 여행 지역 선택
  - 여행 기간 설정
  - AI 기반 일자별 추천 장소 생성

- **일정 커스터마이징**
  - 생성된 일정 수정 가능
  - 방문할 장소 추가/삭제
  - 날짜별 일정 조정

### 2. 지역 캐릭터 카드 수집
- **방문 인증 카드 시스템**
  - 지역별 고유 캐릭터 카드 제공
  - 방문 시 해당 지역 카드 획득
  - 나만의 카드 컬렉션 구축

- **카드 도감**
  - 수집한 카드 목록 확인
  - 미수집 카드 확인
  - 카드 수집 현황 표시

### 3. 이동 경로 안내
- **기본 경로 정보 제공**
  - 출발지-도착지 간 소요 시간 계산
  - 이동 거리 정보 제공
  - 경로 지도 표시

## 🎥 [소개 영상](https://youtu.be/FSi6VjUQT_E)
https://youtu.be/FSi6VjUQT_E

## ⚙️ 기술 스택
[![stackticon](https://firebasestorage.googleapis.com/v0/b/stackticon-81399.appspot.com/o/images%2F1741835600997?alt=media&token=045c2016-6d64-4c1d-a7ed-04fd3c6fd605)](https://github.com/msdio/stackticon)
### Backend
- **Spring Boot**
  - Spring Security를 활용한 인증/인가 구현
  - RESTful API 설계 및 구현
- **MySQL**
  - 사용자 정보, 여행 계획, 장소 정보 등 영구 데이터 저장
- **Redis**
  - refresh Token 관리
- **MongoDB**
  - 인기 검색어 구현

### Frontend
- **Vue.js**
  - 반응형 사용자 인터페이스 구현
  - Vuex를 통한 상태 관리
  - Vue Router를 이용한 SPA 구현


## 📦 프로젝트 구조
<details>
  <summary><strong>Back 폴더 구조 보기</strong></summary>
  <pre>
  </pre>
</details>
<details>
  <summary><strong>Front 폴더 구조 보기</strong></summary>
  <pre>
📦src
 ┣ 📂main
 ┃ ┣ 📂java
 ┃ ┃ ┗ 📂com
 ┃ ┃ ┃ ┗ 📂ssafy
 ┃ ┃ ┃ ┃ ┗ 📂enjoyTrip
 ┃ ┃ ┃ ┃ ┃ ┣ 📂api
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂attraction
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂exception
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂util
 ┃ ┃ ┃ ┃ ┃ ┣ 📂domain
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂attraction
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂mapper
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂card
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂mapper
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂member
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂exception
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂plan
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂dto
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂detail
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂plan
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂exception
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂repository
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂service
 ┃ ┃ ┃ ┃ ┃ ┣ 📂global
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂annotation
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂config
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂exception
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂jwt
 ┃ ┃ ┃ ┃ ┃ ┗ 📜EnjoyTripApplication.java
 ┃ ┗ 📂resources
 ┃ ┃ ┣ 📂prompts
 ┃ ┃ ┗ 📜application.yml
 ┗ 📂test
 ┃ ┗ 📂java
 ┃ ┃ ┗ 📂com
 ┃ ┃ ┃ ┗ 📂ssafy
 ┃ ┃ ┃ ┃ ┗ 📂enjoyTrip
 ┃ ┃ ┃ ┃ ┃ ┗ 📜EnjoyTripApplicationTests.java
  </pre>
</details>

## 💻 설치 및 실행 방법
1. 요구사항
   - JDK 11 이상
   - MySQL 8.0
   - Redis 6.0
   - Node.js 14.0 이상

2. 백엔드 실행
```bash
# 프로젝트 클론
git clone [repository URL]

# 데이터베이스 설정
mysql -u root -p < database.sql

# Spring Boot 실행
./gradlew bootRun
```

3. 프론트엔드 실행
```bash
# 의존성 설치
cd frontend
npm install

# 개발 서버 실행
npm run serve
```

## 🔒 환경 설정
`application.properties` 파일에 다음 설정이 필요합니다:
```properties
server:
  port: {port}
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    username: {username}
    password: {password}
    url: {url}
    hikari:
      maximum-pool-size: 20
  redis:
    host: {host}
    port: {port}
  jpa:
    hibernate:
      ddl-auto: update
    properties:
      hibernate:
        dialect: org.hibernate.dialect.MySQLDialect
  ai:
    openai:
      api-key: {apiKey}
      chat:
        options:
          model: {model}
          temperature: {temperature}
    template:
      path: {path}
      cache: true
jwt:
  secret: {jwtKey}
  access-token-validity: 3600000  # 1시간
  refresh-token-validity: 604800000  # 7일
springdoc:
  swagger-ui:
    path: /swagger/enjoy-trip.html
  api-docs:
    path: /v3/api-docs
```

## 📱 API 문서
API 문서는 Swagger UI를 통해 확인할 수 있습니다: https://trip-moca.kro.kr:8081/swagger/swagger-ui/index.html

## 📜 산출물
<details>
  <summary><strong>📌 브랜치 컨벤션</strong></summary>

💡 해당 프로젝트는 Git Flow 전략을 채택했습니다.

**- 브랜치 종류**
---
### 1. main branch
- 제품으로 출시 가능한 브랜치
- 배포(Release) 이력을 관리하며, 항상 배포 가능한 상태만 유지
---
### 2. develop branch
- 기능 개발 브랜치들을 병합하기 위한 브랜치
- 모든 기능이 추가되고 안정화된 후, main 브랜치로 병합
- 개발 시에는 항상 develop 브랜치를 기반으로 작업
---
### 3. feature branch
- 새로운 기능 개발 및 버그 수정 시 사용
- `develop` 브랜치에서 분기하여 개발
- 기본적으로 로컬에서 작업, 필요 시 원격 저장소에 push
- 작업 완료 후 `develop` 브랜치로 병합하고 브랜치 삭제
**✅ 작업 순서**
1. `develop` 브랜치에서 feature 브랜치 분기
2. 기능 개발 수행
3. 개발 완료 후 `develop` 브랜치로 병합
4. feature 브랜치 삭제
5. 원격 저장소에 push (필요 시)
---
### 4. release branch
- 배포 준비를 위한 브랜치
- 배포 주기 동안 최종 점검, 버그 수정, 문서 추가 등만 수행
- 새로운 기능은 추가하지 않음
**✅ 작업 순서**
1. `develop` 브랜치에서 release 브랜치 분기
2. 배포 준비 작업 수행
3. 준비 완료 시 `main` 브랜치에 병합 (Release 태그 부여)
4. 변경 사항을 `develop` 브랜치에도 병합
---
### 5. hotfix branch
- 배포 중인 버전에서 긴급한 버그 발생 시 사용
- `main` 브랜치에서 직접 분기하여 빠르게 수정 후 배포
**✅ 작업 순서**
1. `main` 브랜치에서 hotfix 브랜치 분기
2. 문제 수정
3. 수정 완료 후 `main` 브랜치에 병합 및 버전 태그
4. 변경 사항을 `develop` 브랜치에도 병합
</details>

<details>
  <summary><strong>📌 커밋 컨벤션</strong></summary>

💡 커밋은 논리적으로 구분이 되고, 일관성이 유지되는 단위로 최대한 작게 쪼개서 작성합니다.

---
### 1. 메시지 타입
INIT: 프로젝트 생성

FEAT: 새로운 기능 추가

FIX: 버그 수정

DOCS: 문서 수정

STYLE: 코드 formatting, 세미콜론(;) 누락 등 (기능 변경 없음)

DESIGN: 디자인 적용 및 디자인 관련 코드 수정

REFACTOR: 코드 리팩토링

TEST: 테스트 코드, 리팩토링 테스트 코드 추가

CHORE: 빌드 업무 수정, 패키지 매니저 설정 등 변경

MINOR: 사소한 변화


---
### 2. 제목은 50글자 이내로 작성

---
### 3. 제목 + 본문(선택)으로 구성  
제목만으로 설명이 부족한 경우 본문에 자세히 작성

---
### 4. 커밋 메시지는 무엇을 했는지 파악할 수 있게 작성

---
### 5. "어떻게" 보다는 "무엇"과 "왜"를 설명하기

---
### ✔️ 커밋 메시지 형식 예시







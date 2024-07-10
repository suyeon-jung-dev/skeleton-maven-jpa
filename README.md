# Skeleton - Maven - JPA

## 🇰🇷한글 문서는 [아래](#Skeketon--Maven---JPA-한글문서)를 봐주세요!


## Spec
- java `17`
- spring boot `3.3.1`
- mysql `8.4`
- Used `docker-compose support`. A MySQL server in a local environment is configured to match the application lifecycle in a container.
  - Docker and Docker Compose must be pre-installed locally. [Installing Docker Desktop once is sufficient.](https://www.docker.com/products/docker-desktop/)
  > If it's the first time running the `mysql:8.4` image, the image will be downloaded when the application starts.

## Database Schema
DDL generation is configured to be script-based rather than Hibernate-based.

```yaml
spring:
  sql:
    init:
      mode: always
      schema-locations: classpath*:db/schema.sql
      data-locations: classpath*:db/data.sql
  jpa:
    show-sql: true
    hibernate:
      ddl-auto: validate
```

Execution order: `schema.sql > data.sql > hibernate(ddl-auto)`

If you want to set the `ddl-auto: create` configuration,
```yaml
spring:
  jpa:
    hibernate:
      ddl-auto: create
    defer-datasource-initialization: true  # Change the execution order to Hibernate followed by script.
```
The execution order will be changed as follows.
`hibernate(ddl-auto) > schema.sql > data.sql`

> I recommend using DDL scripts rather than using Hibernate because Hibernate may not guarantee column order, potentially leading to unintended DDL generation.

## Actuator

### profile: `local`
To retrieve all available paths.
- http://localhost:${port}/actuator


---
# Skeketon - Maven - JPA 한글문서
프로젝트 구성은 다음과 같습니다.

- java 17
- spring boot 3.3.1
- mysql 8.4
- docker-compose support 적용으로, 로컬환경에서 MYSQL 서버가 Application lifecycle 에 맞춰 컨테이너가 구성됩니다.
  - 로컬에 docker, docker compose 가 미리 설치되어 있어야 합니다. [Docker Desktop 설치 한번이면 충분합니다.](https://www.docker.com/products/docker-desktop/)
  > `mysql:8.4` 이미지를 최초 구동하는 경우, Application 시작시 이미지 다운로드 진행됩니다.

## Database Schema
hibernate 기반 ddl 생성하지 않고, 스크립트 기반으로 ddl 생성하도록 설정해두었습니다.

```yaml
spring:
  sql:
    init:
      mode: always
      schema-locations: classpath*:db/schema.sql
      data-locations: classpath*:db/data.sql
  jpa:
    show-sql: true
    hibernate:
      ddl-auto: validate
```

실행 순서: schema.sql > data.sql > hibernate(ddl-auto)

따로 ddl-auto: craete 설정하시고 싶으시면,
```yaml
spring:
  jpa:
    hibernate:
      ddl-auto: create
    defer-datasource-initialization: true  # 실행순서를 hibernate > script 순으로 변경
```
실행순서는 다음과 같이 변경됩니다.
hibernate(ddl-auto) > schema.sql > data.sql

> hibernate 로 DDL 생성하게 되면 컬럼순서 보장이 되지 않고, 의도된 DDL이 생성되지 않을 수 있으므로 script 기반 ddl 생성을 추천드립니다.

## Actuator

### profile: `local`
사용 가능한 모든 경로 조회 
- http://localhost:${port}/actuator


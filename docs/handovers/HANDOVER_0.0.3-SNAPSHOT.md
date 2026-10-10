# login 0.0.3-SNAPSHOT security handover

## State and scope

Based on `f270713`. 0.0.2-SNAPSHOT pinned Jackson, Tomcat and Log4j on Spring
Boot 3.5.16, but `spring-webmvc` 6.2.19 still carried two critical advisories
(`GHSA-j9f9-w8pj-32f8`, `GHSA-pc63-qcmh-9cmg`) with no open-source fix in the
6.2 line. This moves the app to Spring Boot 4.1.1 / Spring Framework 7.0.9 /
Spring Security 7.1.1 / Hibernate 7.4.5. No deployment is claimed.

## Changes

- Spring Boot 3.5.16 -> 4.1.1, dependency-management 1.1.7, Gradle 8.5 -> 9.8.1.
- `spring-boot-starter-web` -> `spring-boot-starter-webmvc`;
  `spring-security-test` -> `spring-boot-starter-security-test`.
- `EntityScan` and `SecurityAutoConfiguration` moved packages in Boot 4; the
  imports in `LoginApplication` follow them, and the exclusion is unchanged.
- `tomcat.version` 11.0.26, `jackson-bom.version` 3.1.7 and
  `jackson-2-bom.version` 2.21.7 override the Boot 4.1.1 BOM. The buildscript
  forces Jackson 3.1.7 and commons-lang3 3.21.0 on the Boot Gradle plugin's own
  classpath. Drop these once a Boot release ships them.
- The Log4j override is gone: Boot 4.1.1 manages the patched 2.25.5.

## Validation (Docker)

- MySQL 8.4.11 seeded with `src/main/resources/user.sql`; `./gradlew test bootJar`:
  `EncoderTest` 3/3 and `LoginApplicationTests` 1/1 pass.
- The packaged jar was exercised over HTTP, with the same 9 checks passing
  before and after the upgrade: anonymous `/home` redirects to `/login`,
  `/login` renders, `/health/database` is healthy, `manager1` logs in and sees
  `/home` and `/manager`, `user1` logs in and gets 403 on `/manager`, and a
  wrong password redirects to `/login?error`.
- GitHub Advisory Database: 0 advisories across all 126 resolved application
  and test artifacts (2 critical before), and 0 across the 26 build-classpath
  artifacts.

## Rollback

Revert this commit to return to 0.0.2-SNAPSHOT on Spring Boot 3.5.16, which
restores the two `spring-webmvc` advisories.

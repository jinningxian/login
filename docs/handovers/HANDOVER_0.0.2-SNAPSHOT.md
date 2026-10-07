# login 0.0.2-SNAPSHOT security handover

## Scope

This security candidate upgrades Spring Boot from 3.2.3 to 3.5.16, uses the current MySQL Connector/J coordinate, and aligns vulnerable runtime and build classpath dependencies with compatible releases. Java 17 remains the declared minimum.

The batch does not change application routes, authentication rules, database schema intent, persisted production data, production configuration, or account access.

## Compatibility decision

The application source already uses Jakarta persistence and the component-based Spring Security configuration expected by Spring Boot 3. The bounded Spring Boot 3.5 upgrade therefore keeps the existing framework generation while moving to the latest compatible 3.x dependency line used in this batch.

Alternatives considered:

- Retain Spring Boot 3.2 and override each vulnerable transitive dependency: rejected because it creates a less coherent managed dependency graph.
- Move to Spring Boot 4 / Spring Framework 7: deferred because that expands compatibility and rollout risk and is not required for this incremental security improvement.

## Functional evidence before closeout

- `gradlew.bat --no-daemon clean test assemble buildEnvironment dependencies --configuration testRuntimeClasspath` passed with 4 tests, 0 failures, 0 errors, and 0 skips against a disposable MySQL 8.4.11 fixture.
- The packaged application bound to loopback only; `/login` returned HTTP 200.
- `/health/database` returned HTTP 200 with `Database connection is healthy` against the disposable fixture.
- An unauthenticated `/manager` request returned HTTP 302 to `/login`, preserving the protected-route boundary.

The exact post-closeout snapshot, commands, logs, and source hashes are recorded in the task evidence handoff.

## Residual advisories

- `org.springframework:spring-webmvc:6.2.19` remains affected by `GHSA-pc63-qcmh-9cmg`; no compatible patched Spring Framework 6.2 release was available in the verified advisory snapshot.
- Exact-version scan coverage gaps and build-classpath findings remain recorded in the task evidence. They are not suppressed or represented as fixed.

## Rollback

Restore the prior `build.gradle` and rebuild the Spring Boot 3.2.3 artifact. No data migration or persistent-state recovery is required. Validate the login page, database health route, and unauthenticated protected-route redirect after rollback.

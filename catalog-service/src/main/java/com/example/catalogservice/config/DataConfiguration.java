package com.example.catalogservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;

@Configuration
@EnableJdbcAuditing
/*
Note In Spring Data JPA, you would use the @EnableJpaAuditing annotation to enable JPA auditing,
and you would annotate the entity class with @EntityListeners(AuditingEntityListener.class)
to make it listen to audit events, which doesn’t happen automatically as in Spring Data JDBC.

When this feature is enabled, audit events are generated whenever data is created, updated,
or deleted. Spring Data provides convenient annotations that we can
use on dedicated fields to capture the information from such events (audit metadata) and
store it in the database as part of the entity.
*/
public class DataConfiguration {
}

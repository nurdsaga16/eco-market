plugins {
	java
	id("org.springframework.boot") version "4.1.2"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

val javaVersion = 25
val jjwtVersion = "0.13.0"
val mapstructVersion = "1.6.3"
val lombokMapstructBindingVersion = "0.2.0"
val springdocVersion = "3.2.0"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(javaVersion)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	// Spring Boot
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-webmvc")
	implementation(
		"org.springframework.boot:spring-boot-starter-security-oauth2-resource-server"
	)

	// Lombok
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	annotationProcessor(
		"org.projectlombok:lombok-mapstruct-binding:$lombokMapstructBindingVersion"
	)

	// MapStruct
	implementation("org.mapstruct:mapstruct:$mapstructVersion")
	annotationProcessor("org.mapstruct:mapstruct-processor:$mapstructVersion")

	// JWT
	implementation("io.jsonwebtoken:jjwt-api:$jjwtVersion")
	runtimeOnly("io.jsonwebtoken:jjwt-impl:$jjwtVersion")
	runtimeOnly("io.jsonwebtoken:jjwt-jackson:$jjwtVersion")

	// Database
	runtimeOnly("org.postgresql:postgresql")

	// OpenAPI and Swagger UI, including Swagger annotations
	implementation(
		"org.springdoc:springdoc-openapi-starter-webmvc-ui:$springdocVersion"
	)

	// Tests
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

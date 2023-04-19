plugins {
	java
	id("org.springframework.boot") version "2.7.10"
	id("io.spring.dependency-management") version "1.1.0"
}

group = "com.side.backend"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {

	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-security")
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	runtimeOnly("com.mysql:mysql-connector-j")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("com.jayway.jsonpath:json-path:2.7.0")

// https://mvnrepository.com/artifact/org.modelmapper/modelmapper
	implementation("org.modelmapper:modelmapper:3.1.1")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
//	testImplementation("org.springframework.security:spring-security-test")
//	implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity6")

}

tasks.withType<Test> {
	useJUnitPlatform()
}

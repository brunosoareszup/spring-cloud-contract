import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.springframework.cloud:spring-cloud-contract-spec-kotlin:3.1.0")
    }
}

plugins {
    kotlin("jvm") version "1.6.10"
    kotlin("plugin.spring") version "1.6.10"

    id("org.springframework.boot") version "2.6.2"
    id("org.springframework.cloud.contract") version "3.1.0"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
}

group = "br.com.zup.brunosoares"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

extra["springCloudVersion"] = "2021.0.0"
extra["springCloudContractVersion"] = "2021.0.0"

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
//    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
//    implementation("org.springframework.cloud:spring-cloud-starter-sleuth")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")

    testImplementation("io.mockk:mockk:1.12.2")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.cloud:spring-cloud-starter-contract-verifier")
    testImplementation("org.springframework.cloud:spring-cloud-contract-spec-kotlin")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

contracts {
    testFramework.value(org.springframework.cloud.contract.verifier.config.TestFramework.JUNIT5)

    baseClassForTests.value("br.com.zup.brunosoares.producer.config.ContractTestConfig")
    failOnNoContracts.value(false)
}
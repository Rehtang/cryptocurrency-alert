import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.6.3"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.7.10"
    kotlin("kapt") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
    kotlin("plugin.jpa") version "1.6.21"
    kotlin("plugin.serialization") version "1.7.10"

}

extra.apply {
    set("springCloudVersion", "2021.0.1")
    set("openApi", "1.6.8")
    set("jjwt", "0.9.1")
}

group = "ru.rehtang"
version = "1.0"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // Spring & Spring Cloud
    implementation("org.springframework.boot:spring-boot-starter-web")

    // Swagger
    implementation("org.springdoc:springdoc-openapi-ui:${property("openApi")}")


    //Jackson
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.4")

    // Kafka
    implementation("org.springframework.kafka:spring-kafka")

    //Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.0")

    compileOnly("org.projectlombok:lombok:1.18.22")


    //Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")

    //Telegram
    implementation("dev.inmo:tgbotapi-jvm:3.2.7")
    implementation("org.telegram:telegrambots:6.1.0")
    implementation("org.telegram:telegrambotsextensions:6.1.0")

}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
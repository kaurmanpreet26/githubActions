val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project

plugins {
    kotlin("jvm") version "1.9.0"
    id("io.ktor.plugin") version "2.3.3"
}

group = "hackathon"
version = "0.0.1"

application {
    mainClass.set("hackathon.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm")
    implementation("io.ktor:ktor-server-netty-jvm")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-tests-jvm")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
    testImplementation ("org.junit.jupiter:junit-jupiter-api:5.9.3")
    testImplementation ("org.junit.jupiter:junit-jupiter-engine:5.9.3")
    testImplementation ("org.junit.platform:junit-platform-runner:1.9.3")
}
tasks {
    test {
        useJUnitPlatform {
        }
    }
}
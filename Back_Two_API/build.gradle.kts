plugins {
    kotlin("jvm") version "1.8.0"
    kotlin("plugin.serialization") version "1.8.0"

    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(group= "org.hibernate.validator", name="hibernate-validator", version= "8.0.0.Final")
    implementation("com.squareup.okhttp3:mockwebserver:4.10.0")
    implementation(group= "com.fasterxml.jackson.module", name= "jackson-module-kotlin", version= "2.11.2")
    implementation(group= "javax.validation", name= "validation-api", version= "2.0.1.Final")
    implementation(group= "org.jetbrains.kotlinx", name="kotlinx-serialization-json-jvm", version="1.5.0")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}
plugins {
    kotlin("jvm") version "1.8.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("dev.kord:kord-core:0.8.0-M5")
    implementation("org.slf4j:slf4j-api:2.0.5")
    implementation("org.slf4j:slf4j-simple:2.0.5")
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
    implementation("dev.kord", "kord-core", "0.8.1")
    implementation("org.slf4j:slf4j-simple:2.0.5")
    implementation ("ch.qos.logback:logback-classic:1.2.6")
    implementation("me.jakejmattson:DiscordKt:0.23.4")
    implementation(kotlin("stdlib"))
    implementation("io.github.cdimascio:dotenv-kotlin:6.2.2")
    implementation(kotlin("stdlib-jdk8"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.21"
    `maven-publish`
}

group = "com.ederfmatos"
version = "2.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.code.gson:gson:2.8.5")
    implementation("junit:junit:4.12")
    testImplementation(kotlin("test-junit5"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.0")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.ederfmatos"
            artifactId = "kotlintestdatabuilder"
            version = "2.0"

            from(components["java"])
        }
    }
    repositories {
        maven {
            name = "KotlinTestDataBuilder"
            setUrl("https://maven.pkg.github.com/ederfmatos/KotlinTestDataBuilder")
            credentials {
                username = "ederfmatos"
                password = "28eb9b4f0e1b6611d1439ce335408d671429e24e"
            }
        }
    }
}
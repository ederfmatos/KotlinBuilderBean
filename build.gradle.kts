import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

import java.io.FileInputStream
import java.util.*

plugins {
    kotlin("jvm") version "1.4.21"
    `maven-publish`
}

group = "com.ederfmatos"
version = "1.1.5"

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

val githubProperties = Properties()
githubProperties.load(FileInputStream(rootProject.file("github.properties")))

publishing {
    publications {
        create<MavenPublication>("gpr") {
            run {
                groupId = "com.ederfmatos"
                artifactId = "kotlintestdatabuilder"
                version = "1.1.5"
                artifact("$buildDir/libs/${artifactId}-${version}.jar")
            }
        }
    }
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/ederfmatos/KotlinBuilderBean")
            credentials {
                username = "ederfmatos"
                password = "1b3aec180ae16c3fff1044484f62d414f1bcd11a"
            }
        }
    }
}
/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java application project to get you started.
 * For more details on building Java & JVM projects, please refer to https://docs.gradle.org/8.11.1/userguide/building_java_projects.html in the Gradle documentation.
 */

plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application

    // Apply the JavaFX plugin to add support for building JavaFX applications.
    id("org.openjfx.javafxplugin") version "0.1.0"
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Use JUnit Jupiter for testing.
    testImplementation(libs.junit.jupiter)

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // This dependency is used by the application.
    implementation(libs.guava)

    // SQLite JDBC driver.
    implementation("org.xerial:sqlite-jdbc:3.47.1.0")

    // JavaFX dependencies.
    implementation("org.openjfx:javafx-base:23.0.1")
    implementation("org.openjfx:javafx-controls:23.0.1")
    implementation("org.openjfx:javafx-graphics:23.0.1")
    implementation("org.openjfx:javafx-fxml:23.0.1")

    // Catppuccino Palette dependency.
    implementation("com.catppuccin:catppuccin-palette:2.0.2")
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    // Define the main class for the application.
    mainClass = "App"
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}

javafx {
    version = "23.0.1"
    modules = listOf("javafx.controls", "javafx.fxml")
}

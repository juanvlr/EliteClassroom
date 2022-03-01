import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import java.io.FileInputStream
import java.util.Properties

plugins {
    java
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("kr.entree.spigradle") version "2.3.4"
}

group = "io.github.juanvlr.eliteclassroom"
version = "1.0-SNAPSHOT"

val localProperties = Properties().apply {
    load(FileInputStream(File(rootProject.rootDir, "local.properties")))
}

repositories {
    mavenCentral()

    maven {
        name = "Paper repository"
        url = uri("https://papermc.io/repo/repository/maven-public/")
    }

    maven {
        name = "Aikar repository"
        url = uri("https://repo.aikar.co/content/groups/aikar/")
    }
}

dependencies {
    // Paper API
    compileOnly(group = "org.github.paperspigot", name = "paperspigot-api", version = "1.8.8-R0.1-SNAPSHOT")

    // Command API
    implementation(group = "co.aikar", name = "acf-paper", version = "0.5.1-SNAPSHOT")

    // Guice
    implementation(group = "com.google.inject", name = "guice", version = "5.1.0")
    implementation(group = "com.google.inject.extensions", name = "guice-throwingproviders", version = "5.1.0")

    // YAML Resource Bundle
    implementation(group = "dev.akkinoc.util", name = "yaml-resource-bundle", version = "2.3.0")

    // Adventure API
    implementation(group = "net.kyori", name = "adventure-platform-bukkit", version = "4.0.1")
    implementation(group = "net.kyori", name = "adventure-text-minimessage", version = "4.10.0")
    implementation(group = "net.kyori", name = "adventure-text-serializer-gson", version = "4.10.0")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

spigot {
    name = project.properties["pluginName"].toString()

    authors(project.properties["author"].toString())
}

tasks {
    named<JavaCompile>("compileJava") {
        options.compilerArgs.add("-parameters")
    }
}

tasks {
    named<ShadowJar>("shadowJar") {
        archiveFileName.set("${project.properties["pluginName"]}.jar")
        destinationDirectory.set(file(localProperties.getProperty("pluginDestinationDirectory")))

        relocate("com.google", "libs.com.google")
    }
}
plugins {
    kotlin("jvm") version "1.9.23"
    id("net.minecrell.plugin-yml.bukkit") version "0.6.0"
    id ("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "me.baggi"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://repo.aikar.co/content/groups/aikar/")
    maven("https://repo.extendedclip.com/content/repositories/placeholderapi/")
    maven("https://jitpack.io")
    maven("https://maven.enginehub.org/repo/")
    maven("https://repo.codemc.io/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.20-R0.1-SNAPSHOT")
    compileOnly("me.clip:placeholderapi:2.11.3")
    compileOnly("com.github.decentsoftware-eu:decentholograms:2.8.6")

    implementation("co.aikar:acf-paper:0.5.1-SNAPSHOT")
    implementation("dev.triumphteam:triumph-gui:3.1.2")
}

kotlin {
    jvmToolchain(17)
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

tasks.shadowJar {
    relocate("co.aikar.commands", "me.falvan.acf")
    relocate("co.aikar.locales", "me.falvan.locales")
    relocate("dev.triumphteam.gui", "me.falvan.gui")
}

bukkit {
    name = "Plugin"
    authors = listOf("Falvan")
    apiVersion = "1.20"
    main = "me.falvan.plugin.App"
    version = project.version.toString()
}
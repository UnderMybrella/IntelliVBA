plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "1.9.0"
    id("org.jetbrains.intellij") version "1.15.0"
    antlr
}

group = "dev.brella"
version = "1.0-SNAPSHOT"

sourceSets {
    main {
        java {
            srcDir(tasks.generateGrammarSource)
        }
    }
}

repositories {
    mavenCentral()
}

dependencies {
    api("org.antlr:antlr4-intellij-adaptor:0.1") {
        exclude(group = "org.antlr", module = "antlr4-runtime")
    }

    implementation("org.antlr:antlr4-runtime:4.12.0") {
        exclude(group = "com.ibm.icu", module = "icu4j")
    }

    antlr("org.antlr:antlr4:4.12.0") {
        exclude(group = "com.ibm.icu", module = "icu4j")
    }
}

// Configure Gradle IntelliJ Plugin
// Read more: https://plugins.jetbrains.com/docs/intellij/tools-gradle-intellij-plugin.html
intellij {
    version.set("2022.2.5")
    type.set("IC") // Target IDE Platform

    plugins.set(listOf(/* Plugin Dependencies */))

    sandboxDir.set("C:\\IdeaProjects\\Sandboxes\\vba")
}

tasks {
    // Set the JVM compatibility versions
    withType<JavaCompile> {
        sourceCompatibility = "17"
        targetCompatibility = "17"
    }
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "17"
    }

    patchPluginXml {
        sinceBuild.set("222")
        untilBuild.set("232.*")
    }

    signPlugin {
        certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
        privateKey.set(System.getenv("PRIVATE_KEY"))
        password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
    }

    publishPlugin {
        token.set(System.getenv("PUBLISH_TOKEN"))
    }

    generateGrammarSource {
        val pkg = listOf("dev", "brella", "antlr")

        arguments = arguments + listOf("-Xexact-output-dir")
    }
}
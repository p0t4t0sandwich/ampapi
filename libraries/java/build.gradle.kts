plugins {
    id("java")
    id("maven-publish")
    id("com.diffplug.spotless") version("7.0.2")
    id("xyz.wagyourtail.jvmdowngrader") version("1.2.2")
}

group = "dev.neuralnexus"
version = "2608.3.0"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("org.jetbrains:annotations:24.1.0")
    implementation("com.google.code.gson:gson:2.12.1")
    implementation("com.github.sviperll:result4j:1.2.0")
}

spotless {
    format("misc") {
    target("*.gradle", ".gitattributes", ".gitignore")
        trimTrailingWhitespace()
        leadingTabsToSpaces()
        endWithNewline()
    }
    java {
        importOrder()
        removeUnusedImports()
        cleanthat()
        googleJavaFormat("1.24.0")
            .aosp()
            .formatJavadoc(true)
            .reorderImports(true)
        formatAnnotations()
        licenseHeader("""/**
 * Copyright (c) 2025 Dylan Sperrer - dylan@sperrer.ca
 * This project is Licensed under <a href="https://github.com/p0t4t0sandwich/ampapi/blob/main/LICENSE">MIT</a>
 */
"""
        )
    }
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
}

java {
    withSourcesJar()
    withJavadocJar()
    val javaVersion = JavaVersion.toVersion(21)
    sourceCompatibility = javaVersion
    targetCompatibility = javaVersion
    if (JavaVersion.current() < javaVersion) {
        toolchain.languageVersion = JavaLanguageVersion.of(21)
    }
}

tasks.downgradeJar {
    downgradeTo = JavaVersion.VERSION_1_8
    dependsOn(tasks.spotlessApply)
}

tasks.shadeDowngradedApi {
    downgradeTo = JavaVersion.VERSION_1_8
    shadePath = {
        it.substringBefore(".")
            .substringBeforeLast("-")
            .replace(Regex("[.;\\[/]"), "-")
            .replace("ampapi", "dev/neuralnexus/ampapi/jvmdg")
    }
    archiveClassifier.set("downgraded-8-shaded")
}

tasks.assemble {
    dependsOn(tasks.shadeDowngradedApi)
}

tasks.withType<GenerateModuleMetadata> {
    enabled = false
}

publishing {
    repositories {
        mavenLocal()
        maven("https://maven.neuralnexus.dev/releases") {
            name = "NeuralNexusReleases"
            credentials {
                username = project.findProperty("neuralNexusUsername") as? String ?: System.getenv("NEURALNEXUS_USERNAME") ?: ""
                password = project.findProperty("neuralNexusPassword") as? String ?: System.getenv("NEURALNEXUS_PASSWORD") ?: ""
            }
        }
        maven("https://maven.neuralnexus.dev/snapshots") {
            name = "NeuralNexusSnapshots"
            credentials {
                username = project.findProperty("neuralNexusUsername") as? String ?: System.getenv("NEURALNEXUS_USERNAME") ?: ""
                password = project.findProperty("neuralNexusPassword") as? String ?: System.getenv("NEURALNEXUS_PASSWORD") ?: ""
            }
        }
    }
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
            artifact(tasks.downgradeJar.get())
            artifact(tasks.shadeDowngradedApi.get())
        }
    }
}

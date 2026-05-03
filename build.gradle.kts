plugins {
    id("java-library")
    id("io.qameta.allure") version "2.12.0"
}

group = "com.jiharpv"
version = "1.0-SNAPSHOT"

allure {
    report {
        version.set("2.32.0")
    }
    adapter {
        aspectjWeaver.set(true)
        frameworks {
            junit5 {
                adapterVersion.set("2.32.0")
            }
        }
    }
}

repositories {
    mavenCentral()
}

dependencies {
    dependencies {
        testImplementation(platform("org.junit:junit-bom:5.14.1"))
        testImplementation("org.junit.jupiter:junit-jupiter:5.14.1")
        testImplementation("com.codeborne:selenide:7.13.0")
        testImplementation("net.datafaker:datafaker:2.5.4")
        testImplementation("com.codeborne:pdf-test:1.5.0")
        testImplementation("com.codeborne:xls-test:1.7.2")
        testImplementation("org.apache.poi:poi:5.2.3")
        testImplementation("com.opencsv:opencsv:5.10")
        testImplementation("com.fasterxml.jackson.core:jackson-databind:2.13.1")
        testImplementation("io.rest-assured:rest-assured:6.0.0")
        testImplementation("io.rest-assured:json-schema-validator:6.0.0")
        testImplementation("io.qameta.allure:allure-selenide:2.32.0")
        testImplementation("org.slf4j:slf4j-simple:2.0.17")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()

    systemProperties(System.getProperties().mapKeys { it.key.toString() })

    testLogging {
        events("started", "skipped", "failed", "standard_error", "standard_out")
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.SHORT
    }
}




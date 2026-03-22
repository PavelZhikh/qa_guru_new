plugins {
    id("java-library")
}

group = "com.jiharpv"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    dependencies {
        testImplementation(platform("org.junit:junit-bom:5.10.0"))
        testImplementation("org.junit.jupiter:junit-jupiter")
        testImplementation("com.codeborne:selenide:7.14.0")
        testImplementation("com.codeborne:selenide:7.0.1")
        testImplementation("net.datafaker:datafaker:2.5.4")
        testImplementation("com.codeborne:pdf-test:1.5.0")
        testImplementation("com.codeborne:xls-test:1.7.2")
        testImplementation("org.apache.poi:poi:5.2.3")
        testImplementation("com.opencsv:opencsv:5.10")
    }
}

tasks.test {
    useJUnitPlatform()

}



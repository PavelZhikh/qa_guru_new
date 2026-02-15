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
    }
}

tasks.test {
    useJUnitPlatform()
}




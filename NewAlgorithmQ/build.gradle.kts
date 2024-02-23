plugins {
    kotlin("jvm") version "1.9.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation ("com.google.truth:truth:1.1")
    testImplementation( "junit:junit:4.13.1")

}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(20)
}
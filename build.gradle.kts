plugins {
    java
}
allprojects {
    apply{
        plugin("java")
    }

    group = "com.uptc.frw"
    version = "0.0.1-SNAPSHOT"

    java {
        toolchain {
            languageVersion = JavaLanguageVersion.of(17)
        }
    }

    repositories {
        mavenCentral()
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}

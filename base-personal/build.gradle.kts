plugins {
    java
}

repositories {
    mavenCentral()
}

sourceSets {
    main {
        java.srcDirs("ejercicios", "katas", "clase")
    }
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

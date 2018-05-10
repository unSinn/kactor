plugins {
    application
    kotlin("jvm") version "1.2.41"
}

application {
    mainClassName = "ch.ma3.kactor.MainKt"
}

dependencies {
    compile(kotlin("stdlib"))
    compile("io.github.microutils:kotlin-logging:1.5.4")
    compile("org.slf4j:slf4j-log4j12:1.7.5")
}

repositories {
    jcenter()
}
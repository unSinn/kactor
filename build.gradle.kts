plugins {
    application
    kotlin("jvm") version "1.2.41"
}

application {
    mainClassName = "ch.ma3.kactor.MainKt"
}

dependencies {
    compile(kotlin("stdlib"))
}

repositories {
    jcenter()
}
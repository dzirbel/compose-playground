import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm") version "1.9.10"
    id("org.jetbrains.compose") version "1.5.3"
}

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
    implementation(compose.desktop.currentOs)
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            packageName = "compose-playground"
            packageVersion = "1.0.0"
            targetFormats(TargetFormat.Dmg, TargetFormat.Pkg)
        }
    }
}

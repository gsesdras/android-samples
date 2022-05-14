// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    val navVersion by extra { "2.4.2" }

    repositories {
        google()
    }
    dependencies {
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$navVersion")
    }
}

plugins {
    id("com.android.application") version "7.1.3" apply false
    id("com.android.library") version "7.1.3" apply false
    id("org.jetbrains.kotlin.android") version "1.6.21" apply false
}

tasks.register("clean", Delete::class){
    delete(rootProject.buildDir)
}
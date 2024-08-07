pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        // 必选项
        maven { setUrl("https://mvn.shalltry.com/repository/maven-public/") }
        // 必选项
        maven { setUrl("https://mvn.shalltry.com/repository/ad-releases/") }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { setUrl("https://jitpack.io") }
        // 必选项
        maven { setUrl("https://mvn.shalltry.com/repository/maven-public/") }
        // 必选项
        maven { setUrl("https://mvn.shalltry.com/repository/ad-releases/") }
    }
}
rootProject.name = "Ulti-Commons"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":samples", "commons")

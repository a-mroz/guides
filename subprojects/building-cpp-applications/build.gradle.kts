import org.gradle.guides.GenerateReadMeFile

plugins {
    id("org.gradle.guides.getting-started") version "0.15.13"
}

guide {
    repositoryPath.set("gradle-guides/building-cpp-applications")
    minimumGradleVersion.set("5.5.1")
    title.set("Building C++ Applications")
}

tasks.withType(GenerateReadMeFile::class).configureEach {
    title.set(guide.title.map { it.replace("C++", "{cpp}") })
}

// NOTE: Patch until we fix this in guide plugin
afterEvaluate {
    tasks.named("gitPublishReset") {
        enabled = true
    }
}

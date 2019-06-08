plugins {
    id("com.gradle.build-scan") version "2.3"
    id("org.gradle.guides.topical") version "0.15.8"
    id("org.gradle.guides.test-jvm-code") version "0.15.8"
}

configure<org.gradle.guides.GuidesExtension> {
    repositoryPath.set("gradle-guides/performance")
    minimumGradleVersion.set("4.10.3")
}

buildScan {
    setTermsOfServiceUrl("https://gradle.com/terms-of-service")
    setTermsOfServiceAgree("yes")
    if (!System.getenv("CI").isNullOrEmpty()) {
        publishAlways()
        tag("CI")
    }
}

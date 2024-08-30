import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "eu.kanade"
    compileSdk = 34

    defaultConfig {
        applicationId = "app.komikku"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    // Compose
    implementation(compose.activity)
    implementation(compose.foundation)
    implementation(compose.material3.core)
    implementation(compose.material.icons)
    implementation(compose.animation)
    implementation(compose.animation.graphics)
    implementation(compose.ui)
    debugImplementation(compose.ui.tooling)
    implementation(compose.ui.tooling.preview)
    implementation(compose.ui.graphics)
    implementation(compose.ui.util)

    implementation(platform(compose.bom))

    // AndroidX libraries
    implementation(androidx.corektx)

    implementation(androidx.bundles.navigation)

    implementation(androidx.bundles.lifecycle)

    // Tests
    testImplementation(libs.bundles.test)

    androidTestImplementation(platform(compose.bom))
}

tasks {
    // See https://kotlinlang.org/docs/reference/experimental.html#experimental-status-of-experimental-api(-markers)
    // https://stackoverflow.com/a/44143253
    withType<KotlinCompile> {
        compilerOptions.freeCompilerArgs.addAll(
            "-opt-in=androidx.compose.animation.graphics.ExperimentalAnimationGraphicsApi",
        )
    }
}

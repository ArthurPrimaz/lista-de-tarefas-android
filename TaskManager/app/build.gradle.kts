plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.ap.taskmanager"

    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.taskmanager"
        minSdk = 23
        targetSdk = 34

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}

dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")

    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")

    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
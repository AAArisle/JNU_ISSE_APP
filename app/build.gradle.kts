plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.userstory"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.userstory"
        minSdk = 30
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation("com.tencent.map:tencent-map-vector-sdk:4.4.2")
    implementation("com.squareup.picasso:picasso:2.71828")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.drawerlayout:drawerlayout:1.0.0")
    implementation("androidx.test.espresso.idling:idling-concurrent:3.5.1")
    implementation("androidx.fragment:fragment-testing:1.7.1")
    implementation("androidx.test.espresso:espresso-intents:3.5.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.0-alpha02")
    androidTestImplementation("androidx.test.espresso:espresso-contrib:3.6.0-alpha02")


    implementation("androidx.viewpager2:viewpager2:1.0.0")






    implementation ("androidx.tracing:tracing:1.2.0-beta02")
    testImplementation ("org.json:json:20231013")

}
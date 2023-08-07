plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("com.google.devtools.ksp")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
    id("com.google.firebase.firebase-perf")
    id("dagger.hilt.android.plugin")
    id("com.ncorti.ktfmt.gradle") version "0.10.0"
}

android {
    compileSdk = 34
    namespace = "com.example.notessampleapp"

    defaultConfig {
        applicationId = "com.example.notessampleapp"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "com.example.notessampleapp.NotesSampleAppRunner"
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    flavorDimensions += "environment"
    productFlavors {
        create("dev")
        create("staging")
        create("prod")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }

    packaging {
        resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
    }
}

ktfmt {
    googleStyle()
}

dependencies {
    val room_version = "2.5.2" // check latest version from docs

    implementation("androidx.room:room-runtime:$room_version")
    annotationProcessor("androidx.room:room-compiler:$room_version")


    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.compose:compose-bom:2023.06.01")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.material:material")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material:material-icons-extended:1.4.3")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation("androidx.navigation:navigation-compose:2.6.0")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    implementation("androidx.preference:preference-ktx:1.2.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.6.4")
    implementation("com.google.accompanist:accompanist-permissions:0.30.1")
    implementation("com.google.dagger:hilt-android:2.47")
    implementation("androidx.room:room-ktx:2.5.2")
    implementation("androidx.compose.material3:material3:1.1.1")
    ksp("com.google.dagger:hilt-compiler:2.47")




    implementation("androidx.room:room-ktx:$room_version")
    ksp("androidx.room:room-compiler:$room_version")
    ksp("android.arch.persistence.room:compiler:1.1.1")

    //Firebase

    implementation("com.google.firebase:firebase-analytics-ktx")
    implementation("com.google.firebase:firebase-crashlytics-ktx")
    implementation("com.google.firebase:firebase-auth-ktx")
    implementation("com.google.firebase:firebase-firestore-ktx")
    implementation("com.google.firebase:firebase-perf-ktx")
    implementation("com.google.firebase:firebase-config-ktx")
    implementation("com.google.firebase:firebase-messaging-ktx")
    implementation(platform("com.google.firebase:firebase-bom:32.2.2"))


    //Test
    testImplementation("junit:junit:4.+")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    androidTestImplementation("com.google.dagger:hilt-android-testing:2.43.2")
    androidTestImplementation("com.google.truth:truth:1.1.3")
    kspAndroidTest("com.google.dagger:hilt-compiler:2.47")
    debugImplementation("androidx.compose.ui:ui-tooling")
}

//dependencies {
//    def nav_version = "2.6.0"
//
//    implementation 'androidx.core:core-ktx:1.10.1'
//    implementation platform('org.jetbrains.kotlin:kotlin-bom:1.8.0')
//    implementation 'androidx.lifecycle:lifecycle-runtime-ktx:2.6.1'
//    implementation 'androidx.activity:activity-compose:1.7.2'
//    implementation platform('androidx.compose:compose-bom:2022.10.00')
//    implementation 'androidx.compose.ui:ui'
//    implementation 'androidx.compose.ui:ui-graphics'
//    implementation 'androidx.compose.ui:ui-tooling-preview'
//    implementation 'androidx.compose.material3:material3'
//    implementation 'com.google.firebase:protolite-well-known-types:18.0.0'
//    implementation 'androidx.navigation:navigation-runtime-ktx:2.6.0'
//    testImplementation 'junit:junit:4.13.2'
//    androidTestImplementation 'androidx.test.ext:junit:1.1.5'
//    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.1'
//    androidTestImplementation platform('androidx.compose:compose-bom:2022.10.00')
//    androidTestImplementation 'androidx.compose.ui:ui-test-junit4'
//    debugImplementation 'androidx.compose.ui:ui-tooling'
//    debugImplementation 'androidx.compose.ui:ui-test-manifest'
//
//    implementation "androidx.navigation:navigation-compose:$nav_version"
//
//    //Dagger - Hilt
//    implementation "com.google.dagger:hilt-android:2.44"
//    kapt "com.google.dagger:hilt-compiler:2.44"
//    implementation "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03"
//    kapt "androidx.hilt:hilt-compiler:1.0.0"
//
//    implementation 'androidx.hilt:hilt-navigation-fragment:1.0.0'
//
//
//    // Coroutines Dependencies
//    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1'
//    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1'
//
//    // Room Dependencies
//    def room_version = "2.5.2"
//
//    implementation "androidx.room:room-runtime:$room_version"
//    annotationProcessor "androidx.room:room-compiler:$room_version"
//
//    // To use Kotlin annotation processing tool (kapt)
//    kapt "androidx.room:room-compiler:$room_version"
//
//    // Kotlin Extensions and Coroutines support for Room
//    implementation 'androidx.room:room-ktx:2.5.2'
//    kapt "androidx.room:room-compiler:2.5.2"
//}
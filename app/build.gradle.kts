plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
}

android {
    compileSdk = Config.COMPILE_SDK_DEPENDENCY

    defaultConfig {
        applicationId = Config.APPLICATION_ID_DEPENDENCY
        minSdk = Config.MIN_SDK_DEPENDENCY
        targetSdk = Config.TARGET_SDK_DEPENDENCY
        versionCode = Releases.VERSION_CODE_DEPENDENCY
        versionName = Releases.VERSION_NAME_DEPENDENCY

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = Config.JAVA_VERSION_DEPENDENCY
        targetCompatibility = Config.JAVA_VERSION_DEPENDENCY
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures{
        viewBinding = true
    }
}

dependencies {

    implementation (Default.CORE_KTX_DEPENDENCY)
    implementation (Default.APP_COMPAT_DEPENDENCY)
    implementation (Default.MATERIAL_DEPENDENCY)
    implementation (Default.CONSTRAINT_LAYOUT_DEPENDENCY)
    testImplementation (Default.JUNIT_DEPENDENCY)
    androidTestImplementation (Default.TEST_JUNIT_DEPENDENCY)
    androidTestImplementation (Default.TEST_ESPRESSO_DEPENDENCY)

    //OkHTTP
    implementation (OkHttp.OKHTTP_DEPENDENCY)

    //Retrofit 2



}
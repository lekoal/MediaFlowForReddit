import org.gradle.api.JavaVersion

object Versions {
    const val CORE_CTX_VERSION = "1.8.0"
    const val APP_COMPAT_VERSION = "1.4.2"
    const val MATERIAL_VERSION = "1.6.1"
    const val CONSTRAINT_LAYOUT_VERSION = "2.1.4"
    const val JUNIT_VERSION = "4.13.2"
    const val TEST_JUNIT = "1.1.3"
    const val TEST_ESPRESSO = "3.4.0"
    const val OK_HTTP_VERSION = "4.9.3"
    const val RETROFIT_VERSION = "2.9.0"
    const val RETROFIT_COROUTINES_ADAPTER_VERSION = "0.9.2"
    const val KOIN_VERSION = "3.2.0"
    const val COROUTINE_VERSION = "1.6.2"
    const val ROOM_VERSION = "2.4.2"
    const val GLIDE_VERSION = "4.13.2"
    const val BROADCAST_MANAGER_VERSION = "1.1.0"
    const val LIFECYCLE_VERSION = "2.4.1"
}

object Config {
    const val APPLICATION_ID_DEPENDENCY = "com.example.mediaflowforreddit"
    const val COMPILE_SDK_DEPENDENCY = 32
    const val MIN_SDK_DEPENDENCY = 28
    const val TARGET_SDK_DEPENDENCY = 32
    val JAVA_VERSION_DEPENDENCY = JavaVersion.VERSION_1_8
}

object Releases {
    const val VERSION_CODE_DEPENDENCY = 1
    const val VERSION_NAME_DEPENDENCY = "1.0"
}

object Default {
    const val CORE_KTX_DEPENDENCY = "androidx.core:core-ktx:${Versions.CORE_CTX_VERSION}"
    const val APP_COMPAT_DEPENDENCY = "androidx.appcompat:appcompat:${Versions.APP_COMPAT_VERSION}"
    const val MATERIAL_DEPENDENCY = "com.google.android.material:material:${
        Versions.MATERIAL_VERSION
    }"
    const val CONSTRAINT_LAYOUT_DEPENDENCY = "androidx.constraintlayout:constraintlayout:${
        Versions.CONSTRAINT_LAYOUT_VERSION
    }"
    const val JUNIT_DEPENDENCY = "junit:junit:${Versions.JUNIT_VERSION}"
    const val TEST_JUNIT_DEPENDENCY = "androidx.test.ext:junit:${Versions.TEST_JUNIT}"
    const val TEST_ESPRESSO_DEPENDENCY = "androidx.test.espresso:espresso-core:${
        Versions.TEST_ESPRESSO
    }"
}

object OkHttp {
    const val OKHTTP_DEPENDENCY =
        "com.squareup.okhttp3:okhttp:${Versions.OK_HTTP_VERSION}"
}

object Retrofit {
    const val RETROFIT_DEPENDENCY =
        "com.squareup.retrofit2:retrofit:${Versions.RETROFIT_VERSION}"
    const val RETROFIT_JSON_CONVERTER_DEPENDENCY =
        "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT_VERSION}"
    const val RETROFIT_COROUTINES_ADAPTER_DEPENDENCY =
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${
            Versions.RETROFIT_COROUTINES_ADAPTER_VERSION
        }"
}

object Koin {
    const val KOIN_CORE_DEPENDENCY =
        "io.insert-koin:koin-core:${Versions.KOIN_VERSION}"
    const val KOIN_ANDROID_DEPENDENCY =
        "io.insert-koin:koin-android:${Versions.KOIN_VERSION}"
    const val KOIN_ANDROID_COMPAT_DEPENDENCY =
        "io.insert-koin:koin-android-compat:${Versions.KOIN_VERSION}"
}

object Coroutines {
    const val COROUTINE_CORE_DEPENDENCY =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINE_VERSION}"
    const val COROUTINE_ANDROID_DEPENDENCY =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINE_VERSION}"
}

object Room {
    const val ROOM_RUNTIME_DEPENDENCY =
        "androidx.room:room-runtime:${Versions.ROOM_VERSION}"
    const val ROOM_COMPILER_DEPENDENCY =
        "androidx.room:room-compiler:${Versions.ROOM_VERSION}"
    const val ROOM_KTX_DEPENDENCY =
        "androidx.room:room-ktx:${Versions.ROOM_VERSION}"
}

object Glide {
    const val GLIDE_DEPENDENCY =
        "com.github.bumptech.glide:glide:${Versions.GLIDE_VERSION}"
    const val GLIDE_COMPILER_DEPENDENCY =
        "com.github.bumptech.glide:compiler:${Versions.GLIDE_VERSION}"
}

object BroadcastManager {
    const val BROADCAST_MANAGER_DEPENDENCY =
        "androidx.localbroadcastmanager:localbroadcastmanager:${Versions.BROADCAST_MANAGER_VERSION}"
}

object Lifecycle {
    const val LIFECYCLE_LIVEDATA_DEPENDENCY =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE_VERSION}"
    const val LIFECYCLE_VIEWMODEL_DEPENDENCY =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE_VERSION}"
    const val LIFECYCLE_VIEWMODEL_SAVEDSTATE_DEPENDENCY =
        "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.LIFECYCLE_VERSION}"
}
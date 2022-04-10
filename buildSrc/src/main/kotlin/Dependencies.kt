/**
 * Plugins
 */
object BuildPlugins {
    const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val application = "com.android.application:${Versions.android}"
    const val androidLibrary = "com.android.library:${Versions.android}"
    const val gradleBuildTools = "com.android.tools.build:gradle:${Versions.gradle}"
    const val androidKotlin = "org.jetbrains.kotlin.android:${Versions.kotlin}"
    const val kotlinJvm = "org.jetbrains.kotlin.jvm:${Versions.kotlin}"
    const val hiltPlugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.daggerHilt}"
}

/**
 * Dependencies
 */
object Libs {

    const val kotlin ="org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val androidKtx = "androidx.core:core-ktx:${Versions.androidCore}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompact}"
    const val materialDesign = "com.google.android.material:material:${Versions.material}"


    const val androidJunitTest = "androidx.test.ext:junit:${Versions.androidTestJunit}"

    const val androidHilt = "com.google.dagger:hilt-android:${Versions.daggerHilt}"

    const val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxJava}"
    const val rxRelay = "com.jakewharton.rxrelay2:rxrelay:${Versions.rxAndroid}"
    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"

    // Instrumentation tests
    const val junit = "junit:junit:${Versions.jUnit}"
    const val espressoTest = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    const val hiltTesting  = "com.google.dagger:hilt-android-testing:${Versions.daggerHilt}"
    const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${Versions.daggerHilt}"
}

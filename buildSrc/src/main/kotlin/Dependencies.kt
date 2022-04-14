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
    const val navSafeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"
}

/**
 * Dependencies
 */
object Libs {

    const val kotlin ="org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val androidKtx = "androidx.core:core-ktx:${Versions.androidCore}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompact}"
    const val materialDesign = "com.google.android.material:material:${Versions.material}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val okHttp = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
    const val gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val lifeCycle = "androidx.lifecycle:lifecycle-extensions:${Versions.lifeCycle}"
    const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragmentX}"


    const val androidJunitTest = "androidx.test.ext:junit:${Versions.androidTestJunit}"

    /**
     * HILT
     */
    const val androidHilt = "com.google.dagger:hilt-android:${Versions.daggerHilt}"

    const val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxJava}"
    const val rxRelay = "com.jakewharton.rxrelay2:rxrelay:${Versions.rxAndroid}"
    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"
    const val retrofitRxAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"

    const val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUIKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    const val javaxInject = "javax.inject:javax.inject:1"

    // Instrumentation tests
    const val junit = "junit:junit:${Versions.jUnit}"
    const val espressoTest = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    const val navigationTesting = "androidx.navigation:navigation-testing:${Versions.navigation}"
    const val hiltTesting  = "com.google.dagger:hilt-android-testing:${Versions.daggerHilt}"
    const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:${Versions.daggerHilt}"
    const val fragmentTesting ="androidx.fragment:fragment-testing:${Versions.fragmentX}"
    const val androidxTestRunner = "androidx.test:runner:${Versions.coreAndroidxTesting}"
    const val androidTestCore = "androidx.test:core-ktx:${Versions.androidxCoreTest}"
    const val espressoIdleResource = "androidx.test.espresso:espresso-idling-resource:${Versions.espressoCore}"
    const val espressoIntents = "androidx.test.espresso:espresso-intents:${Versions.espressoCore}"
    const val espressoTestContrib = "androidx.test.espresso:espresso-contrib:${Versions.espressoCore}"
    const val androidArchCoreTesting = "androidx.arch.core:core-testing:${Versions.archCoreTesting}"
    const val androidxTestRules = "androidx.test:rules:${Versions.coreAndroidxTesting}"
    const val androidxTestCore = "androidx.test:core:${Versions.coreAndroidxTesting}"
    const val googleTruth = "com.google.truth:truth:${Versions.googleTruth}"
}

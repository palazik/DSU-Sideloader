plugins {
    id("com.android.library")
}

android {
    namespace = "com.palaziks.sideloader"
    compileSdk = 37

    defaultConfig {
        minSdk = 29
    }
    buildTypes {
        create("miniDebug"){}
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
}

dependencies {
    implementation("dev.rikka.shizuku:api:_")
    implementation("dev.rikka.shizuku:provider:_")
}

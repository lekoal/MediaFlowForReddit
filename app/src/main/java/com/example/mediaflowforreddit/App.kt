package com.example.mediaflowforreddit

import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import com.example.mediaflowforreddit.di.koinRedditTokenDBModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(koinRedditTokenDBModule)
        }
    }
}

val Context.app: App
    get() = applicationContext as App

val Fragment.app: App
    get() = requireActivity().app
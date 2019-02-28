package com.riningan.mvvmsample.app

import android.app.Application
import com.riningan.mvvmsample.app.di.AppComponent
import com.riningan.mvvmsample.app.di.AppModule
import com.riningan.mvvmsample.app.di.DaggerAppComponent


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        mAppComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .build()
    }


    companion object {
        private lateinit var mAppComponent: AppComponent


        fun getAppComponent(): AppComponent {
            return mAppComponent
        }
    }
}
package com.riningan.mvvmsample.app

import android.app.Activity
import android.app.Application
import com.riningan.mvvmsample.app.di.activity.ActivityComponent
import com.riningan.mvvmsample.app.di.activity.NavigationModule
import com.riningan.mvvmsample.app.di.app.AppComponent
import com.riningan.mvvmsample.app.di.app.AppModule
import com.riningan.mvvmsample.app.di.app.DaggerAppComponent


class App : Application() {
    override fun onCreate() {
        super.onCreate()
        mAppComponent = DaggerAppComponent.builder()
                .appModule(AppModule(applicationContext))
                .build()
    }


    companion object {
        private lateinit var mAppComponent: AppComponent
        private var mActivityComponent: ActivityComponent? = null


        fun createActivityComponent(activity: Activity) {
            if (mActivityComponent == null) {
                mActivityComponent = mAppComponent.addActivityComponent(NavigationModule(activity))
            }
        }

        fun getActivityComponent(): ActivityComponent = mActivityComponent!!

        fun clearActivityComponent() {
            mActivityComponent = null
        }
    }
}
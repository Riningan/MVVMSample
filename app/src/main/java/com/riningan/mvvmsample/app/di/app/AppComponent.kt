package com.riningan.mvvmsample.app.di.app

import com.riningan.mvvmsample.app.di.activity.ActivityComponent
import com.riningan.mvvmsample.app.di.activity.NavigationModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class, NetworkModule::class, DataModule::class])
interface AppComponent {
    fun addActivityComponent(navigationModule: NavigationModule): ActivityComponent
}
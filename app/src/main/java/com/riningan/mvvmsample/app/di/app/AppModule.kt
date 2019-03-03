package com.riningan.mvvmsample.app.di.app

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule(private val mContext: Context) {
    @Provides
    @Singleton
    fun context(): Context = mContext
}
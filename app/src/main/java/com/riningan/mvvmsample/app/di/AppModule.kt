package com.riningan.mvvmsample.app.di

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule(private val mContext: Context) {
    @Provides
    @Singleton
    fun provideContext(): Context {
        return mContext
    }
}
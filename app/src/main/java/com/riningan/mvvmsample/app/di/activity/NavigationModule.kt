package com.riningan.mvvmsample.app.di.activity

import android.app.Activity
import androidx.annotation.NonNull
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.riningan.mvvmsample.R
import dagger.Module
import dagger.Provides


@Module
class NavigationModule(private val mActivity: Activity) {
    @NonNull
    @Provides
    @ActivityScope
    fun activity(): Activity = mActivity

    @NonNull
    @Provides
    @ActivityScope
    fun navigatorHolder(activity: Activity): NavController =
        Navigation.findNavController(activity, R.id.navHostFragment)
}
package com.example.itpeople_bookstore.di;

import com.example.itpeople_bookstore.activities.main.MainActivity;
import com.example.itpeople_bookstore.di.main.MainViewModelsModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
            modules = {MainViewModelsModule.class}
    )
    abstract MainActivity contributeMainActivity();
}

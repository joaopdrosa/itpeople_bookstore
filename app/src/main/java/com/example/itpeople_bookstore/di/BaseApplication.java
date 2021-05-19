package com.example.itpeople_bookstore.di;


import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.HasAndroidInjector;

public class BaseApplication extends DaggerApplication {

    public BaseApplication instance;

    public BaseApplication() {
        instance = this;
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }



}
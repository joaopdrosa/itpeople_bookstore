package com.example.itpeople_bookstore.di;


import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class BaseApplication extends DaggerApplication {
//    ApplicationComponent appComponent = DaggerApplicationComponent.create();

    public BaseApplication instance;

    public BaseApplication() {
        instance = this;
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
//        return DaggerAppComponent.builder().application(this).build();
        return null;
    }

}
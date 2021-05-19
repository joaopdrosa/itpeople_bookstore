package com.example.itpeople_bookstore.di.main;

import androidx.lifecycle.ViewModel;

import com.example.itpeople_bookstore.ui.activities.main.MainActivityViewModel;
import com.example.itpeople_bookstore.di.ViewModelKey;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class MainViewModelsModule {

    @Binds
    @IntoMap
    @ViewModelKey(value = MainActivityViewModel.class)
    abstract ViewModel bindMainActivityViewModel(MainActivityViewModel viewModel);


}

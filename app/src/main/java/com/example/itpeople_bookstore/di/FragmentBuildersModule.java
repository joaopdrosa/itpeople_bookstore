package com.example.itpeople_bookstore.di;

import com.example.itpeople_bookstore.di.main.MainViewModelsModule;
import com.example.itpeople_bookstore.ui.fragments.books.details.BookDetailsFragment;
import com.example.itpeople_bookstore.ui.fragments.books.list.BooksListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBuildersModule {

    @ContributesAndroidInjector(
            modules = {MainViewModelsModule.class}
    )
    abstract BooksListFragment contributeBooksListFragment();

    @ContributesAndroidInjector(
            modules = {MainViewModelsModule.class}
    )
    abstract BookDetailsFragment contributeBookDetailsFragment();
}

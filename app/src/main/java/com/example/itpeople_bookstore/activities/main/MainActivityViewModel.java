package com.example.itpeople_bookstore.activities.main;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import com.example.itpeople_bookstore.fragments.books.details.IBookDetailsViewModel;
import com.example.itpeople_bookstore.fragments.books.list.IBooksListViewModel;

import javax.inject.Inject;

public class MainActivityViewModel extends AndroidViewModel implements IBooksListViewModel, IBookDetailsViewModel {

    @Inject
    public MainActivityViewModel(Application app) {
        super(app);
    }
}

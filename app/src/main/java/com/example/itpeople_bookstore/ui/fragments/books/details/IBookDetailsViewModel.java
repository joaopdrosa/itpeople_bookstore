package com.example.itpeople_bookstore.ui.fragments.books.details;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.itpeople_bookstore.data.models.BookAndInfo;

public interface IBookDetailsViewModel {
    LiveData<BookAndInfo> bookSelected = new MutableLiveData<>();
}

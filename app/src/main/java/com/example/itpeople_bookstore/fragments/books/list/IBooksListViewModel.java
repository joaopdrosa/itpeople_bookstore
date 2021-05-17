package com.example.itpeople_bookstore.fragments.books.list;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.itpeople_bookstore.data.models.Book;

import java.util.List;

public interface IBooksListViewModel {
    LiveData<List<Book>> books = new MutableLiveData<>();
}

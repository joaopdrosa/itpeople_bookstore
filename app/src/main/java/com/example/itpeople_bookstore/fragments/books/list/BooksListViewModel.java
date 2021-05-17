package com.example.itpeople_bookstore.fragments.books.list;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.itpeople_bookstore.data.models.Book;

import java.util.List;

public class BooksListViewModel extends ViewModel {

    public BooksListViewModel() {
        Log.d("BooksListViewModel", "Initializing BooksListViewModel");
        search.setValue("");
    }

    public MutableLiveData<String> search = new MutableLiveData<>();

    private final MutableLiveData<List<Book>> allBooks = new MutableLiveData<>();

    public LiveData<List<Book>> books = applyFilter();

    public void populateBooks(List<Book> booksToPopulate) {
        allBooks.postValue(booksToPopulate);
    }

    private LiveData<List<Book>> applyFilter() {
        return new MutableLiveData<>();
    }
}

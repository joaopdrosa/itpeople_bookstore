package com.example.itpeople_bookstore.ui.activities.main;


import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.itpeople_bookstore.data.models.Book;
import com.example.itpeople_bookstore.data.models.BookAndInfo;
import com.example.itpeople_bookstore.data.repositories.BookRepository;
import com.example.itpeople_bookstore.ui.fragments.books.details.IBookDetailsViewModel;
import com.example.itpeople_bookstore.ui.fragments.books.list.IBooksListViewModel;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

public class MainActivityViewModel extends ViewModel implements IBooksListViewModel, IBookDetailsViewModel {


    private final MutableLiveData<List<Book>> _books = new MutableLiveData<>();

    public LiveData<List<Book>> books = _books;

    private MutableLiveData<Book> _bookClicked = new MutableLiveData<>();
    public LiveData<Book> bookClicked = _bookClicked;

    @Inject
    public MainActivityViewModel(BookRepository repository) {
        Log.d("book123", "estou AQUI =D");

        Book b1 = new Book();
        b1.id = "Book 1";
        Book b2 = new Book();
        b2.id = "Book 2";
        List<Book> books = new LinkedList<>();
        books.add(b1);
        books.add(b2);

        _books.postValue(books);
    }

    @Override
    public void onBookClick(BookAndInfo book) {

    }


}

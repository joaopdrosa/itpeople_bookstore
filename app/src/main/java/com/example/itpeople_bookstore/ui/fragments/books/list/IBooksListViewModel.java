package com.example.itpeople_bookstore.ui.fragments.books.list;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.itpeople_bookstore.data.models.Book;
import com.example.itpeople_bookstore.data.models.BookAndInfo;

import java.util.List;

public interface IBooksListViewModel {
    /**
     * The books the fragment is listing
     */
    LiveData<List<BookAndInfo>> books = new MutableLiveData<>();

    /**
     * To notify the calling activity that a book was clicked
     * @param book The book clicked
     */
    void onBookClick(BookAndInfo book);
}

package com.example.itpeople_bookstore.data.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.itpeople_bookstore.data.models.Book;
import com.example.itpeople_bookstore.data.models.BookAndInfo;

import java.util.List;

@Dao
public interface BookDAO {

    @Insert
    void addToFavorites(BookAndInfo book);


    @Transaction
    @Query("SELECT * FROM book_table")
    List<BookAndInfo> getFavorites();

}

package com.example.itpeople_bookstore.data.repositories;

import com.example.itpeople_bookstore.api.BookAPI;
import com.example.itpeople_bookstore.data.database.AppDatabase;
import com.example.itpeople_bookstore.data.database.BookDAO;

import javax.inject.Inject;

public class BookRepository {

    private BookDAO dao;
    private BookAPI api;

    @Inject
    public BookRepository(AppDatabase db, BookAPI api) {
        dao = db.bookDAO();
    }


}

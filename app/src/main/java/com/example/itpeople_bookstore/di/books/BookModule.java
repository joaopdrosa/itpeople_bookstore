package com.example.itpeople_bookstore.di.books;

import com.example.itpeople_bookstore.api.BookAPI;
import com.example.itpeople_bookstore.data.database.AppDatabase;
import com.example.itpeople_bookstore.data.repositories.BookRepository;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class BookModule {

    @Provides
    public BookAPI provideBookApi(Retrofit retrofit) {
        return retrofit.create(BookAPI.class);
    }


    @Provides
    public BookRepository provideBookRepository(AppDatabase db, BookAPI bookAPI) {
        return new BookRepository(db, bookAPI);
    }
}

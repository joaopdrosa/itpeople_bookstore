package com.example.itpeople_bookstore.data.database;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface BookDAO {

    @Insert
    void addToFavorites(String id);

}

package com.example.itpeople_bookstore.data.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "book_table")
public class Book {
    @PrimaryKey
    @NonNull
    public String id = "";


//    public VolumeInfo volumeInfo = new VolumeInfo();
//
//    public SaleInfo saleInfo = new SaleInfo();
}

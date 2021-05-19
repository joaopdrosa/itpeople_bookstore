package com.example.itpeople_bookstore.data.models;

import androidx.room.Embedded;
import androidx.room.Relation;

public class BookAndInfo {

    @Embedded
    public Book book;

    @Relation(
            parentColumn = "id",
            entityColumn = "bookId"
    )
    public VolumeInfo volumeInfo = new VolumeInfo();

    @Relation(
            parentColumn = "id",
            entityColumn = "bookId"
    )
    public SaleInfo saleInfo = new SaleInfo();

}

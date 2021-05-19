package com.example.itpeople_bookstore.data.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "sale_info_table")
public class SaleInfo {
    @PrimaryKey
    @NonNull
    public String bookId = "";

    public String saleability;
    public boolean isForSale;
    public String buyLink;
}

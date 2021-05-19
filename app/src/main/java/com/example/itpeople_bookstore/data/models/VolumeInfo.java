package com.example.itpeople_bookstore.data.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "volume_info_table")
public class VolumeInfo {
    @PrimaryKey
    @NonNull
    public String bookId = "";

    public String title;
    public String authors;
    public String description;
}

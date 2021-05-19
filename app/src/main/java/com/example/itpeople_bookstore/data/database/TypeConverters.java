package com.example.itpeople_bookstore.data.database;

import androidx.room.TypeConverter;

import com.google.gson.Gson;

import java.util.LinkedList;
import java.util.List;

public class TypeConverters {

    @TypeConverter
    public String fromAuthorsToString(String[] authors) {
        if (authors.length == 0) {
            return "";
        }

       String k = (new Gson()).toJson(authors);

        return k;
    }

    @TypeConverter
    public String[] fromStringToAuthors(String authorsJson) {
        if (authorsJson.equals("")) {
            return new String[]{};
        }


        try {
            LinkedList<String> k = (new Gson()).fromJson(authorsJson, (new LinkedList<String>()).getClass());
        } catch (Exception e) {
            Exception k = e;
        }

        return (new Gson()).fromJson(authorsJson, (new String[]{}).getClass());
    }

//    fun fromDateToLongTimeStampValue(date: Date?): Long? {
//        return date?.time
//    }
//
//    @TypeConverter
//    fun fromTimeStampLongValueToDate(timeStampValue: Long?): Date? {
//        return timeStampValue?.let { Date(it) }
//    }
}

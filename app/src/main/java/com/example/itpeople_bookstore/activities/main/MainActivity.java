package com.example.itpeople_bookstore.activities.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.itpeople_bookstore.R;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
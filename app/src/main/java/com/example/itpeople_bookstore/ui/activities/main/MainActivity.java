package com.example.itpeople_bookstore.ui.activities.main;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.ActionBar;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;

import com.example.itpeople_bookstore.R;
import com.example.itpeople_bookstore.di.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity {

    @Inject
    MainActivityViewModel vm;

    @Inject
    ViewModelProviderFactory providerFactory;

    private NavController navController = null;
    private Integer currentDestinationId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar((androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar));

        ActionBar supportActionBar = getSupportActionBar();

        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }

        vm = new ViewModelProvider(this, providerFactory).get(MainActivityViewModel.class);

        handleNavigation();
        observeViewModel();
    }

    private void handleNavigation() {
        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            currentDestinationId = destination.getId();

            if (destination.getId() == R.id.booksListFragment) {
                setTitle(getString(R.string.app_name));
            } else if (destination.getId() == R.id.bookDetailsFragment) {
                setTitle(getString(R.string.book_details));
            }
        });

    }

    private void observeViewModel() {
        vm.books.observe(this, books -> Log.d("book123", "tenho " + books.size() + " livros na atividade"));

        vm.bookClicked.observe(this, book -> {
            if (currentDestinationId == R.id.booksListFragment) {
                // If a book was clicked and we are in the list, go to the book's details
                navController.navigate(R.id.action_booksListFragment_to_bookDetailsFragment);
            }
            // else ignore
        });
    }

}
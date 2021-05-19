package com.example.itpeople_bookstore.ui.fragments.books.list;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import com.example.itpeople_bookstore.Callable;
import com.example.itpeople_bookstore.data.models.BookAndInfo;
import com.example.itpeople_bookstore.ui.activities.main.MainActivity;
import com.example.itpeople_bookstore.ui.activities.main.MainActivityViewModel;
import com.example.itpeople_bookstore.adapters.BooksAdapter;
import com.example.itpeople_bookstore.data.models.Book;
import com.example.itpeople_bookstore.databinding.FragmentBooksListBinding;
import com.example.itpeople_bookstore.di.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;


public class BooksListFragment extends DaggerFragment {

    private FragmentBooksListBinding binding;

    @Inject
    ViewModelProviderFactory providerFactory;

    public BooksListFragment() {
    }

    @Inject
    public BooksListFragment(ViewModelProviderFactory providerFactory) {
        super();
        this.providerFactory = providerFactory;
    }

    private IBooksListViewModel genericVM;

    private final Callable<BookAndInfo> bookCallable = book -> {
        genericVM.onBookClick(book);
    };

    BooksAdapter adapter = new BooksAdapter(bookCallable);


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Activity parentActivity = getActivity();

        if (parentActivity == null) {
            throw new NullPointerException();
        }

        // in case the fragment is used in multiple activity
        if (parentActivity.getClass() == MainActivity.class) {
            genericVM = new ViewModelProvider((ViewModelStoreOwner) parentActivity, providerFactory).get(MainActivityViewModel.class);
        } else {
            throw new IllegalArgumentException(String.format("ACTIVITY %s NOT SUPPORTED", parentActivity.getLocalClassName()));
        }


        binding = FragmentBooksListBinding.inflate(inflater);
        binding.setLifecycleOwner(this);

        initComponent();
        observeViewModel();

        return binding.getRoot();
    }

    private void initComponent() {
        binding.booksList.setAdapter(adapter);
    }

    private void observeViewModel() {
        genericVM.books.observe(getViewLifecycleOwner(), books -> {
            adapter.setBooks(books);
        });
    }

//    @Override
//    public void call(Book book) {
//    }

}
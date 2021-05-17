package com.example.itpeople_bookstore.fragments.books.list;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.itpeople_bookstore.Callable;
import com.example.itpeople_bookstore.R;
import com.example.itpeople_bookstore.activities.main.MainActivity;
import com.example.itpeople_bookstore.activities.main.MainActivityViewModel;
import com.example.itpeople_bookstore.adapters.BooksAdapter;
import com.example.itpeople_bookstore.api.BookAPI;
import com.example.itpeople_bookstore.data.models.Book;
import com.example.itpeople_bookstore.di.ViewModelProviderFactory;

import java.util.List;

import javax.inject.Inject;

import okhttp3.Call;

public class BooksListFragment extends Fragment {

    @Inject
    ViewModelProviderFactory providerFactory;

    private final Callable<Book> bookCallable = param -> {
        Log.d("book123", "teste no fragmento no método");
    };

    BooksAdapter adapter = new BooksAdapter(bookCallable);

    private IBooksListViewModel genericVM;
    private BooksListViewModel vm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Activity parentActivity = requireActivity();

        if (parentActivity.getClass() == MainActivity.class) {
            new ViewModelProvider((ViewModelStoreOwner) parentActivity, providerFactory).get(MainActivityViewModel.class);
        } else {
            throw new IllegalArgumentException(String.format("ACTIVITY %s NOT SUPPORTED", parentActivity.getLocalClassName()));
        }

        vm = new ViewModelProvider((ViewModelStoreOwner) parentActivity, providerFactory).get(BooksListViewModel.class);

        initComponent();
        observeViewModel();

        return inflater.inflate(R.layout.fragment_books_list, container, false);
    }

    private void initComponent() {
        // adapter
    }

    private void observeViewModel() {
        genericVM.books.observe(getViewLifecycleOwner(), books -> {
            Log.d("book123", String.format("tenho %d livros no observe", books.size()));
            vm.populateBooks(books);
        });

        vm.books.observe(getViewLifecycleOwner(), books -> {
            Log.d("book123", String.format("tenho %d livros depois do filtro", books.size()));
        });
    }

//    @Override
//    public void call(Book book) {
//        Log.d("book123", "teste no fragmento pela interface");
//    }

}
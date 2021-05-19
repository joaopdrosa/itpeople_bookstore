package com.example.itpeople_bookstore.ui.fragments.books.details;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.itpeople_bookstore.ui.activities.main.MainActivity;
import com.example.itpeople_bookstore.ui.activities.main.MainActivityViewModel;
import com.example.itpeople_bookstore.databinding.FragmentBookDetailsBinding;
import com.example.itpeople_bookstore.di.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;


public class BookDetailsFragment extends DaggerFragment {

    private FragmentBookDetailsBinding binding;

    @Inject
    ViewModelProviderFactory providerFactory;

    public BookDetailsFragment() {
    }

    @Inject
    public BookDetailsFragment(ViewModelProviderFactory providerFactory) {
        super();
        this.providerFactory = providerFactory;
    }

    private IBookDetailsViewModel genericVM;

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

        binding = FragmentBookDetailsBinding.inflate(inflater);
        binding.setLifecycleOwner(this);
        binding.setGenericVm(genericVM);

        initComponent();
        observeViewModel();

        return binding.getRoot();
    }

    private void initComponent() {
        genericVM.bookSelected.observe(getViewLifecycleOwner(), book -> binding.buyButton.setVisibility(book.saleInfo.isForSale ? View.VISIBLE : View.GONE));

    }

    private void observeViewModel() {
    }
}
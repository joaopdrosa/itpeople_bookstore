package com.example.itpeople_bookstore.di;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.util.Map;

import javax.inject.Provider;

@SuppressWarnings("unchecked")
public class ViewModelProviderFactory implements ViewModelProvider.Factory {

    private Map<Class<? extends ViewModel>, Provider<ViewModel>> creators;

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        Map.Entry<Class<? extends ViewModel>, Provider<ViewModel>> found = null;

        for (Map.Entry<Class<? extends ViewModel>, Provider<ViewModel>> entry : creators.entrySet()) {
            if (modelClass.isAssignableFrom(entry.getKey())) {
                found = entry;
                break;
            }
        }

        if (found == null) {
            throw new IllegalArgumentException("Unknown model class " + modelClass.toString());
        }

        Provider<ViewModel> creator = found.getValue();

        try {
            return (T) creator.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

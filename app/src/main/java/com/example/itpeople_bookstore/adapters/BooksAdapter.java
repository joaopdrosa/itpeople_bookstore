package com.example.itpeople_bookstore.adapters;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.itpeople_bookstore.Callable;
import com.example.itpeople_bookstore.R;
import com.example.itpeople_bookstore.data.models.Book;
import com.example.itpeople_bookstore.data.models.BookAndInfo;

import java.util.List;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BookViewHolder> {

    private List<BookAndInfo> books;
    private final Callable<BookAndInfo> callable;

    public BooksAdapter(Callable<BookAndInfo> callable) {
        super();
        this.callable = callable;
    }

    public void setBooks(List<BookAndInfo> books) {
        this.books = books;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflatedView =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item, parent, false);

        return new BookViewHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(@NonNull BooksAdapter.BookViewHolder holder, int position) {
       holder.bind(books.get(position), callable);
    }

    @Override
    public int getItemCount() {
        if (books == null) {
            return 0;
        }

        return books.size();
    }

    protected static class BookViewHolder extends RecyclerView.ViewHolder {

        public BookViewHolder(View itemView) {
            super(itemView);
        }

        @SuppressLint("SetTextI18n")
        public void bind(BookAndInfo book, Callable<BookAndInfo> callable) {
//            itemView.title_text_view.text = person.uniqueIdLabel
//            itemView.uniqueId_text_view.text = person.uniqueId
//            itemView.occupational_uniqueId_label.text = person.occupationalUniqueIdLabel
//            itemView.occupational_uniqueId_view.text = person.occupationalUniqueId
//            itemView.name_text_view.text =
//            if (person.title.isNullOrEmpty()) person.name else "${person.title} ${person.name}"
//            itemView.isActive_check_box.isChecked = person.isActive
//
//            itemView.card_view.setOnClickListener {
//                onItemClick?.invoke(person)
//            }


            itemView.setOnClickListener(view -> {
                callable.call(book);
                Log.d("book123", "teste");
            });
//
//            itemView.button_remove.setOnClickListener {
//                viewBinderHelper.closeLayout(layoutId)
//                onRemoveClick?.invoke(person)
//            }
//
//            itemView.button_remove.setImageResource(if (person.iconId == -1) R.drawable.ic_trash else person.iconId)
        }
    }
}

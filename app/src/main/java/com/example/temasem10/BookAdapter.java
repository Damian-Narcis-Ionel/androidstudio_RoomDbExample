package com.example.temasem10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class BookAdapter extends BaseAdapter {

   private ArrayList<Book> books;
   private Context context;
   private LayoutInflater inflater;

    public BookAdapter(ArrayList<Book> books, Context context) {
        this.books = books;
        this.context = context;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Object getItem(int position) {
        return books.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        final View item = inflater.inflate(R.layout.item_book, viewGroup,false);
        TextView tvTitle = item.findViewById(R.id.tv_title);
        TextView tvAuthor = item.findViewById(R.id.tv_author);
        TextView tvYear = item.findViewById(R.id.tv_year);

        Book book = books.get(position);
        tvTitle.setText(book.getTitle());
        tvAuthor.setText(book.getAuthor());
        tvYear.setText(String.valueOf(book.getYearOfPublication()));

        return item;
    }
}

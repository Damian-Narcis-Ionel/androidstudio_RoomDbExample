package com.example.temasem10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppDb database;
    private ListView lvBooks;
    private BookAdapter bookAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvBooks = findViewById(R.id.lv_books);
        database = Room.databaseBuilder(this,AppDb.class, "books").allowMainThreadQueries().build();
        insertBooks();
        setupAdapter(database.bookDAO().getAll());

//        List<Book> books = database.bookDAO().getAll();
//        for(Book book : books){
//            Log.v("Books_all", book.toString());
//        }
//
//        List<Book> books2 = database.bookDAO().getAllFromAuthor("F.M. Dostoyevsky");
//        for(Book book : books2){
//            Log.v("Books_auth", book.toString());
//        }
//
//        List<Book> books3 = database.bookDAO().getAllFromAuthorBeforeYear("F.M. Dostoyevsky",1870);
//        for(Book book : books3){
//            Log.v("Books_auth_year", book.toString());
//        }


    }


    private void insertBooks(){

        database.bookDAO().deleteAll();
        database.bookDAO().insertBook(new Book("America","Franz Kafka", 1927));
        database.bookDAO().insertBook(new Book("The Shining","Stephen King", 1977));
        database.bookDAO().insertBook(new Book("Lord of the Flies","William Golding", 1954));
        database.bookDAO().insertBook(new Book("Crime and Punishment","F.M. Dostoyevsky", 1866));
        database.bookDAO().insertBook(new Book("The Brothers Karamazov","F.M. Dostoyevsky", 1879));
        database.bookDAO().insertBook(new Book("The Idiot","F.M. Dostoyevsky", 1869));

    }

    private void setupAdapter(List<Book> bookList){
        ArrayList<Book> books = new ArrayList<Book>();

        for (Book book : bookList){
            books.add(book);
        }

        for(Book book : books){
            Log.v("testing",book.getTitle().toString());
        }

        bookAdapter = new BookAdapter(books,this);

        lvBooks.setAdapter(bookAdapter);
    }





}
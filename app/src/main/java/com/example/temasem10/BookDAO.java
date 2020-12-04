package com.example.temasem10;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface BookDAO {

    @Insert
            (onConflict = OnConflictStrategy.IGNORE)
    public void insertBook(Book book);

    @Delete
    public void deleteBook(Book book);

    @Query("SELECT * FROM books")
    List<Book> getAll();

    @Query("SELECT * FROM books where author =:author")
    List<Book> getAllFromAuthor(String author);

    @Query("SELECT * FROM books where author =:author and year_of_publication < :year")
    List<Book> getAllFromAuthorBeforeYear(String author,int year);

    @Query("DELETE FROM books")
    public void deleteAll();
}

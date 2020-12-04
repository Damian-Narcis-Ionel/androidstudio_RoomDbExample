package com.example.temasem10;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities =  {Book.class},version = 1)
public abstract class AppDb extends RoomDatabase {

        public abstract BookDAO bookDAO();
}

package com.example.seminar4;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface LibrarieDao {
    @Insert
    void insert(Librarie librarie);

    @Query("SELECT * FROM librarie")
    List<Librarie> getAll();

    @Query("SELECT * FROM librarie WHERE isbn = :isbn")
    Librarie getByIsbn(String isbn);

    @Delete
    void delete(Librarie librarie);

    @Update
    void update(Librarie librarie);
}

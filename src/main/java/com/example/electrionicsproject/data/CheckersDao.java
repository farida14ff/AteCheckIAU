package com.example.electrionicsproject.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.electrionicsproject.models.Checker;

import java.util.List;

@Dao
public interface CheckersDao {
    @Query("SELECT * FROM checkers")
    List<Checker> getAllCheckers();

    @Insert
    long addCheckers(Checker notes);

//    @Update
//    void update(Notes repos);
//
//    @Delete
//    void delete(Notes notes);
//
//    @Delete
//    void delete(Notes... notes);


//    @Query("UPDATE checkers SET nameOfChecker = :name WHERE id = :id")
//    void updateNotes(String name);

    @Query("DELETE FROM checkers")
    void deleteAllNotes();

    @Query("DELETE FROM checkers WHERE id = :id")
    void deleteNotes(int id);

}


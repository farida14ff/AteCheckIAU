package com.example.electrionicsproject.models;


import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "checkers")
public class Checker {

    @PrimaryKey(autoGenerate = true)
    int id;
    String nameOfChecker;

    @Ignore
    public Checker(int id,String nameOfChecker) {
        this.id = id;
        this.nameOfChecker = nameOfChecker;
    }

    public Checker(String nameOfChecker) {
        this.nameOfChecker = nameOfChecker;
    }

    public String getNameOfChecker() {
        return nameOfChecker;
    }

    public void setNameOfChecker(String nameOfChecker) {
        this.nameOfChecker = nameOfChecker;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

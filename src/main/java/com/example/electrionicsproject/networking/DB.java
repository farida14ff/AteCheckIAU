package com.example.electrionicsproject.networking;

import com.example.electrionicsproject.models.Checker;

import java.util.ArrayList;

import io.paperdb.Paper;

public class DB {
    private final  String CHCECKERSNODE = "checkersNode";

    public static ArrayList<Checker> getChekers(){
        ArrayList<Checker> checkers = Paper.book().read("chekers", new ArrayList<Checker>());
        return checkers;
    }
}

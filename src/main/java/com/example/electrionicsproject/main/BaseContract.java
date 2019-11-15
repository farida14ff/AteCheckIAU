package com.example.electrionicsproject.main;

import com.example.electrionicsproject.models.Checker;

public interface BaseContract {

    interface OnItemClickListener {
        void onItemClick(Checker checker);
    }
}

package com.example.electrionicsproject.newCheckerAdding;

import android.widget.EditText;

public class AddNewCheckerPresenter implements AddNewCheckerContract.Presenter {

    AddNewCheckerContract.View view;

    public AddNewCheckerPresenter(AddNewCheckerContract.View view){
        this.view = view;
    }


}

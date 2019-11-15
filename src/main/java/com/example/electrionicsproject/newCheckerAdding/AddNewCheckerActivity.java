package com.example.electrionicsproject.newCheckerAdding;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.electrionicsproject.data.CHeckersRoomDataBase;
import com.example.electrionicsproject.main.BaseActivity;
import com.example.electrionicsproject.R;
import com.example.electrionicsproject.models.Checker;

public class AddNewCheckerActivity extends BaseActivity {

    private String chackersName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_checker);

        EditText chackersEditText = findViewById(R.id.nameEditText);
        chackersName = chackersEditText.getText().toString();

        chackersEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                chackersName = editable.toString();

            }
        });

        final CHeckersRoomDataBase db = CHeckersRoomDataBase.getDatabase(this);

        Button saveButton = findViewById(R.id.save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Checker checker = new Checker(chackersName);
                db.checkersDao().addCheckers(checker);
                finish();
            }
        });
    }



}

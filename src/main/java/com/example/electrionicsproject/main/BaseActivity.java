package com.example.electrionicsproject.main;

import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public  abstract class BaseActivity extends AppCompatActivity {
    boolean[] shouldExit = {false};

    protected void log(String msg) {
        Log.d("Mylog" + getClass().getSimpleName(), msg);
    }

    @Override
    public void onBackPressed() {

        if (shouldExit[0]) {
            super.onBackPressed();
        } else {
            shouldExit[0] = true;
            Toast.makeText(this, "Tap again", Toast.LENGTH_SHORT).show();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ignored) {

                    } finally {
                        shouldExit[0] = false;
                    }
                }
            }).start();
        }
    }
}

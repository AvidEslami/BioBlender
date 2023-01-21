package com.example.bioblender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPython();
        TextView text1 = findViewById(R.id.textView1);
        text1.setText(example());

    }

    private void initPython() {
        Python.start(new AndroidPlatform(this));
    }

    private String example() {
        Python python = Python.getInstance();
        PyObject pythonFile = python.getModule("Sample");
        return pythonFile.callAttr("test", "this is working").toString();
    }
}



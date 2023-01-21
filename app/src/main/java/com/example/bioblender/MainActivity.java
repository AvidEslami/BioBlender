package com.example.bioblender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView text1;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPython();
        text1 = (TextView) findViewById(R.id.textView1);
        text1.setText(example());
        example();

    }

    private void initPython() {
        Python.start(new AndroidPlatform(this));
    }

    private String example() {
        Python python = Python.getInstance();
        PyObject pythonFile = python.getModule("Sample");
        return pythonFile.callAttr("test", "this is DEFINITELY working").toString();
    }
}



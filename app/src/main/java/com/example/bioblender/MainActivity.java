package com.example.bioblender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.drawable.Icon;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView text1;
        ImageView animal;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPython();
        text1 = (TextView) findViewById(R.id.textView1);
//        animal = (ImageView) findViewById(R.id.imageAnimal);
        text1.setText(example());
//        animal.setImageIcon(findImage());
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

//    private Icon findImage() {
//        Python python = Python.getInstance();
//        PyObject pythonFile = python.getModule("imageAnimalScrape");
//        String imageURL = pythonFile.callAttr("findImageAnimal", "lizard").toString();
//
//    return ICon;
//    }
}



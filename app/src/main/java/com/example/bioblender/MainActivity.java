package com.example.bioblender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPython();
        Button playButton = findViewById(R.id.playbtn);
        Button playGameButton = findViewById(R.id.playbtn2);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BlenderActivity.class);
                startActivity(intent);
            }
        });
        playGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GameMode.class);
                startActivity(intent);
            }
        });
    }

    private void initPython() {
        if (!Python.isStarted())
            Python.start(new AndroidPlatform(this));
    }

    private String example() {
        Python python = Python.getInstance();
        PyObject pythonFile = python.getModule("Sample");
        return pythonFile.callAttr("test", "this is DEFINITELY working").toString();
    }

    ////////////////////// FORMATTED
    public void storeFormattedAnimalList(String animalList) {
        writeToFile("FormattedAnimalList.txt",animalList);
    }
    public String readFormattedAnimalList() {
        return readFromFile("FormattedAnimalList.txt");
    }
    ///////////////////// UNFORMATTED
    public void storeUnformattedAnimalList(String animalList) {
        writeToFile("UnformattedAnimalList.txt",animalList);
    }
    public String readUnformattedAnimalList() {
        return readFromFile("UnformattedAnimalList.txt");
    }
    ////////////////////



    public void writeToFile(String desiredFileName, String stringToStore) { //Writing Mechanism
        File path = getApplicationContext().getFilesDir();
        try {
            FileOutputStream writer = new FileOutputStream(new File(path, desiredFileName));
            writer.write(stringToStore.getBytes());
            writer.close();
            Toast.makeText(getApplicationContext(), "String written to file: " + desiredFileName, Toast.LENGTH_SHORT);
        } catch (Exception e) {
            e.printStackTrace(); //Something Probably Went Wrong
        }
    }
    public String readFromFile(String FileToRead) {
        File path = getApplicationContext().getFilesDir();
        File readFrom = new File(path, FileToRead);
        byte[] extractedString = new byte[(int) readFrom.length()];
        try {
            FileInputStream stream = new FileInputStream(readFrom);
            stream.read(extractedString);
            return new String(extractedString);
            //return Formatted;
        } catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        }
    }}

//    private Icon findImage() {
//        Python python = Python.getInstance();
//        PyObject pythonFile = python.getModule("imageAnimalScrape");
//        String imageURL = pythonFile.callAttr("findImageAnimal", "lizard").toString();
//
//    return ICon;
//    }




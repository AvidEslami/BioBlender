package com.example.bioblender;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

public class GameMode extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_mode);
        memStartup();
        spawnAnimals();
        TextView AnimalList = (TextView)findViewById(R.id.ListAnimal);
        AnimalList.setText(example());
    }


    private void memStartup() {
        Python python = Python.getInstance();
        PyObject pythonFile = python.getModule("AI");
        String oldFiles = readFromAnimalList();
        pythonFile.callAttr("set_animal",oldFiles);
    }


    private String spawnAnimals() {
        Python python = Python.getInstance();
        PyObject pythonFile = python.getModule("AI");
        pythonFile.callAttr("generateAnimal").toString();
        String animals = pythonFile.callAttr("get_animals").toString();
//        return an
        writeAnimalList(animals);
        return animals;
    }
    private String example() {
//        Python python = Python.getInstance();
//        PyObject pythonFile = python.getModule("AI");
//        readFromAnimalList();
        return readFromAnimalList();
    }

    public void writeAnimalList(String animalsToWrite) {
        writeToFile("AnimalListFile.txt",animalsToWrite);
    }

    public String readFromAnimalList() {
        return readFromFile("AnimalListFile.txt");
    }

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
    }



}
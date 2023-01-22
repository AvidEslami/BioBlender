package com.example.bioblender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;

public class BlenderActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText an1;

    private EditText an2;


    private String name;
    private String description;
    private String URL;
    private String reason;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.blendbtn:
                String animal1 = an1.getText().toString();
                String animal2 = an2.getText().toString();

                Python python = Python.getInstance();
                PyObject pythonFile = python.getModule("AI");
                name = pythonFile.callAttr("compareAnimals", animal1, animal2).toString();
                description = pythonFile.callAttr("generate_description", name).toString();
                reason = pythonFile.callAttr("explain_why", animal1, animal2, name).toString();
                PyObject pythonFile2 = python.getModule("imageAnimalScrape");
                URL = pythonFile2.callAttr("serpapi_get_google_images", name).toString();

                Intent intent = new Intent(this, NewAnimal.class);
                intent.putExtra("name", name);
                intent.putExtra("description", description);
                intent.putExtra("URL", URL);
                intent.putExtra("reason", reason);
                startActivity(intent);
                break;
            case R.id.Rand1:
                Python python2 = Python.getInstance();
                PyObject py1 = python2.getModule("AI");
                String random_animal1 = py1.callAttr("generateAnimal").toString();
                EditText text1 = findViewById(R.id.animal1);
                text1.setText(random_animal1);
                break;

            case R.id.Rand2:
                Python python3 = Python.getInstance();
                PyObject py2 = python3.getModule("AI");
                String random_animal2 = py2.callAttr("generateAnimal").toString();
                EditText text2 = findViewById(R.id.animal2);
                text2.setText(random_animal2);
                break;
            default:
                Toast.makeText(this, "You Died", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blender);
        an1 = findViewById(R.id.animal1); // First animal view
        an2 = findViewById(R.id.animal2); // Second animal view
        Button mixButton = findViewById(R.id.blendbtn);
        mixButton.setOnClickListener(this);
        Button rand1 = findViewById(R.id.Rand1);
        rand1.setOnClickListener(this);

        Button rand2 = findViewById(R.id.Rand2);
        rand2.setOnClickListener(this);
    }
}
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
                name = pythonFile2.callAttr("serpapi_get_google_images", name).toString();

                Intent intent = new Intent(this, NewAnimal.class);
                intent.putExtra("name", name);
                intent.putExtra("description", description);
                intent.putExtra("ULR", URL);
                intent.putExtra("reason", reason);
                startActivity(intent);
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
    }
}
package com.example.bioblender;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
public class BlenderActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText an1;
    private EditText an2;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                //result.setText(an1.getText().toString() + " + " + an2.getText().toString() + "= ESLAMI!!");
                Intent intent1 = new Intent(this, NewAnimal.class);
                startActivity(intent1);
                break;
            case R.id.backbtn:
                Intent intent2 = new Intent(this, MainActivity.class);
                startActivity(intent2);
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
        Button mixButton = findViewById(R.id.btn1);
        mixButton.setOnClickListener(this);
        Button backButton = findViewById(R.id.backbtn);
        backButton.setOnClickListener(this);
    }
}
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CambiaPass extends AppCompatActivity {

    public Button modificaPass, home;
    public TextView userText, passText, cambioavv;
    public EditText pass, confpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambia_pass);
        modificaPass = findViewById(R.id.modifButton);
        home = findViewById(R.id.home);
        userText = findViewById(R.id.userText);
        passText = findViewById(R.id.passText);
        pass = findViewById(R.id.nuovapasswordEditText);
        confpass = findViewById(R.id.confnuovapasswordEditText);
        cambioavv = findViewById(R.id.cambioAvvenuto);
        userText.setText(MainActivity.loggato.getUsername());
        passText.setText(MainActivity.loggato.getPassword());

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(CambiaPass.this, Home.class);
                startActivity(back);
                cambioavv.setVisibility(View.INVISIBLE);
            }
        });

        modificaPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pass.getText().toString().length() != 0 && pass.getText() != null){
                    if(!(pass.getText().toString().equals(MainActivity.loggato.getPassword()))){
                        if(pass.getText().toString().equals(confpass.getText().toString())){
                            MainActivity.loggato.setPassword(pass.getText().toString());
                            cambioavv.setVisibility(View.VISIBLE);
                        }
                        else{
                            pass.setError("Le password devono essere uguali");
                            confpass.setError("Le password devono essere uguali");
                        }
                    }
                    else{
                        pass.setError("La nuova password deve essere diversa dalla vecchia password");
                    }
                }
                else{
                    pass.setError("Inserire una password");
                    confpass.setError("Campo obbligatorio");
                }
            }
        });
    }
}
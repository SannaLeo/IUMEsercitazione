package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaParser;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    public Button logout, gestisciAdmin;
    public TextView pass, user, citta, data, sublogin, tipo, modPass;
    public ImageView btnImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        data = findViewById(R.id.dataText);
        btnImage = findViewById(R.id.imagebtn);
        user = findViewById(R.id.userText);
        citta = findViewById(R.id.cittaText);
        pass = findViewById(R.id.passText);
        sublogin = findViewById(R.id.subloginText);
        tipo = findViewById(R.id.tipo);
        gestisciAdmin = findViewById(R.id.gestisciAdmin);
        modPass = findViewById(R.id.modificapass);
        logout = findViewById(R.id.logout);
        sublogin.setText("Benvenuto/a " + user.getText().toString() + "!");
        pass.setText(MainActivity.loggato.getPassword());
        user.setText(MainActivity.loggato.getUsername());
        citta.setText(MainActivity.loggato.getCitta());
        data.setText(MainActivity.loggato.getDataDiNascita());
        setImage(MainActivity.loggato.getImage());



        if(MainActivity.loggato.isAdmin()){
            tipo.setText("Admin");
            tipo.setBackgroundColor(Color.parseColor("#FF018786"));
            gestisciAdmin.setVisibility(View.VISIBLE);
        }

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logout = new Intent(Home.this, MainActivity.class);
                MainActivity.loggato = null;
                startActivity(logout);
            }
        });

        modPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cambiaPass = new Intent(Home.this, CambiaPass.class);
                startActivity(cambiaPass);
            }
        });

        gestisciAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gestAdmin = new Intent(Home.this, GestisciAdmin.class);
                startActivity(gestAdmin);
            }
        });

        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent avatar = new Intent(Home.this, CambiaProPic.class);
                startActivity(avatar);
            }
        });
    }

    public void setImage(int i){

        switch (i){
            case 0:
                btnImage.setImageResource(R.drawable.propic);
                break;
            case 1:
                btnImage.setImageResource(R.drawable.beard);
                break;
            case 2:
                btnImage.setImageResource(R.drawable.chef);
                break;
            case 3:
                btnImage.setImageResource(R.drawable.chef_);
                break;
            case 4:
                btnImage.setImageResource(R.drawable.farmer);
                break;
        }
    }

}
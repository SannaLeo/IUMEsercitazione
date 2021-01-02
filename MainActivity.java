package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;

import java.io.Console;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    public EditText user, pass;
    public Button login;
    public TextView registrati;
    public static Utente loggato;
    public static ArrayList<Utente> utenti = new ArrayList<Utente>();;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(utenti.isEmpty()){
            //chi obeisi utentisi funti innoi
            //utenti test
            utenti.add(new Utente("admin", "admin", "Pompu", true));
            utenti.add(new Utente("a", "a", "Pompu", false));
            utenti.add(new Utente("b", "b", "Pompu", true));
            utenti.add(new Utente("c", "c", "Pompu", false));
            utenti.add(new Utente("a1", "a", "Pompu", false));
            utenti.add(new Utente("b1", "b", "Pompu", false));
            utenti.add(new Utente("c1", "c", "Pompu", false));
            utenti.add(new Utente("a2", "a", "Pompu", false));
            utenti.add(new Utente("b2", "b", "Pompu", true));
            utenti.add(new Utente("c2", "c", "Pompu", false));
            utenti.add(new Utente("a3", "a", "Pompu", false));
            utenti.add(new Utente("b3", "b", "Pompu", true));
            utenti.add(new Utente("c3", "c", "Pompu", false));
            utenti.add(new Utente("a4", "a", "Pompu", false));
            utenti.add(new Utente("b4", "b", "Pompu", true));
            utenti.add(new Utente("c4", "c", "Pompu", false));
            utenti.add(new Utente("a3", "a", "Pompu", false));
            utenti.add(new Utente("b3", "b", "Pompu", true));
            utenti.add(new Utente("c3", "c", "Pompu", false));
            utenti.add(new Utente("a3", "a", "Pompu", false));
            utenti.add(new Utente("b3", "b", "Pompu", true));
            utenti.add(new Utente("c3", "c", "Pompu", false));
            utenti.add(new Utente("a3", "a", "Pompu", false));
            utenti.add(new Utente("b3", "b", "Pompu", true));
            utenti.add(new Utente("c3", "c", "Pompu", false));
            utenti.add(new Utente("a3", "a", "Pompu", false));
            utenti.add(new Utente("b3", "b", "Pompu", true));
            utenti.add(new Utente("c3", "c", "Pompu", false));
            utenti.add(new Utente("a3", "a", "Pompu", false));
            utenti.add(new Utente("b3", "b", "Pompu", true));
            utenti.add(new Utente("c3", "c", "Pompu", false));
            utenti.add(new Utente("a3", "a", "Pompu", false));
            utenti.add(new Utente("b3", "b", "Pompu", true));
            utenti.add(new Utente("c3", "c", "Pompu", false));
        }
        user = findViewById(R.id.usernameEditText);
        pass = findViewById(R.id.passwordEditText);
        login = findViewById(R.id.accediButton);
        registrati = findViewById(R.id.registrazione);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean errPass, errUser, found;
                errPass = true;
                errUser = true;
                found = false;
                if(!CheckUserName(user.getText().toString())){
                    errUser = false;
                    user.setError("Inserisci Username");
                }

                if(!CheckPassword(pass.getText().toString())) {
                    errPass = false;
                    pass.setError("Inserisci Password");
                }
                if(errPass && errUser){
                    for (Utente u : utenti) {
                        Log.d("utenti", " "+ u.getUsername());
                        //controllo utente
                        if(u.getUsername().equals(user.getText().toString())){
                            Log.d("utenti", "utente trovato");
                            found = true;
                            if(u.getPassword().equals(pass.getText().toString())){
                                loggato = u;
                                Intent home = new Intent(MainActivity.this, Home.class);
                                startActivity(home);
                            }
                            else{
                                pass.setError("Password Errata");
                            }
                        }
                    }
                }
                if(!found){
                    user.setError("Utente non trovato");
                }
            }
        });

        registrati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent registrati = new Intent(MainActivity.this, Registrati_Activity.class);
                startActivity(registrati);
            }
        });
    }

    public boolean CheckUserName(String name) {
        return name != null && user.getText().length() != 0;
    }

    public boolean CheckPassword(String pass){
        return pass != null && this.pass.getText().length() != 0;
    }
}


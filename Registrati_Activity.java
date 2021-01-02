package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Registrati_Activity extends AppCompatActivity {

    public TextView data;
    public EditText user, pass, pass2, citta;
    public Button registrati, back;
    //nelle specifiche non era presente il numero di caratteri minimo, potete modificarlo da qua
    public final int num_car = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrati_);

        data = findViewById(R.id.dataTextPreview);
        user = findViewById(R.id.usernameEditText);
        pass = findViewById(R.id.passwordEditText);
        pass2 = findViewById(R.id.passwordEditText2);
        citta =  findViewById(R.id.cittaEditText);
        registrati = findViewById(R.id.registratiButton);
        back = findViewById(R.id.back);

        pass.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus)
                {
                    if(pass.getText().toString().length() < num_car){
                        pass.setError("Almeno " + num_car + " caratteri");
                    }
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(Registrati_Activity.this, MainActivity.class);
                startActivity(back);
            }
        });


        registrati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean errUser, errPass, errUs, errPa, errCi, errDa;
                errPass = false;
                errUser = false;
                errUs = false;
                errPa = false;
                errCi = false;
                errDa = false;

                if(citta.getText() != null && citta.getText().toString().length() != 0){
                    errCi = true;
                }
                if(data.getText() != null && data.getText().toString().length() != 0){
                    errDa = true;
                    //possibile controllo per l'eta
                }
                if(user.getText() != null && user.getText().toString().length() != 0){
                    errUs = true;
                }
                if(pass.getText() != null && pass.getText().toString().length() >= num_car){
                    errPa = true;
                }

                if(errUs && errPa){
                    //pass non vuote e user non vuoto e rispettano il limite di lunghezza (non per gli utenti di debug)
                    if(pass.getText().toString().equals(pass2.getText().toString())){
                        //pass uguali
                        for (Utente u : MainActivity.utenti)
                        {
                            //controllo utente
                            if(u.getUsername().equals(user.getText().toString())){
                                errUser = false;
                            }
                        }
                    }
                    else{
                        errPass = false;
                    }
                }
                if(errUs){
                    user.setError("Username non può essere vuoto");
                }
                if(errPa){
                    pass.setError("Password deve essere di almeno " + num_car + " caratteri");
                }
                if(errPass && errUser && errCi && errDa){
                    Utente tmp = new Utente(user.getText().toString(), pass.getText().toString(), data.getText().toString(), citta.getText().toString());
                    MainActivity.utenti.add(tmp);
                    Intent back = new Intent(Registrati_Activity.this, MainActivity.class);
                    Log.d("utenti", " " + tmp.getUsername());
                    startActivity(back);
                }
                else{
                    if(!errPass){
                        pass2.setError("Le password devono coincidere");
                    }
                    if(!errUser){
                        user.setError("Username già esistente");
                    }
                    if(!errCi){
                        citta.setError("Inserisci la citta");
                    }
                    if(!errDa){
                        data.setError("Inserisci la data");
                    }
                }
            }

        });

        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

        data.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    showDialog();
                }
            }
        });


    }

    public void doPositiveClick(Calendar date) {
        // Do stuff here.
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");
        data.setText(format.format(date.getTime())); //10/10/2020
    }

    public void doNegativeClick() {
        // Do stuff here.
    }

    void showDialog() {
        DialogFragment newFragment = DatePickerFragment.newInstance();
        newFragment.show(getSupportFragmentManager(), "dialog");
    }
}
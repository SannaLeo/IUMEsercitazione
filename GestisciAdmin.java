package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.GetChars;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class GestisciAdmin extends AppCompatActivity {


    public Button home;
    public TextView err;
    CharSequence queryF;
    ArrayList<String> mArrData;
    SchoolAdapter mAdapter;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestisci_admin);
        ListView mListview;
        err = findViewById(R.id.errore);
        mListview = (ListView) findViewById(R.id.listSchool);
        home = findViewById(R.id.home);
        searchView = (SearchView) findViewById(R.id.searchview);
        // Set some data to array list
        mArrData = getUsers();

        // Initialize adapter and set adapter to list view
        mAdapter = new SchoolAdapter(GestisciAdmin.this, mArrData);
        mListview.setAdapter(mAdapter);

        //onclick listener
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(GestisciAdmin.this, Home.class);
                startActivity(back);
            }
        });
        searchView.setQueryHint("Cerca un utente");
        queryF = searchView.getQuery();
        searchView.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    //
                }
            }
        });


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d("searchview", " searchview submit");
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText.length() != 0){
                    mArrData = getUsersByPattern(newText);
                }
                else{
                    mArrData = getUsers();
                    searchView.setBackgroundColor(Color.WHITE);
                    err.setVisibility(View.GONE);
                }
                mAdapter = new SchoolAdapter(GestisciAdmin.this, mArrData);
                mListview.setAdapter(mAdapter);
                return false;
            }
        });

    }

    public ArrayList<String> getUsers(){
        ArrayList<String> tmp = new ArrayList<>();
        for (Utente u : MainActivity.utenti) {
            tmp.add(u.getUsername());
        }
        return tmp;
    }

    public ArrayList<String> getUsersByPattern(String query){
        ArrayList<String> tmp = new ArrayList<>();
        int found = 0;
        for (Utente u : MainActivity.utenti) {
            if(u.getUsername().contains(query)){
                tmp.add(u.getUsername());
                found++;
            }
        }
        if(found == 0){
            searchView.setBackgroundColor(Color.parseColor("#ff6666"));
            err.setVisibility(View.VISIBLE);
        }
        else{
            searchView.setBackgroundColor(Color.WHITE);
            err.setVisibility(View.GONE);
        }
        return tmp;
    }
}
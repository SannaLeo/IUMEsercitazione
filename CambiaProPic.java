package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class CambiaProPic extends AppCompatActivity {

    public Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambia_pro_pic);
        GridView mListview;
        btn = findViewById(R.id.home);
        mListview = findViewById(R.id.gridview);
        ArrayList<Integer> mArrData = new ArrayList<>();
        mArrData.add(0);
        mArrData.add(1);
        mArrData.add(2);
        mArrData.add(3);
        mArrData.add(4);
        GridAdapter mAdapter;

        mAdapter = new GridAdapter(CambiaProPic.this, mArrData);
        mListview.setAdapter(mAdapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(CambiaProPic.this, Home.class);
                startActivity(home);
            }
        });
    }
}
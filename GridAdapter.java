package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

public class GridAdapter extends ArrayAdapter<Integer> {

    private Context mContext;
    private ArrayList<Integer> mArrSchoolData;


    public GridAdapter(Context context, ArrayList<Integer> arrSchoolData) {
        super(context, R.layout.view_listview_row, arrSchoolData);
        mContext = context;
        mArrSchoolData = arrSchoolData;
    }

    public int getCount() {
        // return the number of records
        return mArrSchoolData.size();
    }

    // getView method is called for each item of ListView
    public View getView(int position, View view, ViewGroup parent) {
        // inflate the layout for each item of listView
        View rview = view;

        rview = LayoutInflater.from(mContext).inflate(R.layout.layout_griditem, parent, false);
        /*
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        rview = inflater.inflate(R.layout.layout_griditem, parent, false);

         */
        Log.d("utenti", "entra in grid" + position);
        // get the reference of the image
        ImageView img_select;
        TextView img_imp, img_inf;
        img_select = (ImageView)rview.findViewById(R.id.profilepic);
        img_imp = (TextView) rview.findViewById(R.id.img_impo);
        img_inf = (TextView) rview.findViewById(R.id.inf);
        img_imp.setVisibility(View.INVISIBLE);
        switch (position){
            case 0:
                img_select.setImageResource(R.drawable.propic);
                img_inf.setText("Immagine di base");
                break;
            case 1:
                img_select.setImageResource(R.drawable.beard);
                img_inf.setText("Con barba");
                break;
            case 2:
                img_select.setImageResource(R.drawable.chef);
                img_inf.setText("Chef");
                break;
            case 3:
                img_select.setImageResource(R.drawable.chef_);
                img_inf.setText("Chef");
                break;
            case 4:
                img_select.setImageResource(R.drawable.farmer);
                img_inf.setText("Agricoltore");
                break;

            default:
                Log.d("utenti", "errore grid view");
        }

        img_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.utenti.get(position).setImage(position);
                MainActivity.loggato.setImage(position);
                img_imp.setVisibility(View.VISIBLE);
            }
        });
        return rview;
    }
}

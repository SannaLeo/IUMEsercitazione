package com.example.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

public class SchoolAdapter extends ArrayAdapter<String> {

    private Context mContext;
    private ArrayList<String> mArrSchoolData;
    static public Utente tmp = null;

    public SchoolAdapter(Context context, ArrayList<String> arrSchoolData) {
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
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        rview = inflater.inflate(R.layout.view_listview_row, parent, false);

        // get the reference of textView and button
        TextView txtSchoolTitle = (TextView) rview.findViewById(R.id.txtSchoolTitle);
        Button btnAction = (Button) rview.findViewById(R.id.btnAction);
        ImageView profilepic = (ImageView) rview.findViewById(R.id.profilepic);

        // Set the title and button name and color different cases
        txtSchoolTitle.setText(mArrSchoolData.get(position));
        Log.d("utenti", "item list view");
        btnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.utenti.get(position).setAdmin(true);
                btnAction.setText("Già Admin");
                btnAction.setBackgroundColor(Color.parseColor("#a1afa1"));
            }
        });

        if(MainActivity.utenti.get(position).isAdmin()){
            btnAction.setText("Già Admin");
            btnAction.setBackgroundColor(Color.parseColor("#a1afa1"));
        }

        else{
            btnAction.setText("Rendi Admin");
            btnAction.setBackgroundColor(Color.parseColor("#5bc85b"));
        }

        //get image
        switch (MainActivity.utenti.get(position).getImage()){
            case 1:
                profilepic.setImageResource(R.drawable.beard);
                break;
            case 2:
                profilepic.setImageResource(R.drawable.chef);
                break;
            case 3:
                profilepic.setImageResource(R.drawable.chef_);
                break;
            case 4:
                profilepic.setImageResource(R.drawable.farmer);
                break;
            default:
                profilepic.setImageResource(R.drawable.propic);
        }
        // Click listener of button
        return rview;
    }
}

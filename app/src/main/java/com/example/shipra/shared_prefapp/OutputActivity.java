package com.example.shipra.shared_prefapp;



import android.app.Activity;


import android.content.Context;


import android.content.SharedPreferences;


import android.os.Bundle;


import android.widget.TextView;

public class OutputActivity extends Activity{



    private SharedPreferences prefsPrivate;

    private SharedPreferences prefsWorldRead;

    private SharedPreferences prefsWorldWrite;

    private SharedPreferences prefsWorldReadWrite;








    @Override


    protected void onCreate(Bundle savedInstanceState)


    {


        super.onCreate(savedInstanceState);





        //Set the view for this activity to output.xml


        setContentView(R.layout.output);





        // Get hold of sharedPreferences


        prefsPrivate = getSharedPreferences(MainActivity.PREFS_PRIVATE, Context.MODE_PRIVATE);


        prefsWorldRead = getSharedPreferences(MainActivity.PREFS_WORLD_READ, Context.MODE_PRIVATE);


        prefsWorldWrite = getSharedPreferences(MainActivity.PREFS_WORLD_WRITE, Context.MODE_PRIVATE);


        prefsWorldReadWrite = getSharedPreferences(MainActivity.PREFS_WORLD_READ_WRITE, Context.MODE_PRIVATE);





        //Get hold of output textview - to display values


        TextView privateTxt = (TextView) findViewById(R.id.privateTxt);


        TextView readTxt = (TextView) findViewById(R.id.readTxt);


        TextView writeTxt = (TextView) findViewById(R.id.writeTxt);


        TextView readWriteTxt = (TextView) findViewById(R.id.readWriteTxt);








        // Set values form sharedPreferences to the textViews


        privateTxt.setText(prefsPrivate.getString(MainActivity.KEY_PRIVATE, "NA"));


        readTxt.setText(prefsWorldRead.getString(MainActivity.KEY_WORLD_READ, "NA"));


        writeTxt.setText(prefsWorldWrite.getString(MainActivity.KEY_WORLD_WRITE, "NA"));


        readWriteTxt.setText(prefsWorldReadWrite.getString(MainActivity.KEY_WORLD_READ_WRITE, "NA"));








    }


}



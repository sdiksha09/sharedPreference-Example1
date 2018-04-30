package com.example.shipra.shared_prefapp;

import android.app.Activity;

import android.content.Context;

import android.content.Intent;

import android.content.SharedPreferences;

import android.content.SharedPreferences.Editor;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.widget.Button;

import android.widget.EditText;





/**

 *

 *  Activity class which demos the use of sharedPreferences for sharing data among different Activities

 *

 * @author Akshat

 *

 */

public class MainActivity extends AppCompatActivity

{





    public static final String PREFS_PRIVATE = "PREFS_PRIVATE";

    public static final String PREFS_WORLD_READ = "PREFS_WORLD_READABLE";

    public static final String PREFS_WORLD_WRITE = "PREFS_WORLD_WRITABLE";

    public static final String PREFS_WORLD_READ_WRITE = "PREFS_WORLD_READABLE_WRITABLE";

    public static final String KEY_PRIVATE = "KEY_PRIVATE";

    public static final String KEY_WORLD_READ = "KEY_WORLD_READ";

    public static final String KEY_WORLD_WRITE = "KEY_WORLD_WRITE";

    public static final String KEY_WORLD_READ_WRITE = "KEY_WORLD_READ_WRITE";





    private SharedPreferences prefsPrivate;

    private SharedPreferences prefsWorldRead;

    private SharedPreferences prefsWorldWrite;

    private SharedPreferences prefsWorldReadWrite;









    /** Called when the activity is first created. */

    @Override

    public void onCreate(Bundle savedInstanceState)

    {

        super.onCreate(savedInstanceState);



        //Set the view for this activity to main.xml

        setContentView(R.layout.activity_main);



        //Get hold of the submit button

        Button button = (Button) findViewById(R.id.buttonID);



        //Listener added to the submit button

        button.setOnClickListener(new Button.OnClickListener(){



            @Override

            public void onClick(final View v)

            {



                //Get the input values

                EditText valueOneTxt = (EditText) findViewById(R.id.valueOne);

                EditText valueTwoTxt = (EditText) findViewById(R.id.valueTwo);

                EditText valueThreeTxt = (EditText) findViewById(R.id.valueThree);

                EditText valueFourTxt = (EditText) findViewById(R.id.valueFour);





                // Create shared sharedPreferences

                // We created four different sharedPreferences with different modes

                prefsPrivate = getSharedPreferences(MainActivity.PREFS_PRIVATE, Context.MODE_PRIVATE);

                prefsWorldRead = getSharedPreferences(MainActivity.PREFS_WORLD_READ, Context.MODE_PRIVATE);

                prefsWorldWrite = getSharedPreferences(MainActivity.PREFS_WORLD_WRITE, Context.MODE_PRIVATE);

                prefsWorldReadWrite = getSharedPreferences(MainActivity.PREFS_WORLD_READ_WRITE, Context.MODE_PRIVATE);





                // To add values to the sharedPreferences, we get editors from the sharedPreferences

                Editor privateEdit = prefsPrivate.edit();

                Editor worldReadEdit = prefsWorldRead.edit();

                Editor worldWriteEdit = prefsWorldWrite.edit();

                Editor worldReadWriteEdit = prefsWorldReadWrite.edit();




                // With the Editor you can set String, boolean, float, int, and long types as key/value pairs

                // We save the four input values into the four different sharedPreferences

                privateEdit.putString(MainActivity.KEY_PRIVATE, valueOneTxt.getText().toString());

                worldReadEdit.putString(MainActivity.KEY_WORLD_READ, valueTwoTxt.getText().toString());

                worldWriteEdit.putString(MainActivity.KEY_WORLD_WRITE, valueThreeTxt.getText().toString());

                worldReadWriteEdit.putString(MainActivity.KEY_WORLD_READ_WRITE, valueFourTxt.getText().toString());



                //Commit the sharedPreferences into a file

                privateEdit.commit();

                worldReadEdit.commit();

                worldWriteEdit.commit();

                worldReadWriteEdit.commit();



                //Start another activity by passing an explicit intent

                Intent intent = new Intent(MainActivity.this, OutputActivity.class);

                startActivity(intent);

            }



        });


    }
}


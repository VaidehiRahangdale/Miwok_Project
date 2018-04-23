/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        //Find the view that shows number category
        TextView numbers = (TextView) findViewById(R.id.numbers);

        //Set a ClickListener on that view
        numbers.setOnClickListener(new View.OnClickListener() {

            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                //Create a new intent to open the number activity
                Intent numbersIntent = new Intent(MainActivity.this, NumbersActivity.class);
                //Start the new activity
                startActivity(numbersIntent);
            }
        });

        //Find the view that shows family category
        TextView family = (TextView) findViewById(R.id.family);

        //Set a ClickListener on that view
        family.setOnClickListener(new View.OnClickListener() {

            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                //Create a new intent to open the number activity
                Intent familyIntent = new Intent(MainActivity.this, FamilyMembersActivity.class);
                //Start the new activity
                startActivity(familyIntent);
            }
        });

        //Find the view that shows colors category
        TextView colors = (TextView) findViewById(R.id.colors);

        //Set a ClickListener on that view
        colors.setOnClickListener(new View.OnClickListener() {

            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                //Create a new intent to open the number activity
                Intent colorsIntent = new Intent(MainActivity.this, ColorsActivity.class);
                //Start the new activity
                startActivity(colorsIntent);
            }
        });

        //Find the view that shows phrases category
        TextView phrases = (TextView) findViewById(R.id.phrases);

        //Set a ClickListener on that view
        phrases.setOnClickListener(new View.OnClickListener() {

            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                //Create a new intent to open the number activity
                Intent phrasesIntent = new Intent(MainActivity.this, PhrasesActivity.class);
                //Start the new activity
                startActivity(phrasesIntent);
            }
        });
    }

        public void openNumberList(View view){
            Intent i = new Intent(this, NumbersActivity.class);
            startActivity(i);
    }

        public void openFamilyList(View view){
        Intent j = new Intent(this, FamilyMembersActivity.class);
        startActivity(j);
    }

        public void openColorsList(View view){
        Intent k = new Intent(this, ColorsActivity.class);
        startActivity(k);
    }

        public void openPhrasesList(View view){
        Intent l = new Intent(this, PhrasesActivity.class);
        startActivity(l);
    }
}

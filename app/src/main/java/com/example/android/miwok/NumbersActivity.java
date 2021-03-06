package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        /**Create an array
        ArrayList<String> words = new ArrayList<String>();
        words.add("one");
        words.add("two");
        words.add("three");
        words.add("four");
        words.add("five");
        words.add("six");
        words.add("seven");
        words.add("eight");
        words.add("nine");
        words.add("ten");**/

        //create a list of word
        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("one","lutti",R.drawable.number_one, R.raw.number_one));
        words.add(new Word("two","otiiko",R.drawable.number_two, R.raw.number_two));
        words.add(new Word("three","tolookosu",R.drawable.number_three, R.raw.number_three));
        words.add(new Word("four","oyyisa",R.drawable.number_four, R.raw.number_four));
        words.add(new Word("five","massokka",R.drawable.number_five, R.raw.number_five));
        words.add(new Word("six","timmokka",R.drawable.number_six, R.raw.number_six));
        words.add(new Word("seven","kenekaku",R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("eight","kawinta",R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("nine","wo'e",R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("ten","na'aacha",R.drawable.number_ten, R.raw.number_ten));

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        WordAdapter adapter =
                new WordAdapter(this, words,R.color.category_numbers);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_numbers.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //find out which word is getting clicked on and store that in a variable
                Word word = words.get(position);
                //Release the media player if it currently exists, so that we can play a different audio file
                releaseMediaPlayer();
                //once we get the word, we can get it's audio Resourse id and pass that to the media player
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this,word.getAudioResourceId());
                //Toast.makeText(NumbersActivity. this,"List item Clicked", Toast.LENGTH_SHORT);
                //mMediaPlayer = MediaPlayer.create(NumbersActivity.this,R.raw.number_one);
                mMediaPlayer.start();
                //set up a listener on media play.stop or release the media player once the sound is stopped.
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }

    protected void onStop(){
        //stop audio and release media player even if we suddenly exit from the app
        super.onStop();
        releaseMediaPlayer();
    }

        /**
         * Clean up the media player by releasing its resources.
         */
        private void releaseMediaPlayer() {
            // If the media player is not null, then it may be currently playing a sound.
            if (mMediaPlayer != null) {
                // Regardless of the current state of the media player, release its resources
                // because we no longer need it.
                mMediaPlayer.release();

                // Set the media player back to null. For our code, we've decided that
                // setting the media player to null is an easy way to tell that the media player
                // is not configured to play an audio file at the moment.
                // Test comment
                mMediaPlayer = null;
            }



        //Verify the contents of ArrayList by printing log messages
        //Log.i("NumbersActivity","words on index 0 is:" + words.get(0));
        //Log.i("NumbersActivity","words on index 1 is:" + words.get(1));

        /**typecasted in LinearLayout and returned view is stored in rootView variable of type LinearLayout
        LinearLayout rootView = (LinearLayout)findViewById(R.id.rootView);
            int index = 0;
            while(index < words.size()) {
                //create a TextView object which is stored in wordView(childView) and datatype is TextView
                TextView wordView = new TextView(this);
                //to change the text, setText method is called on 1st element of ArrayList
                wordView.setText(words.get(index));
                //add view as a child to the parent view called rootview
                rootView.addView(wordView);
                index++;
            }
         //If not using loops, We can define a local variable with the same name only once within the same scope.So use wordView2
        //TextView wordView2 = new TextView(this);
        //wordView2.setText(words.get(1));
        //rootView.addView(wordView2);**/

    }
}

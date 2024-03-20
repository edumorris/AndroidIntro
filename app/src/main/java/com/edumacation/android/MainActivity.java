package com.edumacation.android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText userInputText;
    private TextView txtView;
    private int numOfTimesClicked = 0;
    private static final String TAG = "MainActivity";
    private final String TEXT_CONTENTS = "TextContents";

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart: in");
        super.onStart();
        Log.d(TAG, "onStart: out");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        Log.d(TAG, "onRestoreInstanceState: in");
        super.onRestoreInstanceState(savedInstanceState);
//        String savedString = savedInstanceState.getString(TEXT_CONTENTS);
//        txtView.setText(savedString);
        txtView.setText(savedInstanceState.getString(TEXT_CONTENTS));
        Log.d(TAG, "onRestoreInstanceState: out");
    }

    @Override
    protected void onRestart() {
        Log.d(TAG, "onRestart: in");
        super.onRestart();
        Log.d(TAG, "onRestart: out");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d(TAG, "onSaveInstanceState: in");
        outState.putString(TEXT_CONTENTS, txtView.getText().toString()); // Needs to be before the super() method
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: out");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: in");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button_click_counter);

        userInputText = (EditText) findViewById(R.id.editTextText);
        userInputText.setText("");
        Button btn = (Button) findViewById(R.id.button4);
        txtView = (TextView) findViewById(R.id.textView3);
        txtView.setText(""); // Clear text in TextView widget
        txtView.setMovementMethod(new ScrollingMovementMethod()); // Add scrolling to TextView

        View.OnClickListener ourOnClickListener = view -> {
//            numOfTimesClicked += 1;
//            String result = "The button got tapped " + numOfTimesClicked + (numOfTimesClicked != 1 ? " times.\n" : " time.\n");
//            txtView.append(result);

            String input = userInputText.getText().toString() + "\n";
            txtView.append(input);

        };

        btn.setOnClickListener(ourOnClickListener);
        Log.d(TAG, "onCreate: out");


    }


}
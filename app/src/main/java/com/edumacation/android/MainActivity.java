package com.edumacation.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText userInputText;
    private TextView txtView;
    private int numOfTimesClicked = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button_click_counter);

        userInputText = (EditText) findViewById(R.id.editTextText);
        userInputText.setText("");
        Button btn = (Button) findViewById(R.id.button4);
        txtView = (TextView) findViewById(R.id.textView3);
        txtView.setText(""); // Clear text in TextView widget
        txtView.setMovementMethod(new ScrollingMovementMethod()); // Add scrolling to TextView
        // Added `gravity bottom` to text view, all view is maintained to new line

        View.OnClickListener ourOnClickListener = view -> {
//            numOfTimesClicked += 1;
//            String result = "The button got tapped " + numOfTimesClicked + (numOfTimesClicked != 1 ? " times.\n" : " time.\n");
//            txtView.append(result);

            String input = userInputText.getText().toString() + "\n";
            txtView.append(input);

        };

        btn.setOnClickListener(ourOnClickListener);
    }
}
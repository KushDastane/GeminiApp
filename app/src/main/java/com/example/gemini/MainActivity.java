package com.example.gemini;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText userInput;
    private Button actionButton;
    private Button clearButton;
    private TextView resultText;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInput = findViewById(R.id.user_input);
        actionButton = findViewById(R.id.action_button);
        clearButton = findViewById(R.id.clear_button);
        resultText = findViewById(R.id.result_text);
        scrollView = findViewById(R.id.scrollView);

        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = userInput.getText().toString().trim();
                int wordCount = countWords(input);
                resultText.setText("Word count: " + wordCount);
                // Scroll to the result text
                scrollView.post(() -> scrollView.smoothScrollTo(0, resultText.getBottom()));
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInput.setText(""); // Clear the input field
                resultText.setText("Results will be displayed here"); // Optionally reset result text
                // Scroll back to the top (input field)
                scrollView.post(() -> scrollView.fullScroll(ScrollView.FOCUS_UP));
            }
        });
    }

    private int countWords(String text) {
        if (text.isEmpty()) {
            return 0;
        }
        String[] words = text.split("\\s+");
        return words.length;
    }
}

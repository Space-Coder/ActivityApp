package com.example.activityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int SECOND_ACTIVITY_REQUEST_CODE = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void QuestionButton_Click(View view) {
        EditText editText = (EditText)findViewById(R.id.questionEditText);
        String text = new String();
        text = editText.getText().toString();

        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("question", text);
        startActivityForResult(intent, SECOND_ACTIVITY_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SECOND_ACTIVITY_REQUEST_CODE)
        {
            if (resultCode == RESULT_OK)
            {
                Bundle arguments = data.getExtras();
                String answerStr = arguments.get("answer").toString();
                TextView answerTextView = (TextView) findViewById(R.id.answerTextView);
                answerTextView.setText(answerStr);
            }
        }
    }
}
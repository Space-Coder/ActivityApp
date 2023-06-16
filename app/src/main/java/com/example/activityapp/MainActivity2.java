package com.example.activityapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle arguments =  getIntent().getExtras();
        String questionStr = arguments.get("question").toString();

        TextView questionTextView = (TextView) findViewById(R.id.questionTextView);
        questionTextView.setText(questionStr);
    }

    public void AnswerButton_Click(View view) {
        EditText answerEditText = (EditText) findViewById(R.id.answerEditText);
        String answerStr = answerEditText.getText().toString();

        Intent intent = new Intent();
        intent.putExtra("answer", answerStr);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
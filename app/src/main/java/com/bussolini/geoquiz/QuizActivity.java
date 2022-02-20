package com.bussolini.geoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private Button trueButton;
    private Button falseButton;
    private int count = 0;

    private Boolean[] answers = {
            false, true, false, true, true, false, true, false, true, true
    };

    protected boolean checkResponse(boolean answer, int count){
        boolean response = false;

        if (answers[count].equals(answer))
            response = true;

        return response;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();

        TextView question = (TextView) findViewById(R.id.text_question);

        String[] questions = {
                getString(R.string.question_text1),
                getString(R.string.question_text2),
                getString(R.string.question_text3),
                getString(R.string.question_text4),
                getString(R.string.question_text5),
                getString(R.string.question_text6),
                getString(R.string.question_text7),
                getString(R.string.question_text8),
                getString(R.string.question_text9),
                getString(R.string.question_text10)
        };

        trueButton = (Button) findViewById(R.id.true_button);

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (count < 9) {

                    if (checkResponse(true, count)) {
                        Toast.makeText(QuizActivity.this,
                                R.string.correct_toast,
                                Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(QuizActivity.this,
                                R.string.incorrect_toast,
                                Toast.LENGTH_SHORT).show();
                    }

                    count++;
                    question.setText(questions[count]);
                }

                else if (count == 9){
                    question.setText(getString(R.string.question_text11));
                    trueButton.setText(getString(R.string.yes_button));
                    falseButton.setText(getString(R.string.no_button));
                    count ++;
                }

                else{
                    count = 0;
                    trueButton.setText(getString(R.string.true_button));
                    falseButton.setText(getString(R.string.false_button));
                    question.setText(questions[count]);
                }
            }
        });

        falseButton = (Button) findViewById(R.id.false_button);

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (count < 9) {

                    if (checkResponse(false, count)) {
                        Toast.makeText(QuizActivity.this,
                                R.string.correct_toast,
                                Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(QuizActivity.this,
                                R.string.incorrect_toast,
                                Toast.LENGTH_SHORT).show();
                    }

                    count++;
                    question.setText(questions[count]);
                }

                else if (count == 9){
                    question.setText(getString(R.string.question_text11));
                    trueButton.setText(getString(R.string.yes_button));
                    falseButton.setText(getString(R.string.no_button));
                    count ++;
                }

                else
                    finish();

            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
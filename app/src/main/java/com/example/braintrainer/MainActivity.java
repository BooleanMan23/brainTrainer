package com.example.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView scoreTextView;
    TextView timeTextView;
    TextView trueFalseTextView;
    TextView questionTextView;
    Button  answer1Button;
    Button answer2Button;
    Button answer3Button;
    Button answer4Button;

    int hasil;
    int score = 0;

    boolean start = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreTextView = (TextView) findViewById(R.id.scoreTextView);
        timeTextView = (TextView) findViewById(R.id.timeTextView);
        trueFalseTextView = (TextView) findViewById(R.id.trueFalseTextView);
        questionTextView = (TextView) findViewById(R.id.askTextView);

        answer1Button = (Button) findViewById(R.id.answer1Button);
        answer2Button = (Button) findViewById(R.id.answer2Button);
        answer3Button = (Button) findViewById(R.id.answer3Button);
        answer4Button = (Button) findViewById(R.id.answer4Button);


        questionTextView.setVisibility(View.INVISIBLE);
        scoreTextView.setVisibility(View.INVISIBLE);
        timeTextView.setVisibility(View.INVISIBLE);
        trueFalseTextView.setVisibility(View.INVISIBLE);
        answer1Button.setVisibility(View.INVISIBLE);
        answer2Button.setVisibility(View.INVISIBLE);
        answer3Button.setVisibility(View.INVISIBLE);
        answer4Button.setVisibility(View.INVISIBLE);




    }


    public void startGame(View view){
        final Button startButton  = (Button) findViewById(R.id.startButton);
        score = 0;
        scoreTextView.setText("0");

            startButton.setVisibility(View.GONE);
            start = true;

            questionTextView.setVisibility(View.VISIBLE);
            scoreTextView.setVisibility(View.VISIBLE);
            timeTextView.setVisibility(View.VISIBLE);
            trueFalseTextView.setVisibility(View.VISIBLE);
            answer1Button.setVisibility(View.VISIBLE);
            answer2Button.setVisibility(View.VISIBLE);
            answer3Button.setVisibility(View.VISIBLE);
            answer4Button.setVisibility(View.VISIBLE);
            generateQuestion();


        new CountDownTimer(30000, 1000 ){

            public  void  onTick(long milisecondUntilDone){

                timeTextView.setText(String.valueOf(milisecondUntilDone/1000));


            }
            public void onFinish(){
                answer1Button.setVisibility(View.INVISIBLE);
                answer2Button.setVisibility(View.INVISIBLE);
                answer3Button.setVisibility(View.INVISIBLE);
                answer4Button.setVisibility(View.INVISIBLE);
                questionTextView.setText("Score Anda adalah = "+score);
                timeTextView.setVisibility(View.INVISIBLE);
                scoreTextView.setVisibility(View.INVISIBLE);
             trueFalseTextView.setVisibility(View.INVISIBLE);
             startButton.setVisibility(View.VISIBLE);
            }

        }.start();



    }

    public void answering(View view){
        Button answer = (Button) view;
        String jawab = answer.getText().toString();
        int intJawab = Integer.parseInt(jawab);
        if(intJawab == hasil){
             score = score+1;
             trueFalseTextView.setText("BENAR!");
             generateQuestion();
        }
        else{
            trueFalseTextView.setText("SALAH!");
        }
        scoreTextView.setText(String.valueOf(score));


    }

    public void generateQuestion(){
        int digit1 = randomWithRange(1,10);
        int digit2 = randomWithRange(1,10);
        questionTextView.setText(String.valueOf(digit1) + " + " + String.valueOf(digit2) + " = ");
        hasil = digit1+digit2;
        //memasukan hasil kedalam button
        int randomNumberForButton = randomWithRange(1,4);
        if(randomNumberForButton == 1){
            answer1Button.setText(String.valueOf(hasil));
            answer2Button.setText(String.valueOf(hasil+1));
            answer3Button.setText(String.valueOf(hasil+2));
            answer4Button.setText(String.valueOf(hasil-1));
        }
        else if(randomNumberForButton == 2){
            answer1Button.setText(String.valueOf(hasil+1));
            answer2Button.setText(String.valueOf(hasil));
            answer3Button.setText(String.valueOf(hasil+2));
            answer4Button.setText(String.valueOf(hasil-1));
        }
        else if(randomNumberForButton == 3){
            answer1Button.setText(String.valueOf(hasil+1));
            answer2Button.setText(String.valueOf(hasil+2));
            answer3Button.setText(String.valueOf(hasil));
            answer4Button.setText(String.valueOf(hasil-1));
        }
        else if(randomNumberForButton == 4){
            answer1Button.setText(String.valueOf(hasil+1));
            answer2Button.setText(String.valueOf(hasil+2));
            answer3Button.setText(String.valueOf(hasil-1));
            answer4Button.setText(String.valueOf(hasil));
        }

    }

    public int randomWithRange(int min, int max)
    {
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }


}

package com.example.android.scorekeeperbaseball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int runHome = 0;
    int runVisitor = 0;
    int inning = 0;
    int outHome = 0;
    int outVisitor = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayForHome(int score) {
        TextView scoreView = (TextView) findViewById(R.id.runsHome);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForVisitor(int score) {
        TextView scoreView = (TextView) findViewById(R.id.runsVisitor);
        scoreView.setText(String.valueOf(score));
    }

    public void resetAll(View view) {
        runHome = 0;
        runVisitor = 0;
        displayForHome(runHome);
        displayForVisitor(runVisitor);
    }

    public void runScoreHome(View view) {
        runHome += 1;
        displayForHome(runHome);
    }

    public void runScoreVisitor(View view) {
        runVisitor += 1;
        displayForVisitor(runVisitor);
    }


}

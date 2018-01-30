package com.example.android.scorekeeperbaseball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int runHome = 0;
    int runVisitor = 0;
    int inning = 1;
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

    public void displayForHomeOuts(int score) {
        TextView scoreView = (TextView) findViewById(R.id.outsHome);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForVisitorOuts(int score) {
        TextView scoreView = (TextView) findViewById(R.id.outsVisitor);
        scoreView.setText(String.valueOf(score));
    }

    public void displayInning(int inning) {
        TextView scoreView = (TextView) findViewById(R.id.inning);
        scoreView.setText(String.valueOf(inning));
    }

    public void resetAll(View view) {
        outHome = 0;
        outVisitor = 0;
        runHome = 0;
        runVisitor = 0;
        inning = 1;
        displayForHome(runHome);
        displayForVisitor(runVisitor);
        displayForHomeOuts(outHome);
        displayForVisitorOuts(outVisitor);
        displayInning(inning);
    }

    public void runScoreHome(View view) {
        runHome += 1;
        displayForHome(runHome);
    }

    public void runScoreVisitor(View view) {
        runVisitor += 1;
        displayForVisitor(runVisitor);
    }

    /**
     * initial state of game inning = 1
     * first team gets three outs
     * second team gets three outs
     * inning increase by 1
     * outs reset to 0
     * display inning and outs for each team
     * If inning is greater than 9
     * display Extra innings
     */
    public void outsHome(View view) {
        if (outHome == 3 && outVisitor == 3) {
            if (inning < 9) {
                inning += 1;
                outHome = 0;
                outVisitor = 0;
                displayForHomeOuts(outHome);
                displayForVisitorOuts(outVisitor);
            } else {
                displayInning(inning);
            }
            displayInning(inning);
        } else {
            outHome += 1;
            displayForHomeOuts(outHome);
        }


    }

    public void outsVisitor(View view) {
        if (outHome == 3 && outVisitor == 3) {
            if (inning < 9) {
                inning += 1;
                outHome = 0;
                outVisitor = 0;
                displayForHomeOuts(outHome);
                displayForVisitorOuts(outVisitor);
            } else {
                displayInning(inning);
            }
            displayInning(inning);
        } else {
            outVisitor += 1;
            displayForVisitorOuts(outVisitor);
        }
    }

}

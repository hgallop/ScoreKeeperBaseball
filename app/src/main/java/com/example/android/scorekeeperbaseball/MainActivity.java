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

    /**
     * Displays home team score
     */
    public void displayForHome(int score) {
        TextView scoreView = (TextView) findViewById(R.id.runsHome);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays visiting team scoew
     */
    public void displayForVisitor(int score) {
        TextView scoreView = (TextView) findViewById(R.id.runsVisitor);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays home team outs
     */
    public void displayForHomeOuts(int score) {
        TextView scoreView = (TextView) findViewById(R.id.outsHome);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays visiting team outs
     */
    public void displayForVisitorOuts(int score) {
        TextView scoreView = (TextView) findViewById(R.id.outsVisitor);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays inning
     */
    public void displayInning(int inning) {
        TextView scoreView = (TextView) findViewById(R.id.inning);
        scoreView.setText(String.valueOf(inning));
    }

    /**
     * Resets all values to default
     */
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

    /**
     * Calculates and displays home team run on button click
     */
    public void runScoreHome(View view) {
        runHome += 1;
        displayForHome(runHome);
    }

    /**
     * Calculates and displays visiting team run on button click
     */
    public void runScoreVisitor(View view) {
        runVisitor += 1;
        displayForVisitor(runVisitor);
    }

    /**
     * Calculates and displays home team grandslam on button click
     */
    public void grandSlamHome(View view) {
        runHome += 4;
        displayForHome(runHome);
    }

    /**
     * Calculates and displays visiting team grandslam on button click
     */
    public void grandSlamVisitor(View view) {
        runVisitor += 4;
        displayForVisitor(runVisitor);
    }

    /**
     * Calculates and displays home team outs. Control and display inning
     */
    public void outsHome(View view) {
        if (outHome < 3) {
            outHome += 1;
        }
        displayForHomeOuts(outHome);
        if (outHome == 3 && outVisitor == 3 && inning < 9) {
            outHome = 0;
            outVisitor = 0;
            inning += 1;
            displayForHomeOuts(outHome);
            displayForVisitorOuts(outVisitor);
            displayInning(inning);
        }
        if (inning == 9 && runHome == runVisitor) {
            outHome = 0;
            outVisitor = 0;
            inning += 1;
            if (inning >= 10) {
                inning = 10;
            }
            displayForHomeOuts(outHome);
            displayForVisitorOuts(outVisitor);
            displayInning(inning);
        }

    }

    /**
     * Calculates and displays visiting team outs. Control and display inning
     */
    public void outsVisitor(View view) {
        if (outVisitor < 3) {
            outVisitor += 1;
        }
        displayForVisitorOuts(outVisitor);
        if (outHome == 3 && outVisitor == 3 && inning < 9) {
            outHome = 0;
            outVisitor = 0;
            inning += 1;
            displayForHomeOuts(outHome);
            displayForVisitorOuts(outVisitor);
            displayInning(inning);
        }
        if (inning == 9 && runHome == runVisitor) {
            outHome = 0;
            outVisitor = 0;
            inning += 1;
            if (inning >= 10) {
                inning = 10;
            }
            displayForHomeOuts(outHome);
            displayForVisitorOuts(outVisitor);
            displayInning(inning);
        }

    }

}

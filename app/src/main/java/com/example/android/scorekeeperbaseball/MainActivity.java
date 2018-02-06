package com.example.android.scorekeeperbaseball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int runHome = 0;
    int runVisitor = 0;
    int inning = 1;
    int outHome = 0;
    int outVisitor = 0;

    private TextView runsForHome;
    private TextView runsForVisitor;
    private TextView outsForHome;
    private TextView outsForVisitor;
    private TextView inningDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initializes all text views in one call
        runsForHome = findViewById(R.id.runsHome);
        runsForVisitor = findViewById(R.id.runsVisitor);
        outsForHome = findViewById(R.id.outsHome);
        outsForVisitor = findViewById(R.id.outsVisitor);
        inningDisplay = findViewById(R.id.inning);
    }

    /** Saves app data between states */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("runHome", runHome);
        outState.putInt("runVisitor", runVisitor);
        outState.putInt("outHome", outHome);
        outState.putInt("outVisitor", outVisitor);
        outState.putInt("inning", inning);
    }

    /** Restores app data on new state */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        runHome = savedInstanceState.getInt("runHome");
        runVisitor = savedInstanceState.getInt("runVisitor");
        outHome = savedInstanceState.getInt("outHome");
        outVisitor = savedInstanceState.getInt("outVisitor");
        inning = savedInstanceState.getInt("inning");
    }

    /**
     * Displays home team score
     */
    public void displayForHome(int score) {
        TextView scoreView = runsForHome;
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays visiting team scoew
     */
    public void displayForVisitor(int score) {
        TextView scoreView = runsForVisitor;
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays home team outs
     */
    public void displayForHomeOuts(int score) {
        TextView scoreView = outsForHome;
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays visiting team outs
     */
    public void displayForVisitorOuts(int score) {
        TextView scoreView = outsForVisitor;
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays inning
     */
    public void displayInning(int inning) {
        TextView scoreView = inningDisplay;
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
        if (inning >= 9 && runHome > runVisitor && outHome  == 3 && outVisitor == 3) {
            Toast.makeText(this, this.getString(R.string.toasthome), Toast.LENGTH_SHORT).show();
        } else if (inning >= 9 && runHome < runVisitor) {
            Toast.makeText(this, this.getString(R.string.toastvisitor), Toast.LENGTH_SHORT).show();
        }
        displayForHomeOuts(outHome);
        displayForVisitorOuts(outVisitor);
        displayInning(inning);

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
        if (inning >= 9 && runHome > runVisitor && outHome  == 3 && outVisitor == 3) {
            Toast.makeText(this, "Home Team Wins!", Toast.LENGTH_SHORT).show();
        } else if (inning >= 9 && runHome < runVisitor) {
            Toast.makeText(this, "Visiting Team Wins!", Toast.LENGTH_SHORT).show();
        }
        displayForHomeOuts(outHome);
        displayForVisitorOuts(outVisitor);
        displayInning(inning);

    }

}

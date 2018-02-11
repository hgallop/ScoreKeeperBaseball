package com.example.android.scorekeeperbaseball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static final String RUN_HOME = "runHome";
    static final String RUN_VISITOR = "runVisitor";
    static final String OUT_HOME = "outHome";
    static final String OUT_VISITOR = "outVisitor";
    static final String INNING = "inning";
    static final String HOME_NAME = "homeName";
    static final String VISITOR_NAME = "visitorName";

    final int MAX_OUTS = 3;
    final int REG_INNINGS = 9;
    final int RESTART = 0;

    int inning = 1;
    String home;
    String visitor;

    private TextView runsForHome;
    private TextView runsForVisitor;
    private TextView outsForHome;
    private TextView outsForVisitor;
    private TextView inningDisplay;
    private TextView homeName;
    private TextView visitorName;

    Team homeTeam;
    Team visitorTeam;

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
        homeName = findViewById(R.id.home_team);
        visitorName = findViewById(R.id.visitor_team);

        home = getResources().getString(R.string.home);
        visitor = getResources().getString(R.string.visit);

        homeTeam = new Team(0,0, home, homeName, runsForHome, outsForHome);
        visitorTeam = new Team(0,0, visitor, visitorName,runsForVisitor, outsForVisitor);

        homeTeam.displayScore(homeTeam.getRuns());
        homeTeam.displayName(homeTeam.getName());
        homeTeam.displayOuts(homeTeam.getOuts());

        visitorTeam.displayScore(visitorTeam.getRuns());
        visitorTeam.displayName(visitorTeam.getName());
        visitorTeam.displayOuts(visitorTeam.getOuts());
    }

    /**
     * Saves app data between states
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(RUN_HOME, homeTeam.getRuns());
        outState.putInt(RUN_VISITOR, visitorTeam.getRuns());
        outState.putInt(OUT_HOME, homeTeam.getOuts());
        outState.putInt(OUT_VISITOR, visitorTeam.getOuts());
        outState.putString(HOME_NAME, homeTeam.getName());
        outState.putString(VISITOR_NAME, visitorTeam.getName());
        outState.putInt(INNING, inning);
    }

    /**
     * Restores app data on new state
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        homeTeam.setRuns(savedInstanceState.getInt(RUN_HOME));
        visitorTeam.setRuns(savedInstanceState.getInt(RUN_VISITOR));
        homeTeam.setOuts(savedInstanceState.getInt(OUT_HOME));
        visitorTeam.setOuts(savedInstanceState.getInt(OUT_VISITOR));
        homeTeam.setName(savedInstanceState.getString(HOME_NAME));
        visitorTeam.setName(savedInstanceState.getString(VISITOR_NAME));
        inning = savedInstanceState.getInt(INNING);
    }

    /**
     * Displays inning
     */
    public void displayInning(int inning) {
        inningDisplay.setText(String.valueOf(inning));
    }

    /**
     * Resets all values to default
     */
    public void resetAll(View view) {
        homeTeam.setOuts(RESTART);
        visitorTeam.setOuts(RESTART);
        homeTeam.setRuns(RESTART);
        visitorTeam.setOuts(RESTART);
        inning = 1;
        homeTeam.displayScore(homeTeam.getRuns());
        visitorTeam.displayScore(visitorTeam.getRuns());
        homeTeam.displayOuts(homeTeam.getOuts());
        visitorTeam.displayOuts(visitorTeam.getOuts());
        displayInning(inning);
    }

    /**
     * Calculates and displays home team run on button click
     */
    public void runScoreHome(View view) {
        homeTeam.runScore(view);
    }

    /**
     * Calculates and displays visiting team run on button click
     */
    public void runScoreVisitor(View view) {
        visitorTeam.runScore(view);
    }

    /**
     * Calculates and displays home team grandslam on button click
     */
    public void grandSlamHome(View view) {
        homeTeam.grandSlam(view);
    }

    /**
     * Calculates and displays visiting team grandslam on button click
     */
    public void grandSlamVisitor(View view) {
        visitorTeam.grandSlam(view);
    }

    /**
     * Calculates and displays home team outs. Control and display inning
     */
    public void outsHome(View view) {
        homeTeam.teamOut(view);
        if (homeTeam.getOuts() == MAX_OUTS && visitorTeam.getOuts() == MAX_OUTS && inning < REG_INNINGS) {
            homeTeam.setOuts(RESTART);
            visitorTeam.setOuts(RESTART);
            inning += 1;
            homeTeam.displayOuts(homeTeam.getOuts());
            visitorTeam.displayOuts(visitorTeam.getOuts());
            displayInning(inning);
        }
        if (inning == REG_INNINGS && homeTeam.getRuns() == visitorTeam.getRuns()) {
            homeTeam.setOuts(RESTART);
            visitorTeam.setOuts(RESTART);
            inning += 1;
            if (inning >= 10) {
                inning = 10;
            }
            homeTeam.displayOuts(homeTeam.getOuts());
            visitorTeam.displayOuts(visitorTeam.getOuts());
            displayInning(inning);
        }
        if (inning >= REG_INNINGS && homeTeam.getRuns() > visitorTeam.getRuns() && homeTeam.getOuts() == MAX_OUTS && visitorTeam.getOuts() == MAX_OUTS) {
            Toast.makeText(this, this.getString(R.string.toasthome), Toast.LENGTH_SHORT).show();
        } else if (inning >= REG_INNINGS && homeTeam.getRuns() < visitorTeam.getRuns() && homeTeam.getOuts() == MAX_OUTS && visitorTeam.getOuts() == MAX_OUTS) {
            Toast.makeText(this, this.getString(R.string.toastvisitor), Toast.LENGTH_SHORT).show();
        }
        homeTeam.displayOuts(homeTeam.getOuts());
        visitorTeam.displayOuts(visitorTeam.getOuts());
        displayInning(inning);

    }

    /**
     * Calculates and displays visiting team outs. Control and display inning
     */
    public void outsVisitor(View view) {
        visitorTeam.teamOut(view);
        if (homeTeam.getOuts() == MAX_OUTS && visitorTeam.getOuts() == MAX_OUTS && inning < REG_INNINGS) {
            homeTeam.setOuts(RESTART);
            visitorTeam.setOuts(RESTART);
            inning += 1;
            homeTeam.displayOuts(homeTeam.getOuts());
            visitorTeam.displayOuts(visitorTeam.getOuts());
            displayInning(inning);
        }
        if (inning == REG_INNINGS && homeTeam.getRuns() == visitorTeam.getRuns()) {
            homeTeam.setOuts(RESTART);
            visitorTeam.setOuts(RESTART);
            inning += 1;
            if (inning >= 10) {
                inning = 10;
            }
            homeTeam.displayOuts(homeTeam.getOuts());
            visitorTeam.displayOuts(visitorTeam.getOuts());
            displayInning(inning);
        }
        if (inning >= REG_INNINGS && homeTeam.getRuns() > visitorTeam.getRuns() && homeTeam.getOuts() == MAX_OUTS && visitorTeam.getOuts() == MAX_OUTS) {
            Toast.makeText(this, this.getString(R.string.toasthome), Toast.LENGTH_SHORT).show();
        } else if (inning >= REG_INNINGS && homeTeam.getRuns() < visitorTeam.getRuns() && homeTeam.getOuts() == MAX_OUTS && visitorTeam.getOuts() == MAX_OUTS) {
            Toast.makeText(this, this.getString(R.string.toastvisitor), Toast.LENGTH_SHORT).show();
        }
        homeTeam.displayOuts(homeTeam.getOuts());
        visitorTeam.displayOuts(visitorTeam.getOuts());
        displayInning(inning);
    }


}

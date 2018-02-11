package com.example.android.scorekeeperbaseball;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //creates keys for save and restore instance state.
    static final String RUN_HOME = "runHome";
    static final String RUN_VISITOR = "runVisitor";
    static final String OUT_HOME = "outHome";
    static final String OUT_VISITOR = "outVisitor";
    static final String INNING = "inning";
    static final String HOME_NAME = "homeName";
    static final String VISITOR_NAME = "visitorName";

    //creates variables for outs and innings comparisons.
    final int MAX_OUTS = 3;
    final int REG_INNINGS = 9;
    final int RESTART = 0;

    //creates variables for inning, homeTeam name and wisitorTeam name.
    int inning = 1;
    String home;
    String visitor;

    //creates variables for all views that are changed by the object and methods.
    private TextView runsForHome;
    private TextView runsForVisitor;
    private TextView outsForHome;
    private TextView outsForVisitor;
    private TextView inningDisplay;
    private TextView homeName;
    private TextView visitorName;

    //creates variables for Team objects.
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

        //initializes names for Team objects
        home = getResources().getString(R.string.home);
        visitor = getResources().getString(R.string.visit);

        //creates a Team objects.
        homeTeam = new Team(0,0, home);
        visitorTeam = new Team(0,0, visitor);

        //displays initial values to views
        displayScoreHome(homeTeam.getRuns());
        displayNameHome(homeTeam.getName());
        displayOutsHome(homeTeam.getOuts());

        displayScoreVisitor(visitorTeam.getRuns());
        displayNameVisitor(visitorTeam.getName());
        displayOutsVisitor(visitorTeam.getOuts());
    }

    /**
     * saves state of app variables for screen rotation.
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
     * restores state of app variables for screen rotation.
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

    //method to display homeTeam score.
    public void displayScoreHome(int score) {
        runsForHome.setText(String.valueOf(score));
    }

    //method to display visitorTeam score.
    public void displayScoreVisitor(int score) {
        runsForVisitor.setText(String.valueOf(score));
    }

    //method to display homeTeam name.
    public void displayNameHome(String name){
        homeName.setText(name);
    }

    //method to display visitorTeam name.
    public void displayNameVisitor(String name){
        visitorName.setText(name);
    }

    // method to display homeTeam outs
    public void displayOutsHome(int score){
        outsForHome.setText((String.valueOf(score)));
    }

    // method to display visitorTeam outs
    public void displayOutsVisitor(int score){
        outsForVisitor.setText((String.valueOf(score)));
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
        visitorTeam.setRuns(RESTART);
        inning = 1;
        displayScoreHome(homeTeam.getRuns());
        displayScoreVisitor(visitorTeam.getRuns());
        displayOutsHome(homeTeam.getOuts());
        displayOutsVisitor(visitorTeam.getOuts());
        displayInning(inning);
    }

    /**
     * Calculates and displays home team run on button click
     */
    public void runScoreHome(View view) {
        homeTeam.runScore();
        displayScoreHome(homeTeam.getRuns());
    }

    /**
     * Calculates and displays visiting team run on button click
     */
    public void runScoreVisitor(View view) {
        visitorTeam.runScore();
        displayScoreVisitor(visitorTeam.getRuns());
    }

    /**
     * Calculates and displays home team grandslam on button click
     */
    public void grandSlamHome(View view) {
        homeTeam.grandSlam();
        displayScoreHome(homeTeam.getRuns());
    }

    /**
     * Calculates and displays visiting team grandslam on button click
     */
    public void grandSlamVisitor(View view) {
        visitorTeam.grandSlam();
        displayScoreVisitor(visitorTeam.getRuns());
    }

    /**
     * Calculates and displays home team outs.
     */
    public void outsHome(View view) {
        homeTeam.teamOut();
        inningsHelper();
    }

    /**
     * Calculates and displays visiting team outs.
     */
    public void outsVisitor(View view) {
        visitorTeam.teamOut();
        inningsHelper();
    }


    //handles logic for innings and win state.
    private void inningsHelper(){
        if (homeTeam.getOuts() == MAX_OUTS && visitorTeam.getOuts() == MAX_OUTS && inning < REG_INNINGS) {
            homeTeam.setOuts(RESTART);
            visitorTeam.setOuts(RESTART);
            inning += 1;
        } else if (inning == REG_INNINGS && homeTeam.getRuns() == visitorTeam.getRuns()) {
            homeTeam.setOuts(RESTART);
            visitorTeam.setOuts(RESTART);
            inning += 1;
            if (inning >= 10) {
                inning = 10;
            }
        }else if (inning >= REG_INNINGS && homeTeam.getRuns() > visitorTeam.getRuns() && homeTeam.getOuts() == MAX_OUTS && visitorTeam.getOuts() == MAX_OUTS) {
            Toast.makeText(this, this.getString(R.string.toasthome), Toast.LENGTH_SHORT).show();
        } else if (inning >= REG_INNINGS && homeTeam.getRuns() < visitorTeam.getRuns() && homeTeam.getOuts() == MAX_OUTS && visitorTeam.getOuts() == MAX_OUTS) {
            Toast.makeText(this, this.getString(R.string.toastvisitor), Toast.LENGTH_SHORT).show();
        }
        displayOutsHome(homeTeam.getOuts());
        displayOutsVisitor(visitorTeam.getOuts());
        displayInning(inning);
    }
}

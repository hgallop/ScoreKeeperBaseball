package com.example.android.scorekeeperbaseball;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by doyou on 2/10/2018.
 */

public class Team {

    //creates variables for ways to score, and outs.
    private final int MAX_OUTS = 3;
    private final int RUN = 1;
    private final int GRAND_SLAM = 4;
    private final int OUT = 1;

    //creates variables for object
    private int runs;
    private int outs;
    private String name;

    //creates variables for object's views
    private TextView nameView;
    private TextView scoreView;
    private TextView outsView;

    //object constructor. Used in MainActivity.java to create Team objects
    public Team(int runs, int outs, String name, TextView nameView, TextView scoreView, TextView outsView){
        this.runs = runs;
        this.outs = outs;
        this.name = name;
        this.nameView = nameView;
        this.scoreView = scoreView;
        this.outsView =outsView;
    }

    //mustator. allows name value to be set.
    public void setName(String name){
        this.name = name;
    }

    //accessor. allows name value to be accessed.
    public String getName(){
        return name;
    }

    //mutator allows runs value to be set.
    public void setRuns(int runs){
        this.runs = runs;
    }

    //accessor. allows runs value to be accessed
    public int getRuns(){
        return runs;
    }

    //mutator. allows outs value to be set.
    public void setOuts(int outs){
        this.outs = outs;
    }

    //accessor. allows outs value to be accessed.
    public int getOuts(){
        return outs;
    }

    //method to display Team score.
    public void displayScore(int score) {
        scoreView.setText(String.valueOf(score));
    }

    //method to display Team name.
    public void displayName(String name){
        nameView.setText(name);
    }

    // method to display Team outs
    public void displayOuts(int score){
        outsView.setText((String.valueOf(score)));
    }

    //method to score a run for Team
    public void runScore(View view) {
        runs += RUN;
        displayScore(runs);
    }

    //method to score a grandslam for Team
    public void grandSlam(View view){
        runs += GRAND_SLAM;
        displayScore(runs);
    }

    //method to add an out for Team
    public void teamOut(View view) {
        if (outs < MAX_OUTS) {
            outs += OUT;
        }
        displayOuts(outs);
    }
}

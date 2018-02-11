package com.example.android.scorekeeperbaseball;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by doyou on 2/10/2018.
 */

public class Team {

    private final int MAX_OUTS = 3;
    private final int RUN = 1;
    private final int GRAND_SLAM = 4;
    private final int OUT = 1;

    private int runs;
    private int outs;
    private String name;

    private TextView nameView;
    private TextView scoreView;
    private TextView outsView;

    public Team(int runs, int outs, String name, TextView nameView, TextView scoreView, TextView outsView){
        this.runs = runs;
        this.outs = outs;
        this.name = name;
        this.nameView = nameView;
        this.scoreView = scoreView;
        this.outsView =outsView;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setRuns(int runs){
        this.runs = runs;
    }

    public int getRuns(){
        return runs;
    }

    public void setOuts(int outs){
        this.outs = outs;
    }

    public int getOuts(){
        return outs;
    }

    public void setNameView(TextView view){
        nameView = view;
    }

    public TextView getNameView(){
        return nameView;
    }

    public void setScoreView(TextView view){
        scoreView = view;
    }

    public TextView getScoreView(){
        return scoreView;
    }

    public void setOutsView(TextView view){
        outsView = view;
    }

    public TextView getOutsView(){
        return outsView;
    }

    public void displayScore(int score) {
        scoreView.setText(String.valueOf(score));
    }

    public void displayName(String name){
        nameView.setText(name);
    }

    public void displayOuts(int score){
        outsView.setText((String.valueOf(score)));
    }

    public void runScore(View view) {
        runs += RUN;
        displayScore(runs);
    }

    public void grandSlam(View view){
        runs += GRAND_SLAM;
        displayScore(runs);
    }

    public void teamOut(View view) {
        if (outs < MAX_OUTS) {
            outs += OUT;
        }
        displayOuts(outs);
    }
}

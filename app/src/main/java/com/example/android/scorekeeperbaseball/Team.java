package com.example.android.scorekeeperbaseball;

/**
 * Create Team class
 */

public class Team {

    //creates variables for ways to score, and outs.
    private final static int MAX_OUTS = 3;
    private final static int RUN = 1;
    private final static int GRAND_SLAM = 4;
    private final static int OUT = 1;

    //creates variables for object
    private int mRuns;
    private int mOuts;
    private String mName;

    //object constructor. Used in MainActivity.java to create Team objects
    Team(int runs, int outs, String name) {
        mRuns = runs;
        mOuts = outs;
        mName = name;
    }

    //mutator. allows name value to be set.
    public void setName(String name){
        mName = name;
    }

    //accessor. allows name value to be accessed.
    public String getName(){
        return mName;
    }

    //mutator allows mRuns value to be set.
    void setRuns(int runs){
        mRuns = runs;
    }

    //accessor. allows mRuns value to be accessed
    int getRuns(){
        return mRuns;
    }

    //mutator. allows outs value to be set.
    void setOuts(int outs){
        mOuts = outs;
    }

    //accessor. allows outs value to be accessed.
    int getOuts(){
        return mOuts;
    }

    //method to score a run for Team
    void runScore() {
        mRuns += RUN;
    }

    //method to score a grandslam for Team
    void grandSlam(){
        mRuns += GRAND_SLAM;
    }

    //method to add an out for Team
    void teamOut() {
        if (mOuts < MAX_OUTS) {
            mOuts += OUT;
        }
    }
}

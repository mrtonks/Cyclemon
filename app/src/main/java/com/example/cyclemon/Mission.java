package com.example.cyclemon;

import android.widget.ProgressBar;

public class Mission {

    private String title;
    private int reward;
    private int progressMax;
    private int progressCur;

    public Mission(String title, int progMax, int progCur, int reward){
        this.title = title;
        this.progressMax = progMax;
        this.progressCur = progCur;
        this.reward = reward;
    }

    public String getTitle(){return title; }
    public int getReward(){
        return reward;
    }
    public int getProgressCur() {
        return progressCur;
    }
    public int getProgressMax() { return progressMax; }

    public void setTitle(String title) { this.title = title; }
    public void setReward(int reward) {
        this.reward = reward;
    }
    public void setProgressMax(int progressMax) {
        this.progressMax = progressMax;
    }
    public void setProgressCur(int progressCur) {
        this.progressCur = progressCur;
    }



}

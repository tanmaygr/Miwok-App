package com.example.android.miwok.model;

/**
 * Created by SAGAR on 27-04-2018.
 */

public class TaskNo {
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMiwok() {
        return miwok;
    }

    public void setMiwok(String miwok) {
        this.miwok = miwok;
    }

    private String word;
    private String miwok;

    public TaskNo() {

    }

    public TaskNo(String word, String miwok) {
        this.word = word;
        this.miwok = miwok;
    }


}
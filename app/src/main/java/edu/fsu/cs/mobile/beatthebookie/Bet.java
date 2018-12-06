package edu.fsu.cs.mobile.beatthebookie;

import java.util.ArrayList;
import java.util.Date;

public class Bet {

    private  String text;
    private int NumTeams;
    private Date TimeCreated;
    private Date ValidUntil;
    private String Website;
    private double FinalOdds;
    private ArrayList<String> Lines;
    private ArrayList<Integer> Prices;
    private int votes;

    public Bet()
    {
        text="TEST";
        votes=0;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }



}

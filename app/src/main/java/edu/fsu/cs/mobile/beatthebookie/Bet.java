package edu.fsu.cs.mobile.beatthebookie;

import java.util.ArrayList;
import java.util.Date;

public class Bet {

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
        votes=0;
    }

}

package edu.up.cs301.pig;

public class PigGameState {
    private int id, p1Score, p2Score, runTotal, currVal;

    /**
     * Cntr for PigGameState
     * */
    public PigGameState() {
        id = 0; //Whose turn is it
        p1Score = p2Score = runTotal = 0; //Scores and what would be added
        currVal = 1; //Current value on the die
    }

    /**
     * Copy cntr for PigGameState
     * */
    public PigGameState(PigGameState pig) {
        this.id = pig.id;
        this.p1Score = pig.p1Score;
        this.p2Score = pig.p2Score;
        this.runTotal = pig.runTotal;
        this.currVal = pig.currVal;
    }


    /**
     * Various getters and setters for instance variables
     *
     * */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getP1Score() {
        return p1Score;
    }

    public void setP1Score(int p1Score) {
        this.p1Score = p1Score;
    }

    public int getP2Score() {
        return p2Score;
    }

    public void setP2Score(int p2Score) {
        this.p2Score = p2Score;
    }

    public int getRunTotal() {
        return runTotal;
    }

    public void setRunTotal(int runTotal) {
        this.runTotal = runTotal;
    }

    public int getCurrVal() {
        return currVal;
    }

    public void setCurrVal(int currVal) {
        this.currVal = currVal;
    }
}

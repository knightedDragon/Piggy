package edu.up.cs301.pig;

import java.util.Random;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.infoMsg.GameInfo;

public class PigSmartCompPlayer extends GameComputerPlayer {
    /**
     * constructor
     *
     * @param name the player's name (e.g., "John")
     */
    public PigSmartCompPlayer(String name) {
        super(name);
    }

    @Override
    protected void receiveInfo(GameInfo info) {
        PigGameState piggy = new PigGameState((PigGameState) info);
        //Typecast info to make instance of current gamestate
        if (!(piggy.getId() == this.playerNum)) {
            return;
        }
        this.sleep(1000);

        int cP = this.playerNum;
        int hScore, cScore;
        int total = piggy.getRunTotal();

        if (cP == 0) {
            cScore = piggy.getP1Score();
            hScore = piggy.getP2Score();
        } else {
            cScore = piggy.getP2Score();
            hScore = piggy.getP1Score();
        }

        PigRollAction roll = new PigRollAction(this);
        PigHoldAction hold = new PigHoldAction(this);

        if (total + cScore >= 50) { //if they'll win, take it
            game.sendAction(hold);
        } else if (piggy.getCurrVal() >= 4) {//if die is at 4,5, or 6 hold
            game.sendAction(hold);
        } else if (cScore + total >= hScore) { //if puts ahead of/equal to opp take it
            game.sendAction(hold);
        } else {
            Random rand = new Random();
            int hehe = rand.nextInt(2);
            if (hehe == 0) {
                game.sendAction(hold);
            } else {
                game.sendAction(roll);
            }
        } //else its random
    }//receiveInfo
}

package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

import java.util.Random;

// dummy comment, to see if commit and push work from srvegdahl account

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {

    private PigGameState piggy;

    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        piggy = new PigGameState();
    }

    /**
     * can the player with the given id take an action right now?
     */
    @Override
    protected boolean canMove(int playerIdx) {
        return (piggy.getId() == playerIdx);
    }

    /**
     * This method is called when a new action arrives from a player
     *
     * @return true if the action was taken or false if the action was invalid/illegal.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        if (action instanceof PigHoldAction) {
            switch (piggy.getId()) {
                case 0:
                    piggy.setP1Score(piggy.getP1Score() + piggy.getRunTotal());
                    piggy.setId(1); //TODO: Check for num of players
                    break;
                case 1:
                    piggy.setP2Score(piggy.getP2Score() + piggy.getRunTotal());
                    piggy.setId(0); //TODO: Check for num of players
                    break;
            }
            piggy.setRunTotal(0);
            return true;
        } else if (action instanceof PigRollAction) {
            Random rand = new Random();
            piggy.setCurrVal(rand.nextInt(6) + 1);
            if (piggy.getCurrVal() == 1) {
                piggy.setRunTotal(0);
                switch (piggy.getId()) { //TODO: Check for num of players
                    case 0:
                        piggy.setId(1);
                        break;
                    case 1:
                        piggy.setId(0);
                        break;
                }
            } else { //If the die val isn't 1, add it to the running total
                piggy.setRunTotal(piggy.getRunTotal() + piggy.getCurrVal());
            }
            return true;
        }
        return false;
    }//makeMove

    /**
     * send the updated state to a given player
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        PigGameState pigCopy = new PigGameState(piggy);

        //p.sendInfo(pigCopy);
        //TODO: Figure out the sendInfo method yuck
    }//sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        if (piggy.getP1Score() >= 50) {
            //TODO: Find out their name
            return "Yay p1 won w score of " + piggy.getP1Score();
        } else if (piggy.getP2Score() >= 50) {
            //TODO: Find out their name
            return "Yay p2 won w score of " + piggy.getP2Score();
        }

        return null;
    }

}// class PigLocalGame

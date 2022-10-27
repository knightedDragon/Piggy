package edu.up.cs301.pig;

import java.util.Random;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.util.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {

    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {
        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        PigGameState piggy = new PigGameState((PigGameState) info);
        //TODO: Why won't that work >:(

        if (piggy.getId() != this.playerNum) {
            return;
        }

        this.sleep(1000);

        int randy = new Random().nextInt(10);
        if (randy >= 4) {
            PigHoldAction holding = new PigHoldAction(this);
            game.sendAction(holding);
            //pigholdaction
        } else {
            PigRollAction rolling = new PigRollAction(this);
            game.sendAction(rolling);
            //pigrollaction
        }

    }//receiveInfo

}

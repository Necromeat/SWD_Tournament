/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package swdesign.tournament;

import interfaces.ParticipantInfo;
import swdesign.game.AI;
import swdesign.game.Game;
import swdesign.game.GameInstance;
import swdesign.game.GameInstance.Result;

/**
 *
 * @author Andrew
 */
public class Match implements interfaces.MatchInfo{
    private int id = 0;
    private AI player1, player2;
    private Game game;
    private boolean hasFinished;
    
    public Match(AI a,AI b, Game g){
        this.player1 = a;
        this.player2 =b;
        this.game = g;
        this.hasFinished = false;
    }
    
    @Override
    public int matchID() {
        return id;
    }

    @Override
    public ParticipantInfo getParticipantA() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ParticipantInfo getParticipantB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean hasFinished() {
        return hasFinished;
    }

    @Override
    public GameInstance.Result getResult() {
       Result result = null;
    if(!hasFinished){
      result=game.newInstance().playGame(player1, player2);
      hasFinished = true;
    }
       
        return result;
    }
    
}

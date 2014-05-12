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
public class  Match implements Runnable,interfaces.MatchInfo {
    private int id = 0;
    private AI player1, player2;
    private int player1Score = 0
            ,player2Score = 0;
    private Game game;
    private boolean hasFinished;
    private Participant playera, playerb;
    Result result;
    
    public Match(AI a,AI b, Game g){
        this.player1 = a;
        this.player2 =b;
        this.game = g;
        this.hasFinished = false;
        
        this.playera = new Participant(a);
        this.playerb = new Participant(b);
        
    }
    
    @Override
    public int matchID() {
        return id;
    }

    @Override
    public ParticipantInfo getParticipantA() {
        
        return (ParticipantInfo)playera;
    }

    @Override
    public ParticipantInfo getParticipantB() {
   
        return (ParticipantInfo)playerb;
    }

    @Override
    public boolean hasFinished() {
        return hasFinished;
    }

    @Override
    public GameInstance.Result getResult() {
       
        return result;
    }
    
    void setPlayerScore(Enum result){
        if( result == Result.AWINS){
         player1Score++;
         player2Score--;
            
        }
        if( result == Result.BWINS){
         player1Score--;
         player2Score++;
        }
    }

    @Override
    public void run() {
       while(!hasFinished){
        playgame();
       hasFinished = true;
       }
       
    }
    
   public synchronized void playgame(){
        result=game.newInstance().playGame(player1, player2);
      setPlayerScore(result);
      playera.updateScore(player1Score);
      playerb.updateScore(player2Score); 
   }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package swdesign.tournament;

import swdesign.game.AI;
import swdesign.game.GameInstance;

/**
 *
 * @author Andrew
 */
public class Participant implements interfaces.ParticipantInfo{
    protected AI aiDecorator;
    private int score;
    public Participant(AI ai){
        this.aiDecorator = ai;
    }
    
    @Override
    public int getScore() {
        return score;
    }

    @Override
    public String getID() {
    
        return aiDecorator.getName();
    }

    @Override
    public String getName() {
        return aiDecorator.getName();
    }

    @Override
    public void updateScore(int score) {    
        
        this.score = score;
    }

    
    
    
}

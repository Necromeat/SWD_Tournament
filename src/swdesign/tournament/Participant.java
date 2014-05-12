/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package swdesign.tournament;

import java.util.Comparator;
import swdesign.game.AI;

/**
 *
 * @author Andrew
 */
public class Participant implements Comparable,interfaces.ParticipantInfo{
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

    @Override
    public int compareTo(Object t) {
      Participant a = (Participant)t;
        Participant b = this;
        if(a.getScore()> b.getScore()){
            return -1;
        }else{
            if(b.getScore()>a.getScore()){
                return 1;
            }else{
                return 0;
            }
        }
             
    }

    @Override
    public String toString() {
        return "Participant{" + "aiDecorator=" + aiDecorator + ", score=" + score + '}';
    }
    
        
 

    


    }

    
    

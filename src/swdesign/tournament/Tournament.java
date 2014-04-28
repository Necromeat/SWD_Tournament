/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package swdesign.tournament;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import swdesign.examplegames.stupidnumbergame.StupidNumberGame;
import swdesign.game.AI;

/**
 *
 * @author Andrew
 */
public class Tournament<E,B> implements interfaces.TournamentInterface<E,B>{
    private Match match;
    private ArrayList<AI> playersArray = new ArrayList();
    private List<Enum> results = new ArrayList();
    private int id=0;
    @Override
    public void startTournament(B gametype, E[] players) {
       int amountOfMatches;
       StupidNumberGame a = (StupidNumberGame)gametype;
        
       for (E e : players) {
            playersArray.add((AI)e);
        }
       
       amountOfMatches = 100;
       Random ran = new Random();  
     
        for (int i = 0; i < amountOfMatches; i++) {
            match  = new Match(playersArray.get(ran.nextInt(6)),playersArray.get(ran.nextInt(6)), a);
            if(!match.hasFinished()){
                results.add(match.getResult());
                id++;
            }
        }
        
        
        
    }

    @Override
    public List<Enum> getResults() {
        return results;
    }

    @Override
    public int getTourmantID() {
        return id;
    }

    
}

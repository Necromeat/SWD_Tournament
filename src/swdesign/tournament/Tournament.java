/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swdesign.tournament;

import interfaces.ParticipantInfo;
import java.io.IOException;
import static java.lang.Runtime.getRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import swdesign.game.AI;
import swdesign.game.Game;

/**
 *
 * @author Andrew
 */
public class Tournament<E, B> implements interfaces.TournamentInterface<E, B> {

    private Match match;
    private String tournamentName;
    private ArrayList<AI> playersArray = new ArrayList();
    private final List<Enum> results = new ArrayList();
    private Map<String, ParticipantInfo> playerInfoArray = new HashMap<>();
    private ArrayList<Match> matches = new ArrayList<>();
    
    private int id = 0;
    private Game game;

    @Override
    public void startTournament(B gametype, List<E> players) {

        this.game = (Game) gametype;
        playersArray = (ArrayList) players;
 
            playMatches();
          

    }

    @Override
    public List<Enum> getResults() {
        return results;
    }

    @Override
    public int getTourmantID() {
        return id;
    }

    @Override
    public List<ParticipantInfo> getParticipants() {
     
             return sortList();
    }

    @Override
    public String getTourmantName() {
        return tournamentName;
    }

       @Override
    public void setTournamentName(String tournamentname) {
        this.tournamentName = tournamentname;
    }

    private void playMatches(){
        Runtime r = getRuntime();
        Runner run = new Runner();
        for (int i = 0; i < playersArray.size(); i++) {
            for (int j = i + 1; j < playersArray.size(); j++) {
                if (!playersArray.get(i).getID().equals(playersArray.get(j).getID())) {
                    match = new Match(playersArray.get(i), playersArray.get(j), game);
                    matches.add(match);
                
                    run.execute(match);
                    updateResults(playersArray.get(i),playersArray.get(j), match);
                 

                        id++;

                    
                }
            }

        }

    }

    
   public List<ParticipantInfo> sortList(){
      ArrayList<Participant> list2 = new ArrayList<>();
      for(ParticipantInfo p : playerInfoArray.values()){
          list2.add((Participant)p);
      }
      
     Collections.sort(list2);
      
     
       return (List)list2;
     
   }
   
   private void updateResults(AI a, AI b, Match match){
          results.add(match.getResult());
          
                    if (!playerInfoArray.containsKey(a.getID()) && !playerInfoArray.containsKey(b.getID())) {
                        playerInfoArray.put(a.getID(), match.getParticipantA());
                        playerInfoArray.put(b.getID(), match.getParticipantB());

                    } else {
                        if (playerInfoArray.containsKey(a.getID()) && !playerInfoArray.containsKey(b.getID())) {
                            playerInfoArray.get(a.getID()).updateScore(playerInfoArray.get(a.getID()).getScore() + match.getParticipantA().getScore());
                            playerInfoArray.put(b.getID(), match.getParticipantB());

                        } else {
                            if (playerInfoArray.containsKey(a.getID()) && playerInfoArray.containsKey(b.getID())) {
                                playerInfoArray.get(a.getID()).updateScore(playerInfoArray.get(a.getID()).getScore() + match.getParticipantA().getScore());
                                playerInfoArray.get(b.getID()).updateScore(playerInfoArray.get(b.getID()).getScore() + match.getParticipantB().getScore());

                            }
                        }
   }
   }
   
   
       
  
}   


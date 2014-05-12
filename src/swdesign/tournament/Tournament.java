/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swdesign.tournament;

import interfaces.ParticipantInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import swdesign.examplegames.stupidnumbergame.StupidNumberGame;
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
    private final Map<String,ParticipantInfo> playerInfoArray = new HashMap<>();
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
    public Map<String,ParticipantInfo> getParticipants() {
        return playerInfoArray;
    }

    @Override
    public String getTourmantName() {
        return tournamentName;
    }

    @Override
    public List<E> sortByHighestScore(List<E> e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTournamentName(String tournamentname) {
        this.tournamentName = tournamentname;
    }

    private void playMatches() {
        for (int i = 0; i < playersArray.size(); i++) 
    {
            for (int j = i+1; j < playersArray.size(); j++){
              if(!playersArray.get(i).getID().equals(playersArray.get(j).getID())){
                  match = new Match(playersArray.get(i),playersArray.get(j),game);
                  
                   if (!match.hasFinished()) {
                        results.add(match.getResult());
                        if(!playerInfoArray.containsKey(playersArray.get(i).getID())&&!playerInfoArray.containsKey(playersArray.get(j).getID())){
                            playerInfoArray.put(playersArray.get(i).getID(), match.getParticipantA());
                            playerInfoArray.put(playersArray.get(j).getID(), match.getParticipantB());
                          
                        }else{                        
                        if(playerInfoArray.containsKey(playersArray.get(i).getID())&& !playerInfoArray.containsKey(playersArray.get(j).getID())){
                            playerInfoArray.get(playersArray.get(i).getID()).updateScore( playerInfoArray.get(playersArray.get(i).getID()).getScore()+match.getParticipantA().getScore());
                            playerInfoArray.put(playersArray.get(j).getID(), match.getParticipantB());
                          
                            }else{
                              if(playerInfoArray.containsKey(playersArray.get(i).getID())&& playerInfoArray.containsKey(playersArray.get(j).getID())){
                                 playerInfoArray.get(playersArray.get(i).getID()).updateScore( playerInfoArray.get(playersArray.get(i).getID()).getScore()+match.getParticipantA().getScore());
                                 playerInfoArray.get(playersArray.get(j).getID()).updateScore( playerInfoArray.get(playersArray.get(j).getID()).getScore()+match.getParticipantB().getScore());
                           
                              }
                                }
                        }
                       
                        
                        
                        
                        id++;
                      
                    }
                                                }
              }
         
    
        }
        
      }
    
    }

   
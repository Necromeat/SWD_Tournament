/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import java.util.List;

/**
 *
 * @author Andrew
 */
public interface TournamentInterface<E,B>  {
    
    public void startTournament(B gametype,List<E> players);
    public List<Enum> getResults();
    public int getTourmantID();
    public void setTournamentName(String Tournamentname);
    public String getTourmantName();
    public List<ParticipantInfo> getParticipants();
   
   
    
}

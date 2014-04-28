/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Andrew
 */
public interface TournamentInterface<E,B>  {
    
    public void startTournament(B gametype,E[] players);
    public List<Enum> getResults();
    public int getTourmantID();
    
    
}

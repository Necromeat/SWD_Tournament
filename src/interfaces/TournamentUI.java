/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import java.util.List;
import swdesign.game.AI;

/**
 *
 * @author tog
 */
public interface TournamentUI
{
    public void startTournament(String gametype,List<AI> players,String tournamentName, int GamesPrMatch);
    public void showResults(List<ParticipantInfo> results);
    public void addPlayer(AI ai);
    public enum Commands{GameInfo,Start,addPlayer,addPlayers,Stop,Help};
    public enum GameTypes{StupidNumberGame};
    public enum PlayerTypes{RandomNumberPlayer,ConstantNumberPlayer};
    public void addPlayers(int players);
    
}

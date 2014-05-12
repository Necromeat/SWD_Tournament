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
    public void tournamentStart(String gameName, List<ParticipantInfo> participants, MatchInfo[] matches);
    public void matchStarted(int matchIndex);
    public void matchFinished(int matchIndex);
    public void tournamentFinished(List<ParticipantInfo> sortedParticipants);
    public void addPlayer(AI ai);
    public enum Commands{GameInfo,Start,addPlayer};
}

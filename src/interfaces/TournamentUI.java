/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import swdesign.game.AI;

/**
 *
 * @author tog
 */
public interface TournamentUI
{
    
    public void addPlayer(AI ai);
    public enum Commands{GameInfo,Start,addPlayer,Stop,Help};
    public enum GameTypes{StupidNumberGame};
    public enum PlayerTypes{RandomNumberPlayer,ConstantNumberPlayer};
    
}

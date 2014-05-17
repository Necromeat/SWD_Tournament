/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package swdesign;

import interfaces.ParticipantInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import swdesign.examplegames.stupidnumbergame.StupidNumberGame;
import swdesign.examplegames.stupidnumbergame.StupidNumberPlayer;
import swdesign.examplegames.stupidnumbergame.players.ConstantPlayer;
import swdesign.examplegames.stupidnumbergame.players.RandomPlayer;
import swdesign.tournament.Tournament;

/**
 *
 * @author tog
 */
public class SWDesignFinalProject<E>
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        StupidNumberPlayer a = new ConstantPlayer("a", "a", 10);
        StupidNumberPlayer b = new ConstantPlayer("b", "b", 9);
        StupidNumberPlayer c = new ConstantPlayer("c", "c", 8);
        StupidNumberPlayer d = new  ConstantPlayer("d", "d", 7);
        StupidNumberPlayer e = new  ConstantPlayer("e", "e", 6);
        StupidNumberPlayer z = new  ConstantPlayer("z", "z", 5);
        StupidNumberPlayer z1 = new  RandomPlayer("zod", "zod",1, 5);
        StupidNumberPlayer z2 = new  RandomPlayer("Zebra", "Zebra",1, 8);
        StupidNumberPlayer z3 = new  RandomPlayer("Bear", "Bear", 1,9);
       ArrayList<StupidNumberPlayer> list = new ArrayList<>();
       list.add(a);
       list.add(b);
       list.add(c);
       list.add(d);
       list.add(e);
       list.add(z);
       list.add(z1);
       list.add(z2);
       list.add(z3);
       
        StupidNumberGame game = new StupidNumberGame(1000000);
        Tournament<StupidNumberPlayer,StupidNumberGame> Khaan = new Tournament<>();
        Khaan.startTournament(game, list);
           
       
        
        for (ParticipantInfo fd: Khaan.getParticipants()) {
            System.out.println(fd.getID()+":"+fd.getScore());
        }
 
    }
    
}

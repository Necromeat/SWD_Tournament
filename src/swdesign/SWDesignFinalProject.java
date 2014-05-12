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
       ArrayList<StupidNumberPlayer> list = new ArrayList<>();
       Map<String,ParticipantInfo> map = new HashMap();
       list.add(a);
       list.add(b);
       list.add(c);
       list.add(d);
        StupidNumberGame game = new StupidNumberGame(1000000000);
        Tournament<StupidNumberPlayer,StupidNumberGame> Khaan = new Tournament<>();
        Khaan.startTournament(game, list);
       
        for (Enum s : Khaan.getResults()) {
            System.out.println(s);
        }
       
        map = Khaan.getParticipants();
        for (ParticipantInfo fd: map.values()) {
            System.out.println(fd.getID()+":"+fd.getScore());
        }
 
    }
    
}

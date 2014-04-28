/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package swdesign;

import java.util.Iterator;
import swdesign.examplegames.stupidnumbergame.StupidNumberGame;
import swdesign.examplegames.stupidnumbergame.StupidNumberPlayer;
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
        StupidNumberPlayer a = new RandomPlayer("a", "Bob1", 1, 10);
        StupidNumberPlayer b = new RandomPlayer("b", "Bob2", 1, 10);
        StupidNumberPlayer c = new RandomPlayer("c", "Bob3", 1, 10);
        StupidNumberPlayer d = new RandomPlayer("d", "Bob4", 1, 10);
        StupidNumberPlayer e = new RandomPlayer("e", "Bob5", 1, 10);
        StupidNumberPlayer f = new RandomPlayer("f", "Bob6", 1, 10);
        StupidNumberPlayer g = new RandomPlayer("g", "Bob7", 1, 10);
        StupidNumberPlayer[] array = new StupidNumberPlayer[7];
        array[0] = a;
        array[1] = b;
        array[2] = c;
        array[3] = d;
        array[4] = e;
        array[5] = g;
        array[6] = f;
        StupidNumberGame fuck = new StupidNumberGame(10);
        Tournament<StupidNumberPlayer,StupidNumberGame> Khaan = new Tournament<StupidNumberPlayer, StupidNumberGame>();
        Khaan.startTournament(fuck, array);
        for (Enum s : Khaan.getResults()) {
            System.out.println(s);
        }
 
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

import interfaces.ParticipantInfo;
import interfaces.TournamentUI.*;
import interfaces.TournamentUI.Commands;
import interfaces.TournamentUI.GameTypes;
import interfaces.TournamentUI.PlayerTypes;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import swdesign.examplegames.stupidnumbergame.StupidNumberGame;
import swdesign.examplegames.stupidnumbergame.players.ConstantPlayer;
import swdesign.examplegames.stupidnumbergame.players.RandomPlayer;
import swdesign.game.AI;
import swdesign.game.Game;
import swdesign.tournament.Tournament;

/**
 *
 * @author Andrew
 */
public class ui implements interfaces.TournamentUI{
    private Tournament tournament;
    private List<ParticipantInfo> competitors;
    private List<AI> players;
    private Game game;
    private static boolean starttournament = true;
    private List<Enum> help;
    private List<Enum> playertypes;
    private List<Enum> gametypes;
    private RandomPlayer rp;
    private ConstantPlayer cp;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ui ui = new ui();
        ui.loadhelp();
        while(starttournament){
            System.out.println("Type a command");
            ui.runner(scan.next());
            
        }
    }

    public ui() {
        this.players = new ArrayList<>();
        this.competitors = new ArrayList<>();
        this.help = new ArrayList<>();
        this.gametypes = new ArrayList<>();
        this.playertypes = new ArrayList<>();
        tournament = new Tournament();
        
    }

       @Override
    public void addPlayer(AI ai) {
        players.add(ai);
    }
    
    public void runner(String command){
        
        if(command.equals(""+Commands.Start) && !players.isEmpty()){
            Scanner scan = new Scanner(System.in);
            System.out.println("Choose Tourney name:");
            String name = scan.next();
            tournament.setTournamentName(name);
            System.out.println("Choose Tournament game type");
            String gameType = scan.next();
            if(gameType.equals(""+GameTypes.StupidNumberGame)){
                System.out.println("Choose amount of matches pr game");
                int i = scan.nextInt();
                this.game = new StupidNumberGame(i);
            }
            tournament.startTournament(game, players);
           
            System.out.println("Score from bottom to top");
            competitors = tournament.getParticipants();
            for(ParticipantInfo c: competitors){
                  System.out.println(c.getID()+":"+c.getScore());
            }
        }
            
        if(command.equals(""+Commands.Stop)){
            starttournament = false;
        }
        
        if(command.equals(""+Commands.Help)){
            for(Enum e : help){
                System.out.println("Commands: "+""+e);
            }
            for(Enum p: playertypes){
                System.out.println("AIs: " +p);
            }
            
            for(Enum g: gametypes){
                System.out.println("Games:"+ g);
            }
            
        }
        
        if(command.equals(""+Commands.addPlayer)){
            Scanner scan = new Scanner(System.in);
            System.out.println("Choose a player type");
            String player = scan.next();
            if(player.equals(""+PlayerTypes.RandomNumberPlayer)){
            System.out.println("Choose a player Name");
            String name = scan.next();
            String id = name;
            System.out.println("Choose a gueesing range");
            int i = scan.nextInt();
            rp = new RandomPlayer(name,id,1,i);
            addPlayer(rp);
            }
            if(player.equals(""+PlayerTypes.ConstantNumberPlayer)){
            System.out.println("Choose a player Name");
            String name = scan.next();
            String id = name;
            System.out.println("Choose a Constant number");
            int i = scan.nextInt();
            cp = new ConstantPlayer(name,id,i);
            addPlayer(cp);
            }
        }
        
        if(command.equals(""+Commands.GameInfo)){
            System.out.println("The game is about guessing the highest number");
        }
        
    }
    
    private void loadhelp(){
        
        help.add(Commands.GameInfo);
        help.add(Commands.Start);
        help.add(Commands.Stop);
        help.add(Commands.addPlayer);
        playertypes.add(PlayerTypes.RandomNumberPlayer);
        playertypes.add(PlayerTypes.ConstantNumberPlayer);
        gametypes.add(GameTypes.StupidNumberGame);
    }
    
}

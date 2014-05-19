/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

import interfaces.ParticipantInfo;
import interfaces.TournamentUI.Commands;
import interfaces.TournamentUI.GameTypes;
import interfaces.TournamentUI.PlayerTypes;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import swdesign.examplegames.stupidnumbergame.StupidNumberGame;
import swdesign.examplegames.stupidnumbergame.StupidNumberPlayer;
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

    private ui() {
        this.players = new ArrayList<>();
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
        int amountOfGames = 0;
        String gameType = "Default";
        Scanner scan = new Scanner(System.in);
        if(command.equals(""+Commands.Start) && !players.isEmpty()){
            System.out.println("Choose Tourney name:");
            String name = scan.next();
            tournament.setTournamentName(name);
            System.out.println("Choose Tournament game type");
            gameType = scan.next();
            System.out.println("Choose amount of matches pr game");
            amountOfGames = scan.nextInt();
             
            startTournament(gameType, players, name, amountOfGames);
            System.out.println("Score from bottom to top");
            showResults(tournament.getParticipants());
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
          addPlayer();
        }
        
        if(command.equals(""+Commands.addPlayers)){
            System.out.println("Choose amount of players to be added");
            int i = scan.nextInt();
            addPlayers(i);
        }
        
        if(command.equals(""+Commands.GameInfo)){
            System.out.println("The game is about guessing the highest number");
        }
         if(command.equals("Zoidberg")){
            System.out.println("The game is Rigged");
            thingy();
        }
        
    }
    
    private void loadhelp(){
        
        help.add(Commands.GameInfo);
        help.add(Commands.Start);
        help.add(Commands.Stop);
        help.add(Commands.addPlayer);
        help.add(Commands.addPlayers);
        playertypes.add(PlayerTypes.RandomNumberPlayer);
        playertypes.add(PlayerTypes.ConstantNumberPlayer);
        gametypes.add(GameTypes.StupidNumberGame);
    }

    @Override
    public void startTournament(String gametype, List<AI> players, String tournamentName, int GamesPrMatch) {

        if(gametype.equals("StupidNumberGame")){
                this.game = new StupidNumberGame(GamesPrMatch);
        
        }
        
        tournament.setTournamentName(tournamentName);
        if(game != null && !players.isEmpty()){
        tournament.startTournament(game, players);
        
        }
        
    }

    @Override
    public void showResults(List<ParticipantInfo> results) {
        for(ParticipantInfo pi : results){
            System.out.println("Player "+pi.getName()+" Score: "+pi.getScore());
        }
        
    }

    @Override
    public void addPlayers(int players) {
        int i = 0;
        while(i<=players){
            addPlayer();
            i++;
        }
    
    }
    
    private void addPlayer(){
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
    
    private void thingy(){
        StupidNumberPlayer a = new ConstantPlayer("a", "a", 10);
        StupidNumberPlayer b = new ConstantPlayer("b", "b", 9);
        StupidNumberPlayer c = new ConstantPlayer("c", "c", 8);
        StupidNumberPlayer d = new  ConstantPlayer("d", "d", 7);
        StupidNumberPlayer e = new  ConstantPlayer("e", "e", 6);
        StupidNumberPlayer z = new  ConstantPlayer("z", "z", 5);
        StupidNumberPlayer z1 = new  RandomPlayer("zod", "zod",1, 5);
        StupidNumberPlayer z2 = new  RandomPlayer("Zebra", "Zebra",1, 8);
        StupidNumberPlayer z3 = new  RandomPlayer("Bear", "Bear", 1,9);
       ArrayList<AI> list = new ArrayList<>();
       list.add((AI)a);
       list.add((AI)b);
       list.add((AI)c);
       list.add((AI)d);
       list.add((AI)e);
       list.add((AI)z);
       list.add((AI)z1);
       list.add((AI)z2);
       list.add((AI)z3);
        startTournament("StupidNumberGame", list, "Test", 50);
        showResults(tournament.getParticipants());
    }
}

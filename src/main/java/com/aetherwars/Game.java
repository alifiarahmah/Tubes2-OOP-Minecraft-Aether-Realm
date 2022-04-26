package com.aetherwars;
import com.aetherwars.model.*;
import com.aetherwars.event.*;

public class Game {
    private Player players[];
    private int turns;
    private Phase phase;
    private int cur_player;
    private EventChannel channel;
    
    public Game(Player p1, Player p2, EventChannel channel){
        this.players = new Player[2];
        this.players[0] = p1;
        this.players[1] = p2;
        this.channel = channel;
        this.cur_player = 0;
    }
}

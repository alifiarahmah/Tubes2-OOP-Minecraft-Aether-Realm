package com.aetherwars;
import com.aetherwars.model.*;
import com.aetherwars.event.*;

public class Game implements Publisher, Subscriber{
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
    
    public void setup(){
        // di sini harusnya draw 3 kartu dulu
        // terus tiap player reset health
        // publish event playerchanged buat ngubah giliran player jadi giliran p1
        // terus pake stageController buat masuk fase draw
    }
    
    public void stageController(Phase phase){
        if(phase == Phase.DRAW){
            // draw
        }else if (phase == Phase.END){
            // end phase
        }
    }
    @Override
    public void onEvent(Event event){
        // kalo eventnya PhaseChangeEvent
    }
    
    @Override
    public void publish(Event event){
        this.channel.sendEvent(this, event);
    }
}

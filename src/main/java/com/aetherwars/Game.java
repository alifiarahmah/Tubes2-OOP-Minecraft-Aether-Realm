package com.aetherwars;
import com.aetherwars.model.*;
import com.aetherwars.card.*;
import com.aetherwars.card.Character.*;
import java.util.*;

import com.aetherwars.event.*;

public class Game implements Publisher, Subscriber{
    private Player players[];
    private int turns;
    private int phase_id = 0;
    private Phase[] phases = new Phase[] {Phase.DRAW, Phase.PLAN, Phase.ATTACK, Phase.END};
    private int cur_player;
    private EventChannel channel;
    private Deck deck[];
    
    public Game(Player p1, Player p2, EventChannel channel, List<?> listchar){
    	this.deck = new Deck[2];
    	for(int i=0; i<2; i++) {
    		for(int j=0; j<60; j++) {
    			Random random = new Random();
    			int idx = random.nextInt(18);
    			deck[i].addCard((Card)listchar.get(idx)); // add 60 karakter ke deck 
    		}	
    	}
        this.players = new Player[2];
        this.players[0] = p1;
        this.players[1] = p2;
        this.channel = channel;
        this.cur_player = 0;
    }
    
    public void setup(){
        for(int i=0; i<2; i++) {
        	for(int j=0; j<3; j++) {
        		this.players[i].addCard(this.deck[i].drawCard());
        	} // di sini harusnya draw 3 kartu dulu
        }
        this.players[0].setHP(80);
        this.players[1].setHP(80);;// terus tiap player reset health
        
        publish(new PlayerChangedEvent(this.cur_player));
        // publish event playerchanged buat ngubah giliran player jadi giliran p1
        stageController(this.phases[this.phase_id]);
        // terus pake stageController buat masuk fase draw
    }
    
    public Player getPlayer(int player_num) {
    	return this.players[player_num];
    }
    
    public int getCurPlayer() {
    	return this.cur_player;
    }
    
    public void stageController(Phase phase){
        if(phase == Phase.DRAW){
            // draw
        }else if (phase == Phase.END){
            // end phase
        }
    }
    
    public void draw() {
    	// manggil draw()
    }
    
    public void solveBattle() {
    	
    }
    
    public boolean canDirectAttack() {
    	// kalo kartu di tangan musuh abis
    	return this.players[(cur_player+1)%2].getIsDeckEmpty();
    }
    @Override
    public void onEvent(Event event){
        // kalo eventnya PhaseChangeEvent
    	if (event instanceof PhaseChangedEvent) {
    		stageController((Phase)event.getInfo());
    	}
    }
    
    @Override
    public void publish(Event event){
        this.channel.sendEvent(this, event);
    }
}

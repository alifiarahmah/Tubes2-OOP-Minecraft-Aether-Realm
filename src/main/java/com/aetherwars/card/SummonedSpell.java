package com.aetherwars.card;
import com.aetherwars.event.*;
import com.aetherwars.card.spell.*;


public class SummonedSpell implements Summoned, Publisher {
    private Spell spellCard;
    private SummonedCharacter target;
    BoardChannel channel;

    public SummonedSpell(Spell spell){
        this.spellCard = spell;
    }

    public void setTargetSC(SummonedCharacter target){
        this.target = target;
    }
    public Card getBaseCard(){
        return this.spellCard;
    }
    public SummonedCharacter getTarget(){
        return this.target;
    }
    public void setChannel(BoardChannel channel){
        this.channel = channel;
    }

    public void removeCard(){
        this.target.removeSpellFromChar(this);
        publish(new DestroySummonedCardEvent(this));
    }
    @Override 
    public void publish(Event event){
        // this.channel.sendEvent(this, event);
    }
}

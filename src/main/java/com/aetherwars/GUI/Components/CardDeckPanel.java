package com.aetherwars.GUI.Components;

import javax.swing.*;

public class CardDeckPanel extends JPanel {
    private int  currentCard;
    private int maxCard;
    public  javax.swing.GroupLayout cardDeckLayout;
    public JLabel decklabel;
    public JLabel cardLeftLabel;
    public CardDeckPanel(int currentCard,int maxCard){
        cardDeckLayout = new GroupLayout(this);
        this.setLayout(cardDeckLayout);
        cardDeckLayout.setAutoCreateGaps(true);
        cardDeckLayout.setAutoCreateContainerGaps(true);
        this.currentCard = currentCard;
        this.maxCard = maxCard;
        this.decklabel = new JLabel("Deck");
        this.cardLeftLabel = new JLabel(this.currentCard+"/"+this.maxCard);
        this.setBackground(new java.awt.Color(200, 200, 200));
        this.setPreferredSize(new java.awt.Dimension(60, 50));

        cardDeckLayout.setHorizontalGroup(
                cardDeckLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(this.decklabel)
                        .addGap(0, 10, Short.MAX_VALUE)
                        .addComponent(this.cardLeftLabel)
                        .addGap(0, 10, Short.MAX_VALUE)
        );
        cardDeckLayout.setVerticalGroup(
                cardDeckLayout.createSequentialGroup()
                        .addComponent(this.decklabel)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(this.cardLeftLabel)
                        .addGap(0, 20, Short.MAX_VALUE)
        );
    }
}

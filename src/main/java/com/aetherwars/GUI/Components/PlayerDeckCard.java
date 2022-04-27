package com.aetherwars.GUI.Components;

import com.aetherwars.card.Character.Character;

import javax.swing.*;
import java.awt.*;

public class PlayerDeckCard extends JPanel {
    private Character chara;
    private String deckNumber;
    private JLabel deckLabel;
    public javax.swing.GroupLayout cardDescriptionLayout;
    public PlayerDeckCard(String deckNumber){
        cardDescriptionLayout = new GroupLayout(this);
        this.setLayout(cardDescriptionLayout);
        cardDescriptionLayout.setAutoCreateGaps(true);
        cardDescriptionLayout.setAutoCreateContainerGaps(true);
        this.deckNumber = deckNumber;
        this.deckLabel = new JLabel(deckNumber);
        this.deckLabel.setFont(new Font("Serif", Font.PLAIN, 50));
        this.setBackground(new java.awt.Color(200, 200, 200));
        this.setPreferredSize(new java.awt.Dimension(75, 90));
        cardDescriptionLayout.setVerticalGroup(
                cardDescriptionLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(this.deckLabel)
        );
        cardDescriptionLayout.setHorizontalGroup(
                cardDescriptionLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGap(75)
                        .addComponent(this.deckLabel)
        );
    }
}

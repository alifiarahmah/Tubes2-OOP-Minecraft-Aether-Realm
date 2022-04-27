package com.aetherwars.GUI.Components;

import javax.swing.*;
import java.awt.*;

public class CardLabel extends JPanel {
    private JLabel name;
    private JLabel description;
    public javax.swing.GroupLayout cardLayout;

    public CardLabel(String name, String description){
        cardLayout = new GroupLayout(this);
        this.setLayout(cardLayout);
        cardLayout.setAutoCreateGaps(true);
        cardLayout.setAutoCreateContainerGaps(true);
        this.name = new JLabel(name);
        this.description = new JLabel(description);
        this.setBackground(new java.awt.Color(200, 200, 200));

        cardLayout.setVerticalGroup(
                cardLayout.createSequentialGroup()
                        .addComponent(this.name).addGap(0, 74, 126)
                .addComponent(this.description)
        );
        cardLayout.setHorizontalGroup(
                cardLayout.createParallelGroup(
                        GroupLayout.Alignment.CENTER
                )
                        .addComponent(this.name).addGap(0, 78, Short.MAX_VALUE)
                        .addComponent(this.description)
        );
    }
}

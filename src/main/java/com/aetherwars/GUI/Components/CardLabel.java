package com.aetherwars.GUI.Components;

import javax.swing.*;
import java.awt.*;

public class CardLabel extends JPanel {
    private JLabel name;
    private JLabel description;

    public CardLabel(String name, String description){
        //setLayout(new BorderLayout());
        this.name = new JLabel(name);
        this.description = new JLabel(description);
        add(this.name);
        add(this.description);
        this.setBackground(new java.awt.Color(255, 53, 184));
    }
}

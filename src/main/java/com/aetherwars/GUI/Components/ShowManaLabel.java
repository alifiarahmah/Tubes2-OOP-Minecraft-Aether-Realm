package com.aetherwars.GUI.Components;

import javax.swing.*;

public class ShowManaLabel extends JPanel {
    private int  currentMana;
    private int maxMana;
    public  javax.swing.GroupLayout showManaLayout;
    public JLabel manalabel;
    public JLabel manaLeftLabel;
    public ShowManaLabel(int currentMana,int maxMana){
        showManaLayout = new GroupLayout(this);
        this.setLayout(showManaLayout);
        showManaLayout.setAutoCreateGaps(true);
        showManaLayout.setAutoCreateContainerGaps(true);
        this.currentMana = currentMana;
        this.maxMana = maxMana;
        this.manalabel = new JLabel("Mana");
        this.manaLeftLabel = new JLabel(this.currentMana+"/"+this.maxMana);
        this.setBackground(new java.awt.Color(200, 200, 200));
        this.setPreferredSize(new java.awt.Dimension(60, 50));

        showManaLayout.setHorizontalGroup(
                showManaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(this.manalabel)
                        .addGap(0, 10, Short.MAX_VALUE)
                        .addComponent(this.manaLeftLabel)
                        .addGap(0, 10, Short.MAX_VALUE)
        );
        showManaLayout.setVerticalGroup(
                showManaLayout.createSequentialGroup()
                        .addComponent(this.manalabel)
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(this.manaLeftLabel)
                        .addGap(0, 20, Short.MAX_VALUE)
        );
    }
    public void updatePlayerMana(int mana,int currentMana){
        this.currentMana = mana;
        this.maxMana = currentMana;
        this.manaLeftLabel.setText(this.currentMana+"/"+this.maxMana);
    }
}

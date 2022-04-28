package com.aetherwars.GUI.Components;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import com.aetherwars.card.Character.Character;
import com.aetherwars.card.SummonedCharacter;

public class CardDescriptionPanel extends JPanel {
    private JLabel information;
    private JLabel description;
    public JSeparator separator;
    public javax.swing.GroupLayout cardDescriptionLayout;

    public CardDescriptionPanel(SummonedCharacter chara){
        cardDescriptionLayout = new GroupLayout(this);
        this.setLayout(cardDescriptionLayout);
        cardDescriptionLayout.setAutoCreateGaps(true);
        cardDescriptionLayout.setAutoCreateContainerGaps(true);
      // this.setPreferredSize(new java.awt.Dimension(200, 123));
        //gambar kartu
        String informationtext = "<html><h1>"+chara.getBaseCard().getName()+"</h1><p>ATK : "+chara.getAttack()+
                "</p><p>HP : "+chara.getHealth()+"</p><p>Level : "+chara.getLevel()+"</p><p>EXP: "+
                chara.getExp()+"/"+chara.getMaxExpToNextLevel()+"</p><p>Type : "+chara.getBaseCard().getType()+
                "</p></html>";
        this.information = new JLabel(informationtext);
        this.description = new JLabel("<html><p>\""+chara.getBaseCard().getDescription()+"\"</p></html>");
        this.setBackground(new java.awt.Color(200, 200, 200));
        this.separator = new JSeparator((SwingConstants.VERTICAL));
        this.separator.setBackground(Color.black);

        cardDescriptionLayout.setVerticalGroup(
                cardDescriptionLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(this.information)
                        .addComponent(this.separator)
                        .addComponent(this.description)
        );
        cardDescriptionLayout.setHorizontalGroup(
                cardDescriptionLayout.createSequentialGroup()
                        .addComponent(this.information).addGap(0, 50, Short.MAX_VALUE)
                        .addComponent(this.separator).addGap(0, 50, Short.MAX_VALUE)
                        .addComponent(this.description).addGap(0, 50, Short.MAX_VALUE)
        );
    }
}

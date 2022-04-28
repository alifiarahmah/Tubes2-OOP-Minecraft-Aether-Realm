package com.aetherwars.GUI.Components;

import com.aetherwars.card.Character.Character;
import com.aetherwars.card.SummonedCharacter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

public class PlayerDeckCard extends JPanel {
    private SummonedCharacter chara;
    private String deckNumber;
    public javax.swing.GroupLayout cardDescriptionLayout;
    //kalau gak ada kartu
    private JLabel deckLabel;
    //kalau ada kartu
    private ImageIcon attackIcon;
    private ImageIcon healthIcon;
    private JLabel attackLabel;
    private JLabel healthLabel;
    private ImageIcon sprite;
    private JLabel spriteLabel;
    private JLabel levelLabel;
    private JLabel attackIconLabel;
    private JLabel healthIconLabel;
    private JPanel attackPanel;
    private JPanel healthPanel;
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
    public void addCharacter(SummonedCharacter c){
        this.chara = c;
        this.cardDescriptionLayout.removeLayoutComponent(this.deckLabel);
        this.attackIcon = loadAsset("/com/aetherwars/card/image/icon/attack.png",15,15);
        this.attackIconLabel = new JLabel(this.attackIcon);
        this.healthIcon = loadAsset("/com/aetherwars/card/image/icon/health.png",15,15);
        this.healthIconLabel = new JLabel(this.healthIcon);
        this.attackLabel = new JLabel(Integer.toString(c.getAttack()));
        this.healthLabel = new JLabel(Float.toString(c.getHealth()));
        this.sprite = loadAsset(c.getBaseCard().getImagepath(),80,100);
        this.spriteLabel = new JLabel(this.sprite);
        this.levelLabel = new JLabel(c.getExp()+"/"+c.getMaxExpToNextLevel()+" ["+c.getLevel()+"]");

        javax.swing.GroupLayout attackLayout = new GroupLayout(this);
        this.attackPanel.setLayout(attackLayout);
        attackLayout.setAutoCreateGaps(true);
        attackLayout.setAutoCreateContainerGaps(true);

        attackLayout.setVerticalGroup(
                attackLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(this.attackIconLabel)
                        .addComponent(this.attackLabel)
        );


        cardDescriptionLayout.setVerticalGroup(
                cardDescriptionLayout.createSequentialGroup()
                       // .addGroup(cardDescriptionLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(this.attackIconLabel)
                                .addComponent(this.attackLabel)
                                .addComponent(this.healthIconLabel)
                        .addComponent(this.healthLabel)
                        .addComponent(this.spriteLabel)
                        .addComponent(this.levelLabel)
                        //)

        );
        cardDescriptionLayout.setHorizontalGroup(
                cardDescriptionLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(this.attackIconLabel)
                        .addComponent(this.attackLabel)
                        .addComponent(this.healthIconLabel)
                        .addComponent(this.healthLabel)
                        .addComponent(this.spriteLabel)
                        .addComponent(this.levelLabel)
                        .addGap(30)
        );
        this.revalidate();
        this.repaint();
    }
    private ImageIcon loadAsset(String imagePath,int scaledWith,int scaledHeight){
        Image new_img = null;
        try {
            System.out.println(imagePath);
            URL path = getClass().getResource(imagePath);
            BufferedImage original_image = ImageIO.read(new File(path.toURI()));
            ImageIcon image_pre = new ImageIcon(original_image);
            //resize image
            Image image = image_pre.getImage();
            new_img = image.getScaledInstance(scaledWith,scaledHeight,Image.SCALE_DEFAULT);
        }
        catch(Exception e){
            System.out.println(e);
        }
        return new ImageIcon(new_img);
    }

}

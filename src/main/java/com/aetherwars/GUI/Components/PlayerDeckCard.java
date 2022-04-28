package com.aetherwars.GUI.Components;

import com.aetherwars.card.Character.Character;
import com.aetherwars.card.SummonedCharacter;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
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
        this.deckNumber = deckNumber;
        initializeDeckCard();
    }
    public void initializeDeckCard(){
        cardDescriptionLayout.setAutoCreateGaps(true);
        cardDescriptionLayout.setAutoCreateContainerGaps(true);
        this.deckLabel = new JLabel(deckNumber);
        this.deckLabel.setFont(new Font("Serif", Font.PLAIN, 50));
        this.setBackground(new java.awt.Color(200, 200, 200));
        this.setPreferredSize(new java.awt.Dimension(80, 140));
        cardDescriptionLayout.setVerticalGroup(
                cardDescriptionLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGap(130)
                        .addComponent(this.deckLabel)
        );
        cardDescriptionLayout.setHorizontalGroup(
                cardDescriptionLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGap(75)
                        .addComponent(this.deckLabel)
        );
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        this.setBorder(border);
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
        this.sprite = loadAsset(c.getBaseCard().getImagepath(),80,70);
        this.spriteLabel = new JLabel(this.sprite);
        this.levelLabel = new JLabel(c.getExp()+"/"+c.getMaxExpToNextLevel()+" ["+c.getLevel()+"]");
        this.deckLabel = null;
        this.healthPanel = new JPanel();
        javax.swing.GroupLayout healthLayout = new GroupLayout(this.healthPanel);
        this.healthPanel.setLayout(healthLayout);
        this.healthPanel.setBackground(new java.awt.Color(200, 200, 200));

        healthLayout.setHorizontalGroup(
                healthLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(this.healthIconLabel)
                        .addComponent(this.healthLabel)
        );
        healthLayout.setVerticalGroup(
                healthLayout.createSequentialGroup()
                        .addComponent(this.healthIconLabel)
                        .addComponent(this.healthLabel)
        );


        this.attackPanel = new JPanel();
        javax.swing.GroupLayout attackLayout = new GroupLayout(this.attackPanel);
        this.attackPanel.setLayout(attackLayout);
        this.attackPanel.setBackground(new java.awt.Color(200, 200, 200));
        //attackLayout.setAutoCreateGaps(true);
        //attackLayout.setAutoCreateContainerGaps(true);

        attackLayout.setHorizontalGroup(
                attackLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(this.attackIconLabel)
                        .addComponent(this.attackLabel)
        );
        attackLayout.setVerticalGroup(
                attackLayout.createSequentialGroup()
                        .addComponent(this.attackIconLabel)
                        .addComponent(this.attackLabel)
        );

        cardDescriptionLayout.setAutoCreateGaps(false);
        cardDescriptionLayout.setAutoCreateContainerGaps(false);

        cardDescriptionLayout.setVerticalGroup(
                cardDescriptionLayout.createSequentialGroup()
                        .addGap(10)
                        .addGroup(cardDescriptionLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(attackPanel).addGap(20)
                      //  .addComponent(this.healthLabel)
                        .addComponent(healthPanel)
                        )
                        .addComponent(this.spriteLabel)
                        .addComponent(this.levelLabel)
                        .addGap(10)

        );
        cardDescriptionLayout.setHorizontalGroup(
                cardDescriptionLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(cardDescriptionLayout.createSequentialGroup()
                        .addComponent(attackPanel).addGap(20)
                        .addComponent(healthPanel)
                        )
                        .addComponent(this.spriteLabel)
                        .addComponent(this.levelLabel)
                        .addGap(30)

        );
        this.revalidate();
        this.repaint();
    }
    public void removeCharacter(){
        this.chara = null;
        this.cardDescriptionLayout.removeLayoutComponent(this.attackPanel);
        this.cardDescriptionLayout.removeLayoutComponent(this.healthPanel);
        this.cardDescriptionLayout.removeLayoutComponent(this.spriteLabel);
        this.cardDescriptionLayout.removeLayoutComponent(this.levelLabel);

        this.attackIcon = null;
        this.attackIconLabel = null;
        this.healthIcon = null;
        this.healthIconLabel = null;
        this.attackLabel = null;
        this.healthLabel = null;
        this.sprite = null;
        this.spriteLabel = null;
        this.levelLabel = null;
        this.healthPanel = null;
        this.attackPanel = null;
        this.deckLabel = new JLabel(deckNumber);
        this.deckLabel.setFont(new Font("Serif", Font.PLAIN, 50));
        cardDescriptionLayout.setAutoCreateGaps(true);
        cardDescriptionLayout.setAutoCreateContainerGaps(true);
        cardDescriptionLayout.setVerticalGroup(
                cardDescriptionLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGap(130)
                        .addComponent(this.deckLabel)
        );
        cardDescriptionLayout.setHorizontalGroup(
                cardDescriptionLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGap(75)
                        .addComponent(this.deckLabel)
        );
        setSelected(false);
        this.revalidate();
        this.repaint();
    }

    public void setSelected(boolean isSelected){
        if(this.chara!=null && isSelected) {
            this.setBackground(new java.awt.Color(217, 234, 211));
            this.attackPanel.setBackground(new java.awt.Color(217, 234, 211));
            this.healthPanel.setBackground(new java.awt.Color(217, 234, 211));
            Border border = BorderFactory.createLineBorder(new java.awt.Color(251, 180, 84));
            this.setBorder(border);
        }
        else if(!isSelected){
            this.setBackground(new java.awt.Color(200, 200, 200));
            this.attackPanel.setBackground(new java.awt.Color(200, 200, 200));
            this.healthPanel.setBackground(new java.awt.Color(200, 200, 200));
            Border border = BorderFactory.createLineBorder(Color.BLACK);
            this.setBorder(border);
        }
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

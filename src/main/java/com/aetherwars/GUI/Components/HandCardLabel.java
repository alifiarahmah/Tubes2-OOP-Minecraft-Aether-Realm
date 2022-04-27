package com.aetherwars.GUI.Components;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;

public class HandCardLabel extends JPanel {
    private JLabel CardImage;
    private JLabel manaCostLabel;
    private JLabel statLabel;
    private ImageIcon picture;
    public javax.swing.GroupLayout cardLayout;

    public HandCardLabel(int manacost,String description,String imagePath){
        cardLayout = new GroupLayout(this);
        this.setLayout(cardLayout);
        cardLayout.setAutoCreateGaps(true);
        cardLayout.setAutoCreateContainerGaps(true);
        //gambar kartu
        try {
            //String path = URLEncoder.encode(imagePath, "UTF-8").replace("+", "%20");
            //System.out.println(path);
            System.out.println(imagePath);
            //URI uri = new URI(imagePath.replaceAll(" ","%20"));
            //System.out.println(uri.getPath());
            URL path = getClass().getResource(imagePath);
            BufferedImage original_image = ImageIO.read(new File(path.toURI()));
            picture = new ImageIcon(original_image);
            //resize image
            Image image = picture.getImage();
            Image new_img = image.getScaledInstance(60,70,Image.SCALE_DEFAULT);
            picture = new ImageIcon(new_img);
        }
            catch(Exception e){
                System.out.println(e);
            }
        CardImage = new JLabel(picture);
        this.manaCostLabel = new JLabel("MANA "+manacost);
        this.statLabel = new JLabel(description);
        this.setBackground(new java.awt.Color(200, 200, 200));

        cardLayout.setVerticalGroup(
                cardLayout.createSequentialGroup()
                        .addComponent(this.CardImage).addGap(0, 10, 20)
                        .addComponent(this.manaCostLabel).addGap(0, 10, 20)
                .addComponent(this.statLabel).addContainerGap( 20, 30)
        );
        cardLayout.setHorizontalGroup(
                cardLayout.createParallelGroup(
                        GroupLayout.Alignment.CENTER
                )
                        .addComponent(this.CardImage).addGap(0, 78, Short.MAX_VALUE)
                        .addComponent(this.manaCostLabel).addGap(0, 78, Short.MAX_VALUE)
                        .addComponent(this.statLabel)
        );
    }
}

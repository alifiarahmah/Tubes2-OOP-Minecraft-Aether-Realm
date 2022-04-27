package com.aetherwars.GUI.Components;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

public class CardPreviewPanel extends JPanel {
    private ImageIcon picture;
    public javax.swing.GroupLayout previewLayout;
    private JLabel sprite;

    public CardPreviewPanel(String imagePath){
        previewLayout = new GroupLayout(this);
        this.setLayout(previewLayout);
        previewLayout.setAutoCreateGaps(true);
        previewLayout.setAutoCreateContainerGaps(true);
        //gambar kartu
        try {
            System.out.println(imagePath);
            URL path = getClass().getResource(imagePath);
            BufferedImage original_image = ImageIO.read(new File(path.toURI()));
            picture = new ImageIcon(original_image);
            //resize image
            Image image = picture.getImage();
            Image new_img = image.getScaledInstance(100,120,Image.SCALE_DEFAULT);
            picture = new ImageIcon(new_img);
        }
        catch(Exception e){
            System.out.println(e);
        }
        sprite = new JLabel(picture);
        this.setBackground(new java.awt.Color(50, 50, 50));

        previewLayout.setVerticalGroup(
                previewLayout.createSequentialGroup()
                        .addComponent(this.sprite).addGap(0, 20, 30)
        );
        previewLayout.setHorizontalGroup(
                previewLayout.createParallelGroup(
                                GroupLayout.Alignment.CENTER
                        )
                        .addComponent(this.sprite).addGap(0, 78, Short.MAX_VALUE)
        );
    }
}

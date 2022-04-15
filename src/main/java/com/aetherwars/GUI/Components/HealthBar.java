package main.java.com.aetherwars.GUI.Components;

import java.awt.Component;

import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Dimension;

public class HealthBar extends JPanel{
    private int hp = 100;
    private String name;
    private float align = Component.LEFT_ALIGNMENT;

    public HealthBar(String name, float align){
        this.name = name;
        this.align = align;
        render();
    }
    
    public void render(){
        this.setLayout(new BoxLayout(this, javax.swing.BoxLayout.PAGE_AXIS));
    
        JPanel pnl_health_bar = new JPanel();
    
        JLabel lbl_name = new JLabel(name + " [" + hp +"]");
        JProgressBar prb_health_bar = new JProgressBar(0,100);
        prb_health_bar.setPreferredSize(new Dimension(250,20));
        pnl_health_bar.add(prb_health_bar);
        this.add(Box.createRigidArea(new Dimension(0,10)));
        
        pnl_health_bar.setAlignmentX(align);
        this.add(pnl_health_bar);
        lbl_name.setAlignmentX(align);
        this.add(lbl_name);

        prb_health_bar.setValue(hp);
    }
}

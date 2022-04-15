import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.Box;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Color;

import main.java.com.aetherwars.GUI.Components.*;

public class GUI{
    private String player1_name = "Steve";
    private String player2_name = "Alex";
    private int player1_health = 100;
    private int player2_health = 100;
    public static void main(String args[]){
        new GUI();
    }

    public GUI(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750,500);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        
        HealthBar hb_player1 = new HealthBar(player1_name, Component.LEFT_ALIGNMENT);
        HealthBar hb_player2 = new HealthBar(player2_name, Component.RIGHT_ALIGNMENT);
        
        JPanel pnl_turns = new JPanel();
        JPanel pnl_north = new JPanel();
        pnl_north.setLayout(new BorderLayout());
        
        pnl_north.add(hb_player1, BorderLayout.LINE_START);
        pnl_north.add(pnl_turns, BorderLayout.CENTER);
        pnl_north.add(hb_player2, BorderLayout.LINE_END);
        frame.add(pnl_north, BorderLayout.NORTH);
        frame.setVisible(true);
        frame.pack();
    }
}
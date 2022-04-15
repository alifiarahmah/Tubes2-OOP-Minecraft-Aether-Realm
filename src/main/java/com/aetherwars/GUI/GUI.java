import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.Box;
import javax.swing.UIManager;
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
    private int player2_health = 50;
    private int turn = 0;
    public static void main(String args[]){
        new GUI();
    }

    public GUI(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750,500);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        
        UIManager.put("ProgressBar.foreground", Color.GREEN);
        HealthBar hb_player1 = new HealthBar(player1_name, player1_health, Component.LEFT_ALIGNMENT);
        HealthBar hb_player2 = new HealthBar(player2_name, player2_health, Component.RIGHT_ALIGNMENT);
        
        JPanel pnl_turns = new JPanel();
        pnl_turns.setBackground(new Color(0xCCCCCC));
        JLabel lbl_turns = new JLabel("Turn " + turn);
        pnl_turns.add(lbl_turns);
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
package me.rockorbonk.tamodienynas.GUI;

import javax.swing.*;
import java.awt.*;

public class mainGui extends JFrame{

    public static JFrame mainScreen = new JFrame("Tamo");

    public mainGui() {

        JPanel topPanel = new JPanel();

        mainScreen.setSize(1150, 900);
        mainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainScreen.setResizable(false);
        mainScreen.setLayout(new BorderLayout());

        topPanel.setBackground(new Color(226, 230, 204));
        topPanel.setPreferredSize(new Dimension(1150, 100));

        mainScreen.add(topPanel, BorderLayout.NORTH);

        ImageIcon icon = new ImageIcon("C:\\Users\\uname\\Desktop\\TamoDienynas\\pngs\\tamo.png");
        mainScreen.setIconImage(icon.getImage());

        mainScreen.setVisible(false);
    }

    public static void main(String[] args) {
        new mainGui();
    }
}

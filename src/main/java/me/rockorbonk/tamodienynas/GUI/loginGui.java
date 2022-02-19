package me.rockorbonk.tamodienynas.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginGui extends JFrame  implements ActionListener {

    private static JFrame frame;
    private static JPanel panel;
    private static JLabel userLabel;
    private static JLabel passwordLabel;
    private static JLabel success;
    private static JButton login;
    private static JTextField userText;
    private static JPasswordField passwordText;

    loginGui() {
        frame = new JFrame();
        panel = new JPanel();
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(panel);

        panel.setLayout(null);

        userLabel = new JLabel("User");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        userText = new JTextField();
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        login = new JButton("Login");
        login.setBounds(10, 80, 80, 25);
        login.addActionListener(this);
        panel.add(login);

        success = new JLabel("");
        success.setBounds(10, 110, 300, 25);
        panel.add(success);

        ImageIcon icon = new ImageIcon("C:\\Users\\uname\\Desktop\\TamoDienynas\\pngs\\tamo.png");
        frame.setIconImage(icon.getImage());
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String uname = userText.getText();
        String pwd = passwordText.getText();

        if(uname.equals("rokasbruz") && pwd.equals("Rokas123")) {
            success.setText("Sekmingai prisijungėte!");

            ActionListener l = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    userLabel.setVisible(false);
                    passwordLabel.setVisible(false);
                    userText.setVisible(false);
                    passwordText.setVisible(false);
                    login.setVisible(false);

                    success.setVisible(false);

                }
            };
            Timer timer = new Timer(2000, l);
            timer.setRepeats(false);
            timer.start();

        }
        else{
            success.setText("Slapyvardis arba slaptažodis nesutampa!");
        }

    }
    public static void main(String[] args) {
    new loginGui();

    }
}

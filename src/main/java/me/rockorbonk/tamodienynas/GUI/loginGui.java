package me.rockorbonk.tamodienynas.GUI;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;



public class loginGui extends JFrame  implements ActionListener {

    private static final long serialVersionUID = 1L;
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
        success.setBounds(10, 540, 300, 25);
        panel.add(success);

        ImageIcon icon = new ImageIcon("C:\\Users\\uname\\Desktop\\tamo.png");
        frame.setIconImage(icon.getImage());
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String uname = userText.getText();
        String pwd = passwordText.getText();

        DefaultHttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost("https://dienynas.tamo.lt/Prisijungimas/Login/Username="+uname+"&Password=" + pwd);

        try {
            HttpResponse response = client.execute(post);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (ae.getSource() == login) {
            if (uname.equals(post) && pwd.equals(post)) {
                frame.setSize(frame.getWidth() + 500, frame.getHeight() + 400);

            }
        }
    }
    public static void main(String[] args) {
        try {
            loginGui loginFrame = new loginGui();

        } catch (Exception e) {
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
}

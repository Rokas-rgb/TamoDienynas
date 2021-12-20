package me.rockorbonk.tamodienynas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class GUI implements ActionListener {
    private static JFrame frame;
    private static JPanel panel;
    private static JLabel userLabel;
    private static JLabel passwordLabel;
    private static JLabel success;
    private static JButton login;
    private static JTextField userText;
    private static JPasswordField passwordText;
    private static JButton register; //TODO
    private static final String tamoDienynas = "https://dienynas.tamo.lt/api?UserName=rokasbruz&Password=Rokas123";

    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(tamoDienynas))
                .build();
        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        String html = "<html><head><body><div style=\"font-size:24px;font-weight:bold;line-height:24px;\"> 10 </div></body></head></html>";

        Pattern pattern = Pattern.compile(".*<div style=\"font-size:24px;font-weight:bold;line-height:24px;\">(.*?)</div>.*");
        Matcher matcher = pattern.matcher(html);

        if (matcher.find()) {
            System.out.println(matcher.group(1));

        }
        frame = new JFrame();
        panel = new JPanel();
        frame.setSize(350,200);
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
        login.addActionListener(new GUI());
        panel.add(login);

        success = new JLabel("");
        success.setBounds(10, 540, 300, 25);
        panel.add(success);

        frame.setVisible(true);
        ImageIcon icon = new ImageIcon("C:\\Users\\uname\\Desktop\\tamo.png");
        frame.setIconImage(icon.getImage());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = userText.getText();
        String password = passwordText.getText();
        System.out.println(user + ", " + password);

        if(user.equals("rokasbruz") && password.equals("Rokas123")) {
            success.setText("Successfully logged in");

            userLabel.setVisible(false);
            passwordLabel.setVisible(false);
            userText.setVisible(false);
            passwordText.setVisible(false);
            login.setVisible(false);

            frame.setSize(frame.getWidth() + 500, frame.getHeight() + 400);

        }
        else{
            success.setText("Username or Password is incorrect");
        }
    }
}

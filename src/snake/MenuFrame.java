package snake;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class MenuFrame extends JFrame {
    private final int MENU_WIDTH = 315;
    private final int MENU_HEIGHT = 400;

    MenuFrame(){
        this.setTitle("Menu");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(MENU_WIDTH,MENU_HEIGHT);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);




        JPanel menuPanel = new JPanel();
        menuPanel.setPreferredSize(new Dimension(MENU_WIDTH,MENU_HEIGHT));
        menuPanel.setBackground(Color.BLACK);
        menuPanel.setLayout(null);

        JLabel label1 = new JLabel("Snake");
        label1.setFont(new Font("SANS_SERIF",Font.BOLD, 40));
        label1.setForeground(Color.GREEN);
        label1.setBounds(90,10,150,50);
        label1.setVisible(true);
        menuPanel.add(label1);

        String[] difficulties = {"Baby","Easy","Medium","Hard","SUS"};
        JComboBox chooseDifficulty = new JComboBox(difficulties);
        chooseDifficulty.setBounds(140,150,150,30);
        chooseDifficulty.setBackground(Color.green);
        chooseDifficulty.setFont(new Font("Serif", Font.BOLD, 18));
        chooseDifficulty.setVisible(true);
        menuPanel.add(chooseDifficulty);

        MyButton startGame = new MyButton(75,85,150,30,"PLAY");
        startGame.setBackground(Color.green);
        startGame.setLayout(null);
        startGame.setVisible(true);
        startGame.addActionListener(e-> {
            dispose();
            new GameFrame(Objects.requireNonNull(chooseDifficulty.getSelectedItem()).toString());
        });
        menuPanel.add(startGame);

        JLabel label = new JLabel("Difficulty:");
        label.setBounds(10,150,250,30);
        label.setFont(new Font("Serif", Font.BOLD, 26));
        label.setForeground(Color.GREEN);
        menuPanel.add(label);

        MyButton scoresButton = new MyButton(75,225,150,30,"SCORES");
        scoresButton.setBackground(Color.green);
        scoresButton.setLayout(null);
        scoresButton.setVisible(true);
        scoresButton.addActionListener(e-> {
            try {
                new ScoresFrame();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        menuPanel.add(scoresButton);

        MyButton exitButton = new MyButton(75,300,150,30,"EXIT");
        exitButton.setBackground(Color.green);
        exitButton.setLayout(null);
        exitButton.setVisible(true);
        exitButton.addActionListener(e ->System.exit(0));
        menuPanel.add(exitButton);

        menuPanel.setVisible(true);
        this.add(menuPanel);
    }
}

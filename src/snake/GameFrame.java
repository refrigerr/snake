package snake;

import javax.swing.*;

public class GameFrame extends JFrame {

    GameFrame(String difficulty){
        this.add(new GamePanel(difficulty));
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }



}

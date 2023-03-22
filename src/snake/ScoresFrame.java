package snake;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ScoresFrame extends JFrame {

    List<Score> scores = new ArrayList<>();

    ScoresFrame() throws IOException {
        this.setTitle("Scores");
        this.setDefaultCloseOperation();
        this.setSize(400,400);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        JPanel panel = new JPanel();
        panel.setBounds(0,0,400,400);

        File file = new File("Scores.txt");
        file.createNewFile();
        try (Scanner read = new Scanner(file)) {
            if(!read.hasNextLine()){
                read.close();
                return;
            }
            while(read.hasNextLine()){
                String score = read.nextLine();
                String difficulty= read.nextLine();
                String date = read.nextLine();
                int scoree;
                scoree = Integer.parseInt(score);
                scores.add(new Score(scoree,difficulty,date));

            }
        }

        JTable table = new JTable();
        table.setBounds(0,0,400,400);
        String[] columnNames = {"Score", "Difficulty", "Date"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        for (Score score: scores) {
            Object[] o = new Object[3];
            o[0] = score.getScore();
            o[1] = score.getDifficulty();
            o[2] = score.getDate();
            model.addRow(o);
        }
        table.setModel(model);

        table.setVisible(true);
        panel.add(table);

        panel.setVisible(true);
        this.add(panel);
    }

    private void setDefaultCloseOperation() {
        dispose();
    }
}

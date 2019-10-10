package view;

import model.*;

import javax.swing.*;
import java.awt.*;

public class View {

    Model model;
    ChessBoard chessBoard;
    ChessBoxWhite chessBoxWhite;
    ChessBoxBlack chessBoxBlack;


    public View(Model model) {
        this.model = model;
        initComponents();
    }

    void initComponents() {
        this.chessBoard = new ChessBoard(model.figureList);
        this.chessBoxWhite = new ChessBoxWhite(model.whiteDeadList);
        this.chessBoxBlack = new ChessBoxBlack(model.blackDeadList);
        initFrame(chessBoard, chessBoxWhite, chessBoxBlack);
    }

    private void initFrame(ChessBoard chessBoard, ChessBoxWhite chessBoxWhite, ChessBoxBlack chessBoxBlack) {
        JFrame frame = new JFrame();
        frame.setSize(1000, 1000);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        JButton options = new JButton("Options");
        Container pane = frame.getContentPane();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridheight = 3;
        c.gridwidth = 4;
        c.weightx=0.5;
        c.weighty=0.5;
        c.gridx = 0;
        c.gridy = 0;
        pane.add(options, c);
        c.gridx = 1;
        c.gridy = 0;
        pane.add(chessBoxBlack);
        c.gridx = 1;
        c.gridy = 1;
        pane.add(chessBoard);
        c.gridx = 1;
        c.gridy = 2;
        pane.add(chessBoxWhite);
        pane.setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


}
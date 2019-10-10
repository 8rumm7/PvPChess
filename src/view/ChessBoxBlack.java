package view;

import model.Figure;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class ChessBoxBlack extends JPanel {

    private final LinkedList<Figure> blackDeadList;

    public ChessBoxBlack(LinkedList<Figure> blackDeadList) {

        this.blackDeadList = blackDeadList;
        init();
    }


    private void init() {
        this.setSize(100, 100);
        JPanel rect1;
        rect1 = new JPanel();
        rect1.setBackground(new Color(132, 104, 78));
        rect1.setSize(1000, 1000);
        rect1.setPreferredSize(new Dimension(1000,1000));
        this.add(rect1);
        this.setVisible(true);
    }
}

package view;

import model.Figure;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class ChessBoard extends JPanel {
    LinkedList<Figure> figureList;

    public ChessBoard(LinkedList<Figure> figureList) {
        this.figureList = figureList;
        init();
    }

    private void init() {
        this.setBorder(BorderFactory.createBevelBorder(1));
        this.setLayout(new GridLayout(8, 8));
        JPanel rect;
        for (int i = 0; i < 8; i++) {
            for (int n = 0; n < 8; n++) {
                rect = new JPanel();
                if ((i + n) % 2 == 0) {
                    rect.setBackground(Color.ORANGE);
                } else {
                    rect.setBackground(Color.DARK_GRAY);
                }
                rect.setSize(10, 10);
                this.add(rect);

            }
        }
        this.setSize(100, 100);

    }
}

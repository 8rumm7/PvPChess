package view;

import model.Figure;
//import sun.plugin.dom.css.RGBColor;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.LinkedList;

public class ChessBoard extends JPanel {
    LinkedList<Figure> figureList;
    private static final Color LIGHT = new Color(237, 194, 130);
    private static final Color DARK = new Color(140, 110, 65);

    public ChessBoard(LinkedList<Figure> figureList) {
        this.figureList = figureList;
        init();
    }

    private void init() {
        this.setLayout(new GridLayout(8, 8));
        JPanel rect;
        for (int i = 0; i < 8; i++) {
            for (int n = 0; n < 8; n++) {
                rect = new JPanel();
                if ((i + n) % 2 == 0) {
                    rect.setBackground(LIGHT);
                } else {
                    rect.setBackground(DARK);
                }
                this.add(rect);

            }
        }
        this.setSize(100, 100);

    }
}

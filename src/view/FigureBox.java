package view;

import model.Figure;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class FigureBox extends JPanel {
    LinkedList<Figure> deadList;
    private Color BACKGROUND_COLOR;
    private static final Color BOX_COLOR=new Color(132, 104, 78);
    JPanel panel;


    public FigureBox(LinkedList<Figure> deadList, Color backgroundColor) {
        this.deadList = deadList;
        this.BACKGROUND_COLOR=backgroundColor;
        init();
    }

    private void init() {
        this.setBackground(BACKGROUND_COLOR);
        this.setLayout(new GridLayout(8,2));
        JPanel figureField;
        for(int i=0;i<16;i++){
            figureField=new JPanel();
            figureField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            figureField.setBackground(BOX_COLOR);
            this.add(figureField);
        }
        this.setMinimumSize(new Dimension(100, 100));
        this.setMaximumSize(new Dimension(100, 100));
        this.setPreferredSize(new Dimension(100, 100));
        this.setVisible(true);

    }
}

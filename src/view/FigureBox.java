package view;

import model.Figure;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class FigureBox extends JPanel {
    LinkedList<Figure> whiteDeadList;
    private static final Color TRANSLUCENT=new Color(0,0,0,0);
    private static final Color BOX_COLOR=new Color(132, 104, 78);
    JPanel panel;


    public FigureBox(LinkedList<Figure> whiteDeadList) {
        this.whiteDeadList = whiteDeadList;
        init();
    }

    private void init() {
        this.setBackground(BOX_COLOR);
        this.setLayout(new GridLayout(8,2));
        JPanel figureField;
        for(int i=0;i<16;i++){
            figureField=new JPanel();
            figureField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            figureField.setBackground(TRANSLUCENT);
            this.add(figureField);
        }
        this.setVisible(true);
    }
}

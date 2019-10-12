package view;

import model.Figure;
import model.Position;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ChessBoard extends JPanel {
    List<Figure> figureList;
    private Color BACKGROUND_COLOR;
    private static final Color LIGHT = new Color(237, 194, 130);
    private static final Color DARK = new Color(140, 110, 65);

    public ChessBoard(List<Figure> figureList, Color backgroundColor){
        this.figureList = figureList;
        this.BACKGROUND_COLOR = backgroundColor;
        init();
    }

    private void init() {
        this.setLayout(new GridLayout(8, 8));
        this.setBackground(BACKGROUND_COLOR);
        JPanel rect;
        for (int i = 7; i >= 0; i--) {
            for (int n = 0; n < 8; n++) {
                rect = new JPanel();
                if ((i + n) % 2 == 0) {
                    rect.setBackground(LIGHT);
                } else {
                    rect.setBackground(DARK);
                }
                for (Figure f : figureList) {
                    if (f.getPosition().equals(new Position(i, n))) {
                        ImageIcon imageIcon = new ImageIcon("./images/" + f.getType() + "_" + f.getColor() + ".png");
                        Image image = imageIcon.getImage();
                        Image newImg = image.getScaledInstance(30, 40,  java.awt.Image.SCALE_SMOOTH);
                        imageIcon = new ImageIcon(newImg);
                        JLabel l = new JLabel(imageIcon);
                        rect.add(l);
                        break;
                    }
                }
                rect.setMinimumSize(new Dimension(10, 10));
                rect.setMaximumSize(new Dimension(10, 10));
                rect.setPreferredSize(new Dimension(10, 10));
                this.add(rect);
            }
        }
    }




}

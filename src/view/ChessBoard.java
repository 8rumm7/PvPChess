package view;

import model.Figure;
import model.Model;
import model.Position;
import sun.plugin.dom.css.RGBColor;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class ChessBoard extends JPanel {
    LinkedList<Figure> figureList;
    private Color BACKGROUND_COLOR;
    private static final Color LIGHT = new Color(237, 194, 130);
    private static final Color DARK = new Color(140, 110, 65);

    public ChessBoard(LinkedList<Figure> figureList, Color backgroundColor) throws IOException {
        this.figureList = figureList;
        this.BACKGROUND_COLOR = backgroundColor;
        init();
    }

    private void init1() {
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
                    if (f.position.equals(new Position(i, n))) {
                        BufferedImage image = null;
                        try {
                            image = ImageIO.read(new File("./images/" + f.kind + "_" + f.color + ".png"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        ImageIcon icon = new ImageIcon(image);
                        JLabel l = new JLabel(icon);
                        rect.add(l);
                        break;
                    }
                }
                rect.setMinimumSize(new Dimension(10, 10));
                rect.setMaximumSize(new Dimension(10, 10));
                rect.setPreferredSize(new Dimension(10, 10));
                this.add(rect);
                this.setMinimumSize(new Dimension(100, 100));
                this.setMaximumSize(new Dimension(100, 100));
                this.setPreferredSize(new Dimension(100, 100));
            }
        }
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
                    if (f.position.equals(new Position(i, n))) {
                        ImageIcon imageIcon = new ImageIcon("./images/" + f.kind + "_" + f.color + ".png");
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

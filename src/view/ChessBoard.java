package view;

import model.Figure;
import model.Model;
import model.Position;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ChessBoard extends JPanel {
    List<Figure> figureList;
    Model model;
    private Color BACKGROUND_COLOR;
    private final Color FIELD_FREE = new Color(150  ,150,150);
    private final Color THIS_FIGURE =new Color(129,193,122);
    private final Color FIELD_OCCUPIED_BY_OPPONENT = new Color(196,130,130);
    private static final Color LIGHT = new Color(237, 194, 130);
    private static final Color DARK = new Color(140, 110, 65);
    public JButton[][] buttonBoard = initButtonBoardWithLayoutManager();

    private JButton[][] initButtonBoardWithLayoutManager() {
        JButton[][] buttonBoard=new JButton[8][8];
        for(int row=0;row<8;row++){
            for(int column =0;column<8;column++){
                JButton btn = new JButton();
                btn.setLayout(new GridBagLayout());
                buttonBoard[row][column]=btn;

            }
        }
        return buttonBoard;
    }

    public ChessBoard(Model model, Color backgroundColor) {
        this.model = model;
        this.figureList = model.getFigureList();
        this.BACKGROUND_COLOR = backgroundColor;
        init();
    }

    private void init() {
        this.setLayout(new GridLayout(8, 8));
        this.setBackground(BACKGROUND_COLOR);
        update();

    }

    void update() {
        JButton btn;
        for (int row = 7; row >= 0; row--) {
            for (int column = 0; column < 8; column++) {
                btn = buttonBoard[row][column];
                btn.setBorder(null);
                btn.setRolloverEnabled(false);
                btn.setFocusPainted(false);
                btn.setName("Field: " + row + "|" + column);
                if ((row + column) % 2 == 0) {
                    btn.setBackground(LIGHT);
                } else {
                    btn.setBackground(DARK);
                }
                for (Figure f : figureList) {
                    if (f.getPosition().equals(new Position(row, column))) {
                        ImageIcon imageIcon = new ImageIcon("./images/" + f.getType() + "_" + f.getColor() + ".png");
                        Image image = imageIcon.getImage();
                        Image newImg = image.getScaledInstance(30, 40, java.awt.Image.SCALE_SMOOTH);
                        imageIcon = new ImageIcon(newImg);
                        JLabel l = new JLabel(imageIcon);
                        btn.add(l);
                        break;
                    }
                }
                buttonBoard[row][column] = btn;
                btn.setMinimumSize(new Dimension(10, 10));
                btn.setMaximumSize(new Dimension(10, 10));
                btn.setPreferredSize(new Dimension(10, 10));
                this.add(btn);
            }
        }
    }


    public void printPossiblePositions(Figure figure) {
        update();
        int row=figure.getPosition().row;
        int column = figure.getPosition().column;
        buttonBoard[row][column].setBackground(THIS_FIGURE);
        List<Position> positionList = figure.getPossiblePositions();
        if (positionList.size() > 0) {
            for (Position p : positionList) {
                row = p.row;
                column = p.column;
                if (model.board[row][column] == null) {
                    buttonBoard[row][column].setBackground(FIELD_FREE);
                } else if (model.board[row][column].getColor() != figure.getColor()) {
                    buttonBoard[row][column].setBackground(FIELD_OCCUPIED_BY_OPPONENT);
                }
            }
        }
    }
}

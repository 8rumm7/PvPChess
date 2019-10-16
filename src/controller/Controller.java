package controller;

import model.Figure;
import model.Model;
import model.PLAYERCOLOR;
import model.Position;
import view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    final String HOSTNAME = "localhost";
    final int PORT = 9999;
    static Model model;
    static View view;
    Figure activeFigure;
    PLAYERCOLOR playercolor = PLAYERCOLOR.WHITE;

    public Controller(Model model, View view) {
        Controller.model = model;
        this.view = view;

    }

    public void init() {
        model.init();
        view.initComponents();
        ServerClient s = new ServerClient(HOSTNAME, PORT);
        for (JButton[] row : view.chessBoard.buttonBoard) {
            for (JButton button : row) {
                button.addActionListener(this);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonIdentifier = getName(e);
        if (buttonIdentifier.startsWith("Field: ")) {
            buttonIdentifier = buttonIdentifier.replace("Field: ", "");
            String[] rowColumn = buttonIdentifier.split("\\|");
            int row = Integer.parseInt(rowColumn[0]);
            int column = Integer.parseInt(rowColumn[1]);
            if (activeFigure == null) {
                if (model.board[row][column] != null && model.board[row][column].getColor() == playercolor) {
                    activeFigure = model.getFigureAt(new Position(row, column));
                    view.printPossiblePositions(activeFigure);
                } else view.update();
            } else {
                if (activeFigure.getPossiblePositions().contains(new Position(row, column))) {
                    model.moveFigure(activeFigure, new Position(row, column));
                    view.update();

                } else {
                    view.update();
                }
                activeFigure = null;
            }
        }
    }

    private String getName(ActionEvent e) {
        String ret;
        ret = e.getSource().toString().split("\\[")[1];
        ret = ret.split(",")[0];
        return ret;
    }
}

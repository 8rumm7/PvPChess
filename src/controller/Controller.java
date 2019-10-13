package controller;

import model.Model;
import model.Position;
import view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    static Model model;
    static View view;

    public Controller(Model model, View view) {
        Controller.model = model;
        this.view = view;

    }

    public void init() {
        model.init();
        view.initComponents();
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
            buttonIdentifier = buttonIdentifier.toString().replace("Field: ", "");
            String[] rowColumn = buttonIdentifier.split("\\|");
            int row = Integer.parseInt(rowColumn[0]);
            int column = Integer.parseInt(rowColumn[1]);
            if (model.board[row][column] != null) {
                view.printPossiblePositions(model.getFigureAt(new Position(row, column)));
            }
            else view.update();
        }
    }

    private String getName(ActionEvent e) {
        String ret;
        ret = e.getSource().toString().split("\\[")[1];
        ret = ret.split(",")[0];
        return ret;
    }
}

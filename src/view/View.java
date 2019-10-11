package view;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class View {

    Model model;
    ChessBoard chessBoard;
    FigureBox figureBox;
    Chat chat;
    private static final Color BUTTON_BACKGROUND_COLOR=Color.GRAY;
    private static final Color BACKGROUND_COLOR = Color.LIGHT_GRAY;
    private static final int EXTERNAL_PADDING = 5;
    String name = "John Doe";


    public View(Model model)  {
        this.model = model;
        initComponents();
    }


    private void initComponents()  {
        try {
            this.chessBoard = new ChessBoard(model.figureList,BACKGROUND_COLOR);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.figureBox = new FigureBox(model.whiteDeadList,BACKGROUND_COLOR);
        name = JOptionPane.showInputDialog("Whats your opponents name?");
        if (name.equals("")) {
            this.name = "John Doe";
        }
        this.chat = new Chat(BACKGROUND_COLOR, name);
        initFrame(chat);
    }

    private void initFrame(Chat chat) {
        JFrame frame = new JFrame();
        frame.setSize(1000, 1000);
        GridBagConstraints c = new GridBagConstraints();
        JButton button;
        Container pane = frame.getContentPane();
        pane.setLayout(new GridBagLayout());

        button = new JButton("Options");
        button.setBackground(BUTTON_BACKGROUND_COLOR);
        button.setForeground(Color.WHITE);

        c.weightx = 0.1;
        c.weighty = 0.1;
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(EXTERNAL_PADDING, EXTERNAL_PADDING, EXTERNAL_PADDING, EXTERNAL_PADDING);
        pane.add(button, c);

        JLabel connectedTo = new JLabel("Connected to:");
        c.weightx = 0.1;
        c.weighty = 0.1;
        c.gridx = 10;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 2;
        pane.add(connectedTo, c);

        JLabel name = new JLabel("Name: " + this.name);
        c.weightx = 0.1;
        c.weighty = 0.1;
        c.gridx = 10;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 2;
        pane.add(name, c);

        c.weightx = 0.8;
        c.weighty = 0.8;
        c.gridx = 0;
        c.gridy = 2;
        c.gridheight = 8;
        c.gridwidth = 8;
        chessBoard.setBorder(null);
        pane.add(chessBoard, c);

        c.weightx = 0.2;
        c.weighty = 0.8;
        c.gridx = 8;
        c.gridy = 2;
        c.gridheight = 8;
        c.gridwidth = 2;
        figureBox.setBorder(null);
        pane.add(figureBox, c);

        c.weightx = 0.2;
        c.weighty = 0.8;
        c.gridx = 10;
        c.gridy = 2;
        c.gridheight = 8;
        c.gridwidth = 2;
        pane.add(chat, c);

        JLabel time = new JLabel("Time");
        c.weightx = 0.1;
        c.weighty = 0.1;
        c.gridx = 0;
        c.gridy = 10;
        c.gridheight = 1;
        c.gridwidth = 1;
        pane.add(time, c);

        JButton giveUp = new JButton("Give Up");
        giveUp.setBackground(BUTTON_BACKGROUND_COLOR);
        giveUp.setForeground(Color.WHITE);
        c.weightx = 0.1;
        c.weighty = 0.1;
        c.gridx = 10;
        c.gridy = 10;
        c.gridheight = 1;
        c.gridwidth = 1;
        pane.add(giveUp, c);

        pane.setBackground(BACKGROUND_COLOR);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }


}
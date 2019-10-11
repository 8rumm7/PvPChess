package view;

import model.*;

import javax.swing.*;
import java.awt.*;

public class View  {

    Model model;
    ChessBoard chessBoard;
    FigureBox chessBoxWhite;
    Chat chat;
    private static final Color BACKGROUND_COLOR=Color.LIGHT_GRAY;
    private static final int EXTERNAL_PADDING=5;


    public View(Model model) {
        this.model = model;
        initComponents();
    }

    void initComponents() {
        this.chessBoard = new ChessBoard(model.figureList);
        this.chessBoxWhite = new FigureBox(model.whiteDeadList);
        this.chat=new Chat(BACKGROUND_COLOR);
        initFrame(chessBoard, chessBoxWhite,chat);
    }

    private void initFrame(ChessBoard chessBoard, FigureBox chessBoxWhite, Chat chat) {
        JFrame frame = new JFrame();
        frame.setSize(1000, 1000);
        GridBagConstraints c = new GridBagConstraints();
        JButton button;
        Container pane = frame.getContentPane();
        pane.setLayout(new GridBagLayout());

        button = new JButton("Options");
        button.setBackground(Color.GRAY);
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        c.insets=new Insets(EXTERNAL_PADDING,EXTERNAL_PADDING,EXTERNAL_PADDING,EXTERNAL_PADDING);
        c.weightx=0.1;
        c.weighty=0.1;
        c.gridx=0;
        c.gridy=0;
        c.gridwidth=2;
        pane.add(button, c);

        JLabel connectedTo = new JLabel("Connected to:");
        c.gridx=12;
        c.gridy=0;
        pane.add(connectedTo, c);

        c.weightx=0.5;
        c.weighty=0.5;
        c.gridx=0;
        c.gridy=1;
        c.gridheight=8;
        c.gridwidth=8;
        c.fill=GridBagConstraints.BOTH;
        pane.add(chessBoard,c);

        c.weightx=0.1;
        c.weighty=0.1;
        c.gridx=10;
        c.gridy=1;
        c.gridwidth=2;
        pane.add(chessBoxWhite,c);

        c.weightx=0.1;
        c.weighty=0.1;
        c.gridx=12;
        c.gridy=1;
        c.gridwidth=2;
        c.gridheight=8;
        pane.add(chat,c);

        JLabel time = new JLabel("Time");
        c.gridheight=1;
        c.gridx=0;
        c.gridy=9;
        c.fill=GridBagConstraints.NONE;
        pane.add(time,c);

        JButton giveUp = new JButton("Give Up");
        giveUp.setBackground(Color.GRAY);
        giveUp.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        c.gridx=12;
        c.gridy=9;
        pane.add(giveUp,c);

        pane.setBackground(BACKGROUND_COLOR);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }


}
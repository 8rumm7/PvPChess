package view;

import model.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.IOException;

public class View {

    private static final double WINDOW_SCALE_CONSTANT = 1.2;
    Model model;
    ChessBoard chessBoard;
    FigureBox figureBox;
    Chat chat;
    private static final Color BUTTON_BACKGROUND_COLOR=Color.GRAY;
    private static final Color BACKGROUND_COLOR = Color.LIGHT_GRAY;
    private static final int EXTERNAL_PADDING = 5;
    private static final int FIELD_HEIGHT = 400;
    private static final int FIELD_WIDTH = 400;
    private static final int BUTTON_HEIGHT = 50;
    private static final int BUTTON_WIDTH = 200;
    private static final int LABEL_HEIGHT = 50;
    private static final int LABEL_WIDTH = 200;
    private static final int FIGURE_BOX_HEIGHT = 400;
    private static final int FIGURE_BOX_WIDTH = 100;
    private static final int CHAT_HEIGHT = 400;
    private static final int CHAT_WIDTH = 300;
    private static final Border BUTTON_RELEASED_BORDER =BorderFactory.createBevelBorder(0);
    private static final Border BUTTON_PRESSED_BORDER =BorderFactory.createBevelBorder(1);
    private static final Border FIGURE_BOX_BORDER =BorderFactory.createCompoundBorder(
            BorderFactory.createBevelBorder(0),BorderFactory.createBevelBorder(1));
    private static final Border CHAT_BORDER =BorderFactory.createBevelBorder(1);

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
        frame.setSize(sumWidth(), sumHeight());
        GridBagConstraints c = new GridBagConstraints();
        JButton optionsButton;
        Container pane = frame.getContentPane();
        pane.setLayout(new GridBagLayout());

        optionsButton = new JButton("Options (button pressed)");
        optionsButton.setBackground(BUTTON_BACKGROUND_COLOR);
        optionsButton.setForeground(Color.WHITE);
        c.weightx = 0.1;
        c.weighty = 0.1;
        c.gridx = 0;
        c.gridy = 0;
        //c.insets = new Insets(EXTERNAL_PADDING, EXTERNAL_PADDING, EXTERNAL_PADDING, EXTERNAL_PADDING);
        optionsButton.setMinimumSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        optionsButton.setMaximumSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        optionsButton.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        optionsButton.setBorder(BUTTON_PRESSED_BORDER);
        pane.add(optionsButton, c);

        JLabel connectedToLabel = new JLabel("Connected to:");

        c.gridx = 10;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 2;
        connectedToLabel.setMinimumSize(new Dimension(LABEL_WIDTH,LABEL_HEIGHT));
        connectedToLabel.setMaximumSize(new Dimension(LABEL_WIDTH,LABEL_HEIGHT));
        connectedToLabel.setPreferredSize(new Dimension(LABEL_WIDTH,LABEL_HEIGHT));
        pane.add(connectedToLabel, c);

        JLabel nameLabel = new JLabel("Name: " + this.name);

        c.gridx = 10;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 2;
        nameLabel.setMinimumSize(new Dimension(LABEL_WIDTH,LABEL_HEIGHT));
        nameLabel.setMaximumSize(new Dimension(LABEL_WIDTH,LABEL_HEIGHT));
        nameLabel.setPreferredSize(new Dimension(LABEL_WIDTH,LABEL_HEIGHT));
        pane.add(nameLabel, c);

        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 2;
        c.gridheight = 8;
        c.gridwidth = 8;
        chessBoard.setBorder(null);
        chessBoard.setMinimumSize(new Dimension(FIELD_WIDTH,FIELD_HEIGHT));
        chessBoard.setMaximumSize(new Dimension(FIELD_WIDTH,FIELD_HEIGHT));
        chessBoard.setPreferredSize(new Dimension(FIELD_WIDTH,FIELD_HEIGHT));
        chessBoard.setBorder(BorderFactory.createBevelBorder(0));
        pane.add(chessBoard, c);


        c.gridx = 8;
        c.gridy = 2;
        c.gridheight = 8;
        c.gridwidth = 2;
        figureBox.setBorder(null);
        figureBox.setMinimumSize(new Dimension(FIGURE_BOX_WIDTH,FIGURE_BOX_HEIGHT));
        figureBox.setMaximumSize(new Dimension(FIGURE_BOX_WIDTH,FIGURE_BOX_HEIGHT));
        figureBox.setPreferredSize(new Dimension(FIGURE_BOX_WIDTH,FIGURE_BOX_HEIGHT));
        figureBox.setBorder(FIGURE_BOX_BORDER);
        pane.add(figureBox, c);


        c.gridx = 10;
        c.gridy = 2;
        c.gridheight = 8;
        c.gridwidth = 2;
        chat.setMinimumSize(new Dimension(CHAT_WIDTH,CHAT_HEIGHT));
        chat.setMaximumSize(new Dimension(CHAT_WIDTH,CHAT_HEIGHT));
        chat.setPreferredSize(new Dimension(CHAT_WIDTH,CHAT_HEIGHT));
        chat.setBorder(CHAT_BORDER);
        pane.add(chat, c);

        JLabel time = new JLabel("Time");
        c.fill=GridBagConstraints.NONE;
        c.weightx = 0.1;
        c.weighty = 0.1;
        c.gridx = 0;
        c.gridy = 10;
        c.gridheight = 1;
        c.gridwidth = 1;
        time.setMinimumSize(new Dimension(LABEL_WIDTH,LABEL_HEIGHT));
        time.setMaximumSize(new Dimension(LABEL_WIDTH,LABEL_HEIGHT));
        time.setPreferredSize(new Dimension(LABEL_WIDTH,LABEL_HEIGHT));
        pane.add(time, c);

        JButton giveUpButton = new JButton("Give Up (button released)");
        giveUpButton.setBackground(BUTTON_BACKGROUND_COLOR);
        giveUpButton.setForeground(Color.WHITE);

        c.gridx = 10;
        c.gridy = 10;
        c.gridheight = 1;
        c.gridwidth = 1;
        giveUpButton.setMinimumSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        giveUpButton.setMaximumSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        giveUpButton.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        giveUpButton.setBorder(BUTTON_RELEASED_BORDER);
        pane.add(giveUpButton, c);

        pane.setBackground(BACKGROUND_COLOR);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private int sumWidth() {
        return (int)((FIELD_WIDTH+FIGURE_BOX_WIDTH+CHAT_WIDTH)*WINDOW_SCALE_CONSTANT);
    }

    private int sumHeight() {
        return (int)((FIELD_HEIGHT+LABEL_HEIGHT+BUTTON_HEIGHT)*WINDOW_SCALE_CONSTANT);
    }


}
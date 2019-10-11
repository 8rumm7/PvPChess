package view;

import javax.swing.*;
import java.awt.*;

public class Chat extends JPanel {
    private JTextArea textArea;
    private JScrollPane scrollPane;
    private Color BACKGROUND_COLOR;
    private static final Color TEXT_WINDOW_COLOR = Color.DARK_GRAY;

    Chat(Color backgroundColor) {
        this.BACKGROUND_COLOR = backgroundColor;
        init();
    }

    void init() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        String input = JOptionPane.showInputDialog("Whats your opponents name?");
        if(input==null||input.equals("")){
            input="John Doe";
        }
        JLabel name = new JLabel("Name: "+input);
        c.gridx=0;
        c.gridy=0;
        this.add(name,c);


        scrollPane = new JScrollPane();
        textArea = new JTextArea(5, 30);
        textArea.setText("dummy: dumb test message");
        textArea.setSize(100, 100);
        textArea.setBackground(TEXT_WINDOW_COLOR);
        textArea.setVisible(true);
        scrollPane.add(textArea);
        scrollPane.setSize(1000, 1000);
        scrollPane.setVisible(true);

        c.weightx=1;
        c.weighty=1;
        c.fill=GridBagConstraints.BOTH;
        c.gridx=0;
        c.gridy=1;
        c.gridheight=8;
        this.add(scrollPane,c);
        this.setBackground(BACKGROUND_COLOR);
        this.setSize(1000, 1000);
        this.setVisible(true);
    }
}

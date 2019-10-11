package view;

import javax.swing.*;
import java.awt.*;

public class Chat extends JPanel {
    private JPanel panel;
    private JLabel label;
    private JScrollPane scrollPaneMessenger;
    private Color BACKGROUND_COLOR;
    private static final Color MESSENGER_BACKGROUND_COLOR = Color.DARK_GRAY;
    private static final Color MESSENGER_TEXT_COLOR = Color.LIGHT_GRAY;


    Chat(Color backgroundColor) {
        this.BACKGROUND_COLOR = backgroundColor;
        init();
    }

    private void init() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        String name = JOptionPane.showInputDialog("Whats your opponents name?");
        if (name == null || name.equals("")) {
            name = "John Doe";
        }
        JLabel nameLabel = new JLabel("Name: " + name);
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0;
        c.weighty = 0;
        this.add(nameLabel, c);


        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        for (int i = 0; i < 5; i++) {
            label = new JLabel();
            label.setText(name+": dumb test message");
            label.setOpaque(true);
            label.setBackground(MESSENGER_BACKGROUND_COLOR);
            label.setForeground(MESSENGER_TEXT_COLOR);
            label.setVisible(true);
            panel.add(label);
        }
        scrollPaneMessenger = new JScrollPane(panel);
        scrollPaneMessenger.setOpaque(true);
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 1;
        c.gridheight = 6;
        c.fill=GridBagConstraints.BOTH;
        scrollPaneMessenger.setBackground(MESSENGER_BACKGROUND_COLOR);
        scrollPaneMessenger.setBorder(null);
        scrollPaneMessenger.setVisible(true);
        this.add(scrollPaneMessenger, c);

        JTextField input= new JTextField();
        c.gridx = 0;
        c.gridy = 8;
        c.weightx=0;
        c.weighty=0;
        c.fill=GridBagConstraints.HORIZONTAL;
        input.setBorder(null);
        this.add(input,c);
        this.setBackground(BACKGROUND_COLOR);
        this.setBorder(null);
        this.setVisible(true);
    }
}

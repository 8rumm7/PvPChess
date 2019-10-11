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
    String name;


    Chat(Color backgroundColor, String name) {
        this.BACKGROUND_COLOR = backgroundColor;
        this.name = name;
        init();
    }

    private void init() {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        for (int i = 0; i < 5; i++) {
            label = new JLabel();
            label.setText(name + ": dumb test message");
            label.setOpaque(true);
            label.setBackground(MESSENGER_BACKGROUND_COLOR);
            label.setForeground(MESSENGER_TEXT_COLOR);
            label.setVisible(true);
            panel.add(label);
        }
        panel.setMaximumSize(new Dimension(1000, 1000));
        panel.setBackground(MESSENGER_BACKGROUND_COLOR);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        scrollPaneMessenger = new JScrollPane(panel);
        scrollPaneMessenger.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1000));

        scrollPaneMessenger.setBackground(MESSENGER_BACKGROUND_COLOR);
        scrollPaneMessenger.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        scrollPaneMessenger.setVisible(true);
        this.add(scrollPaneMessenger);

        JTextField input = new JTextField();
        input.setBorder(null);
        input.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
        this.add(input);
        this.setBackground(BACKGROUND_COLOR);
        this.setBorder(null);
        this.setVisible(true);
    }
}

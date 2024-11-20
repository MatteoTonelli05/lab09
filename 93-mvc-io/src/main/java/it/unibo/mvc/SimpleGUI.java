package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {
    private static final int PROPORTION = 4;
    private final JFrame frame = new JFrame();

    /**
     * constructor.
     * 
     * @param ctrl controller of the view.
     */
    public SimpleGUI(final Controller ctrl) {
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        final JTextField textField = new JTextField();
        canvas.add(textField, BorderLayout.NORTH);
        final JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        canvas.add(textArea, BorderLayout.CENTER);
        final JPanel southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.X_AXIS));
        final JButton print = new JButton("Print");
        final JButton showHistory = new JButton("Show history");
        southPanel.add(print);
        southPanel.add(showHistory);
        canvas.add(southPanel, BorderLayout.SOUTH);
        frame.add(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        print.addActionListener(new ActionListener() {

            /**
             * ignore.
             * 
             * @param e ignore.
             */
            @Override
            public void actionPerformed(final ActionEvent e) {
                final String txt = textField.getText();
                try {
                    if (!txt.isEmpty() && !txt.isBlank()) {
                        ctrl.setNextStringToPrint(txt);
                        ctrl.printCurrentString();
                    }
                } catch (IOException e1) {
                    e1.printStackTrace(); // NOPMD allowed for exercise
                }
            }
        });

        showHistory.addActionListener(new ActionListener() {

            /**
             * ignore.
             * 
             * @param e ignore.
             */
            @Override
            public void actionPerformed(final ActionEvent e) {
                textArea.setText(ctrl.getPrintedStringsHistory().toString());
            }
        });
    }

    /**
     * make the frame visible and proportioned.
     */
    public void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * main.
     * 
     * @param args ignore.
     */
    public static void main(final String[] args) {
        final Controller ctrl = new SimpleController();
        final SimpleGUI view = new SimpleGUI(ctrl);
        view.display();
    }
}

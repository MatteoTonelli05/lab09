package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 * 
 */
public class SimpleGUI {

    private static final int PROPORTION = 4;
    private final JFrame frame = new JFrame("My first java graphical interface");

    /**
     * Contructor for the SimpleGUI (view).
     * 
     * @param ctrl controller
     */
    public SimpleGUI(final Controller ctrl) {
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        final JTextArea txtArea = new JTextArea();
        canvas.add(txtArea);
        txtArea.setVisible(true);
        final JButton saveBtn = new JButton("Save");
        canvas.add(saveBtn, BorderLayout.SOUTH);
        saveBtn.setVisible(true);
        saveBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                ctrl.saveOnCurrentFile(txtArea.getText());
            }

        });
        frame.add(canvas);
    }

    /**
     * Method to inizialize the frame.
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
     * @param args ignore
     */
    public static void main(final String[] args) {
        final Controller mainCtrl = new Controller();
        final SimpleGUIWithFileChooser app = new SimpleGUIWithFileChooser(mainCtrl);
        app.display();
    }

}

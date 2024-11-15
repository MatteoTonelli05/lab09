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

    public SimpleGUI() {
        JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        JTextArea txtArea = new JTextArea();
        canvas.add(txtArea);
        txtArea.setVisible(true);
        JButton saveBtn = new JButton("Save");
        canvas.add(saveBtn, BorderLayout.SOUTH);
        saveBtn.setVisible(true);
        saveBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }

        });
        frame.add(canvas);
    }

    public void display() {

        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    static public void main(String args[]) {
        Controller mainCtrl = new Controller();
        SimpleGUIWithFileChooser app = new SimpleGUIWithFileChooser(mainCtrl);
        app.display();
    }

}

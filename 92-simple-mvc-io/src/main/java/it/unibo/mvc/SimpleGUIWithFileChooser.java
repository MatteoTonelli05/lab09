package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final int PROPORTION = 3;
    private final JFrame frame = new JFrame("My first java graphical interface");

    public SimpleGUIWithFileChooser(Controller ctrl) {

        Controller controller = ctrl;
        JPanel canvas = new JPanel();

        JPanel downCanvas = new JPanel();
        JTextArea txtArea = new JTextArea();
        JTextField showFile = new JTextField(20);
        JButton browseButton = new JButton("Browse...");
        JPanel innerCanvas = new JPanel();
        innerCanvas.setLayout(new BorderLayout());
        innerCanvas.add(showFile, BorderLayout.CENTER);
        innerCanvas.add(browseButton, BorderLayout.LINE_END);
        canvas.add(innerCanvas, BorderLayout.NORTH);
        showFile.setEditable(true);
        showFile.setEnabled(false);
        browseButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser savefile = new JFileChooser();
                int result = savefile.showSaveDialog(savefile);
                if (result == JFileChooser.APPROVE_OPTION) {
                    showFile.setText(ctrl.getCurrentFile().toPath().toString());
                } else if (result == JFileChooser.CANCEL_OPTION) {
                    return;
                } else {
                    JOptionPane.showMessageDialog(null, "an error has occured");
                }
            }

        });
        showFile.setVisible(true);
        browseButton.setVisible(true);
        innerCanvas.setVisible(true);
        canvas.setVisible(true);
        frame.add(canvas);
        downCanvas.setLayout(new BoxLayout(downCanvas, BoxLayout.Y_AXIS));
        downCanvas.add(txtArea, BorderLayout.CENTER);
        txtArea.setVisible(true);
        JButton saveBtn = new JButton("Save");
        downCanvas.add(saveBtn, BorderLayout.SOUTH);
        saveBtn.setVisible(true);
        saveBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }

        });
        frame.add(downCanvas, BorderLayout.SOUTH);
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
}

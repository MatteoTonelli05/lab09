package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    private static final int PROPORTION = 4;
    private final JFrame frame = new JFrame("My first java graphical interface");

    /**
     * Contructor for the SimpleGUI (view).
     * 
     * @param ctrl controller
     */
    public SimpleGUIWithFileChooser(final Controller ctrl) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Panel configuration
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        // Text area
        final JTextArea text = new JTextArea();
        // Save button
        final JButton save = new JButton("Save");
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent event) {
                ctrl.saveOnCurrentFile(text.getText());
            }
        });
        // Assemble text and button
        canvas.add(text, BorderLayout.CENTER);
        canvas.add(save, BorderLayout.SOUTH);

        final JPanel secondPanel = new JPanel();
        secondPanel.setLayout(new BorderLayout());
        canvas.add(secondPanel, BorderLayout.NORTH);
        final JTextField jfield = new JTextField();
        final JButton jbutton = new JButton("Browse...");
        secondPanel.add(jfield, BorderLayout.CENTER);
        secondPanel.add(jbutton, BorderLayout.LINE_END);
        jfield.setEnabled(false);
        jfield.setText(ctrl.getCurrentFile().getPath());
        jbutton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser fileChooser = new JFileChooser();
                final int choose = fileChooser.showSaveDialog(fileChooser);
                switch (choose) {
                    case JFileChooser.APPROVE_OPTION:
                        ctrl.setCurrentFile(fileChooser.getSelectedFile());
                        jfield.setText(ctrl.getContent());
                        break;
                    case JFileChooser.CANCEL_OPTION:
                        break;
                    default:
                        JOptionPane.showMessageDialog(fileChooser, "an error has occurred");
                        break;
                }
            }
        });
        frame.add(canvas);
    }

    /**
     * inizialize the frame.
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
}

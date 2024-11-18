package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private File currentFile;

    /**
    * Constructor for class Controller.
    * @param currentFile the starter file to control.
    */
    public Controller(final File currentFile) {
        this.currentFile = currentFile;
    }

    /**
    * Another constructor for class Controller.
    */
    public Controller() { 
        this(new File(System.getProperty("user.home") + System.getProperty("file.separator") + "output.txt"));
    }

    /**
    * Set the file to control.
    * @param currentFile the file to control.
    */
    public void setCurrentFile(final File currentFile) {
        this.currentFile = currentFile;
    }

    /**
    * Get the file assigned to controller.
    * @return currentFile.
    */
    public File getCurrentFile() {
        return this.currentFile;
    }

    /**
    * Set the content of currentFile.
    * @param text text to print in the file.
    */
    public void saveOnCurrentFile(final String text) {
        try (PrintStream out = new PrintStream(currentFile, StandardCharsets.UTF_8)) {
            out.println(text);
        } catch (IOException exc) {
            exc.printStackTrace(); //NOPMD: this is allowed only for exercise purpose
        }
    }

    /**
     * Return content.
     * @return concatenate strings.
     */
    public String getContent() {
        String out = "";
        try {
                final List<String> lines = Files.readAllLines(currentFile.toPath());
                for (final String line: lines) {
                    out = out.concat(line);
                } 
            } catch (IOException exc) {
                exc.printStackTrace(); // NOPMD: allowed as this is just an exercise
            }
        return out;
    }

}

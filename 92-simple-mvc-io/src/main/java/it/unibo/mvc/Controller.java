package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller{
    private File currentFile;

    public Controller(final File currentFile) {
        setCurrentFile(currentFile);
    }

    public Controller() {
        this(new File(System.getProperty("user.home") + System.getProperty("file.separator") + "output.txt"));
    }

    public void setCurrentFile(File currentFile) {
        this.currentFile = currentFile;
    }

    public File getCurrentFile() {
        return this.currentFile;
    }

    public void setContentFile(){

    }

    public void saveOnCurrentFile(final String text) {
        try (PrintStream out = new PrintStream(currentFile, StandardCharsets.UTF_8)) {
            out.println(text);
        }catch(IOException exc){
            exc.printStackTrace(); //NOPMD: this is allowed only for exercise purpose
        }
    }

}

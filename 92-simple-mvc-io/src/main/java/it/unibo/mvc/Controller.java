package it.unibo.mvc;

import java.io.File;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private File currentFile;

    public Controller(File currentFile) {
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

}

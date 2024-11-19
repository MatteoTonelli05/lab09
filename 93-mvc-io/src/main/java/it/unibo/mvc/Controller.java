package it.unibo.mvc;

import java.io.IOException;
import java.util.List;

/**
 *
 */
public interface Controller {
    /**
     * 
     * @param nextString next string to print
     * @throws IOException 
     */
    void setNextStringToPrint(String nextString) throws IOException;

    /**
     * 
     * @return next string to print
     */
    String getNextStringToPrint();

    /**
     * 
     * @return history of printed strings as a list
     */
    List<String> getPrintedStringsHistory();

    /**
     * 
     */
    void printCurrentString();
}

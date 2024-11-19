package it.unibo.mvc;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 *
 */
public final class SimpleController implements Controller {
    private final List<String> stringsPrinted;
    private String stringToPrint;

    /**
     * constructor.
     */
    public SimpleController() {
        stringsPrinted = new LinkedList<>();
        stringToPrint = null;
    }

    /**
     * Add a string to the queue toPrint.
     */
    @Override
    public void setNextStringToPrint(final String nextString) {
        if (nextString == null) {
            throw new IllegalArgumentException("String cannot be null.");
        } else {
            stringToPrint = nextString;
        }
    }

    /**
     * @return the string to be printed.
     */
    @Override
    public String getNextStringToPrint() {
        return stringToPrint;
    }

    /**
     *
     * @return all the string already printed.
     */
    @Override
    public List<String> getPrintedStringsHistory() {
        return new LinkedList<>(stringsPrinted);
    }

    /**
     * print the String that has selected as the next to be printed.
     */
    @Override
    public void printCurrentString() {
        if (stringToPrint == null) {
            throw new IllegalStateException("There is no string set");
        } else {
            System.out.println(stringToPrint); //NOPMD only for exercise purpose
            stringsPrinted.add(stringToPrint);
        }
    }

}

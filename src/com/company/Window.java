package com.company;

import javax.swing.*;

public class Window {

    /*
     * Displays a message.
     */
    public void msg(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    /*
     * Prompts user for input and returns said input.
     */
    public String in(String msg) {
        return JOptionPane.showInputDialog(msg);
    }

    /*
     * Prompts user to select a button and returns the index of the button that the user selected.
     */
    public int option(String[] options, String msg) {
        return JOptionPane.showOptionDialog(
                null,
                msg, // my message
                "Click a button", // dialog box title
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options, // possible options
                options[0]); // default option
    }
}

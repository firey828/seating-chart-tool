package com.company;

import javax.swing.*;

public class Window {

    // this class

    public void msg(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    public String in(String msg) {
        return JOptionPane.showInputDialog(msg);
    }

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

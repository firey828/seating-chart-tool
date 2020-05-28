package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Frame {

    // ======== INSTANCE VARIABLES ========
    private JFrame _frame;
    private JPanel _pan;

    // ======== CONSTRUCTORS ========
    public Frame(String text, int i) {
        makeFrame(text, i);
    }

    /*
     * Creates a frame with the String text as its content.
     */
    public void makeFrame(String text, int i) {
        setupPanel(text);
        setupFrame(text, i);
    }

    /*
     * Prepares a panel for display.
     */
    private void setupPanel(String text) {
        _pan = new JPanel();
        JLabel lbl = new JLabel();
        lbl.setText(text);
        lbl.setFont(Font.getFont(Font.SANS_SERIF));
        _pan.add(lbl);
        _pan.setVisible(true);
    }

    /*
     * Prepares a frame for display.
     */
    private void setupFrame(String text, int i) {
        _frame = new JFrame("text");
        _frame.add(_pan);
        _frame.setSize(500, 100);
        _frame.setBackground(new Color(255, 255, 255));
        // _frame.setLocation(_frame.getX() + i, _frame.getY() + i);
        _frame.setLocation(((int) (Math.random() * 500)), ((int) (Math.random() * 500)));
        _frame.setVisible(true);
    }
}
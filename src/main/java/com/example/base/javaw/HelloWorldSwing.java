package com.example.base.javaw;

import javax.swing.*;

/**
 * Author by Sun, Date on 2019/3/21.
 * PS: Not easy to write code, please indicate.
 */
public class HelloWorldSwing {
    private static void createAndShowGUI() {
        JFrame jFrame = new JFrame("HelloWorld Swing");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel helloLabel = new JLabel("Hello World!");
        jFrame.getContentPane().add(helloLabel);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}

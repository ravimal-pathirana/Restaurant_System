package com.Restaurant_System.main;

import com.Restaurant_System.gui.MainFrame;
import javax.swing.UIManager;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {

        // The Magic Line: Force Swing to use the host Operating System's native style
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("Could not load system theme, falling back to default.");
        }

        // It is a Java best practice to launch GUI components on this specific thread
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}
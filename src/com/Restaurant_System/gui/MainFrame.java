package com.Restaurant_System.gui;

import com.Restaurant_System.models.MenuCatalog;
import com.Restaurant_System.models.MenuItem;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {

        // 1. Setup the basic window properties
        setTitle("QuickBite Ordering System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centers the window on the screen

        // 2. Fetch the "Fake Database"
        MenuCatalog catalog = new MenuCatalog();

        // 3. Create a Panel with a Grid Layout
        // The GridLayout parameters are: (rows, columns, horizontal gap, vertical gap)
        // Setting rows to 0 tells Java "just keep adding new rows automatically as needed"
        JPanel menuPanel = new JPanel(new GridLayout(0, 3, 10, 10));

        // Add an invisible border to act as padding so buttons don't touch the window edges
        menuPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // 4. The "Magic Loop" - Dynamically building the buttons
        for (MenuItem item : catalog.getMenuItems()) {

            // Format the text to look nice on the button using HTML
            String buttonText = "<html><center><b>" + item.getName() + "</b><br>"+ "<p style='font-size:9px; margin:2px;'>" + item.getDescription() + "<p>" + "Rs." + item.getBasePrice() + "</center></html>";
            JButton itemButton = new JButton(buttonText);

            // Make the buttons a nice uniform size
            itemButton.setPreferredSize(new Dimension(150, 80));

            // Tell the button what to do when clicked
            itemButton.addActionListener(e -> {
                System.out.println("Clicked: " + item.getName());
                // Later, this is where we will add the item to the Order object!
            });

            // Drop the button into the grid
            menuPanel.add(itemButton);
        }

        // 5. Add the finished grid panel to the main window
        add(menuPanel, BorderLayout.CENTER);
    }
}
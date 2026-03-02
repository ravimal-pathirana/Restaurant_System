package Restaurant_System.utils;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class KitchenThread implements Runnable {

    private ProgressBar orderProgressBar;
    private Label statusLabel;
    private int totalItems;

    // The Constructor: This is how the Main Menu passes the UI elements over here
    public KitchenThread(ProgressBar orderProgressBar, Label statusLabel, int totalItems) {
        this.orderProgressBar = orderProgressBar;
        this.statusLabel = statusLabel;
        this.totalItems = totalItems;
    }

    @Override
    public void run() {
        try {
            // Loop to fill the progress bar
            for (double i = 0; i <= 1.0; i += 0.05) {
                final double currentProgress = i;

                // Safely update the UI from the background
                Platform.runLater(() -> {
                    orderProgressBar.setProgress(currentProgress);
                });

                Thread.sleep(2000); // Control the speed
            }

            // Final update when finished
            Platform.runLater(() -> {
                orderProgressBar.setProgress(1.0);
                statusLabel.setText("Order Ready!");
                orderProgressBar.setStyle("-fx-accent: #28a745;"); // Turn it green
            });

        } catch (InterruptedException e) {
            System.err.println("Kitchen thread was interrupted!");
        }
    }
}
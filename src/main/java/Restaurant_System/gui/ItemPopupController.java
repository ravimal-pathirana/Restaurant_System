package Restaurant_System.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.control.CheckBox;
import Restaurant_System.models.MenuItem;
import Restaurant_System.models.Extra;

public class ItemPopupController {

    @FXML private ImageView popupImage;
    @FXML private Label popupName;
    @FXML private Label popupPrice;
    @FXML private Label popupDescription;
    @FXML private VBox optionsContainer;
    @FXML private Label quantityLabel;
    @FXML private Button confirmButton;

    private Runnable closeAction;
    private MenuItem currentItem;
    private int quantity = 1; // Start at 1

    public void iniData(MenuItem item) {
        this.currentItem = item;
        this.quantity = 1; // Reset quantity to 1 every time the popup opens

        popupName.setText(item.getName());
        popupDescription.setText(item.getDescription());

        if (quantityLabel != null) {
            quantityLabel.setText(String.valueOf(quantity));
        }

        // --- 1. IMAGE LOGIC ---
        try {
            Image image = new Image(getClass().getResourceAsStream(item.getImagePath()));
            popupImage.setImage(image);
            popupImage.setPreserveRatio(true);
            popupImage.setSmooth(true);
        } catch (Exception e) {
            System.out.println("Could not load image for: " + item.getName());
        }

        // --- 2. EXTRAS LOGIC (Dynamic Checkboxes) ---
        if (optionsContainer != null) {
            optionsContainer.getChildren().clear(); // Clear leftovers from previous clicks

            for (Extra extra : item.getAvailableExtras()) {
                CheckBox cb = new CheckBox(extra.toString());

                // Make the checkbox actually do something
                cb.setOnAction(e -> {
                    if (cb.isSelected()) {
                        // --- ERROR FIXED HERE ---
                        item.addSelectedExtra(extra); // Matches MenuItem method name exactly
                    } else {
                        item.getSelectedExtras().remove(extra);
                    }
                    updatePriceDisplay(); // Instantly update the price label
                });

                optionsContainer.getChildren().add(cb);
            }
        }

        // Show the initial price
        updatePriceDisplay();
    }

    // Helper method to calculate (Base Price + Extras) * Quantity
    private void updatePriceDisplay() {
        double total = currentItem.getTotalPrice() * quantity;
        popupPrice.setText("Rs. " + String.format("%.2f", total));
    }

    // Connects the popup to the Main Menu's overlay
    public void setCloseAction(Runnable closeAction) {
        this.closeAction = closeAction;
    }

    // --- 3. BUTTON CLICK METHODS ---

    @FXML
    private void handlePlus() {
        quantity++;
        if (quantityLabel != null) quantityLabel.setText(String.valueOf(quantity));
        updatePriceDisplay();
    }

    @FXML
    private void handleMinus() {
        if (quantity > 1) { // Prevents ordering 0 or negative items
            quantity--;
            if (quantityLabel != null) quantityLabel.setText(String.valueOf(quantity));
            updatePriceDisplay();
        }
    }

    @FXML
    private void handleConfirm() {
        System.out.println("Confirmed " + quantity + "x " + currentItem.getName());

        // TODO: Pass 'currentItem' and 'quantity' to the order list on the right side!

        if (closeAction != null) {
            closeAction.run(); // Removes the dark overlay
        }
    }
    @FXML
    private void handleClose() {
        if (closeAction != null) {
            closeAction.run();
        }
    }
}
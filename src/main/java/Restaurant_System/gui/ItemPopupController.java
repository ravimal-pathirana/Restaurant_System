package Restaurant_System.gui;

import java.io.InputStream;
import java.util.function.Consumer;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import Restaurant_System.models.Extra;
import Restaurant_System.models.MenuItem;
import Restaurant_System.models.OrderItem;

public class ItemPopupController {

    @FXML private ImageView popupImage;
    @FXML private Label popupName;
    @FXML private Label popupPrice;
    @FXML private Label popupDescription;
    @FXML private VBox optionsContainer;
    @FXML private Label quantityLabel;
    @FXML private Button confirmButton;

    private MenuItem currentItem;
    private int quantity = 1;
    private Runnable closeAction;
    private Consumer<OrderItem> onAddToCart;

    public void initData(MenuItem item) {
        this.currentItem = item;
        this.quantity = 1;

        // Clears any unconfirmed extras from previous cancelled attempts
        this.currentItem.getSelectedExtras().clear();

        popupName.setText(item.getName());
        popupDescription.setText(item.getDescription());

        if (quantityLabel != null) {
            quantityLabel.setText(String.valueOf(quantity));
        }

        loadImage(item);
        loadExtras(item);
        updatePriceDisplay();
    }

    private void loadImage(MenuItem item) {
        InputStream imageStream = getClass().getResourceAsStream(item.getImagePath());
        if (imageStream != null) {
            popupImage.setImage(new Image(imageStream));
            popupImage.setPreserveRatio(true);
            popupImage.setSmooth(true);
        } else {
            System.err.println("Image File not found for:  " + item.getName());
        }
    }

    private void loadExtras(MenuItem item) {
        if (optionsContainer != null) {
            optionsContainer.getChildren().clear();

            for (Extra extra : item.getAvailableExtras()) {
                CheckBox cb = new CheckBox(extra.toString());

                cb.setOnAction(e -> {
                    if (cb.isSelected()) {
                        item.addSelectedExtra(extra);
                    } else {
                        item.getSelectedExtras().remove(extra);
                    }
                    updatePriceDisplay();
                });

                optionsContainer.getChildren().add(cb);
            }
        }
    }

    private void updatePriceDisplay() {
        double total = currentItem.getTotalPrice() * quantity;
        popupPrice.setText("Rs. " + String.format("%.2f", total));
    }

    // --- 4. SETTERS FOR THE CONTROLLER BRIDGE ---
    public void setCloseAction(Runnable closeAction) {
        this.closeAction = closeAction;
    }

    public void setOnAddToCart(Consumer<OrderItem> onAddToCart) {
        this.onAddToCart = onAddToCart;
    }

    // --- 5. FXML BUTTON EVENT HANDLERS ---
    @FXML
    private void handlePlus() {
        quantity++;
        if (quantityLabel != null) quantityLabel.setText(String.valueOf(quantity));
        updatePriceDisplay();
    }

    @FXML
    private void handleMinus() {
        if (quantity > 1) {
            quantity--;
            if (quantityLabel != null) quantityLabel.setText(String.valueOf(quantity));
            updatePriceDisplay();
        }
    }

    @FXML
    private void handleConfirm() {
        OrderItem newOrder = new OrderItem(currentItem, quantity);

        if (onAddToCart != null) {
            onAddToCart.accept(newOrder);
        }

        if (closeAction != null) {
            closeAction.run();
        }
    }

    @FXML
    private void handleClose() {
        if (closeAction != null) {
            closeAction.run();
        }
    }
}
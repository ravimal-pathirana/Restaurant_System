package Restaurant_System.gui;

import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.geometry.Pos;

import Restaurant_System.models.MenuCatalog;
import Restaurant_System.models.MenuItem;
import Restaurant_System.models.OrderItem;

public class MainMenuController {

    @FXML private TilePane menuGrid;
    @FXML private StackPane rootStackPane;
    @FXML private VBox cartVBox;
    @FXML private Label totalLabel;

    //Class Level Variables
    private List<OrderItem> currentCart = new ArrayList<>();
    private MenuCatalog catalog = new MenuCatalog();
    private List<MenuItem> allItems;

    @FXML
    public void initialize() {
        System.out.println("MainMenuController initialized Successfully");

        // Save the full list of items when the app first opens
        allItems = catalog.getMenuItems();

        // Show all items on startup
        displayItems(allItems);
    }

    // --- LEFT PANEL ACTIONS ---

    @FXML
    private void showAllItems() {
        displayItems(allItems); // Sends the full, unfiltered list
    }

    @FXML
    private void showFoods() {
        List<MenuItem> foodsOnly = new ArrayList<>();
        for (MenuItem item : allItems) {
            if (item instanceof Restaurant_System.models.Foods) {
                foodsOnly.add(item);
            }
        }
        displayItems(foodsOnly); // Sends only the filtered list!
    }

    @FXML
    private void showDrinks() {
        List<MenuItem> drinksOnly = new ArrayList<>();
        for (MenuItem item : allItems) {
            if (item instanceof Restaurant_System.models.Drinks) {
                drinksOnly.add(item);
            }
        }
        displayItems(drinksOnly); // Sends only the filtered list!
    }

    private void displayItems(List<MenuItem> itemsToShow) {
        menuGrid.getChildren().clear();

        for (MenuItem item : itemsToShow) {
            VBox foodCard = createFoodCard(item);
            menuGrid.getChildren().add(foodCard);
        }
    }

    private VBox createFoodCard(MenuItem item) {

        VBox card = new VBox(10);
        card.setStyle("-fx-background-color: white; " +
                "-fx-background-radius: 15; " +
                "-fx-padding: 15; " +
                "-fx-alignment: center; " +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0, 0, 0);");

        // --- 1. IMAGE HANDLING ---
        ImageView imageView = new ImageView();
        try {
            Image image = new Image(getClass().getResourceAsStream(item.getImagePath()));
            imageView.setImage(image);
            imageView.setFitWidth(160);
            imageView.setFitHeight(110);
            imageView.setPreserveRatio(false);

            Rectangle clip = new Rectangle(160, 110);
            clip.setArcWidth(25);
            clip.setArcHeight(25);
            imageView.setClip(clip);

        } catch (Exception e) {
            System.out.println("Error loading image: " + item.getImagePath());
            e.printStackTrace();
        }

        Label nameLabel = new Label(item.getName());
        nameLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 15px;");

        Label descLabel = new Label(item.getDescription());
        descLabel.setWrapText(true);
        descLabel.setMinHeight(40);
        descLabel.setMaxWidth(160);
        descLabel.setStyle("-fx-font-size: 12px; -fx-text-fill: #666666; -fx-text-alignment: center;");

        Label priceLabel = new Label("Rs." + String.format("%.2f", item.getBasePrice()));
        priceLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: #d9534f;");

        Button addButton = new Button("Add to Order");
        addButton.setStyle("-fx-background-color: #28a745; -fx-text-fill: white; -fx-cursor: hand;");

        addButton.setOnAction(event -> {
            openItemPopup(item); // This calls your popup method
        });

        // --- 2. ADD IMAGE TO THE CARD ---
        card.getChildren().addAll(imageView, nameLabel, descLabel, priceLabel, addButton);

        return card;
    }

    private void openItemPopup(MenuItem selectedItem) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Restaurant_System/gui/ItemPopup.fxml"));
            Parent popupRoot = loader.load();

            ItemPopupController popupController = loader.getController();

            popupController.initData(selectedItem);

            // --- THE NEW BRIDGE ---
            popupController.setOnAddToCart(orderItem -> {
                currentCart.add(orderItem);
                updateCartUI();
                System.out.println("SUCCESS: Added " + orderItem.getQuantity() + "x " + orderItem.getItem().getName() + " to the cart!");
            });

            // --- THE OVERLAY LOGIC ---
            StackPane overlay = new StackPane();
            overlay.setStyle("-fx-background-color: rgba(0, 0, 0, 0.6);");

            overlay.getChildren().add(popupRoot);
            rootStackPane.getChildren().add(overlay);

            popupController.setCloseAction(() -> rootStackPane.getChildren().remove(overlay));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateCartUI() {
        // 1. Wipe the screen clean
        cartVBox.getChildren().clear();
        double grandTotal = 0.0;

        // 2. Loop through the background data
        for (OrderItem orderItem : currentCart) {

            // Create a small container for this specific row
            VBox rowContainer = new VBox(2);
            rowContainer.setStyle("-fx-border-color: #e0e0e0; -fx-border-width: 0 0 1 0; -fx-padding: 0 0 5 0;");

            // Main Name and Quantity Label
            Label nameLabel = new Label(orderItem.getQuantity() + "x " + orderItem.getItem().getName());
            nameLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");

            rowContainer.getChildren().add(nameLabel);

            // Loop through any extras and add them as smaller text
            if (!orderItem.getItem().getSelectedExtras().isEmpty()) {
                for (Restaurant_System.models.Extra extra : orderItem.getItem().getSelectedExtras()) {
                    Label extraLabel = new Label("+ " + extra.getName());
                    extraLabel.setStyle("-fx-font-size: 11px; -fx-text-fill: #777777;");
                    rowContainer.getChildren().add(extraLabel);
                }
            }

            // Price for this row (aligned to the right)
            Label rowPriceLabel = new Label("Rs. " + String.format("%.2f", orderItem.getTotalPrice()));
            rowPriceLabel.setStyle("-fx-font-weight: bold; -fx-text-fill: #555555;");

            HBox priceBox = new HBox(rowPriceLabel);
            priceBox.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
            rowContainer.getChildren().add(priceBox);

            // 3. Drop the completed row into the right panel!
            cartVBox.getChildren().add(rowContainer);

            // 4. Add to the running total
            grandTotal += orderItem.getTotalPrice();
        }

        // Update the big label at the bottom
        totalLabel.setText("Rs. " + String.format("%.2f", grandTotal));
    }
}
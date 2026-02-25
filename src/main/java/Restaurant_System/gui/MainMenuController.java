package Restaurant_System.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import Restaurant_System.models.MenuCatalog;
import Restaurant_System.models.MenuItem;

import java.util.ArrayList;
import java.util.List;


public class MainMenuController {

    @FXML
    private TilePane menuGrid;

    @FXML
    public void initialize() {
        System.out.println("MainMenuController initialized Successfully");
        loadMenuCards();
    }

    private void loadMenuCards() {

        // TEMPORARY UI TESTER
        // This loop generates dummy cards with descriptions so we can test the layout right now.
        /*
        for (int i = 1; i <= 6; i++) {
            String dummyName = "Sample Food " + i;
            String dummyDesc = "A delicious, mouth-watering QuickBite signature item made with fresh ingredients.";
            double dummyPrice = 12.50;

            VBox foodCard = createFoodCard(dummyName, dummyDesc, dummyPrice);
            menuGrid.getChildren().add(foodCard);
        }
         */

        MenuCatalog catalog = new MenuCatalog();
        menuGrid.getChildren().clear();

        for (MenuItem item : catalog.getMenuItems()) {
            VBox foodCard = createFoodCard(
                    item.getName(),
                    item.getDescription(),
                    item.getBasePrice(),
                    item.getImagePath());
            menuGrid.getChildren().add(foodCard);
        }

    }

    private VBox createFoodCard(String name, String description, double price, String imagePath) {

        VBox card = new VBox(10);
        card.setStyle("-fx-background-color: white; " +
                "-fx-background-radius: 15; " +
                "-fx-padding: 15; " +
                "-fx-alignment: center; " +
                "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0, 0, 0);");

        // --- 1. IMAGE HANDLING ---
        ImageView imageView = new ImageView();
        try {
            Image image = new Image(getClass().getResourceAsStream(imagePath));
            imageView.setImage(image);
            imageView.setFitWidth(160);
            imageView.setFitHeight(110);
            imageView.setPreserveRatio(false);

            Rectangle clip = new Rectangle(160, 110);
            clip.setArcWidth(25);
            clip.setArcHeight(25);
            imageView.setClip(clip);

        } catch (Exception e) {
            System.out.println("Error loading image: " + imagePath);
        }

        Label nameLabel = new Label(name);
        nameLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 15px;");

        Label descLabel = new Label(description);
        descLabel.setWrapText(true);
        descLabel.setMinHeight(40);
        descLabel.setMaxWidth(160);
        descLabel.setStyle("-fx-font-size: 12px; -fx-text-fill: #666666; -fx-text-alignment: center;");

        Label priceLabel = new Label("Rs." + String.format("%.2f", price));
        priceLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 14px; -fx-text-fill: #d9534f;");

        Button addButton = new Button("Add to Order");
        addButton.setStyle("-fx-background-color: #28a745; -fx-text-fill: white; -fx-cursor: hand;");

        // --- 2. ADD IMAGE TO THE CARD ---
        // Make sure 'imageView' is the FIRST thing in this list so it appears at the top!
        card.getChildren().addAll(imageView, nameLabel, descLabel, priceLabel, addButton);

        return card;
    }
}
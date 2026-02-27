package Restaurant_System.gui;

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
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Modality;


import Restaurant_System.models.MenuCatalog;
import Restaurant_System.models.MenuItem;

import java.util.ArrayList;
import java.util.List;


public class MainMenuController {

    @FXML
    private TilePane menuGrid;

    @FXML private StackPane rootStackPane;


    @FXML
    public void initialize() {
        System.out.println("MainMenuController initialized Successfully");
        loadMenuCards();
    }

    private void loadMenuCards() {

        MenuCatalog catalog = new MenuCatalog();
        menuGrid.getChildren().clear();

        for (MenuItem item : catalog.getMenuItems()) {
//            VBox foodCard = createFoodCard(
//                    item.getName(),
//                    item.getDescription(),
//                    item.getBasePrice(),
//                    item.getImagePath());
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
        // Make sure 'imageView' is the FIRST thing in this list so it appears at the top!
        card.getChildren().addAll(imageView, nameLabel, descLabel, priceLabel, addButton);

        return card;
    }

    private void openItemPopup(MenuItem selectedItem) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Restaurant_System/gui/ItemPopup.fxml"));
            Parent popupRoot = loader.load();

            ItemPopupController popupController = loader.getController();
            popupController.iniData(selectedItem);

            // --- THE OVERLAY LOGIC ---
            // Create a dark, semi-transparent background
            StackPane overlay = new StackPane();
            overlay.setStyle("-fx-background-color: rgba(0, 0, 0, 0.6);"); // 60% black

            // Add the popup to the center of the dark background
            overlay.getChildren().add(popupRoot);

            // Add the overlay to the main screen
            rootStackPane.getChildren().add(overlay);

            // Tell the popup controller how to close itself!
            popupController.setCloseAction(() -> rootStackPane.getChildren().remove(overlay));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
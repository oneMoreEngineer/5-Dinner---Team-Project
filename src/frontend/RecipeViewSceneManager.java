package frontend;

import backend.Recipe;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;

/**
 * This sets up the Recipe View page
 * @author Farah, James, Shota, and Andrei
 *
 */
public class RecipeViewSceneManager {

	private Label recipeName;			//this stores the recipe name
	private Label alertLabel;			//this is an alert label
	private FlowPane tagPane;			//this stores the tags
	private Text instructions;			//this stores the instructions
	private Button viewRecipeBackBtn;	//this is the back button
	private Button likeBtn;				//this is the like button

	/**
	 * This is the getter for the recipe name
	 * @return the recipe name
	 */
	public Label getRecipeName() {
		return recipeName;
	}

	/**
	 * This is the getter for the alert label
	 * @return the alert label
	 */
	public Label getAlertLabel() {
		return alertLabel;
	}

	/**
	 * This is the getter for the tags
	 * @return the tags
	 */
	public FlowPane getTagPane() {
		return tagPane;
	}

	/**
	 * This is the getter for the instructions
	 * @return the instructions
	 */
	public Text getInstructions() {
		return instructions;
	}

	/**
	 * This is the getter for the back button
	 * @return the back button
	 */
	public Button getViewRecipeBackBtn() {
		return viewRecipeBackBtn;
	}

	/**
	 * This is the getter for the like button
	 * @return the like button
	 */
	public Button getLikeBtn() {
		return likeBtn;
	}

	/**
	 * This is the getter for the recipe view scene
	 * @return the recipe view scene
	 */
	public Scene getRecipeViewScene() {
		BorderPane root = new BorderPane();
		root.setStyle("-fx-background-color: #edcbb8;");
		root.setPadding(new Insets(20, 20, 20, 20));

		//sets up the components
		VBox headerContainer = getHeader();
		ScrollPane scrollPane = getRecipeCard();
		HBox buttons = getButtons();

		//adds all components to the root
		root.setTop(headerContainer);
		root.setCenter(scrollPane);
		root.setBottom(buttons);

		//adds the root to the scene
		Scene scene = new Scene(root, 500, 500);
		return scene;
	}

	/**
	 * This is the getter for the header
	 * @return the header
	 */
	private VBox getHeader() {
		//sets the title
		Label header = new Label("View Recipe");
		Font headerFont = Font.font("Times New Roman", FontPosture.ITALIC, 30);
		header.setFont(headerFont);

		//sets up the alert label
		alertLabel = new Label("");
		Font alertFont = Font.font("Times New Roman", 16);
		alertLabel.setFont(alertFont);

		//adds the title and the alert label to the VBox
		VBox headerContainer = new VBox();
		headerContainer.setPadding(new Insets(20, 20, 20, 20));
		headerContainer.setAlignment(Pos.BASELINE_CENTER);
		headerContainer.setSpacing(10);
		headerContainer.getChildren().addAll(header, alertLabel);

		return headerContainer;
	}

	/**
	 * This sets up the recipe card
	 * @return the recipe card
	 */
	private ScrollPane getRecipeCard() {
		//sets up recipe name label
		recipeName = new Label("[Recipe Name]");
		Font font = Font.font("Times New Roman", 26);
		recipeName.setFont(font);
		recipeName.setPadding(new Insets(10, 10, 10, 10));

		// sets up tag list
		tagPane = new FlowPane();
		tagPane.setHgap(15d);
		tagPane.setVgap(5d);
		tagPane.setPadding(new Insets(0, 0, 5, 15));
		tagPane.setOrientation(Orientation.HORIZONTAL);

		//sets up instructions
		instructions = new Text("");
		Font insFont = Font.font("Times New Roman", 16);
		instructions.setFont(insFont);

		//adds instructions to VBox
		VBox descriptionCard = new VBox();
		descriptionCard.getChildren().addAll(instructions);

		//adds all components to VBox
		VBox recipeCard = new VBox();
		recipeCard.getChildren().addAll(recipeName, tagPane, descriptionCard);
		recipeCard.setPadding(new Insets(15, 15, 15, 15));

		//adds VBox to ScrollPane
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setContent(recipeCard);

		return scrollPane;
	}

	/**
	 * This method handles the buttons
	 * @return the buttons
	 */
	private HBox getButtons() {
		//sets up back button
		viewRecipeBackBtn = new Button("Back");
		viewRecipeBackBtn.setPrefWidth(100);
		viewRecipeBackBtn.setPrefHeight(10);
		viewRecipeBackBtn.setFont(new Font("Times New Roman", 14));
		viewRecipeBackBtn.setStyle("-fx-background-color: #dba49a; -fx-border-color: black; -fx-border-width: 1px;"
				+ "-fx-border-radius: 7px; -fx-background-radius: 7px;");

		//sets up like button
		likeBtn = new Button("Add to likes");
		likeBtn.setPrefWidth(200);
		likeBtn.setPrefHeight(10);
		likeBtn.setFont(new Font("Times New Roman", 14));
		likeBtn.setStyle("-fx-background-color: #dba49a; -fx-border-color: black; -fx-border-width: 1px;"
				+ "-fx-border-radius: 7px; -fx-background-radius: 7px;");

		//adds buttons to HBox
		HBox buttons = new HBox();							
		buttons.setAlignment(Pos.BASELINE_CENTER);
		buttons.setSpacing(10);
		buttons.setPadding(new Insets(20, 20, 10, 20));
		buttons.getChildren().addAll(viewRecipeBackBtn, likeBtn);

		return buttons;
	}

	/**
	 * This method fills the recipe scene 
	 * @param recipe is the recipe to fill
	 */
	public void fillRecipeScene(Recipe recipe) {
		if (recipe == null)
			return;

		//sets up recipe name
		getRecipeName().setText(recipe.getRecipeName());

		//loops through tags
		for (String tag : recipe.getTags()) {
			if (!tag.isEmpty()) {
				//sets up tag formatting
				Label tagLabel = new Label(tag);
				tagLabel.setStyle("-fx-background-color: #b2908a; -fx-background-radius: 7px;");
				tagLabel.setPadding(new Insets(3, 3, 3, 3));
				tagLabel.setTextFill(Color.web("white"));
				getTagPane().getChildren().add(tagLabel);
			}
		}
		//sets up recipe instructions
		getInstructions().setText(recipe.getRecipeInstructions());
	}
}

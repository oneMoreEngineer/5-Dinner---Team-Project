package frontend;

import java.util.ArrayList;

import backend.DataManager;
import backend.Recipe;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * This class handles the Create Post Scene
 * @author Farah, James, Shota, and Andrei
 *
 */
public class CreatePostSceneManager {

	private Label createPostAlert;					//this is an alert label that displays if the user did something incorrect
	private TextField recipeNameField;				//this is the recipe name text field
	private TextArea recipeInstructionsTextArea;	//this is the recipe instructions text area
	private ComboBox<String> priceMenu;				//this is the dropdown for the price 
	private ArrayList<CheckBox> checkBoxes;			//these are the check boxes for the tags
	private Button backPrflButton;					//this is the back button
	private Button postButton;						//this is the post button

	/**
	 * Constructor to initialize the ArrayList if check boxes for the tags
	 */
	public CreatePostSceneManager() {
		checkBoxes = new ArrayList<>();
	}

	/**
	 * This is a getter method for the alert label
	 * @return the alert label
	 */
	public Label getCreatePostAlert() {
		return createPostAlert;
	}

	/**
	 * This is a getter method for the recipe name
	 * @return the recipe name text field
	 */
	public TextField getRecipeNameField() {
		return recipeNameField;
	}

	/**
	 * This is a getter method for the recipe instructions text area
	 * @return recipe instructions text area
	 */
	public TextArea getRecipeInstructionsTextArea() {
		return recipeInstructionsTextArea;
	}

	/**
	 * This is a getter method for the recipe price dropdown
	 * @return recipe price dropdown
	 */
	public ComboBox<String> getPriceMenu() {
		return priceMenu;
	}

	/**
	 * This is a getter method for the checkboxes for the tags
	 * @return the checkboxes for the tags
	 */
	public ArrayList<CheckBox> getCheckBoxes() {
		return checkBoxes;
	}

	/**
	 * This is a getter method for the back button
	 * @return back button
	 */
	public Button getBackPrflButton() {
		return backPrflButton;
	}

	/**
	 * This is a getter method for the post button
	 * @return the post button
	 */
	public Button getPostButton() {
		return postButton;
	}

	/**
	 * This method sets up the create post page
	 * @return the create post scene
	 */
	public Scene getCreatePostScene() {
		BorderPane root = new BorderPane();
		root.setStyle("-fx-background-color:edcbb8");
		root.setPadding(new Insets(20, 20, 20, 20));

		//gets header and center
		VBox headerContainer = getHeader();
		VBox centerContainer = getCenter();

		//adds them to the root
		root.setTop(headerContainer);
		root.setCenter(centerContainer);

		//adds root to the scene
		Scene scene = new Scene(root, 500, 500);
		return scene;
	}

	/**
	 * This method sets up the header
	 * @return the header
	 */
	private VBox getHeader() {
		//sets up title
		Label header = new Label("Create a Post");
		header.setFont(new Font("Times New Roman", 26));

		//sets up VBox to hold title
		VBox headerContainer = new VBox();
		headerContainer.setPadding(new Insets(20, 20, 20, 20));
		headerContainer.setAlignment(Pos.BASELINE_CENTER);
		headerContainer.getChildren().add(header);

		return headerContainer;
	}

	/**
	 * This method handles the formatting for the buttons
	 * @return the HBox with the buttons
	 */
	private HBox getButtons() {
		//sets up the back button
		backPrflButton = new Button("Back");
		backPrflButton.setPrefSize(100,20);
		backPrflButton.setStyle("-fx-background-color: #dba49a; -fx-border-color: black; -fx-border-width: 1px;"
				+ "-fx-border-radius: 7px; -fx-background-radius: 7px;");
		backPrflButton.setFont(Font.font("Times New Roman", 14));

		//sets up the post button
		postButton = new Button("Post");
		postButton.setPrefSize(100,20);
		postButton.setStyle("-fx-background-color: #dba49a; -fx-border-color: black; -fx-border-width: 1px;"
				+ "-fx-border-radius: 7px; -fx-background-radius: 7px;");
		postButton.setFont(Font.font("Times New Roman", 14));

		//sets up the HBox to hold the buttons 
		HBox buttons = new HBox();
		buttons.getChildren().addAll(backPrflButton, postButton);
		buttons.setAlignment(Pos.BASELINE_CENTER);
		buttons.setSpacing(10);
		buttons.setPadding(new Insets(10, 10, 10, 10));

		return buttons;
	}

	/**
	 * This method handles the formatting for the recipe name
	 * @return the HBox with the recipe name information
	 */
	private HBox getRecipeName() {
		//sets up label for recipe name
		Label recipeNameLbl = new Label("Recipe Name: ");
		recipeNameLbl.setPadding(new Insets(10, 10, 0, 0));
		recipeNameLbl.setFont(Font.font("Times New Roman", 14));

		//sets up recipe name text field
		recipeNameField = new TextField();
		recipeNameField.setPromptText("Enter Name");
		recipeNameField.setPadding(new Insets(10, 10, 10, 10));
		recipeNameField.setStyle("-fx-background-color: fcedde");

		//sets up HBox to hold the label and text field
		HBox recipeNameContainer = new HBox();
		recipeNameContainer.setAlignment(Pos.BASELINE_CENTER);
		recipeNameContainer.getChildren().addAll(recipeNameLbl, recipeNameField);

		return recipeNameContainer;
	}

	/**
	 * This method handles the formatting for the recipe cost
	 * @return the HBox with the recipe cost information
	 */
	private HBox getRecipeCost() {
		//sets up HBox to hold the cost
		HBox costRange = new HBox();
		costRange.setSpacing(10);
		costRange.setPadding(new Insets(0, 0, 0, 70));
		costRange.setAlignment(Pos.BOTTOM_CENTER);

		//sets up label to prompt for the cost
		Label recipeCost = new Label("Select Price Range: ");
		Font font = Font.font("Times New Roman", 14);
		recipeCost.setFont(font);
		recipeCost.setPadding(new Insets(0,0,3,0));

		//sets up dropdown
		priceMenu = new ComboBox<>();
		priceMenu.getItems().addAll("$5", "$5 - $10", "$10 - $15");

		//adds label and dropdown to the HBox
		costRange.getChildren().addAll(recipeCost, priceMenu);

		return costRange;
	}

	/**
	 * This method handles the formatting for the center of the page
	 * @return the VBox with the center of the page
	 */
	private VBox getCenter() {
		//sets up the VBox for the center of the page
		VBox centerContainer = new VBox();
		centerContainer.setPadding(new Insets(10, 0, 0, 0));
		centerContainer.setSpacing(10);
		centerContainer.setAlignment(Pos.TOP_CENTER);

		//sets up alert label
		createPostAlert = new Label("");
		createPostAlert.setFont(new Font("Times New Roman", 14));

		//sets up instructions label
		Label recipeInstructionsLbl = new Label("Enter Instructions: ");

		//sets up instructions text area
		recipeInstructionsTextArea = new TextArea();
		recipeInstructionsTextArea.setStyle("-fx-background-color:fcedde");

		//gets the rest of the components
		HBox recipeNameContainer = getRecipeName();
		HBox costRange = getRecipeCost();		
		FlowPane tags = constructTagsCard();
		HBox buttons = getButtons();

		//adds all components to the center
		centerContainer.getChildren().addAll(recipeNameContainer, costRange, tags, recipeInstructionsLbl, recipeInstructionsTextArea, createPostAlert, buttons);

		return centerContainer;
	}

	/**
	 * This is a helper method to set up the CheckBoxes
	 * @return a FlowPane with the CheckBoxes
	 */
	private FlowPane constructTagsCard() {
		//sets up the flowpane to hold the tags
		FlowPane tags = new FlowPane();
		tags.setPadding(new Insets(0, 0, 0, 0));
		tags.setOrientation(Orientation.HORIZONTAL);
		tags.setAlignment(Pos.BASELINE_CENTER);
		tags.setVgap(10d);
		tags.setHgap(10d);

		//creates a checkbox for each option
		CheckBox vegetarian = createCheckbox("Vegetarian");
		CheckBox vegan = createCheckbox("Vegan");
		CheckBox nut_free = createCheckbox("Nut-Free");
		CheckBox gluten_free= createCheckbox("Gluten-Free");
		CheckBox pescetarian = createCheckbox("Pescetarian");

		//adds checkbox to the ArrayList
		checkBoxes.add(vegetarian);
		checkBoxes.add(vegan);
		checkBoxes.add(nut_free);
		checkBoxes.add(gluten_free);
		checkBoxes.add(pescetarian);

		//adds each checkbox to the HBox for formatting
		HBox checklist = new HBox();
		checklist.setSpacing(10.0);
		checklist.getChildren().addAll(vegetarian, vegan, nut_free, gluten_free, pescetarian);

		//HBox is added to the FlowPane
		tags.getChildren().addAll(checklist);

		return tags;
	}

	/**
	 * This creates a CheckBox for the constructTagsCard() method
	 * @param name is the name of the CheckBox
	 * @return a CheckBox
	 */
	private CheckBox createCheckbox(String name) {
		//creates a new checkbox
		CheckBox checkbox = new CheckBox(name);
		checkbox.setPadding(new Insets(10, 0, 0, 0));

		return checkbox;
	}

	/**
	 * This method handles actions for the back button
	 * @param primaryStage is the primary stage
	 * @param profile is the profile scene
	 */
	public void createPostBack(Stage primaryStage, Scene profile) {
		getBackPrflButton().setOnAction(e -> {			
			// Clear all values on scene before transitioning
			getRecipeNameField().clear(); getRecipeInstructionsTextArea().clear(); getCreatePostAlert().setText(""); getPriceMenu().getSelectionModel().clearSelection();
			//uncheck all the checkboxes
			for (CheckBox cb : getCheckBoxes()) cb.setSelected(false);
			//go to the profile page
			primaryStage.setScene(profile);
		});
	}

	/**
	 * This method handles the actions for the create post button
	 * @param primaryStage is the primary stage
	 * @param dm is the DataManager object
	 * @param recipeName is the recipe name
	 * @param recipeInstructions is the recipe instructions
	 * @param priceRanges is the price range
	 * @param tags is the tags
	 * @param currentUser is the current username
	 * @param newText is the reformatted recipe instructions
	 * @param profilePage is the profile page object
	 * @param Recipes is the ArrayList of recipes
	 * @param recipesDB is the path to the recipe flat file DB
	 * @param likedRecipesDB is the path to the liked recipes flat file DB
	 * @param profile is the profile scene
	 */
	public void createPostButton(Stage primaryStage, DataManager dm, String recipeName, String recipeInstructions, String priceRanges,
			ArrayList<String> tags, String currentUser, String newText, ProfileSceneManager profilePage, ArrayList<Recipe> Recipes, String recipesDB,
			String likedRecipesDB, Scene profile) {
		//checks that all user input fields are filled
		if (recipeName.isEmpty() || recipeInstructions.isEmpty() || priceRanges == null) {

			getCreatePostAlert().setText("**Please fill out all fields");
		}
		//checks that recipe names are unique
		else if(dm.noDuplicateRecipeNames(recipeName, recipesDB)) {
			getCreatePostAlert().setText("**Please enter a unique recipe name");
		}
		else {
			//handles creating a post
			createPostButtonHelper(primaryStage, dm, recipeName, recipeInstructions, priceRanges, tags, currentUser, newText, profilePage, Recipes,
					recipesDB, likedRecipesDB, profile);
		}
	}

	/**
	 * This method is a helper method and aids in assisting the post actions
	 * @param primaryStage is the primary stage
	 * @param dm is the DataManager object
	 * @param recipeName is the recipe name
	 * @param recipeInstructions is the recipe instructions
	 * @param priceRanges is the price range
	 * @param tags is the tags
	 * @param currentUser is the current username
	 * @param newText is the reformatted recipe instructions
	 * @param profilePage is the profile page object
	 * @param Recipes is the ArrayList of recipes
	 * @param recipesDB is the path to the recipe flat file DB
	 * @param likedRecipesDB is the path to the liked recipes flat file DB
	 * @param profile is the profile scene
	 */
	private void createPostButtonHelper(Stage primaryStage, DataManager dm, String recipeName, String recipeInstructions, String priceRanges,
			ArrayList<String> tags, String currentUser, String newText, ProfileSceneManager profilePage, ArrayList<Recipe> Recipes, String recipesDB,
			String likedRecipesDB, Scene profile) {
		String recipeTags = "";
		//Constructs ArrayList based on tags
		for (CheckBox box : getCheckBoxes()) {
			if (box.isSelected()) {
				tags.add(box.getText());	//adds tag
				recipeTags = recipeTags + " TAG " + box.getText();	//adds tag to the string of tags
			}
		}

		//adds recipe to DB
		dm.saveRecipe(currentUser, recipeName, priceRanges, recipeTags, newText, recipesDB);

		//clears own recipe list view
		profilePage.getOwnRecipePosts().getItems().clear();
		ArrayList<String> profilePosts = dm.getNamesOwnRecipes(currentUser, recipesDB);
		for(String n: profilePosts) {
			profilePage.getOwnRecipePosts().getItems().add(n);	//updates list view of own recipes
		}

		// Add recipe to Recipes ArrayList<>
		Recipe newRecipe = new Recipe(priceRanges, tags, recipeName, "", recipeInstructions);
		Recipes.add(newRecipe);

		// Clear all values on scene before transitioning
		getRecipeNameField().clear(); getRecipeInstructionsTextArea().clear(); getCreatePostAlert().setText(""); getPriceMenu().getSelectionModel().clearSelection();
		for (CheckBox cb : getCheckBoxes()) cb.setSelected(false);
		profilePage.getLikedRecipePosts().getItems().clear();
		for (String recipe : dm.recipesLikedByUser(currentUser, likedRecipesDB)) {
			profilePage.getLikedRecipePosts().getItems().add(recipe);
		}
		//changes page
		primaryStage.setScene(profile);
	}
}

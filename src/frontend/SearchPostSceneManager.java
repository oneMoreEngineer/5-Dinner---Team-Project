package frontend;

import java.util.ArrayList;
import java.util.Scanner;

import backend.DataManager;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * This class sets up the Search Post page
 * @author Farah, James, Shota, and Andrei
 *
 */
public class SearchPostSceneManager {

	private ComboBox<String> searchPriceMenu;	//this is the dropdown with the price values
	private ArrayList<CheckBox> checkBoxes;		//this is the ArrayList of checkboxes
	private Label searchPostAlert;				//this is the alert label
	private Button searchBtn;					//this is the search button
	private Button backBtn;						//this is the back button

	/**
	 * This is the constructor to initialize the ArrayList
	 */
	public SearchPostSceneManager() {
		checkBoxes = new ArrayList<>();
	}

	/**
	 * This is the getter method for the price dropdown
	 * @return the price dropdown
	 */
	public ComboBox<String> getSearchPriceMenu() {
		return searchPriceMenu;
	}

	/**
	 * This is the getter method for the checkboxes
	 * @return the checkboxes
	 */
	public ArrayList<CheckBox> getCheckBoxes() {
		return checkBoxes;
	}

	/**
	 * This is the getter method for the alert label
	 * @return the alert label
	 */
	public Label getSearchPostAlert() {
		return searchPostAlert;
	}

	/**
	 * This is the getter method for the search button
	 * @return the search button
	 */
	public Button getSearchBtn() {
		return searchBtn;
	}

	/**
	 * This is the getter method for the back button
	 * @return the back button
	 */
	public Button getBackBtn() {
		return backBtn;
	}

	/**
	 * This method sets up the search recipes page
	 * @return the search recipes scene
	 */
	public Scene getSearchRecipeScene() {
		BorderPane root = new BorderPane();
		root.setStyle("-fx-background-color: #edcbb8;");

		//sets up all the components
		VBox headerContainer = getHeader();		
		VBox centerCard = getCenter();
		HBox buttons = getButtons();

		//add all components to the root
		root.setTop(headerContainer);
		root.setCenter(centerCard);
		root.setBottom(buttons);

		//adds root to the scene
		Scene scene = new Scene(root, 500, 400);
		return scene;
	}

	/**
	 * This method sets up the header
	 * @return the header
	 */
	private VBox getHeader() {
		//sets up title label
		Label header = new Label("Search For Recipes");
		Font headerFont = Font.font("Times New Roman", 30);
		header.setFont(headerFont);

		//adds label to the header
		VBox headerContainer = new VBox();
		headerContainer.setPadding(new Insets(20, 20, 20, 20));
		headerContainer.setAlignment(Pos.BASELINE_CENTER);
		headerContainer.getChildren().add(header);

		return headerContainer;
	}

	/**
	 * This method gets the cost range components
	 * @return the cost range components
	 */
	private HBox getCostRange() {
		//sets up the HBox to hold the components
		HBox costRange = new HBox();
		costRange.setSpacing(10);
		costRange.setPadding(new Insets(0, 0, 0, 70));
		costRange.setAlignment(Pos.BASELINE_CENTER);

		//sets up a label for the recipe cost
		Label recipeCost = new Label("Select Price Range: ");
		Font font = Font.font("Times New Roman", 14);
		recipeCost.setFont(font);
		recipeCost.setPadding(new Insets(0,0,3,0));

		//sets up the dropdown
		searchPriceMenu = new ComboBox<>();
		searchPriceMenu.getItems().addAll("$5", "$5 - $10", "$10 - $15");

		//adds all components to the HBox
		costRange.getChildren().addAll(recipeCost, searchPriceMenu);

		return costRange;
	}

	/**
	 * This method sets up the buttons
	 * @return the buttons
	 */
	private HBox getButtons() {
		//sets up search button
		searchBtn = new Button("Search");
		searchBtn.setPrefWidth(100);
		searchBtn.setPrefHeight(10);
		searchBtn.setFont(new Font("Times New Roman", 14));
		searchBtn.setStyle("-fx-background-color: #dba49a; -fx-border-color: black; -fx-border-width: 1px;"
				+ "-fx-border-radius: 7px; -fx-background-radius: 7px;");

		//sets up back button
		backBtn = new Button("Back");
		backBtn.setPrefWidth(100);
		backBtn.setPrefHeight(10);
		backBtn.setFont(new Font("Times New Roman", 14));
		backBtn.setStyle("-fx-background-color: #dba49a; -fx-border-color: black; -fx-border-width: 1px;"
				+ "-fx-border-radius: 7px; -fx-background-radius: 7px;");

		//adds buttons to HBox
		HBox buttons = new HBox();
		buttons.setAlignment(Pos.BASELINE_CENTER);
		buttons.setSpacing(10);
		buttons.setPadding(new Insets(20, 20, 10, 20));
		buttons.getChildren().addAll(backBtn, searchBtn);
		buttons.setPadding(new Insets(-130,0,0,0));

		return buttons;
	}

	/**
	 * This gets the center portion of the page
	 * @return the center portion of the page
	 */
	private VBox getCenter() {
		//gets the cost range and tags 
		HBox costRange = getCostRange();		
		FlowPane tags = constructTagsCard();

		//sets up alert label
		searchPostAlert = new Label("");
		searchPostAlert.setFont(new Font("Times New Roman", 14));
		searchPostAlert.setPadding(new Insets(0,0,0,150));

		//sets up center card with all the components
		VBox centerCard = new VBox();
		centerCard.setPadding(new Insets(30, 0, 0, 0));
		centerCard.setSpacing(20.0);
		centerCard.getChildren().addAll(costRange, tags, searchPostAlert);

		return centerCard;
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
		//creates a checkbox
		CheckBox checkbox = new CheckBox(name);
		checkbox.setPadding(new Insets(10, 0, 0, 0));

		return checkbox;
	}

	/**
	 * This method handles the navigation of the back button
	 * @param primaryStage is the primary stage
	 * @param profile is the profile scene
	 */
	public void backButtonNav(Stage primaryStage, Scene profile) {
		getBackBtn().setOnAction(e -> {
			
			// Clear all values on scene before transitioning
			getSearchPriceMenu().getSelectionModel().clearSelection();
			for (CheckBox cb : getCheckBoxes()) cb.setSelected(false);
			
			//set scene to the profile
			primaryStage.setScene(profile);
		});
	}

	/**
	 * This method handles the search button navigation
	 * @param primaryStage is the primary scene
	 * @param dm is the Data Manager object
	 * @param searchResultsDB is the path to the search results DB
	 * @param recipesDB is the path to the recipes DB
	 * @param searchResultsPage is the search results page
	 * @param sc is the Scanner
	 * @param viewResults is the view results scene
	 */
	public void searchButtonNav(Stage primaryStage, DataManager dm, String searchResultsDB, String recipesDB, SearchResultsSceneManager searchResultsPage, Scanner sc, Scene viewResults) {
		getSearchBtn().setOnAction(e -> {
			//handles input validation
			if(getSearchPriceMenu().getValue()==null) {
				getSearchPostAlert().setText("**Please fill out Price Range Field");
			}
			else {
				//adds selected tags to list
				ArrayList<String> tags = new ArrayList<>();
				for (CheckBox box : getCheckBoxes()) {
					if (box.isSelected()) {
						tags.add(box.getText());
					}
				}
				
				//searches for recipes
				dm.searchRecipes(getSearchPriceMenu().getValue(), tags , searchResultsDB, recipesDB, sc);

				//adds items to list view
				ArrayList<String> names = dm.getNames(searchResultsDB);
				for(String n: names) {
					searchResultsPage.getRecipeList().getItems().add(n);
				}
				searchResultsPage.getRecipeList().getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

				// Clear all values on scene before transitioning
				for (CheckBox cb : getCheckBoxes()) cb.setSelected(false);
				getSearchPriceMenu().getSelectionModel().clearSelection();

				//sets the scene
				primaryStage.setScene(viewResults);
			}
		});
	}
}

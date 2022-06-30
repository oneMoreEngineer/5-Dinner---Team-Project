package frontend;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;

/**
 * This class sets up the Search Results page
 * @author Farah, James, Shota, and Andrei
 *
 */
public class SearchResultsSceneManager {

	private ListView<String> recipeList;	//this is the list of recipes
	private Label alertLabel;
	private Button searchBackBtn;			//this is the back button
	private Button submitBtn;				//this is the submit button
	
	/**
	 * This is the getter method for the list of recipes
	 * @return the list of recipes
	 */
	public ListView<String> getRecipeList() {
		return recipeList;
	}

	/**
	 * This is a getter for the alert label
	 * @return the alert label
	 */
	public Label getAlertLabel() {
		return alertLabel;
	}

	/**
	 * This is the getter method for the back button
	 * @return the back button
 	 */
	public Button getSearchBackBtn() {
		return searchBackBtn;
	}

	/**
	 * This is the getter method for the submit button
	 * @return the submit button
	 */
	public Button getSubmitBtn() {
		return submitBtn;
	}

	/**
	 * This method sets up the search results page
	 * @return the search results scene
	 */
	public Scene getSearchResultsScene() {
		BorderPane root = new BorderPane();
		root.setStyle("-fx-background-color: #edcbb8;");
		root.setPadding(new Insets(20, 20, 20, 20));
		
		//sets up the page components
		VBox headerContainer = getHeader();	
		VBox listView = getListView();
		HBox buttons = getButtons();
		
		//adds all components to the root
		root.setTop(headerContainer);
		root.setCenter(listView);
		root.setBottom(buttons);
		
		//adds the root to the scene
		Scene scene = new Scene(root, 500, 500);
		return scene;
	}
	
	/**
	 * This sets up the header
	 * @return the header
	 */
	private VBox getHeader() {
		//sets up the title
		Label header = new Label("View Search Results");
		Font headerFont = Font.font("Times New Roman", FontPosture.ITALIC, 30);
		header.setFont(headerFont);
		
		//sets up alert label
		alertLabel = new Label("");
		Font font = Font.font("Times New Roman", 14);
		alertLabel.setFont(font);
		
		//adds the title to the VBox
		VBox headerContainer = new VBox();
		headerContainer.setPadding(new Insets(20, 20, 20, 20));
		headerContainer.setAlignment(Pos.BASELINE_CENTER);
		headerContainer.setSpacing(5);
		headerContainer.getChildren().addAll(header, alertLabel);
		
		return headerContainer;
	}
	
	/**
	 * This sets up the recipe list view
	 * @return the recipe list view
	 */
	private VBox getListView() {
		//sets up the label instructing what to do
		Label instructions = new Label("Select a Recipe");
		Font font = Font.font("Times New Roman", 14);
		instructions.setFont(font);
		instructions.setPadding(new Insets(10, 10, 10, 10));
		
		//sets up list
		recipeList = new ListView<>();
		
		//adds all components to the VBox
		VBox listView = new VBox();
		listView.getChildren().addAll(instructions, recipeList);
		
		return listView;
	}
	
	/**
	 * This method handles setting up the buttons
	 * @return buttons
	 */
	private HBox getButtons() {
		//sets up back button
		searchBackBtn = new Button("Back");
		searchBackBtn.setPrefWidth(100);
		searchBackBtn.setPrefHeight(10);
		searchBackBtn.setFont(new Font("Times New Roman", 14));
		searchBackBtn.setStyle("-fx-background-color: #dba49a; -fx-border-color: black; -fx-border-width: 1px;"
				+ "-fx-border-radius: 7px; -fx-background-radius: 7px;");
		
		//sets up submit button
		submitBtn = new Button("Submit");
		submitBtn.setPrefWidth(100);
		submitBtn.setPrefHeight(10);
		submitBtn.setFont(new Font("Times New Roman", 14));
		submitBtn.setStyle("-fx-background-color: #dba49a; -fx-border-color: black; -fx-border-width: 1px;"
				+ "-fx-border-radius: 7px; -fx-background-radius: 7px;");
		
		//adds buttons to HBox
		HBox buttons = new HBox();							
		buttons.setAlignment(Pos.BASELINE_CENTER);
		buttons.setSpacing(10);
		buttons.setPadding(new Insets(20, 20, 10, 20));
		buttons.getChildren().addAll(searchBackBtn, submitBtn);
		
		return buttons;
	}
}

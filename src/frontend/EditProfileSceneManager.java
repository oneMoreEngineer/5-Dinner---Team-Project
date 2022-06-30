package frontend;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * This sets up the Edit Profile page
 * @author Farah, James, Shota, and Andrei
 *
 */
public class EditProfileSceneManager {

	private Label editProfileAlert;			//this is an alert label 
	private TextField editUsernameField;	//this is the edit username text field
	private TextField editEmailField;		//this is the edit email text field
	private TextField editPasswordField;	//this is the edit password text field
	private Button backButton;				//this is the back button
	private Button saveButton;				//this is the save button

	/**
	 * This is a getter for the alert label
	 * @return the alert label
	 */
	public Label getEditProfileAlert() {
		return editProfileAlert;
	}

	/**
	 * This is a getter for the edit username field
	 * @return the edit username field
	 */
	public TextField getEditUsernameField() {
		return editUsernameField;
	}

	/**
	 * This is a getter for the edit email field
	 * @return the edit email field
	 */
	public TextField getEditEmailField() {
		return editEmailField;
	}

	/**
	 * This is a getter for the edit password field
	 * @return the edit password field
	 */
	public TextField getEditPasswordField() {
		return editPasswordField;
	}

	/**
	 * This is a getter for the back button
	 * @return the back button
	 */
	public Button getBackButton() {
		return backButton;
	}

	/**
	 * This is a getter for the save button
	 * @return the save button
	 */
	public Button getSaveButton() {
		return saveButton;
	}

	/**
	 * This method sets up the Edit Profile Scene
	 * @return
	 */
	public Scene getEditProfileScene() {
		BorderPane root = new BorderPane();
		root.setStyle("-fx-background-color:edcbb8");
		root.setPadding(new Insets(20, 20, 20, 20));

		//sets up the header and center
		VBox headerContainer = getHeader();
		VBox centerContainer = getCenter();

		//adds header and center to the root
		root.setTop(headerContainer);
		root.setCenter(centerContainer);

		//adds root to the scene
		Scene scene = new Scene(root, 500, 500);
		return scene;
	}

	/**
	 * This is a helper method to set up the header
	 * @return the header
	 */
	private VBox getHeader() {
		//sets up a label for the title
		Label header = new Label("Edit Profile");
		header.setFont(new Font("Times New Roman", 26));

		//adds the label to the VBox
		VBox headerContainer = new VBox();
		headerContainer.setPadding(new Insets(20, 20, 20, 20));
		headerContainer.setAlignment(Pos.BASELINE_CENTER);
		headerContainer.getChildren().add(header);

		return headerContainer;
	}

	/**
	 * This is a helper method to set up the buttons
	 * @return the buttons
	 */
	private HBox getButtons() {
		//sets up back button
		backButton = new Button("Back");
		backButton.setPrefSize(100,20);
		backButton.setStyle("-fx-background-color: #dba49a; -fx-border-color: black; -fx-border-width: 1px;"
				+ "-fx-border-radius: 7px; -fx-background-radius: 7px;");
		backButton.setFont(Font.font("Times New Roman", 14));

		//sets up save button
		saveButton = new Button("Save");
		saveButton.setPrefSize(100,20);
		saveButton.setStyle("-fx-background-color: #dba49a; -fx-border-color: black; -fx-border-width: 1px;"
				+ "-fx-border-radius: 7px; -fx-background-radius: 7px;");
		saveButton.setFont(Font.font("Times New Roman", 14));

		//adds the buttons to a HBox
		HBox buttons = new HBox();
		buttons.getChildren().addAll(backButton, saveButton);
		buttons.setAlignment(Pos.BASELINE_CENTER);
		buttons.setSpacing(10);
		buttons.setPadding(new Insets(10, 10, 10, 10));

		return buttons;
	}

	/**
	 * This is a helper method to set up the username
	 * @return the username HBox
	 */
	private HBox getUser() {
		//sets up label to display username
		Label username = new Label("Username: ");
		username.setPadding(new Insets(10, 10, 0, 0));
		username.setFont(Font.font("Times New Roman", 14));

		//sets up text field to enter the username
		editUsernameField = new TextField();
		editUsernameField.setPromptText("Enter New Username");
		editUsernameField.setPadding(new Insets(10, 10, 10, 10));
		editUsernameField.setStyle("-fx-background-color: fcedde");

		//adds all username fields to a HBox
		HBox usernameContainer = new HBox();
		usernameContainer.getChildren().addAll(username, editUsernameField);
		usernameContainer.setAlignment(Pos.TOP_CENTER);

		return usernameContainer;
	}

	/**
	 * This is a helper method to set up the email
	 * @return the email HBox
	 */
	private HBox getEmail() {
		//sets up label to display email
		Label email = new Label("Email: ");
		email.setPadding(new Insets(10, 33, 0, 0));
		email.setFont(Font.font("Times New Roman", 14));

		//sets up text field to enter the email
		editEmailField = new TextField();
		editEmailField.setPromptText("Enter New Email");
		editEmailField.setPadding(new Insets(10, 10, 10, 10));
		editEmailField.setStyle("-fx-background-color: fcedde");

		//adds all email fields to a HBox
		HBox emailContainer = new HBox();
		emailContainer.getChildren().addAll(email, editEmailField);
		emailContainer.setAlignment(Pos.TOP_CENTER);

		return emailContainer;
	}

	/**
	 * This is a helper method to set up the password
	 * @return the password HBox
	 */
	private HBox getPass() {
		//sets up label to display password
		Label password = new Label("Password: ");
		password.setPadding(new Insets(10, 10, 0, 0));
		password.setFont(Font.font("Times New Roman", 14));

		//sets up text field to enter the password
		editPasswordField = new TextField();
		editPasswordField.setPromptText("Enter New Password");
		editPasswordField.setPadding(new Insets(10, 10, 10, 10));
		editPasswordField.setStyle("-fx-background-color: fcedde");

		//adds all password fields to a HBoxß
		HBox passwordContainer = new HBox();
		passwordContainer.getChildren().addAll(password, editPasswordField);
		passwordContainer.setAlignment(Pos.TOP_CENTER);

		return passwordContainer;
	}

	/**
	 * This is a helper method to set up the center
	 * @return the center
	 */
	private VBox getCenter() {
		//sets up VBox to set up center
		VBox centerContainer = new VBox();
		centerContainer.setPadding(new Insets(35, 0, 0, 0));
		centerContainer.setSpacing(10);
		centerContainer.setAlignment(Pos.TOP_CENTER);

		//sets up alert label
		editProfileAlert = new Label("");
		editProfileAlert.setFont(new Font("Times New Roman", 14));

		//sets up all the center components
		HBox usernameContainer = getUser();
		HBox emailContainer = getEmail();	
		HBox passwordContainer = getPass();
		HBox buttons = getButtons();

		//adds all values to the center VBox
		centerContainer.getChildren().addAll(usernameContainer, emailContainer, passwordContainer, editProfileAlert, buttons);

		return centerContainer;
	}

	/**
	 * This method handles the scene navigation of the back button
	 * @param primaryStage is the primary stage
	 * @param profile is the profile scene
	 */
	public void editProfileBack(Stage primaryStage, Scene profile) {
		getBackButton().setOnAction(e -> primaryStage.setScene(profile));
	}
}

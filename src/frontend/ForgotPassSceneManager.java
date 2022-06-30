package frontend;

import java.util.ArrayList;
import java.util.Scanner;

import backend.DataManager;
import backend.UserAccount;
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
 * This class creates the Forgot Password Page
 * @author Farah, James, Shota, and Andrei
 *
 */
public class ForgotPassSceneManager {
	private Label forgotPasswordAlert;	//this is the alert label
	private TextField searchUser;		//this is the username text field
	private TextField searchEmail;		//this is the email text field
	private TextField newPassword;		//this is the new password text field
	private Button cancel;				//this is the cancel
	private Button signInButton;		//this is the sign in button 
	
	/**
	 * This method gets the alert label
	 * @return the alert label
	 */
	public Label getForgotPasswordAlert() {
		return forgotPasswordAlert;
	}

	/**
	 * This method gets the username text field
	 * @return the username text field
	 */
	public TextField getSearchUser() {
		return searchUser;
	}

	/**
	 * This method gets the email text field
	 * @return the email text field
	 */
	public TextField getSearchEmail() {
		return searchEmail;
	}

	/**
	 * This method gets the new password text field
	 * @return the new password text field
	 */
	public TextField getNewPassword() {
		return newPassword;
	}

	/**
	 * This method gets the cancel button
	 * @return the cancel button
	 */
	public Button getCancel() {
		return cancel;
	}

	/**
	 * This method gets the sign in button
	 * @return the sign in button
	 */
	public Button getSignInButton() {
		return signInButton;
	}
	
	/**
	 * This method gets the forget password scene 
	 * @return the forget password scene
	 */
	public Scene getPassScene() {
		BorderPane root = new BorderPane();
		root.setStyle("-fx-background-color:edcbb8");
		
		//sets up all the components of the scene
		VBox topPanel = getTopPanel();
		HBox userName = getUser(); 
		HBox emailAddr = getEmail();
		HBox passWord = getPass();
		HBox buttons = getButtons();
		VBox center = getCenter(topPanel, userName, emailAddr, passWord, forgotPasswordAlert, buttons);		
		
		//added to the root
		root.setCenter(center);
		center.setAlignment(Pos.TOP_CENTER);

		//the root is added to the scene
		Scene scene = new Scene(root,500,500);
		return scene;
	}

	/**
	 * This gets the top panel
	 * @return the top panel
	 */
	private VBox getTopPanel() {
		//sets up title label
		Label title = new Label("$5 Dinner");
		title.setFont(new Font("Times New Roman", 26));
		title.setPadding(new Insets(0,0,15,0));

		//sets up description label
		Label description = new Label("Forgot your Password?");
		description.setFont(new Font("Times New Roman", 15));

		//sets up another description label
		Label description1 = new Label("Enter your username, email, and new password.");
		description1.setFont(new Font("Times New Roman", 15));
		
		//sets up alert label
		forgotPasswordAlert = new Label("");

		//adds all labels to a VBox
		VBox topPanel = new VBox();
		topPanel.getChildren().addAll(title, description, description1);
		topPanel.setAlignment(Pos.CENTER);
		topPanel.setPadding(new Insets(60,0,5,0));
		
		return topPanel;
	}
	
	/**
	 * This method gets the username fields
	 * @return the username fields 
	 */
	private HBox getUser() {
		//sets up username textfield
		searchUser = new TextField();
		searchUser.setPromptText("Enter Username");
		searchUser.setPadding(new Insets(10, 10, 10, 10));
		searchUser.setStyle("-fx-background-color:fcedde");
		
		//sets up username label
		Label userTxt = new Label("Username:         ");
		userTxt.setFont(new Font("Times New Roman", 14));
		userTxt.setPadding(new Insets(10, 10, 0, 0));
		
		//adds username label and textfield ot HBox
		HBox userName = new HBox();
		userName.getChildren().addAll(userTxt, searchUser);
		userName.setAlignment(Pos.TOP_CENTER);
		
		return userName;
	}
	
	/**
	 * This method gets the email fields
	 * @return the email fields 
	 */
	private HBox getEmail() {
		//sets up the email text field
		searchEmail = new TextField();
		searchEmail.setPromptText("Enter Email");
		searchEmail.setPadding(new Insets(10, 10, 10, 10));
		searchEmail.setStyle("-fx-background-color:fcedde");

		//sets up the email label
		Label emailTxt = new Label("Email:               ");
		emailTxt.setFont(new Font("Times New Roman", 14));
		emailTxt.setPadding(new Insets(10, 10, 0, 0));

		//adds email text field and label to a HBox
		HBox emailAddr = new HBox();
		emailAddr.getChildren().addAll(emailTxt, searchEmail);
		emailAddr.setAlignment(Pos.TOP_CENTER);
		
		return emailAddr;
	}
	
	/**
	 * This method gets the new password fields
	 * @return the new password fields 
	 */
	private HBox getPass() {
		//sets up new password text field
		newPassword = new TextField();
		newPassword.setPromptText("Enter Password");
		newPassword.setPadding(new Insets(10, 10, 10, 10));
		newPassword.setStyle("-fx-background-color:fcedde");

		//sets up new password label
		Label passTxt = new Label("New Password: ");
		passTxt.setFont(new Font("Times New Roman", 14));
		passTxt.setPadding(new Insets(10, 10, 0, 0));
		
		//adds text field and label to a HBox
		HBox passWord = new HBox();
		passWord.getChildren().addAll(passTxt, newPassword);
		passWord.setAlignment(Pos.TOP_CENTER);
		
		return passWord;
	}
	
	/**
	 * This method gets all the buttons
	 * @return the buttons
	 */
	private HBox getButtons() {
		//sets up the cancel button
		cancel = new Button("Cancel");
		cancel.setStyle("-fx-background-color: #dba49a; -fx-border-color: black; -fx-border-width: 1px;"
				+ "-fx-border-radius: 7px; -fx-background-radius: 7px;");
		cancel.setPadding(new Insets(7,20,7,20));

		//sets up the sign in button
		signInButton = new Button("Sign In");
		signInButton.setStyle("-fx-background-color: #dba49a; -fx-border-color: black; -fx-border-width: 1px;"
				+ "-fx-border-radius: 7px; -fx-background-radius: 7px;");
		signInButton.setPadding(new Insets(7,20,7,20));

		//adds all buttons to a HBox
		HBox buttons = new HBox();
		buttons.getChildren().addAll(cancel, signInButton);
		buttons.setAlignment(Pos.TOP_CENTER);
		buttons.setSpacing(10);
		
		return buttons;
	}
	
	/**
	 * This method gets the center of the page
	 * @param topPanel is the top panel
	 * @param userName is the username field 
	 * @param emailAddr is the email field
	 * @param passWord is the new password field
	 * @param forgotPasswordAlert is the alert label
	 * @param buttons is the button field
	 * @return the center of the page
	 */
	private VBox getCenter(VBox topPanel, HBox userName, HBox emailAddr, HBox passWord, Label forgotPasswordAlert, HBox buttons) {
		VBox center = new VBox();
		center.setSpacing(10);
		center.getChildren().addAll(topPanel, userName, emailAddr, passWord, forgotPasswordAlert, buttons);
		
		return center;
	}
	
	/**
	 * This method handles the cancel button actions
	 * @param primaryStage is the primary stage
	 * @param loginScene is the login scene
	 */
	public void forgotPassCancel(Stage primaryStage, Scene loginScene) {
		getCancel().setOnAction(e -> primaryStage.setScene(loginScene));
	}
	
	/**
	 * This method handles the sign in actions
	 * @param primaryStage is the primary stage
	 * @param dm is the data manager object
	 * @param username is the username
	 * @param email is the email
	 * @param password is the password
	 * @param userDB is the path to the DB with usernames
	 * @param sc is the Scanner
	 * @param UserAccounts is the ArrayList of UserAccount
	 * @param loginScene is the login scene
	 */
	public void forgotPassSignIn(Stage primaryStage, DataManager dm, String username, String email, String password, String userDB, Scanner sc, ArrayList<UserAccount> UserAccounts, Scene loginScene) {
		//checks to see if fields are filled
		if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
			getForgotPasswordAlert().setText("**Please fill out all text fields");
		}
		else {
			//checks validity of the fields
			if (dm.validateLoginInformation(username, password, email, userDB, UserAccounts)) {
				
				//edits the password
				dm.editPassword(username, email, password, userDB, sc);
				
				// Change user information in Array List as well
				for (UserAccount user: UserAccounts) {
					if (user.getUserName().equals(username) && user.getUserEmail().equals(email)) {
						user.setPassWord(password);
					}
				}
				
				// Clear information on scene before transition
				getSearchUser().clear(); getSearchEmail().clear(); getNewPassword().clear(); getForgotPasswordAlert().setText("");
				
				//changes the scene
				primaryStage.setScene(loginScene);
			}
			else {
				getForgotPasswordAlert().setText("**Account does not exist");
			}
		}
	}
}

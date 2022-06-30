package frontend;

import java.util.ArrayList;

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
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;

/**
 * This class creates the Login Page
 * @author Farah, James, Shota, and Andrei
 *
 */
public class LoginSceneManager {
	private TextField user;				//this is the username text field
	private TextField pass;				//this is the password text field
	private Label loginAlertLabel;		//this is the alert labe;
	private Button signIn;				//this is the sign in button
	private Button forgotPass;			//this is the forgot password button
	private Button createAcc;			//this is the create account button

	/**
	 * This is the getter method for the username text field
	 * @return the username text field
	 */
	public TextField getUser() {
		return user;
	}

	/**
	 * This is the getter method for the password text field
	 * @return the password text field
	 */
	public TextField getPass() {
		return pass;
	}

	/**
	 * This is the getter for the alert label
	 * @return the alert label
	 */
	public Label getLoginAlertLabel() {
		return loginAlertLabel;
	}

	/**
	 * This is the getter for the sign in button
	 * @return the sign in button
	 */
	public Button getSignIn() {
		return signIn;
	}

	/**
	 * This is the getter for the forgot password button
	 * @return the forgot password button
	 */
	public Button getForgotPass() {
		return forgotPass;
	}

	/**
	 * This is the getter for the create account button
	 * @return the create account button
	 */
	public Button getCreateAcc() {
		return createAcc;
	}

	/**
	 * This method sets the login page
	 * @return the login scene
	 */
	public Scene getLoginScene() {	
		BorderPane root = new BorderPane();
		root.setStyle("-fx-background-color:edcbb8");

		//sets up each component
		loginAlertLabel = setUpLoginAlert();
		signIn = setUpSignIn();
		VBox topPanel = setUpTopPanel();	
		HBox userName = setUpUsername();
		HBox passWord = setUpPassword();
		HBox buttons = setUpButtons();
		VBox center = setUpCenter(topPanel, userName, passWord, signIn, buttons, loginAlertLabel);

		//adds components to the root
		root.setCenter(center);
		center.setAlignment(Pos.TOP_CENTER);

		//adds root to scene
		Scene scene = new Scene(root,500,500);	
		return scene;
	}

	/**
	 * This method sets up the top panel
	 * @return the top panel
	 */
	private VBox setUpTopPanel() {
		//sets up title
		Label title = new Label("$5 Dinner");
		title.setFont(new Font("Times New Roman", 26));

		//sets up description
		Label description = new Label("An Affordable Meals Finder");
		Font font = Font.font("Times New Roman",FontPosture.ITALIC, 16);
		description.setFont(font);

		//adds labels to top panel
		VBox topPanel = new VBox();
		topPanel.getChildren().addAll(title, description);
		topPanel.setAlignment(Pos.CENTER);
		topPanel.setPadding(new Insets(60,0,5,0));

		return topPanel;
	}

	/**
	 * This method sets up the username fields
	 * @return the username fields
	 */
	private HBox setUpUsername() {
		//sets up username text field
		user = new TextField();
		user.setPromptText("Enter Username");
		user.setPadding(new Insets(10, 10, 10, 10));
		user.setStyle("-fx-background-color:fcedde");

		//sets up username label
		Label userTxt = new Label("Username: ");
		userTxt.setFont(new Font("Times New Roman", 14));
		userTxt.setPadding(new Insets(10, 10, 0, 0));

		//adds label and text field to a HBox
		HBox userName = new HBox();
		userName.getChildren().addAll(userTxt, user);
		userName.setAlignment(Pos.TOP_CENTER);

		return userName;
	}

	/**
	 * THhis method sets up the password fields
	 * @return the password fields
	 */
	private HBox setUpPassword() {
		//sets up the password text field
		pass = new TextField();
		pass.setPromptText("Enter Password");
		pass.setPadding(new Insets(10, 10, 10, 10));
		pass.setStyle("-fx-background-color:fcedde");

		//sets up the password label
		Label passTxt = new Label("Password: ");
		passTxt.setFont(new Font("Times New Roman", 14));
		passTxt.setPadding(new Insets(10, 10, 0, 0));

		//adds text field and a label to a HBox
		HBox passWord = new HBox();
		passWord.getChildren().addAll(passTxt, pass);
		passWord.setAlignment(Pos.TOP_CENTER);

		return passWord;
	}

	/**
	 * This method sets up the buttons
	 * @return the buttons
	 */
	private HBox setUpButtons() {
		//sets up forgot password button
		forgotPass = new Button("Forgot Password");
		forgotPass.setStyle("-fx-background-color: #dba49a; -fx-border-color: black; -fx-border-width: 1px;"
				+ "-fx-border-radius: 7px; -fx-background-radius: 7px;");
		forgotPass.setPadding(new Insets(7,20,7,20));

		//sets up create account button
		createAcc = new Button("Create Account");
		createAcc.setStyle("-fx-background-color: #dba49a; -fx-border-color: black; -fx-border-width: 1px;"
				+ "-fx-border-radius: 7px; -fx-background-radius: 7px;");
		createAcc.setPadding(new Insets(7,20,7,20));

		//adds buttons to a HBox
		HBox buttons = new HBox();
		buttons.getChildren().addAll(forgotPass, createAcc);
		buttons.setAlignment(Pos.TOP_CENTER);
		buttons.setSpacing(10);

		return buttons;
	}

	/**
	 * This method sets up the login alert label
	 * @return the login alert label
	 */
	private Label setUpLoginAlert() {
		loginAlertLabel = new Label("");
		loginAlertLabel.setFont(new Font("Times New Roman", 14));
		loginAlertLabel.setPadding(new Insets(10, 10, 0, 0));
		return loginAlertLabel;
	}

	/**
	 * This method sets up the sign in button
	 * @return the sign in button
	 */
	private Button setUpSignIn() {
		signIn = new Button("Sign In");
		signIn.setStyle("-fx-background-color: #dba49a; -fx-border-color: black; -fx-border-width: 1px;"
				+ "-fx-border-radius: 7px; -fx-background-radius: 7px;");
		signIn.setPadding(new Insets(6,30,6,30));
		return signIn;
	}

	/**
	 * This method sets up the center panel of the page
	 * @param topPanel is the top panel
	 * @param userName is the username fields
	 * @param passWord is the password fields
	 * @param signIn is the sign in button
	 * @param buttons are the other buttons
	 * @param loginAlertLabel is the login alert label
	 * @return
	 */
	private VBox setUpCenter(VBox topPanel, HBox userName,HBox passWord,Button signIn,HBox buttons,Label loginAlertLabel) {
		VBox center = new VBox();
		center.setSpacing(10);
		center.getChildren().addAll(topPanel, userName, passWord, signIn, buttons, loginAlertLabel);
		return center;
	}

	/**
	 * This method handles the scene changes for the create account button
	 * @param primaryStage is the primary stage
	 * @param createAccount is the create account scene
	 */
	public void createAcc(Stage primaryStage, Scene createAccount) {
		getCreateAcc().setOnAction(e -> primaryStage.setScene(createAccount));
	}

	/**
	 * This method handles the scene changes for the forgot password button
	 * @param primaryStage is the primary stage
	 * @param forgotPassword is the forgot password scene
	 */
	public void forgotPass(Stage primaryStage, Scene forgotPassword) {
		getForgotPass().setOnAction(e -> {

			// Clear information on scene before transition
			getUser().clear(); getPass().clear();
			getLoginAlertLabel().setText("");

			//sets the scene
			primaryStage.setScene(forgotPassword);
		});
	}

	/**
	 * This method handles the user input validation case and saves the user information
	 * @param primaryStage is the primary stage
	 * @param dm is the data manager object
	 * @param profilePage is the profile page object
	 * @param currentUser is the current username
	 * @param password is the password
	 * @param userDB is the path to the DB with user account information
	 * @param UserAccounts is the ArrayList of UserAccount
	 * @param recipesDB is the path to the recipes DB
	 * @param likedRecipesDB is the path to the liked recipes DB
	 * @param profile is the profile scene
	 */
	public void ifStatementsSignIn(Stage primaryStage, DataManager dm, ProfileSceneManager profilePage, String currentUser, String password, String userDB, ArrayList<UserAccount> UserAccounts, String recipesDB, String likedRecipesDB, Scene profile) {
		//check to see if informaiton is valid
		if (dm.validateLoginInformation(currentUser, password, userDB, UserAccounts)) {
			//scene change to the profile
			isValid(primaryStage, dm, profilePage, currentUser, userDB, recipesDB, likedRecipesDB, profile);
		}
		//checks to see if fields are empty
		else if(currentUser.isEmpty() || password.isEmpty()) {
			getLoginAlertLabel().setText("Please fill out all fields");
		}
		//wrong input information
		else {
			getLoginAlertLabel().setText("Incorrect username/password");
		}
	}

	/**
	 * This method is a helper method for the ifStatementsSignIn method and handles the case where the user needs to sign in
	 * @param primaryStage is the primary stage
	 * @param dm is the data manager object
	 * @param profilePage is the profile page object
	 * @param currentUser is the current username
	 * @param userDB is the path to the DB with user account information
	 * @param recipesDB is the path to the recipes DB
	 * @param likedRecipesDB is the path to the liked recipes DB
	 * @param profile is the profile scene
	 */
	private void isValid(Stage primaryStage, DataManager dm, ProfileSceneManager profilePage, String currentUser, String userDB, String recipesDB, String likedRecipesDB, Scene profile) {
		//sets username and email labels
		profilePage.getFullnameLbl().setText(currentUser);
		profilePage.getEmailLbl().setText(dm.getEmail(userDB, currentUser));

		//fills own recipe listview
		ArrayList<String> profilePosts = dm.getNamesOwnRecipes(currentUser, recipesDB);
		for(String n: profilePosts) {
			profilePage.getOwnRecipePosts().getItems().add(n);
		}

		//fills liked recipe listview
		profilePage.getLikedRecipePosts().getItems().clear();
		for (String recipe : dm.recipesLikedByUser(currentUser, likedRecipesDB)) {
			profilePage.getLikedRecipePosts().getItems().add(recipe);
		}

		//changes the scene to the profile
		primaryStage.setScene(profile);
	}
}

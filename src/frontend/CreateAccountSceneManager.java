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
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * This class creates the Create Account Page
 * @author Farah, James, Shota, and Andrei
 *
 */
public class CreateAccountSceneManager {
	private TextField usernameTxt;		//this is a text field for the username
	private TextField emailTxt;			//this is a text field for the email
	private TextField passwordTxt;		//this is a text field for the password
	private Button cancelBtn;			//this is the cancel button
	private Button createAcctBtn;		//this is the create account button
	private Label createAccAlertLabel;	//this is the alert label
	private Label title;				//this is the title label
	private Label explanation;			//this is the explanation label
	private Label direction;			//this is the direction label
	private Label usernameLbl;			//this is the username label
	private Label emailLbl;				//this is the email label
	private Label passwordLbl;			//this is the password label

	/**
	 * This is the getter for the username text field
	 * @return username text field
	 */
	public TextField getUsernameTxt() {
		return usernameTxt;
	}

	/**
	 * This is the getter for the email text field
	 * @return email text field
	 */
	public TextField getEmailTxt() {
		return emailTxt;
	}

	/**
	 * This is the getter for the password text field
	 * @return password text field
	 */
	public TextField getPasswordTxt() {
		return passwordTxt;
	}

	/**
	 * This is the getter for the cancel button
	 * @return cancel button
	 */
	public Button getCancelBtn() {
		return cancelBtn;
	}

	/**
	 * This is the getter for the create account button
	 * @return create account button
	 */
	public Button getCreateAcctBtn() {
		return createAcctBtn;
	}

	/**
	 * This is the getter for the alert label
	 * @return alert label
	 */
	public Label getCreateAccAlertLabel() {
		return createAccAlertLabel;
	}

	/**
	 * This method sets up the create account scene
	 * @return
	 */
	public Scene createAccountScene() {
		//sets up the page
		setUpLbl();
		setUpTF();
		setUpButtons();

		//adds all components to the root
		GridPane root = setUpGrid();

		//adds the root to the scene
		Scene scene = new Scene(root,500,500);
		return scene;
	}

	/**
	 * This method sets up the buttons
	 */
	private void setUpButtons() {
		//sets up cancel button
		cancelBtn = new Button("Cancel");
		cancelBtn.setFont(new Font("Times New Roman", 14));
		cancelBtn.setStyle("-fx-background-color: #dba49a; -fx-border-color: black; -fx-border-width: 1px;"
				+ "-fx-border-radius: 7px; -fx-background-radius: 7px;");

		//sets up create account button
		createAcctBtn = new Button("Create Account");
		createAcctBtn.setFont(new Font("Times New Roman", 14));
		createAcctBtn.setStyle("-fx-background-color: #dba49a; -fx-border-color: black; -fx-border-width: 1px;"
				+ "-fx-border-radius: 7px; -fx-background-radius: 7px;");
	}

	/**
	 * This method sets up the text fields
	 */
	private void setUpTF() {
		//sets up username text field
		usernameTxt = new TextField();
		usernameTxt.setPromptText("Enter Username");
		usernameTxt.setPrefColumnCount(10);
		usernameTxt.setStyle("-fx-background-color: fcedde");

		//sets up email text field
		emailTxt = new TextField();
		emailTxt.setPromptText("Enter Email");
		emailTxt.setPrefColumnCount(10);
		emailTxt.setStyle("-fx-background-color: fcedde");

		//sets up password text field
		passwordTxt = new TextField();
		passwordTxt.setPromptText("Enter Password");
		passwordTxt.setPrefColumnCount(10);
		passwordTxt.setStyle("-fx-background-color: fcedde");
	}

	/**
	 * This method sets up the labels
	 */
	private void setUpLbl() {
		//sets up the title label
		title = new Label("$5 Dinner");
		title.setFont(new Font("Times New Roman", 26));
		title.setPadding(new Insets(10,10,10,150));

		//sets up the explanation label
		explanation = new Label("Create an Account");
		explanation.setFont(new Font("Times New Roman", 14));

		//sets up the direction label
		direction = new Label("Enter your the following information below");
		direction.setFont(new Font("Times New Roman", 14));

		//sets up the username label
		usernameLbl = new Label("Username: ");
		usernameLbl.setFont(new Font("Times New Roman", 14));

		//sets up the email label
		emailLbl = new Label("Email: ");
		emailLbl.setFont(new Font("Times New Roman", 14));

		//sets up the password label
		passwordLbl = new Label("Password: ");
		passwordLbl.setFont(new Font("Times New Roman", 14));

		//sets up the alert label
		createAccAlertLabel = new Label();
		createAccAlertLabel.setFont(new Font("Times New Roman", 14));
	}

	/**
	 * This method adds all components to a GridPane
	 * @return a Grid with all components
	 */
	private GridPane setUpGrid() {
		//sets up grid
		GridPane root = new GridPane();
		root.setStyle("-fx-background-color: edcbb8");
		root.setPadding(new Insets(-120, 0, 0, 0));
		root.setVgap(7);
		root.setAlignment(Pos.CENTER);

		//adds all components to the grid
		root.add(title,0,0);
		root.add(explanation,0,1);
		root.add(direction,0,2);
		root.add(usernameLbl,0,4);
		root.add(usernameTxt,1,4);
		root.add(emailLbl,0,5);
		root.add(emailTxt,1,5);
		root.add(passwordLbl,0,6);
		root.add(passwordTxt,1,6);
		root.add(cancelBtn,0,7);
		root.add(createAcctBtn,1,7);
		root.add(createAccAlertLabel, 0, 8);

		return root;
	}

	/**
	 * This method handles the actions for the cancel button
	 * @param primaryStage is the primary stage
	 * @param loginScene is the login scene
	 */
	public void createAccountCancel(Stage primaryStage, Scene loginScene) {
		getCancelBtn().setOnAction(e -> primaryStage.setScene(loginScene));
	}

	/**
	 * This method handles the actions for the create account button
	 * @param primaryStage is the primary stage
	 * @param dm is the data manager object
	 * @param loginScene is the login scene
	 * @param userDB is the path to the DB with user accounts
	 * @param UserAccounts is the ArrayList of UserAccount objects
	 */
	public void createAccountCreate(Stage primaryStage, DataManager dm, Scene loginScene, String userDB, ArrayList<UserAccount> UserAccounts) {
		getCreateAcctBtn().setOnAction(e -> {
			//checks to see if text fields are filled
			if (getUsernameTxt().getText().isEmpty() || getEmailTxt().getText().isEmpty() || getPasswordTxt().getText().isEmpty()) {
				getCreateAccAlertLabel().setText("**Please fill out all text fields");
			} 
			//prevents duplicate usernames
			else if(dm.noDuplicateUsers(getUsernameTxt().getText(), userDB)) {
				getCreateAccAlertLabel().setText("**Username already exists. Please pick a new one.");
			}
			else {
				//saves user account information
				dm.saveUserAccount(getUsernameTxt().getText(), getEmailTxt().getText(), getPasswordTxt().getText(), userDB, UserAccounts);

				// Clear information on scene before transition
				getUsernameTxt().clear(); getEmailTxt().clear(); getPasswordTxt().clear(); getCreateAccAlertLabel().setText("");

				//sets scene to login
				primaryStage.setScene(loginScene);
			}
		});
	}
}

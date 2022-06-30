package application;

import java.util.ArrayList;
import java.util.Scanner;

import backend.DataManager;
import backend.Recipe;
import backend.UserAccount;
import frontend.CreateAccountSceneManager;
import frontend.CreatePostSceneManager;
import frontend.EditProfileSceneManager;
import frontend.ForgotPassSceneManager;
import frontend.LoginSceneManager;
import frontend.ProfileSceneManager;
import frontend.RecipeViewSceneManager;
import frontend.SearchPostSceneManager;
import frontend.SearchResultsSceneManager;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This class handles the functionality of the entire program
 * @author Farah, James, Shota, and Andrei
 *
 */
public class Runner  {

	//Instance Variables for the Scenes
	private Scene loginScene;		
	private Scene forgotPassword;	
	private Scene profile;
	private Scene editProfile;
	private Scene createPost;
	private Scene search;
	private Scene viewResults;
	private Scene createAccount;	
	private Scene viewRecipe;

	//Lists of Recipe and UserAccounts
	private ArrayList<UserAccount> UserAccounts;	
	private ArrayList<Recipe> Recipes;

	//Paths of the DBs
	private String userDB;
	private String recipesDB; 
	private String searchResultsDB;
	private String likedRecipesDB;

	//An object for each scene
	private LoginSceneManager login;
	private ForgotPassSceneManager forgotPass;
	private CreateAccountSceneManager createAcc;
	private ProfileSceneManager profilePage;
	private EditProfileSceneManager editProfilePage;
	private CreatePostSceneManager createPostPage;
	private SearchPostSceneManager searchPostPage;
	private SearchResultsSceneManager searchResultsPage;
	private RecipeViewSceneManager recipeViewPage;

	//other
	private String chosenRecipeName;	
	private String currentUser;
	private String oldUser;
	private int count;
	private boolean changed;
	private Scanner sc;

	/**
	 * This is the constructor for the runner class and calls the appropriate methods to initialize my instance variables
	 */
	public Runner() {
		count = 0;
		Recipes = new ArrayList<>();
		UserAccounts = new ArrayList<>();

		//helper methods, allows me to initialize instance variables
		initializeDBPaths();
		initializeClasses();
		initializeScenes();
	}

	/**
	 * Helper method for the constructor
	 * Initializes the scenes
	 */
	private void initializeScenes() {
		loginScene = getLoginScene();				
		forgotPassword = getPassScene();
		createAccount = createAccountScene();
		editProfile = getEditProfileScene();
		createPost = getCreatePostScene();
		search = getSearchRecipeScene();
		profile = getProfileScene();
		viewResults = getSearchResultsScene();
		viewRecipe = getRecipeViewScene();
	}

	/**
	 * Helper method for the constructor
	 * Initializes my class objects
	 */
	private void initializeClasses() {
		login = new LoginSceneManager();
		forgotPass = new ForgotPassSceneManager();
		createAcc = new CreateAccountSceneManager();
		profilePage = new ProfileSceneManager();
		editProfilePage = new EditProfileSceneManager();
		createPostPage = new CreatePostSceneManager();
		searchPostPage = new SearchPostSceneManager();
		searchResultsPage = new SearchResultsSceneManager();
		recipeViewPage = new RecipeViewSceneManager();
	}

	/**
	 * Helper method for my constructor
	 * Initializes the path for the flat file DBs
	 */
	private void initializeDBPaths() {
		userDB = "src/UserAccounts.txt";
		recipesDB = "src/Recipes.txt"; 
		searchResultsDB = "src/SearchResults.txt";
		likedRecipesDB = "src/likedRecipes.txt";
	}

	/**
	 * This method sets the login page
	 * @return the login scene
	 */
	public Scene getLoginScene() {
		return login.getLoginScene();
	}

	/**
	 * This method sets the forgot password page
	 * @return the forgot password scene
	 */
	public Scene getPassScene() {
		return forgotPass.getPassScene();
	}

	/**
	 * This method sets the create account page
	 * @return the create account scene
	 */
	public Scene createAccountScene() {
		return createAcc.createAccountScene();
	}

	/**
	 * This method sets up the Profile page
	 * @return the profile scene
	 */
	public Scene getProfileScene() {
		return profilePage.getProfileScene();
	}

	/**
	 * This method sets up the edit profile page 
	 * @return the edit profile scene
	 */
	public Scene getEditProfileScene() {
		return editProfilePage.getEditProfileScene();
	}

	/**
	 * This method sets up the create post page
	 * @return the create post scene
	 */
	public Scene getCreatePostScene() {
		return createPostPage.getCreatePostScene();
	}

	/**
	 * This method sets up the search recipes page
	 * @return the search recipes scene
	 */
	public Scene getSearchRecipeScene() {
		return searchPostPage.getSearchRecipeScene();
	}

	/**
	 * This method sets up the search results page
	 * @return the search results scene
	 */
	public Scene getSearchResultsScene() {
		return searchResultsPage.getSearchResultsScene();
	}

	/**
	 * This method sets up the recipe view page
	 * @return the recipe view scene
	 */
	public Scene getRecipeViewScene() {
		return recipeViewPage.getRecipeViewScene();
	}

	/**
	 * This method finds the recipe in the ArrayList of recipes
	 * @param recipeName is the name of the recipe
	 * @return the recipe if it is found
	 */
	private Recipe findRecipe(String recipeName) {	
		//traverse through recipes
		for (Recipe recipe : Recipes) {
			//search for recipe
			if (recipe.getRecipeName().equals(recipeName)) {
				return recipe;
			}
		}
		return null;
	}

	/**
	 * This method allows me to replace new lines in a the recipeInstructions input.
	 * @return the new String
	 */
	private String removeNewLines(String text) {
		String newText = "";
		//checks to see if input text has a new line
		if(text.contains("\n")) {
			//traverse through text
			for(int i=0; i<text.length(); i++) {
				String currentChar = text.substring(i, i+1);
				//checks to see if there is a new line
				if(!currentChar.equals("\n")) {
					newText = newText + currentChar;
				}
				else { //removes new line
					newText = newText + " NEWLINE ";
				}
			}
		}
		else {
			newText = text;
		}

		return newText;
	}

	/**
	 * This method handles the login scene navigation
	 * @param primaryStage is the primary stage
	 * @param dm is the data manager object
	 */
	private void loginSceneNav(Stage primaryStage, DataManager dm) {
		//sign in button action
		login.getSignIn().setOnAction(e -> {		
			//modify instance variables
			currentUser = login.getUser().getText();
			oldUser = login.getUser().getText();
			String password = login.getPass().getText();
			changed = false;

			//handles the user input validarion and scene changes if necessary
			login.ifStatementsSignIn(primaryStage, dm, profilePage, currentUser, password, userDB, UserAccounts, recipesDB, likedRecipesDB, profile);
		});

		//handles scene changes for the forgot password and create account buttons
		login.forgotPass(primaryStage, forgotPassword);
		login.createAcc(primaryStage, createAccount);
	}

	/**
	 * This method handles the forgot password scene navigation
	 * @param primaryStage is the primary stage
	 * @param dm is the data manager object
	 */
	private void forgotPassNav(Stage primaryStage, DataManager dm) {
		//sign in button action
		forgotPass.getSignInButton().setOnAction(e -> {	
			//store current values
			String username = forgotPass.getSearchUser().getText();
			String email = forgotPass.getSearchEmail().getText();
			String password = forgotPass.getNewPassword().getText();

			//handles user input validation, backend handling, and scene changes if needed
			forgotPass.forgotPassSignIn(primaryStage, dm, username, email, password, userDB, sc, UserAccounts, loginScene);
		});

		//handles scene changes for the cancel button
		forgotPass.forgotPassCancel(primaryStage, loginScene);
	}

	/**
	 * This handles the create account scene navigation
	 * @param primaryStage is the primary stage
	 * @param dm is the data manager object
	 */
	private void createAccNav(Stage primaryStage, DataManager dm) {
		//handles scene changes for the cancel and create account buttons
		createAcc.createAccountCancel(primaryStage, loginScene);
		createAcc.createAccountCreate(primaryStage, dm, loginScene, userDB, UserAccounts);
	}

	/**
	 * This method handles the scene navigation for the profile page
	 * @param primaryStage is the primary stage
	 */
	private void profileNav(Stage primaryStage) {
		//handles scene changes to the edit profile, create post, and search recipe pages
		profilePage.profileSceneNav(primaryStage, editProfile, createPost, search);
	}

	/**
	 * This method handles the edit profile scene navigation
	 * @param primaryStage is the primary stage
	 * @param dm is the data manager object
	 */
	private void editProfileNav(Stage primaryStage, DataManager dm) {
		//scene changes for the back and save buttons
		editProfilePage.editProfileBack(primaryStage, profile);
		editProfilePage.getSaveButton().setOnAction(e -> {		
			if (editProfilePage.getEditUsernameField().getText().isEmpty() && editProfilePage.getEditEmailField().getText().isEmpty() && editProfilePage.getEditPasswordField().getText().isEmpty()) {

				editProfilePage.getEditProfileAlert().setText("**Please fill out at least one text field");
			}
			else {
				//allows me to save the current profile info
				saveEditProfile(primaryStage, dm);
			}
		});
	}
	
	/**
	 * This method is a helper method to save the profile information
	 * @param primaryStage is the primary stage
	 * @param dm is the data manager object
	 */
	private void saveEditProfile(Stage primaryStage, DataManager dm) {
		String tempEmail = dm.getEmail(userDB, currentUser);
		//edits flat file DBs
		dm.editProfile(currentUser, tempEmail, editProfilePage.getEditUsernameField().getText(), editProfilePage.getEditPasswordField().getText(), editProfilePage.getEditEmailField().getText(), userDB, sc);

		//changes value of currentUser if the username was changed
		if(!(editProfilePage.getEditUsernameField().getText().equals(""))) {
			currentUser = editProfilePage.getEditUsernameField().getText();
			changed = true;
		}
		
		//changes labels indicating email and username
		profilePage.getEmailLbl().setText(dm.getEmail(userDB, currentUser));
		profilePage.getFullnameLbl().setText(currentUser);

		//edits the flat file DBs if the username was changed
		dm.changedUser(oldUser, currentUser, changed, recipesDB, sc);
		dm.changedUser(oldUser, currentUser, changed, likedRecipesDB, sc);
		oldUser = currentUser;
		changed = false;

		// Clear information on scene before transition
		editProfilePage.getEditUsernameField().clear(); editProfilePage.getEditEmailField().clear(); editProfilePage.getEditPasswordField().clear(); editProfilePage.getEditProfileAlert().setText("");
		primaryStage.setScene(profile);
	}

	/**
	 * This method handles the create post button
	 * @param primaryStage is the primart stage
	 * @param dm is the data manager object
	 */
	private void createPostPostButton(Stage primaryStage, DataManager dm) {
		createPostPage.getPostButton().setOnAction(e -> {
			
			//stores current information
			String recipeName = createPostPage.getRecipeNameField().getText();
			String recipeInstructions = createPostPage.getRecipeInstructionsTextArea().getText();
			String priceRanges = createPostPage.getPriceMenu().getValue();
			ArrayList<String> tags = new ArrayList<>();
			String newText = removeNewLines(createPostPage.getRecipeInstructionsTextArea().getText());
			
			//handles creating the post
			createPostPage.createPostButton(primaryStage, dm, recipeName, recipeInstructions, priceRanges, tags, currentUser, newText, profilePage, Recipes,
					recipesDB, likedRecipesDB, profile);
		});
	}

	/**
	 * This method handles the create post scene navigation
	 * @param primaryStage is the primary stage
	 * @param dm is the data manager object
	 */
	private void createPostNav(Stage primaryStage, DataManager dm) {
		//handles post and back buttons
		createPostPage.createPostBack(primaryStage, profile);
		createPostPostButton(primaryStage, dm);
	}

	/**
	 * This method handles the search post scene navigation
	 * @param primaryStage is the primary stage
	 * @param dm is the data manager object
	 */
	private void searchPostNav(Stage primaryStage, DataManager dm) {
		//this handles the back and search buttons
		searchPostPage.backButtonNav(primaryStage, profile);
		searchPostPage.searchButtonNav(primaryStage, dm, searchResultsDB, recipesDB, searchResultsPage, sc, viewResults);
	}

	/**
	 * This method handles the search view navigation
	 * @param primaryStage is the primary stage
	 * @param dm is the data manager object
	 */
	private void searchViewNav(Stage primaryStage, DataManager dm) {
		//back button actions
		searchResultsPage.getSearchBackBtn().setOnAction(e -> {
			//clear all necessary fields
			dm.clearFile(searchResultsDB, sc);
			searchResultsPage.getRecipeList().getItems().clear();	
			profilePage.getLikedRecipePosts().getItems().clear();
			
			//add recipes to the liked recipe view on profile
			for (String recipe : dm.recipesLikedByUser(currentUser, likedRecipesDB)) {
				profilePage.getLikedRecipePosts().getItems().add(recipe);
			}
			primaryStage.setScene(profile);
		});

		//submit button actions
		searchResultsPage.getSubmitBtn().setOnAction(e -> {	
			//fill page view
			chosenRecipeName = searchResultsPage.getRecipeList().getSelectionModel().getSelectedItem();	
			if(chosenRecipeName!=null) {
				searchResultsPage.getAlertLabel().setText("");
				recipeViewPage.fillRecipeScene(findRecipe(chosenRecipeName));
				primaryStage.setScene(viewRecipe);
			}
			else {
				searchResultsPage.getAlertLabel().setText("***Select a Recipe");
			}
		});
	}

	/**
	 * This method handles the recipe view navigation
	 * @param primaryStage is the primary stage
	 * @param dm is the data manager object
	 */
	private void recipeViewNav(Stage primaryStage, DataManager dm) {
		//the back button action
		recipeViewPage.getViewRecipeBackBtn().setOnAction(e -> {
			primaryStage.setScene(viewResults);
			//clear fields
			recipeViewPage.getAlertLabel().setText("");
			recipeViewPage.getTagPane().getChildren().clear();
			count = 0;
		});

		//like button actions
		recipeViewPage.getLikeBtn().setOnAction(e -> {
			if(count==0) {
				//no duplicate liked recipes
				if(dm.noDuplicateRecipeNames(chosenRecipeName, likedRecipesDB)) {
					recipeViewPage.getAlertLabel().setText("**Already Liked Recipe");
				}
				else {
					//saves liked recipe
					dm.addLikedRecipe(currentUser, chosenRecipeName, likedRecipesDB);
					recipeViewPage.getAlertLabel().setText("**Liked Recipe");
				}
			}
			count++;
		});
	}

	/**
	 * This method runs each scene change and allows me to run the entire program
	 * @param primaryStage is the primary stage
	 */
	public void start(Stage primaryStage) {
		try {
			//clears file and allows me to start program
			DataManager dm = new DataManager();
			dm.clearFile(searchResultsDB, sc);
			dm.populateRecipesList(recipesDB, Recipes);

			//scene navigation handlers
			loginSceneNav(primaryStage, dm);
			forgotPassNav(primaryStage, dm);
			createAccNav(primaryStage, dm);
			profileNav(primaryStage);
			editProfileNav(primaryStage, dm);
			createPostNav(primaryStage, dm);
			searchPostNav(primaryStage, dm);
			searchViewNav(primaryStage, dm);
			recipeViewNav(primaryStage, dm);

			//starts program with the login scene
			primaryStage.setScene(loginScene);
			primaryStage.setTitle("$5 Dinner");
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
package frontend;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * This sets up the Profile page
 * @author Farah, James, Shota, and Andrei
 *
 */
public class ProfileSceneManager {
	private Label fullnameLbl;					//this is the label displaying the username
	private Label emailLbl;						//this is the label displaying the email
	private ListView<String> ownRecipePosts; 	//this is a listview of own recipes
	private ListView<String> likedRecipePosts;  //this is a listview of liked recipes
	private Button editPrflBtn;					//this is the edit profile button
	private Button createPostBtn;				//this is the create post button
	private Button searchRecipeBtn;				//this is the search recipe button
	
	/**
	 * This method gets the username
	 * @return the username
	 */
	public Label getFullnameLbl() {
		return fullnameLbl;
	}

	/**
	 * This method gets the email
	 * @return the email
	 */
	public Label getEmailLbl() {
		return emailLbl;
	}

	/**
	 * This method gets the edit profile button
	 * @return the edit profile button
	 */
	public Button getEditPrflBtn() {
		return editPrflBtn;
	}

	/**
	 * This method gets the listview of own recipes
	 * @return the listview of own recipes
	 */
	public ListView<String> getOwnRecipePosts() {
		return ownRecipePosts;
	}

	/**
	 * This method gets the listview of liked recipes
	 * @return the listview of liked recipes
	 */
	public ListView<String> getLikedRecipePosts() {
		return likedRecipePosts;
	}

	/**
	 * This method gets the create post button
	 * @return the create post button
	 */
	public Button getCreatePostBtn() {
		return createPostBtn;
	}

	/**
	 * This method gets the search recipe button
	 * @return the search recipe button
	 */
	public Button getSearchRecipeBtn() {
		return searchRecipeBtn;
	}
	
	/**
	 * This method sets up the Profile page
	 * @return the profile scene
	 */
	public Scene getProfileScene() {
		BorderPane root = new BorderPane();
		root.setStyle("-fx-background-color:edcbb8");
		root.setPadding(new Insets(20, 20, 20, 20));
		
		//sets up header
		VBox headerContainer = setUpHeader();	
		
		//sets up center with profile info and post views
		VBox centerContainer = new VBox();
		AnchorPane profileInformationSection = setUpProfileInfo();
		HBox viewRecipePostsSection = setUpViewPosts();
		centerContainer.getChildren().addAll(profileInformationSection, viewRecipePostsSection);
	
		//sets up buttons
		HBox buttons = setUpButtons();
		
		//adds all components to root
		root.setTop(headerContainer);
		root.setCenter(centerContainer);
		root.setBottom(buttons);
		
		//adds root to scene
		Scene scene = new Scene(root,500,500);
		return scene;
	}
	
	/**
	 * This method sets up the header
	 * @return the header
	 */
	private VBox setUpHeader() {
		//sets up the title
		Label header = new Label("Profile");
		header.setFont(new Font("Times New Roman", 26));
		
		//sets up a VBox with the title
		VBox headerContainer = new VBox();
		headerContainer.setPadding(new Insets(20, 20, 20, 20));
		headerContainer.setAlignment(Pos.BASELINE_CENTER);
		headerContainer.getChildren().add(header);
		
		return headerContainer;
	}
	
	/**
	 * This method sets up the name and email labels
	 * @return the name and email labels
	 */
	private VBox setUpNameAndEmail() {
		//sets up VBox to hold labels
		VBox nameAndEmailContainer = new VBox();
		nameAndEmailContainer.setPadding(new Insets(10, 10, 10, 10));
		
		//sets up username label
		fullnameLbl = new Label();
		fullnameLbl.setFont(new Font("Times New Roman", 14));
		
		//sets up email label
		emailLbl = new Label();
		emailLbl.setFont(new Font("Times New Roman", 14));
		
		//adds labels to VBox
		nameAndEmailContainer.getChildren().addAll(fullnameLbl, emailLbl);
		
		return nameAndEmailContainer;
	}
	
	/**
	 * This method sets up the edit profile button
	 * @return the edit profile button
	 */
	private HBox setUpEditPrflBtnContainer() {
		//sets up HBox to hold the button
		HBox editPrflBtnContainer = new HBox();
		editPrflBtnContainer.setPadding(new Insets(10, 10, 10, 10));
		
		//sets up button
		editPrflBtn = new Button("Edit Profile");
		editPrflBtn.setFont(new Font("Times New Roman", 14));
		editPrflBtn.setStyle("-fx-background-color: #dba49a; -fx-border-color: black; -fx-border-width: 1px;"
				+ "-fx-border-radius: 7px; -fx-background-radius: 7px;");
		
		//adds button to HBox
		editPrflBtnContainer.getChildren().addAll(editPrflBtn);
		
		return editPrflBtnContainer;
	}
	
	/**
	 * This method sets up the profile information
	 * @return the profile information
	 */
	private AnchorPane setUpProfileInfo() {
		//sets up AnchorPane to hold the profile information
		AnchorPane profileInformationSection = new AnchorPane();
		
		//sets up username, email, and edit profile button
		VBox nameAndEmailContainer = setUpNameAndEmail();
		HBox editPrflBtnContainer = setUpEditPrflBtnContainer();
		
		//added components
		AnchorPane.setLeftAnchor(nameAndEmailContainer, 0.0);
		AnchorPane.setRightAnchor(editPrflBtnContainer, 0.0);
		profileInformationSection.getChildren().addAll(nameAndEmailContainer, editPrflBtnContainer);
		
		return profileInformationSection;
	}
	
	/**
	 * This method sets up the view posts section
	 * @return the view posts section
	 */
	private HBox setUpViewPosts() {
		//sets up new HBox to hold the posts
		HBox viewRecipePostsSection = new HBox();
		
		//sets up VBox for own posts component
		VBox ownPostsContainer = new VBox();
		ownPostsContainer.setPadding(new Insets(10, 10, 10, 10));
		Label ownRecipeLbl = new Label("View List of Own Recipe Posts");
		ownRecipeLbl.setFont(new Font("Times New Roman", 14));
		ownRecipePosts = new ListView<>();
		ownRecipePosts.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		ownPostsContainer.getChildren().addAll(ownRecipeLbl, ownRecipePosts);
		
		//sets up HBox for liked posts component
		VBox likedPostsContainer = new VBox();
		likedPostsContainer.setPadding(new Insets(10, 10, 10, 10));
		Label likedRecipeLbl = new Label("View List of Liked Recipes");
		likedRecipeLbl.setFont(new Font("Times New Roman", 14));
		likedRecipePosts = new ListView<>();
		likedRecipePosts.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		likedPostsContainer.getChildren().addAll(likedRecipeLbl, likedRecipePosts);
		
		//add all post components to the HBox
		viewRecipePostsSection.getChildren().addAll(ownPostsContainer, likedPostsContainer);
		
		return viewRecipePostsSection;
	}
	
	/**
	 * This method sets up the buttons
	 * @return the buttons HBox
	 */
	private HBox setUpButtons() {
		//sets up the create post button
		createPostBtn = new Button("Create a Post");
		createPostBtn.setFont(new Font("Times New Roman", 14));
		createPostBtn.setStyle("-fx-background-color: #dba49a; -fx-border-color: black; -fx-border-width: 1px;"
				+ "-fx-border-radius: 7px; -fx-background-radius: 7px;");
		
		//sets up the search recipe button
		searchRecipeBtn = new Button("Search for Recipes");
		searchRecipeBtn.setFont(new Font("Times New Roman", 14));
		searchRecipeBtn.setStyle("-fx-background-color: #dba49a; -fx-border-color: black; -fx-border-width: 1px;"
				+ "-fx-border-radius: 7px; -fx-background-radius: 7px;");
		
		//adds buttons to HBox
		HBox buttons = new HBox();
		buttons.getChildren().addAll(createPostBtn, searchRecipeBtn);
		buttons.setAlignment(Pos.BASELINE_CENTER);
		buttons.setSpacing(10);
		buttons.setPadding(new Insets(10, 10, 10, 10));
		
		return buttons;
	}
	
	/**
	 * This method handles the scene changes for the profile scene
	 * @param primaryStage is the primary stage
	 * @param editProfile is the edit profile scene 
	 * @param createPost is the create post scene 
	 * @param search is the search recipe scene
	 */
	public void profileSceneNav(Stage primaryStage, Scene editProfile, Scene createPost, Scene search){
		//handles scene changes for the edit profile, create post, and search recipe buttons
		getEditPrflBtn().setOnAction(e -> primaryStage.setScene(editProfile));
		getCreatePostBtn().setOnAction(e -> primaryStage.setScene(createPost));
		getSearchRecipeBtn().setOnAction(e -> primaryStage.setScene(search));
	}
}

package backend;

import java.util.*;

/**
 * This class handles and controls the User Accounts
 * @author Farah, James, Shota, and Andrei
 *
 */
public class UserAccount {
	private String userName;	//holds the username
	private String userEmail;	//holds the emails
	private String passWord;	//holds the passwords
	private ArrayList<Recipe> postedRecipes;	//holds the recipes posted
	private ArrayList<Recipe> likedRecipes;		//holds the liked recipes
	
	/**
	 * This initializes the user account objects
	 * @param userName is the username
	 * @param userEmail is the email
	 * @param passWord is the password
	 */
	public UserAccount(String userName, String userEmail, String passWord) {
		this.userName = userName;
		this.userEmail = userEmail;
		this.passWord = passWord;
	}
	
	/**
	 * This is a getter method for the username
	 * @return the username
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * This is a getter method for the email
	 * @return the email
	 */
	public String getUserEmail() {
		return userEmail;
	}
	
	/**
	 * This is the getter method for the password
	 * @return the password
	 */
	public String getPassWord() {
		return passWord;
	}
	
	/**
	 * This is a getter method for the posted recipes
	 * @return the posted recipes
	 */
	public ArrayList<Recipe> getPostedRecipes(){
		return postedRecipes;
	}
	
	/**
	 * This is a getter method for the liked recipes
	 * @return the liked recipes
	 */
	public ArrayList<Recipe> getLikedRecipes(){
		return likedRecipes;
	}
	
	/**
	 * This is a setter method for the username
	 * @param newUserName is the new username
	 */
	public void setUserName(String newUserName) {
		userName = newUserName;
	}
	
	/**
	 * This is a setter method for the email
	 * @param newUserEmail is the new email
	 */
	public void setUserEmail(String newUserEmail) {
		userEmail = newUserEmail;
	}
	
	/**
	 * This is a setter method for the password
	 * @param newPassWord is the new password
	 */
	public void setPassWord(String newPassWord) {
		passWord = newPassWord;
	}
	
	/**
	 * This adds a recipe to the list of posted recipes
	 * @param post is the new recipe
	 */
	public void addPostedRecipe(Recipe post) {
		postedRecipes.add(post);
	}
	
	/**
	 * This adds a recipe to the list of liked recipes
	 * @param post is the new recipe
	 */
	public void addPostedLiked(Recipe post) {
		likedRecipes.add(post);
	}
}

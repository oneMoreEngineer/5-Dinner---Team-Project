package backend;

import java.util.*;

/**
 * This represents Recipe objects 
 * @author Farah, James, Shota, and Andrei
 *
 */
public class Recipe {
	private String priceRange;			//represents the price range
	private ArrayList<String> tags;		//represents the list of tags
	private String recipeName;			//represents the recipe name
	private String recipeIngredients;	//holds the recipe ingredients
	private String recipeInstructions;	//holds the recipe instructions
	
	/**
	 * Instantiates Recipe objects
	 * @param priceRange is the price range
	 * @param tags are the tags
	 * @param recipeName is the recipe name
	 * @param recipeIngredients is the ingredients
	 * @param recipeInstructions is the instructions
	 */
	public Recipe(String priceRange, ArrayList<String> tags, String recipeName, String recipeIngredients, String recipeInstructions) {
		this.priceRange = priceRange;
		this.tags = tags;
		this.recipeName = recipeName;
		this.recipeIngredients = recipeIngredients;
		this.recipeInstructions = recipeInstructions;
	}
	
	/**
	 * This is a getter method for the price range
	 * @return the price range
	 */
	public String getPriceRange() {
		return priceRange;
	}
	
	/**
	 * This is a getter method for the tags
	 * @return the tags
	 */
	public ArrayList<String> getTags(){
		return tags;
	}

	/**
	 * This is a getter method for the recipe name
	 * @return the recipe name
	 */
	public String getRecipeName() {
		return recipeName;
	}
	
	/**
	 * This is a getter method for the recipe ingredients
	 * @return the recipe ingredients
	 */
	public String getRecipeIngredients() {
		return recipeIngredients;
	}
	
	/**
	 * This is a getter method for the recipe instructions
	 * @return the recipe instructions
	 */
	public String getRecipeInstructions() {
		return recipeInstructions;
	}
	
	/**
	 * This is a setter method for the price range
	 * @param newPriceRange is the new price range
	 */
	public void setPriceRange(String newPriceRange) {
		priceRange = newPriceRange;
	}
	
	/**
	 * This adds a new tag
	 * @param newTags is the new tag
	 */
	public void setTags(String newTags) {
		tags.add(newTags);
	}
	
	/**
	 * This is a setter method for the recipe name
	 * @param newRecipeName is the new recipe name
	 */
	public void setRecipeName(String newRecipeName) {
		recipeName = newRecipeName;
	}
	
	/**
	 * This is a setter method for the ingredients
	 * @param newRecipeIngredients are the new ingredients
	 */
	public void setRecipeIngredients(String newRecipeIngredients) {
		recipeIngredients = newRecipeIngredients;
	}
	
	/**
	 * This is a setter method for the instructions
	 * @param newRecipeInstructions are the new instructions
	 */
	public void setRecipeInstructions(String newRecipeInstructions) {
		recipeInstructions = newRecipeInstructions;
	}
}

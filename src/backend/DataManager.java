package backend;

import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
/**
 * This class handles the data management part of the program
 * @author Farah, James, Shota, and Andrei
 *
 */
public class DataManager {
	/**
	 * This gets the email of the current user
	 * @param filepath is the filepath
	 * @return the email
	 */
	public String getEmail(String filepath, String user) {
		String email = "";
		BufferedReader br = null;
		String line = "";

		//user input validation for values in the flat file
		try {
			br = new BufferedReader(new FileReader(filepath));
			while ((line = br.readLine()) != null) {	//traverses through the file

				String[] row = line.split(",");
				if (row.length == 3) {
					if(row[0].equals(user)) {	//checks if the username is equal
						email = row[1];
					}
				}
			}		
			br.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return email;
	}

	/**
	 * This method validates user info 
	 * @param username is the username
	 * @param password is the password
	 * @param filepath is the path
	 * @return a boolean value if input is valid
	 */
	public Boolean validateLoginInformation(String username, String password, String filepath, ArrayList<UserAccount> UserAccounts) {
		// read CSV file
		boolean valid = false;
		BufferedReader br = null;
		String line = "";
		String userInDb; String passInDb;

		//user input validation for values in the flat file
		try {
			br = new BufferedReader(new FileReader(filepath));
			while ((line = br.readLine()) != null) {

				String[] row = line.split(",");
				if (row.length == 3) {
					userInDb = row[0];
					passInDb = row[2];

					//checks if the username and password are equal
					if (username.equals(userInDb)) {
						if (password.equals(passInDb))
							valid = true;
					}
				}
			}

			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return valid;
	}

	/**
	 * This method validates the login information
	 * @param username is the username to validate
	 * @param password is the password
	 * @param email is the email
	 * @param filepath is the path to the file
	 * @param UserAccounts is the arraylist of users
	 * @return a boolean value if it is valid or not
	 */
	public Boolean validateLoginInformation(String username, String password, String email, String filepath, ArrayList<UserAccount> UserAccounts) {
		// read CSV file
		boolean valid = false;
		BufferedReader br = null;
		String line = "";
		String userInDb; String emailInDb;

		//user input validation for values in the flat file
		try {
			br = new BufferedReader(new FileReader(filepath));
			while ((line = br.readLine()) != null) {

				String[] row = line.split(",");
				if (row.length == 3) {
					userInDb = row[0];
					emailInDb = row[1];

					//checks if the username and email are equal
					if (username.equals(userInDb)) {
						if (email.equals(emailInDb)) {
							valid = true;
						}
					}
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return valid;
	}

	/**
	 * This finds the user and returns the user object
	 * @param username is the username
	 * @param password is the password
	 * @param UserAccounts is the arraylist of users
	 * @return the found user account
	 */
	public UserAccount getUserInformation(String username, String password, ArrayList<UserAccount> UserAccounts) {
		//traverses through ArrayList of user accounts
		for (UserAccount user: UserAccounts) {
			if (user.getUserName().equals(username) && user.getPassWord().equals(password)) {
				return user;	//returns user with appropriate username and password
			}
		}
		return null;
	}

	/**
	 * Save user information to the database and add to ArrayList<UserAccount>
	 * @param username is the account username
	 * @param email is the account email
	 * @param password is the account password
	 * @param filepath is the path to the file
	 */
	public void saveUserAccount(String username, String email, String password, String filepath, ArrayList<UserAccount> UserAccounts) {
		try {
			// Write to flat-file database in project (UserAccounts.txt)
			FileWriter fw = new FileWriter(filepath, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);

			pw.println(username+","+email+","+password);
			pw.flush();
			pw.close();
			bw.close();
			fw.close();

			// Add to ArrayList<UserAccount> to access information
			UserAccount user = new UserAccount(username, email, password);
			UserAccounts.add(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This saves a recipe to the database
	 * @param username is the username 
	 * @param recipeName is the recipe name
	 * @param price is the price
	 * @param recipeTags are the tags
	 * @param recipeInstructions are the instructions
	 * @param filepath is the path to the file
	 */
	public void saveRecipe(String username, String recipeName, String price,  String recipeTags, String recipeInstructions, String filepath) {
		try {
			// Write to flat-file database in project 
			FileWriter fw = new FileWriter(filepath, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);

			//writes all the recipe information
			pw.println(username+","+ recipeName + "," + price + "," + recipeTags + "," + recipeInstructions);
			pw.flush();
			pw.close();
			bw.close();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create a temporary file and iterate over all values in the DB
	 * If account is found, update the password in the temporary file
	 * Finally, delete our DB and make the temporary file our new DB
	 * @param editUsername is the edit username 
	 * @param editEmail is the email
	 * @param newPassword is the new password
	 * @param filepath is the path to the file
	 */
	public void editPassword(String editUsername, String editEmail, String newPassword, String filepath, Scanner sc) {
		String tempFile = "temp.txt";
		File oldFile = new File(filepath);
		File newFile = new File(tempFile);
		String username; String email; String password; String line;
		try {
			FileWriter fw = new FileWriter(tempFile, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			sc = new Scanner(new File(filepath));

			while (sc.hasNext()) {
				line = sc.nextLine();
				if (line.trim().isEmpty())		// In the DB, if the row is empty, break the loop
					break;
				String[] row = line.split(",");
				username = row[0];
				email = row[1];
				password = row[2];
				// If matched user name and email, print new password into the new DB file
				if (username.equals(editUsername) && email.equals(editEmail)) {
					pw.println(username+","+email+","+newPassword);
				} else { // else, just copy over line from the old DB file
					pw.println(username+","+email+","+password);
				}
			}
			sc.close();
			pw.flush();
			pw.close();
			oldFile.delete();
			File dump = new File(filepath);
			newFile.renameTo(dump);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method searches for recipes in the DB
	 * @param priceRange is the price range
	 * @param tag are the tags
	 * @param searchPath is the path to write to
	 * @param filepath is the path to search
	 * @param sc is a Scanner
	 */
	public void searchRecipes(String priceRange, ArrayList<String> tag, String searchPath, String filepath, Scanner sc ) {
		try {
			FileWriter fw = new FileWriter(searchPath, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			sc = new Scanner(new File(filepath));
			String line; String price; String tags;
			Boolean checkPrice = false;
			Boolean checkTags = false;

			while (sc.hasNext()) {
				line = sc.nextLine();
				if (line.trim().isEmpty())		// In the DB, if the row is empty, break the loop
					break;

				String[] row = line.split(",");
				price = row[2];
				if(priceRange.equals(price)) {	//checks if price is appropriate
					checkPrice = true;	//sets checkPrice to true if that is the case
				}

				if(tag.size()!=0) {
					tags = row[3];
					String[] arrTags = tags.split(" TAG ");	

					for(int i=0; i<arrTags.length; i++) {
						if(tag.contains(arrTags[i])) {
							checkTags = true;	//if a tag is in the list, checkTags is true
						}
					}
				}
				else {
					checkTags = true;	//if there are no tags, checkTags is also true
				}
				//if checkTags and checkPrice are valid, print the line
				if(checkTags && checkPrice) {
					pw.println(line);
				}
				checkPrice = false;
				checkTags = false;
			}
			sc.close();
			pw.flush();
			pw.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method clears a database
	 * @param filepath is the path
	 * @param sc is a Scanner
	 */
	public void clearFile(String filepath, Scanner sc) {
		String tempFile = "temp.txt";
		File oldFile = new File(filepath);
		File newFile = new File(tempFile);
		String line;
		try {
			FileWriter fw = new FileWriter(tempFile, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			sc = new Scanner(new File(filepath));
			while (sc.hasNext()) {				//traverses through the DB
				line = sc.nextLine();
				if (line.trim().isEmpty())		// In the DB, if the row is empty, break the loop
					break;
				pw.println("");					//deletes content
			}
			sc.close();
			pw.flush();
			pw.close();
			oldFile.delete();
			File dump = new File(filepath);
			newFile.renameTo(dump);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create a temporary file and iterate over all values in the DB
	 * If account is found, update the email in the temporary file
	 * Finally, delete our DB and make the temporary file our new DB
	 * @param editUsername is the edit username 
	 * @param editEmail is the email
	 * @param newEmail is the new email
	 * @param filepath is the path to the file
	 */
	public void editProfile(String editUsername, String editEmail, String newUsername, String newPassword, String newEmail, String filepath, Scanner sc) {
		String tempFile = "temp.txt";
		File oldFile = new File(filepath);
		File newFile = new File(tempFile);
		String username; String email; String password; String line;
		try {
			FileWriter fw = new FileWriter(tempFile, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			sc = new Scanner(new File(filepath));

			while (sc.hasNext()) {
				line = sc.nextLine();
				if (line.trim().isEmpty())		// In the DB, if the row is empty, break the loop
					break;

				String[] row = line.split(",");
				username = row[0];
				email = row[1];
				password = row[2];

				// If matched user name and email, print new password into the new DB file
				if (username.equals(editUsername) && email.equals(editEmail)) {	
					if(!(newUsername.equals(""))) {
						username = newUsername;
					}
					if(!(newEmail.equals(""))) {
						email = newEmail;
					}
					if(!(newPassword.equals(""))) {
						password = newPassword;
					}
					pw.println(username+","+email+","+password);
				} else { // else, just copy over line from the old DB file
					pw.println(username+","+email+","+password);
				}
			}
			sc.close();
			pw.flush();
			pw.close();
			oldFile.delete();
			File dump = new File(filepath);
			newFile.renameTo(dump);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This gets the recipe names
	 * @param filepath is the path 
	 * @return an ArrayList of names
	 */
	public ArrayList<String> getNames(String filepath) {
		ArrayList<String> names = new ArrayList<>();
		BufferedReader br = null;
		String line = "";
		//user input validation for values in the flat file
		try {
			br = new BufferedReader(new FileReader(filepath));
			while ((line = br.readLine()) != null) {

				String[] row = line.split(",");
				if (row.length == 5) {
					names.add(row[1]);
				}
			}		
			br.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return names;
	}

	/**
	 * This gets the recipe names of own recipes
	 * @param filepath is the path 
	 * @return an ArrayList of names
	 */
	public ArrayList<String> getNamesOwnRecipes(String user, String filepath) {
		ArrayList<String> names = new ArrayList<>();
		BufferedReader br = null;
		String line = "";
		//user input validation for values in the flat file
		try {
			br = new BufferedReader(new FileReader(filepath));
			while ((line = br.readLine()) != null) {
				String[] row = line.split(",");
				if (row[0].equals(user)) {
					names.add(row[1]);
				}
			}		
			br.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return names;
	}

	/**
	 * This method populates the ArrayList of recipes
	 * @param filepath is the path to the file
	 * @param Recipes is the ArrayList to populate
	 */
	public void populateRecipesList(String filepath, ArrayList<Recipe> Recipes) {
		// read CSV file
		BufferedReader br = null;
		String line = "";
		String recipeName; String priceRange; String[] tags; String instructions;	// String recipeCreator;

		// user input validation for values in the flat file
		try {
			br = new BufferedReader(new FileReader(filepath));
			while ((line = br.readLine()) != null) {

				String[] row = line.split(",");
				if (row.length == 5) {
					recipeName = row[1];
					priceRange = row[2];
					tags = row[3].split(" TAG ");
					instructions = row[4].replace(" NEWLINE ", "\n");	//replaces newline with an actual new line character
					ArrayList<String> tagList = new ArrayList<>(Arrays.asList(tags));	//adds tags to lost
					Recipe recipeToAdd = new Recipe(priceRange, tagList, recipeName, "", instructions);
					Recipes.add(recipeToAdd);	//adds the new recipe
				}
			}
			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method adds a liked recipe to the flat file DB
	 * @param user is the username
	 * @param recipeName is the recipe name
	 * @param filepath is the path to the flat file
	 */
	public void addLikedRecipe(String user, String recipeName, String filepath) {
		try {
			// Write to flat-file database in project 
			FileWriter fw = new FileWriter(filepath, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);

			pw.println(user+","+ recipeName);	//adds liked recipe

			pw.flush();
			pw.close();
			bw.close();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method gets the recipes liked by the user 
	 * @param user is the username
	 * @param filepath is the path to the file
	 * @return the recipes liked by the yser
	 */
	public ArrayList<String> recipesLikedByUser(String user, String filepath) {
		ArrayList<String> recipesLikedByUser = new ArrayList<>();
		// read CSV file
		BufferedReader br = null;
		String line = "";
		String userInDB; String recipe;

		try {
			br = new BufferedReader(new FileReader(filepath));
			while ((line = br.readLine()) != null) {	//reads the file
				String[] row = line.split(",");
				if (row.length == 2) {
					userInDB = row[0];
					recipe = row[1];
					if (userInDB.equals(user)) {	//checks if the username is valid
						recipesLikedByUser.add(recipe);	//recipe is added
					}
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return recipesLikedByUser;
	}

	/**
	 * Create a temporary file and iterate over all values in the DB
	 * If username is changed, update DB	
	 * @param oldUser is the old username 
	 * @param newUser is the new usernmae
	 * @param changed is the if the username is changed
	 * @param filepath is the path to the file
	 * @param sc is the scanner
	 */
	public void changedUser(String oldUser, String newUser, Boolean changed, String filepath, Scanner sc) {
		String tempFile = "temp.txt";
		File oldFile = new File(filepath);
		File newFile = new File(tempFile);
		String username; String line;
		try {
			FileWriter fw = new FileWriter(tempFile, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			sc = new Scanner(new File(filepath));

			while (sc.hasNext()) {		//loops through file
				line = sc.nextLine();
				if (line.trim().isEmpty())		// In the DB, if the row is empty, break the loop
					break;

				String[] row = line.split(",");
				username = row[0];

				// If matched user name and email, print new password into the new DB file
				if (username.equals(oldUser)) {	
					pw.println(newUser + line.substring(oldUser.length()));
				} else { // else, just copy over line from the old DB file
					pw.println(line);
				}
			}
			sc.close();
			pw.flush();
			pw.close();
			oldFile.delete();
			File dump = new File(filepath);
			newFile.renameTo(dump);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Prevents duplicate usernames from being created
	 * @param username the username
	 * @param filepath is the filepath
	 * @return a boolean value 
	 */
	public boolean noDuplicateUsers(String username, String filepath) {
		ArrayList<String> names = new ArrayList<>();
		BufferedReader br = null;
		String line = "";
		boolean value = false;
		//user input validation for values in the flat file
		try {
			br = new BufferedReader(new FileReader(filepath));
			while ((line = br.readLine()) != null) {
				String[] row = line.split(",");
				names.add(row[0]);
			}
			if(names.contains(username)) {
				value = true;
			}
			br.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
	/**
	 * Prevents duplicate recipe names from being created
	 * @param recipeName is the recipe name
	 * @param filepath is the filepath
	 * @return a boolean value 
	 */
	public boolean noDuplicateRecipeNames(String recipeName, String filepath) {
		ArrayList<String> names = new ArrayList<>();
		BufferedReader br = null;
		String line = "";
		boolean value = false;
		//user input validation for values in the flat file
		try {
			br = new BufferedReader(new FileReader(filepath));
			while ((line = br.readLine()) != null) {
				String[] row = line.split(",");
				names.add(row[1]);
			}
			if(names.contains(recipeName)) {
				value = true;
			}
			br.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
}

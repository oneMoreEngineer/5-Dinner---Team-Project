package application;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * This runs the whole program
 * @author Farah, James, Shota, and Andrei
 *
 */
public class Main extends Application{

	//runs the program
	@Override
	public void start(Stage primaryStage) throws Exception {
		Runner r = new Runner();
		r.start(primaryStage);
	}
	
	//starts the program
	public static void main(String[] args){
		launch(args);
	}
}
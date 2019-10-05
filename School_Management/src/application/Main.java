package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.fxml.FXMLLoader;
/*
 *  @author  elijah ndung'u
 *  @version 1.0
 */


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent  root = FXMLLoader.load(getClass().getResource("LoginUI.fxml"));
			 primaryStage.setScene(new Scene(root));
			 primaryStage.setFullScreen(true);
			   primaryStage.getIcons().add(new Image("/application/icon.png"));
			 primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

/**
 *
 */
package yoko_Pkg;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author snipper
 *
 */
public class Yokohahama extends Application{



	@Override
	public void start(Stage stage) throws Exception {
                   stage.setTitle("Yokohama Tyres");
                   Parent root=FXMLLoader.load(getClass().getResource("yokohama.fxml"));
                   stage.setScene(new Scene(root));
                   stage.show();

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);

	}
}

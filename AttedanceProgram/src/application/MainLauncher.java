package application;



import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class MainLauncher extends Application{


	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root=FXMLLoader.load(getClass().getResource("splashScreen.fxml"));
 FadeTransition fadeIn=new FadeTransition(Duration.seconds(4), root);
fadeIn.setFromValue(0);
fadeIn.setToValue(2);
fadeIn.setCycleCount(2);

//fade ou
FadeTransition fadeOut=new FadeTransition(Duration.seconds(3), root);
fadeOut.setFromValue(2);
fadeOut.setToValue(0);
fadeOut.setCycleCount(2);


fadeIn.play();

fadeIn.setOnFinished((e)->{
	fadeOut.play();
});

fadeOut.setOnFinished((e)->{
	try {
		Parent root2=FXMLLoader.load(getClass().getResource("coolways.fxml"));
		 primaryStage.setScene(new Scene(root2));
		  primaryStage.show();
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
});
        primaryStage.initStyle(StageStyle.TRANSPARENT);

        primaryStage.setScene(new Scene(root));


        primaryStage.show();

	}
public static void main(String[] args) {
           launch(args);
	}

}

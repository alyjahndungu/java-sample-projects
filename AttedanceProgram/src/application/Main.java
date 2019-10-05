package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	//this is our primaryStage
	private Stage primaryStage;
	//this is the borderpane of the rootLayout
	private BorderPane rootLayout;

	@Override
	public void start(Stage primaryStage) {
		//declare the stage
		this.primaryStage=primaryStage;
		this.primaryStage.setTitle("Testing..");
		//initialize the rootLayout
		initRootLayout();

		//display the employees operation view
		showEmployeesOperationView();

	}

    //initializes the rootLayout(BorderPane object)
	private void initRootLayout() {
		// TODO Auto-generated method stub

		try {
			//Lood layout from the RootLayout.fxml
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(Main.class.getResource("/viewUI/EmployeesOne.fxml"));
			rootLayout=(BorderPane) loader.load();
			//show the scene containing the root layout
			Scene scene=new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




	}

	private void showEmployeesOperationView() {

		try {
			FXMLLoader loader=new FXMLLoader();
			loader.setLocation(Main.class.getResource("/viewUI/RootLayout.fxml"));
			AnchorPane employeesView;
			employeesView = (AnchorPane) loader.load();
			rootLayout.setCenter(employeesView);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public static void main(String[] args) {
		launch(args);
	}
}

/**
 *
 */
package application;

import java.io.IOException;
import java.sql.Connection;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * @author  elijah ndung'u
 *
 */
public class HomeController{
@FXML
public Button btnDashbord;

@FXML
public Button btnStudents;

@FXML
public Button btnTimetable;

@FXML
public Button btnSettings;

@FXML
public Button btnUpdate;

@FXML
public Button btnClasses;

Connection conn;
	/**
	 *
	 */

  public void handleDashclicked(){
	  btnDashbord.setOnAction(new EventHandler<ActionEvent>(){

		@Override
		public void handle(ActionEvent event) {


			try {
			Parent	dash= FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
		      Stage stage=new Stage();
		      stage.setTitle("Genius Dashboard");
		      stage.setScene(new Scene(dash));
		      stage.show();
		      //hide the current window.
		  ((Node) event.getSource()).getScene().getWindow().hide();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	  });

  }

  public void handleStudentsclicked(){
	  btnStudents.setOnAction(new EventHandler<ActionEvent>(){

		@Override
		public void handle(ActionEvent event) {
			try {
			Parent	students= FXMLLoader.load(getClass().getResource("Students.fxml"));
		      Stage stage1=new Stage();
		      stage1.setTitle("Students window");
		      stage1.setScene(new Scene(students));
		      stage1.show();
		      //hide the current window.
		  ((Node) event.getSource()).getScene().getWindow().hide();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	  });
  }

  public void handleTimeclicked(){
	  btnTimetable.setOnAction(new EventHandler<ActionEvent>(){

		@Override
		public void handle(ActionEvent event) {
			try {
			Parent	tTable= FXMLLoader.load(getClass().getResource("Timetable.fxml"));
		      Stage stage=new Stage();
		      stage.setTitle("Genius Timetable");
		      stage.setScene(new Scene(tTable));
		      stage.show();
		      //hide the current window.
		  ((Node) event.getSource()).getScene().getWindow().hide();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	  });
  }

  public void handleSettings(){

  }

  public void handleUpdate(){
	  btnUpdate.setOnAction(new EventHandler<ActionEvent>(){

		@Override
		public void handle(ActionEvent event) {
			try {
			Parent	enroll= FXMLLoader.load(getClass().getResource("enrollment.fxml"));
		      Stage stage=new Stage();
		      stage.setTitle("Genius Enrollment");
		      stage.setScene(new Scene(enroll));
		      stage.show();
		      //hide the current window.
		  ((Node) event.getSource()).getScene().getWindow().hide();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	  });
  }

  public void handleClasses(){

  }

	public HomeController() {
		// TODO Auto-generated constructor stub
	}



}

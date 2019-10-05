/**
 *
 */
package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;


/**
 * @author  elijah ndung'u
 *
 */
public class EnrollmentController {
@FXML
private Button  btnHome, btnSave, btnClear, btnDelete, btnSearch;
@FXML
private TextField txtAdmin, txtSname, txtFname, txtLname, txtPhone,txtReside, txtIdNumber, txtCurriculum, txtLevel,
txtModelearn, txtNation,txtCourse, txtEmail, txtGender;
@FXML
private DatePicker  txtYear;

Connection conn;
Statement ps;


public void handleHome(){
	 btnHome.setOnAction(new EventHandler<ActionEvent>(){
	@Override
	public void handle(ActionEvent event) {
		try {
		Parent	home= FXMLLoader.load(getClass().getResource("Home.fxml"));
	      Stage stage=new Stage();
	      stage.setTitle("Genius Home");
	      stage.setScene(new Scene(home));
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

public void handleSave(){
	 btnSave.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				try {

					 conn= login.connect();
					ps=conn.createStatement();

				    String admNo=txtAdmin.getText();
				    String Sir=txtSname.getText();
                    String first=txtFname.getText();
                    String Last=txtLname.getText();
                    String gender=txtGender.getText();
                    String phone=txtPhone.getText();
                    String mail=txtEmail.getText();
                    String reside=txtReside.getText();
                    String nation=txtNation.getText();
                    LocalDate date= txtYear.getValue();
                   String coActivity=txtCurriculum.getText();
                   String idNo=txtIdNumber.getText();
                   String level=txtLevel.getText();
                   String course=txtCourse.getText();
                   String mode=txtModelearn.getText();



               String sql="insert into students_infotb values('"+admNo+"','"+Sir+"','"+first+"','"+Last+"','"+gender+"','"+phone+"','"+mail+"','"+reside+"','"+nation+"', '"+date+"','"+coActivity+"','"+idNo+"','"+ level+"','"+course+"','"+mode+"')";

             Alert alert=new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Add new User");
				alert.setHeaderText("You are about to add" + " " + first + " " + "to Genius college HR system");
				 String s=" "+first+" "+" has been successifully added to HR system";
				   alert.setContentText(s);
				   alert.show();
               ps.executeUpdate(sql);
               //clearing the text fields
                 txtAdmin.clear();
                 txtSname.clear();
				 txtFname.clear();
				 txtLname.clear();
				 txtSname.clear();
				 txtEmail.clear();
				 txtPhone.clear();
				 txtReside.clear();
				 txtGender.clear();
				 txtCourse.clear();
				 txtNation.clear();
				 txtModelearn.clear();
				 txtLevel.clear();
				 txtIdNumber.clear();
				 txtCurriculum.clear();
				} catch (SQLException e) {
					e.printStackTrace();
				}


			} });
}
 public void handleSearch(){
	 btnSearch.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				String str=txtAdmin.getText();
				try {

					 conn= login.connect();
					PreparedStatement pst=conn.prepareStatement("SELECT * from students_infotb WHERE adm_no = ?");
					pst.setString(1, str);

					//executing
					ResultSet rss=pst.executeQuery();
					 if(rss.next()){
						 String s=rss.getString(2);
						 String s1=rss.getString(3);
						 String s2=rss.getString(4);
						 String s3=rss.getString(5);
						 String s4=rss.getString(6);
						 String s5=rss.getString(7);
						 String s6=rss.getString(8);
						 String s7=rss.getString(9);
						 String s8=rss.getString(10);
						 String s9=rss.getString(11);
						 String s10=rss.getString(12);
						 String s11=rss.getString(13);
						 String s12=rss.getString(14);



						 txtFname.setText(s);
						 txtLname.setText(s1);
						 txtSname.setText(s2);
						 txtEmail.setText(s3);
							 txtPhone.setText(s4);
							 txtReside.setText(s5);
							 txtGender.setText(s6);
							 txtCourse.setText(s7);
							 txtNation.setText(s8);
							 txtModelearn.setText(s9);
							 txtLevel.setText(s10);
							 txtIdNumber.setText(s11);
							 txtCurriculum.setText(s12);

					 }
				} catch (SQLException e) {
					e.printStackTrace();

				}

			}

		 });
 }

 public void handleDelete(){
	 btnDelete.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				String str=txtAdmin.getText();
				try {
					 conn= login.connect();
					PreparedStatement ps=conn.prepareStatement("DELETE FROM students_infotb WHERE adm_no=?");

					ps.setString(1, str);
			          Alert alert=new Alert(AlertType.CONFIRMATION);
						alert.setTitle("Remove employee");
						alert.setHeaderText("You are about to remove Admission  No:" + " " + str+ " " + "from Genius College System");
						 String s="Confirm removal of "+" "+str+" "+" from HR system permanently";
						   alert.setContentText(s);
						   alert.show();

					ps.executeUpdate();

			         txtAdmin.clear();
	                 txtSname.clear();
					 txtFname.clear();
					 txtLname.clear();
					 txtSname.clear();
					 txtEmail.clear();
					 txtPhone.clear();
					 txtReside.clear();
					 txtGender.clear();
					 txtCourse.clear();
					 txtNation.clear();
					 txtModelearn.clear();
					 txtLevel.clear();
					 txtIdNumber.clear();
					 txtCurriculum.clear();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		 });
 }

 public void handleClear(){
btnClear.setOnAction(new EventHandler<ActionEvent>(){

	@Override
	public void handle(ActionEvent event) {
	       txtAdmin.clear();
           txtSname.clear();
			 txtFname.clear();
			 txtLname.clear();
			 txtSname.clear();
			 txtEmail.clear();
			 txtPhone.clear();
			 txtReside.clear();
			 txtGender.clear();
			 txtCourse.clear();
			 txtNation.clear();
			 txtModelearn.clear();
			 txtLevel.clear();
			 txtIdNumber.clear();
			 txtCurriculum.clear();

	}

});

 }
	public EnrollmentController() {
		// TODO Auto-generated constructor stub
	}

}

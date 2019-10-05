package application;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class EmployeesController{
	@FXML
    TextField empId,txtNewmail,txtFname,txtLname,txtSname,txtEmail;
	@FXML
    Button btSearch,btDelete,btUpdate,btAdd,btnClose;
	@FXML
    TextArea textArea;
	@FXML
	ProgressIndicator pi;

    Connection conn;
    Statement ps;


	public void search(ActionEvent event){
		 btSearch.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				String str=empId.getText();
				try {

					 conn= login.connect();
					PreparedStatement pst=conn.prepareStatement("SELECT * from employees WHERE idNo = ?");
					pst.setString(1, str);

					//executing
					ResultSet rss=pst.executeQuery();
					 if(rss.next()){
						 String s=rss.getString(2);
						 String s1=rss.getString(3);
						 String s2=rss.getString(4);
						 String s3=rss.getString(5);
						 String s4=rss.getString(6);

						 //add the to text field
						 txtNewmail.setText(s);
						 txtFname.setText(s1);
						 txtLname.setText(s2);
						 txtSname.setText(s3);
						 txtEmail.setText(s4);

					 }else{

								   Alert alert=new Alert(AlertType.ERROR);
									alert.setTitle("Not Found");
									alert.setHeaderText("Employee ID No:" + " " + str + " " + "is not available in Levin MicroSystems  Limited");
									 String s=" "+str+" "+"Invalid Employee ID";
									   alert.setContentText(s);
									   alert.show();

					 }
				} catch (SQLException e) {
					e.printStackTrace();

				}

			}

		 });
	}

	public void delete(ActionEvent event){
		 btDelete.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				String str=empId.getText();
				try {
					 conn= login.connect();
					PreparedStatement ps=conn.prepareStatement("DELETE FROM employees WHERE idNo=?");

					ps.setString(1, str);
			          Alert alert=new Alert(AlertType.CONFIRMATION);
						alert.setTitle("Remove employee");
						alert.setHeaderText("You are about to remove employeeID no:" + " " + str+ " " + "from Levin MicroSystems Limited");
						 String s="Confirm removal of "+" "+str+" "+" from HR system permanently";
						   alert.setContentText(s);
						   alert.show();

					ps.executeUpdate();
              //clearing the text fields
               empId.clear();
               txtNewmail.clear();
				 txtFname.clear();
				 txtLname.clear();
				 txtSname.clear();
				 txtEmail.clear();

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		 });
	}

	public void add(ActionEvent event){
		 btAdd.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				try {

					 conn= login.connect();
					ps=conn.createStatement();

				   String idNo=empId.getText();
                  String newMail=txtNewmail.getText();
                  String first=txtFname.getText();
                  String Last=txtLname.getText();
                  String Sir=txtSname.getText();
                  String regEmail=txtEmail.getText();

                  String sql="insert into employees values('"+idNo+"','"+newMail+"','"+first+"','"+Last+"','"+Sir+"','"+regEmail+"')";

                Alert alert=new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Add new User");
				alert.setHeaderText("You are about to add" + " " + first + " " + "to Levin MicroSystems  Limited");
				 String s=" "+first+" "+" has been successifully added to HR system";
				   alert.setContentText(s);
				   alert.show();
                  ps.executeUpdate(sql);
                  //clearing the text fields
                  empId.clear();
                  txtNewmail.clear();
   				 txtFname.clear();
   				 txtLname.clear();
   				 txtSname.clear();
   				 txtEmail.clear();
				} catch (SQLException e) {
					e.printStackTrace();
				}


			} });
	}
	public void terminate(ActionEvent event){
        btnClose.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				System.exit(0);

			}

        });
	 }

	public void update(ActionEvent event){
		 btUpdate.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				String str=empId.getText();
				try {
					 conn= login.connect();
					PreparedStatement ps=conn.prepareStatement("UPDATE FROM employees where idNo=?");

					ps.setString(1, str);
			          Alert alert=new Alert(AlertType.CONFIRMATION);
						alert.setTitle("Updating");
						alert.setHeaderText("You are about to update employeeID no:" + " " + str+ " " + "in Levin MicroSystems Limited");
						 String s="Confirm changes for "+" "+str+" "+" and save to the HR system permanently";
						   alert.setContentText(s);
						   alert.show();

					ps.executeUpdate();
              //clearing the text fields
               empId.clear();
               txtNewmail.clear();
				 txtFname.clear();
				 txtLname.clear();
				 txtSname.clear();
				 txtEmail.clear();

				} catch (SQLException e) {
					e.printStackTrace();

				}

			}

		 });

	}


}

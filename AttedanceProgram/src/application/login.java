/**
 *
 */
package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author elijah ndung'u
 *
 */

public class login {
	@FXML
        TextField txtUser;
	@FXML
        PasswordField txtPass;
	@FXML
	    Button btnLogin,btnCancel;
      static Connection conn;

      static int maxAttempts=5;
      static int countAttempts=1;

public static  Connection connect()  {
	return conn;
}

public void MyConfirmition( String msg, String[] buts_options){
	  int opt=JOptionPane.showOptionDialog(null, msg, "Error",JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null, buts_options, buts_options[0]);

	  if(opt==JOptionPane.YES_OPTION){

		}else{
			System.exit(1);
		}

}

    public boolean authentication(String username, String password){
    	    boolean status=false;
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", username, password);
			status=true;

		} catch (ClassNotFoundException e1) {
			e1.getMessage();
		} catch (SQLException e) {
             int error=e.getErrorCode();
               status=false;
                 switch(error){

                 case 0:
                	 			Alert alert1=new Alert(AlertType.ERROR);
    					alert1.setTitle("Error");
    					alert1.setHeaderText("No Server was found.");
    							String s1="Unable to locate the legit server";
    					  alert1.setContentText(s1);
    					  alert1.show();
                      break;

                 case 1045:
                	 String attemptsMsg="";
                	 if(countAttempts!=maxAttempts){
                			attemptsMsg="\n\nNOTE:\t"+(maxAttempts-countAttempts)+" Attempts Remaining";
						}else{

							Alert alert=new Alert(AlertType.CONFIRMATION);
							alert.setTitle("Exit");
							alert.setHeaderText("You provided wrong credentials");
							 String s="Program could not process your request..??";
							   alert.setContentText(s);
							   alert.show();
							System.exit(1);
						}

                                ++countAttempts;


                                Alert al=new Alert(AlertType.WARNING);
    							al.setTitle("Warning");
    							al.setHeaderText("You provided wrong credentials");
    							 String ts="Incorrect username or password supplied?  Try Again!!!" +attemptsMsg;
    							   al.setContentText(ts);
    							   al.showAndWait();

                        txtUser.clear();
				    	txtPass.setText("");
				    	status=false;
				    	break;

                 case 1049:

                		Alert alert=new Alert(AlertType.ERROR);
    					alert.setTitle("Error");
    					alert.setHeaderText("Connection error");
    					 String s="Unable to access the database";
    					   alert.setContentText(s);
    					   alert.show();
						break;
					default:
						break;
                 }
		}
    	 return status;

    }

       public void loginButton(ActionEvent event){
    	   btnLogin.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {

				 String user=txtUser.getText();
				  String pass=txtPass.getText();

				if(!user.equals("")&& !pass.equals("")){

					boolean response=authentication(user,pass);

					if(response==true){
					      ((Node) event.getSource()).getScene().getWindow().hide();

					      Parent root;
					      try {
					    	  root=FXMLLoader.load(getClass().getResource("EmployeesOne.fxml"));

					      Stage stage=new Stage();
					      stage.setTitle("Registration of employees");
					      stage.initStyle(StageStyle.TRANSPARENT);
					      stage.setScene(new Scene(root));
					      stage.show();

					  	} catch (IOException e) {

							e.printStackTrace();
						}
					}
				}else{

					Alert alert=new Alert(AlertType.ERROR);
					alert.setTitle("Error");
					alert.setHeaderText("No credentials provided");
					 String s="Username and Password fields cannot be empty";
					   alert.setContentText(s);
					   alert.show();

					      txtUser.clear();
					      txtPass.clear();
				}


	}
       });

       }

	public void cancel(ActionEvent event){
    	   btnCancel.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
			System.exit(1);

			}

    	   });

       }
}

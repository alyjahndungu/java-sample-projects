/**
 *
 */
package yoko_Pkg;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

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

/**
 * @author snipper
 *
 */
public class Yoko_controller  {
 @FXML
 TextField txtEmail;
 @FXML
 PasswordField txtPass;
 @FXML
 Button btnLogin,btnSign;

 //for the sign in window;
 @FXML
 TextField txtFname,txtMobile,txtNewEmail,txtSirname,txtLname;
 @FXML
 PasswordField txtNewPass;
 @FXML
 Button butSign,butClear;

 Properties prop=new Properties();

boolean dbProperty(){
	try {

		prop.load(new FileInputStream("C:/Users/snipper/Desktop/db.properties"));
return true;
	}
	catch (FileNotFoundException eee) {
		JOptionPane.showMessageDialog(null, "file not found"+eee.getMessage());
		return false;
	}

 catch (IOException ee) {

ee.getMessage();
return false;
}
	}
 public void handleEmail(){

 }

 public void handlePassword(){

 }

 public void handleLogin(){

   btnLogin.setOnAction(new EventHandler<ActionEvent>(){

	@Override
	public void handle(ActionEvent event) {

			 if( dbProperty()){
				 String e=txtEmail.getText();
				 String p= txtPass.getText();
				try {

					if( e.equals(prop.getProperty("email")) && p.equals( prop.getProperty("password"))){

				    Parent	root=FXMLLoader.load(getClass().getResource("trasactions.fxml"));
				      Stage stage=new Stage();
				      stage.setScene(new Scene(root));
				      stage.show();

				      Alert alert=new Alert(AlertType.ERROR);
			           alert.setTitle("Welcome to Yokohama Company");
			           alert.setHeaderText("WELCOME");
			           String s="  " +e+"  "+ "Thanks for choosing YOKOHAMA COMPANY as your trusted partneship....Click 'OK' to Continue";
			           alert.setContentText(s);
			           alert.show();
				      //hide the current window.
				((Node) event.getSource()).getScene().getWindow().hide();

				  	}
					else{
						  Alert alert=new Alert(AlertType.ERROR);
				           alert.setTitle("Login ERROR");
				           alert.setHeaderText("INVALID CREDENTIALS");
				           String s="User" + "  " +e+"  "+ "does not exist in the company, Create new Account";
				           alert.setContentText(s);
				           alert.show();
				           txtEmail.clear();
				           txtPass.clear();
					}
				}catch (IOException eee) {

						eee.printStackTrace();
					}
				}


			 else{

		 }

	}

   });


 }
 public void handleSign(){
	 //opens the sign up page
	 btnSign.setOnAction(new EventHandler<ActionEvent>(){

		@Override
		public void handle(ActionEvent event) {
			try {

			    Parent	root=FXMLLoader.load(getClass().getResource("yokosign.fxml"));
			      Stage stage=new Stage();
			      stage.setTitle("Yokohama Sign in");
			      stage.setScene(new Scene(root));
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


//Another level to add actions to the Create account window
 public void handleFname(){
	 //takes the firstname
 }

 public void handleLname(){
	 //lastname
 }

 public void handleNewEmail(){
	 //email

	  prop.setProperty("email",txtNewEmail.getText().toString());
	 
 }

 public void handleMobile(){
	 //mobile
 }

 public void handleSir(){
	 //sirname
 }

 public void handleNewPass(){
	 //new password
	  prop.setProperty("password",txtNewPass.getText().toString());
 }

 public void handleSignUp(){
	 // button sign in
	 butSign.setOnAction(new EventHandler<ActionEvent>(){

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			JOptionPane.showMessageDialog(null, "Saved successifully");
			 try {
					prop.store(new FileWriter("C:/Users/snipper/Desktop/db.properties"), "I am signing in to you");

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            txtNewEmail.clear();
            txtNewPass.clear();
		}

	 });

 }

 public void handleClear(){
	 //button clear
 }
}

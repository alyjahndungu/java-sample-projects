/**
 *
 */
package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.controlsfx.control.textfield.TextFields;

import application.StudentsModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * @author elijah ndung'u
 *
 */
public class StudentsController implements Initializable {
	   @FXML
	    private TableView<StudentsModel> tdData;
	    @FXML
	    public TableColumn<StudentsModel,String> AdmissionNo;

	    @FXML
	    public TableColumn<StudentsModel, String> firstName;

	    @FXML
	    public TableColumn<StudentsModel, String> lastName;

	    @FXML
	    public TableColumn<StudentsModel, String>colEmail;

	    @FXML
	    public TableColumn<StudentsModel, String> colPhone;

	    @FXML
	    public TableColumn<StudentsModel, String> colLevel;

	    @FXML
	    public TableColumn<StudentsModel, String> colCourse;

	    @FXML
	    private Button btnHome;

	    @FXML
	    private TextField txtSearch;

	    Connection conn;
	public StudentsController() {

	}

	public void handleAutoComplete(){

	}

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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	       AdmissionNo.setCellValueFactory(new PropertyValueFactory<>("AdmissionNo"));
	        firstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
	        lastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
	        colEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
	        colPhone.setCellValueFactory(new PropertyValueFactory<>("Phone"));
	        colLevel.setCellValueFactory(new PropertyValueFactory<>("Level"));
	        colCourse.setCellValueFactory(new PropertyValueFactory<>("Course"));

		conn= login.connect();
		ResultSet resultSet=null;
		try {
			PreparedStatement pst=conn.prepareStatement("SELECT adm_no, firstname,lastname,email,phone,level,course  FROM  students_infotb");
		    resultSet = pst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		   try {
			   ObservableList<StudentsModel> dbData = FXCollections.observableArrayList(dbArrayList(resultSet));
			for(int i =0; i<resultSet.getMetaData().getColumnCount(); i++){
				   switch(resultSet.getMetaData().getColumnName(i + 1)){
				   case "AdmissionNo":
					   AdmissionNo.setText("adm_no");
					   break;
				   case "firstname":
					   firstName.setText("firstname");
					   break;

				   case "lastname":
					   lastName.setText("lastname");
					   break;

				   case "email":
					   colEmail.setText("email");
					   break;

				   case "phone":
					   colPhone.setText("phone");
					   break;

				   case "level":
					   colLevel.setText("level");
					   break;

				   case "course":
					   colCourse.setText("course");
					   break;

					   default: AdmissionNo.setText(resultSet.getMetaData().getColumnName(i + 1));
					     break;
				   }

			   }
		      tdData.setItems(dbData);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private ArrayList<StudentsModel> dbArrayList(ResultSet resultSet) throws SQLException {
		ArrayList<StudentsModel> data =new ArrayList<>();

		while(resultSet.next()){
			Integer AdmissioNo = resultSet.getInt("adm_no");
			String  firstName= resultSet.getString("firstname");
			String lastName = resultSet.getString("lastname");
			String email =resultSet.getString("email");
			Integer phone = resultSet.getInt("phone");
			String level = resultSet.getString("level");
			String course = resultSet.getString("course");
			data.add(new StudentsModel(AdmissioNo, firstName,lastName,  email,  phone, level,  course));
			 TextFields.bindAutoCompletion(txtSearch, data);
		}

			return data;
	}

}

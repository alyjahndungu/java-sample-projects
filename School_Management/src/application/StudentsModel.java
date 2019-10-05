/**
 *
 */
package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * @author  elijah ndung'u
 *
 */
public class StudentsModel {
	 private SimpleIntegerProperty AdmissionNo;
	    private SimpleStringProperty firstName;
	    private SimpleStringProperty lastName;
	    private SimpleStringProperty  email;
	    private SimpleIntegerProperty phone;
	    private SimpleStringProperty level;
	    private SimpleStringProperty course;

	public StudentsModel(Integer admNo, String fName, String lName, String mail, Integer phoneNo, String  levelEd, String courseName) {
	     this.AdmissionNo = new SimpleIntegerProperty(admNo);
	        this.firstName = new SimpleStringProperty(fName);
	        this.lastName = new SimpleStringProperty(lName);
	        this.email = new SimpleStringProperty(mail);
	        this.phone = new SimpleIntegerProperty(phoneNo);
	        this.level = new SimpleStringProperty(levelEd);
	        this.course = new SimpleStringProperty(courseName);

	}

    public int getAdmissionNo() {
        return AdmissionNo.get();
    }

    public void setAdmissionNo(int AdmissionNo) {
        this.AdmissionNo = new SimpleIntegerProperty(AdmissionNo);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName = new SimpleStringProperty(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName = new SimpleStringProperty(lastName);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.lastName = new SimpleStringProperty(email);
    }

    public int getPhone() {
        return phone.get();
    }

    public void setPhone(int phone) {
        this.phone = new SimpleIntegerProperty(phone);
    }

    public String getLevel() {
        return level.get();
    }

    public void setLevel(String level) {
        this.level = new SimpleStringProperty(level);
    }

    public String getCourse() {
        return course.get();
    }

    public void setCourse(String course) {
        this.course = new SimpleStringProperty(course);
    }
}

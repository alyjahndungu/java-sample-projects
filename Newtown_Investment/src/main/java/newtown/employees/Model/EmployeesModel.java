package newtown.employees.Model;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table (name = "dbnewton.tbnewton")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties (value ={"updated_at"}, allowGetters = true)

public class EmployeesModel implements Serializable {
@Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private  Long id;

@Column
    String firstname;

@Column
    String lastname;

@Column
    String gender;

@Column
    String email;

@Column
   Integer phone_no;

@Column
    String position;
@Column(nullable = false)
    @Temporal(TemporalType.DATE)
@LastModifiedDate

    private Date updated_at;

public Long getId(){
    return id;
}

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(Integer phone_no) {
        this.phone_no = phone_no;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

}

package newtown.employees.Repository;


import newtown.employees.Model.EmployeesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepo extends JpaRepository<EmployeesModel, Long> {


}

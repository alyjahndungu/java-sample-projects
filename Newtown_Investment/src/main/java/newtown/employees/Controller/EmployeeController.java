package newtown.employees.Controller;

import newtown.employees.Exception.ResourceNotFoundException;
import newtown.employees.Model.EmployeesModel;
import newtown.employees.Repository.EmployeesRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/newton_employees")
public class EmployeeController {

    @Autowired
    EmployeesRepo employeesRepo;

@GetMapping("/viewAll")
public List <EmployeesModel> getAllNotes(){
        return employeesRepo.findAll();
    }

@PostMapping("/newEmployee")
    public EmployeesModel newEmployee (@Valid @RequestBody EmployeesModel employeesModel){
    return employeesRepo.save(employeesModel);
}

    @GetMapping("/viewEmployee/{id}")
  public EmployeesModel getEmployeeById(@PathVariable (value = "id") Long employeeId){
  return employeesRepo.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("EmployeeModel", "id", employeeId));
    }

    @PutMapping("/updateEmployee/{id}")
public EmployeesModel updateEmployee(@PathVariable(value = "id") Long employeeId, @Valid @RequestBody EmployeesModel employeesModel){
           EmployeesModel employeesModel1= employeesRepo.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("EmployeeModel", "id", employeeId));
           employeesModel1.setFirstname(employeesModel.getFirstname());
           employeesModel1.setLastname(employeesModel.getLastname());
           employeesModel1.setGender(employeesModel.getGender());
           employeesModel1.setEmail(employeesModel.getEmail());
           employeesModel1.setPhone_no(employeesModel.getPhone_no());
           employeesModel1.setPosition(employeesModel.getPosition());
           return employeesModel1;
    }

@DeleteMapping("/deleteEmployee/{id}")
public ResponseEntity<?>deleteEmployee(@PathVariable (value = "id") Long employeeId){
    EmployeesModel employeesModel = employeesRepo.findById(employeeId).orElseThrow(()->new ResourceNotFoundException("EmployeeModel", "id", employeeId));
     employeesRepo.delete(employeesModel);
     return ResponseEntity.ok().build();
}

}

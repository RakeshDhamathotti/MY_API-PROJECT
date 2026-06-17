package Api.build.Service.implementation;

import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import Api.build.Entity.Employee;
import Api.build.Repository.EmployeeRepository;
import Api.build.Service.EmployeeApiService;



@Service
public class ServiceImplementation implements EmployeeApiService{


    private final  EmployeeRepository emprep;

    ServiceImplementation(EmployeeRepository emprep) {
        this.emprep = emprep;
    }

    @Override
    public Employee getEmployee(Employee emp) {
        if(emp.getEmployee_Id()==null || emp.getEmployee_Id().isEmpty())
        {
            throw new RuntimeException("Employee Id is required..");
        }
        // if(!emprep.existsById(emp.getEmployee_Id()))
        // {
        //     throw new RuntimeException("Employee ID is not Present ");
        // }
       
        return  emprep.findById(emp.getEmployee_Id()).orElseThrow(()->new RuntimeException("Employee id is not present "));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return emprep.findAll();
    }

    @Override
    public String addEmployee(@RequestBody Employee emp) {
      
         
         if(emp.getEmployee_Id()== null || emp.getEmployee_Id().isEmpty())
         {
            throw new RuntimeException("Employeee ID is required");

         }
         if(emprep.existsById(emp.getEmployee_Id()))
         {
            throw new RuntimeException("Employee ID already Exist enter new One");
         }

         emprep.save(emp);
         return emp.getEmployee_Id()+"employee Inserted";
    }

    // @Override
    // public Employee updateEmpById(String Id) {
        
    //     emprep.findById(Id)
    // }

    @Override
    public String deleteById(Employee emp) 
    {
        if(emp.getEmployee_Id()==null || emp.getEmployee_Id().isEmpty())
        {
            throw new RuntimeException("ID is Required");
            
        }
        emprep.deleteById(emp.getEmployee_Id());

        return emp.getEmployee_Id()+" Emloyee deleted successfully";

    }
    
}

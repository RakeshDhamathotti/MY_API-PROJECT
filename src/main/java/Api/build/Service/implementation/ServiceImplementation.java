
package Api.build.Service.implementation;

import java.time.LocalDate;
import java.util.ArrayList;
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
    public List<Employee> getAllEmployees() 
    {
        return emprep.findAll();
    }

    @Override
    public List<Employee> addEmployee(@RequestBody List<Employee> emp) {
      
        for(Employee emplist:emp)
        {
         
            if(emplist.getEmployee_Id()== null || emplist.getEmployee_Id().isEmpty())
            {
                throw new RuntimeException("Employeee ID is required");

            }
            if(emprep.existsById(emplist.getEmployee_Id()))
            {
                throw new RuntimeException("Employee ID already Exist enter new One");
            }
            
        }
        return emprep.saveAll(emp);
    }

    // @Override
    // public Employee updateEmpById(String Id) {
        
    //     emprep.findById(Id)
    // }

    @Override
    public String deleteById(Employee emp) 
    {
        
        if (emp.getEmployee_Id() == null || emp.getEmployee_Id().isEmpty())
            {
                throw new IllegalArgumentException("Employee ID is required ");
            }

                boolean exists = emprep.existsById(emp.getEmployee_Id());

        if (!exists)
            {
                throw new RuntimeException("Employee not found with ID: " + emp.getEmployee_Id());
            }

        emprep.deleteById(emp.getEmployee_Id());

        return emp.getEmployee_Id() + " Employee deleted successfully ";


    }

    @Override
    public List<Employee> retrievePunches(LocalDate startdate, LocalDate enddate) {
        List<Employee> empall =emprep.findAll();
        List<Employee> newemp = new ArrayList<>();

        if(!enddate.isAfter(startdate))
        {
            throw new RuntimeException("the endDate should be after startDate");
        }
        for (Employee allemp : empall) 
        {
            LocalDate start= allemp.getIn_Punch().toLocalDate();
            if (!start.isAfter(enddate) && !start.isBefore(startdate)) 
            {
                newemp.add(allemp);
            }
            
        }

        return newemp;
    }

    @Override
    public List<Employee> punchesTillDate(LocalDate startdate) {
        LocalDate enddate=LocalDate.now();
         List<Employee> empall =emprep.findAll();
        List<Employee> newemp = new ArrayList<>();

        if(!enddate.isAfter(startdate))
        {
            throw new RuntimeException("The Start Date cannot be in Future");
        }
        for (Employee allemp : empall) 
        {
            LocalDate start= allemp.getIn_Punch().toLocalDate();
            if (!start.isAfter(enddate) && !start.isBefore(startdate)) 
            {
                newemp.add(allemp);
            }
            
        }

        return newemp;
        
    }

    @Override
    public List<Employee> employeePunchesDateRange(String empId, LocalDate startdate, LocalDate enddate) {
        
        List<Employee> empall =emprep.findAll();
        List<Employee> newemp = new ArrayList<>();

        if(!enddate.isAfter(startdate))
        {
            throw new RuntimeException("the endDate should be after startDate");
        }
        for (Employee allemp : empall) 
        {
            LocalDate start= allemp.getIn_Punch().toLocalDate();
            if (!start.isAfter(enddate) && !start.isBefore(startdate) && allemp.getEmployee_Id().equals(empId)) 
            {
                newemp.add(allemp);
            }
            
        }

        return newemp;
    }

    @Override
    public List<Employee> employeePunchesTillDate(String empid, LocalDate startdate) {
         List<Employee> empall =emprep.findAll();
        List<Employee> newemp = new ArrayList<>();
        LocalDate enddate=LocalDate.now();

        if(!enddate.isAfter(startdate))
        {
            throw new RuntimeException("the Start Date cannot be in Future");
        }
        for (Employee allemp : empall) 
        {
            LocalDate start= allemp.getIn_Punch().toLocalDate();
            if (!start.isAfter(enddate) && !start.isBefore(startdate) && allemp.getEmployee_Id().equals(empid)) 
            {
                newemp.add(allemp);
            }
            
        }

        return newemp;

    }
    
}


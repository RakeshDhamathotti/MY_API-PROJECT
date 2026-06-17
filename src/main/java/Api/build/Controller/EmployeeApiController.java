
package Api.build.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Api.build.Entity.Employee;
import Api.build.Service.EmployeeApiService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api")
public class EmployeeApiController {
    
    EmployeeApiService service;

    public EmployeeApiController(EmployeeApiService service)
    {
        this.service=service;
    }



    @GetMapping("/empall")
    public List<Employee> getAllEmployees()
    {
        return service.getAllEmployees();
    }


    @GetMapping("/emp")
    public Employee getEmployee(@RequestBody Employee emp)
    {
        return service.getEmployee(emp);
    }

    @PostMapping("/add")
    public String addEmployee(@RequestBody Employee emp) {
     
        return service.addEmployee(emp);
    }

    @PostMapping("/delete")
    public String deleteById(@RequestBody Employee emp)
    {
        return service.deleteById(emp);

    }
    
}


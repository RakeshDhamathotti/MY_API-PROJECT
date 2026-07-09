
package Api.build.Controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Api.build.Entity.Employee;
import Api.build.Service.EmployeeApiService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;



@RestController
@RequestMapping("/api")
public class EmployeeApiController {
    
    EmployeeApiService service;

    public EmployeeApiController(EmployeeApiService service)
    {
        this.service=service;
    }



    @GetMapping("/employees")
    public List<Employee> getAllEmployees()
    {
        return service.getAllEmployees();
    }


    @GetMapping("/employees/id")
    public Employee getEmployee(@RequestBody Employee emp)
    {
        return service.getEmployee(emp);
    }

    @PostMapping("/employees")
    public List<Employee> addEmployee(@RequestBody List<Employee> emp) {
     
        return service.addEmployee(emp);
    }

    @PostMapping("/employees/delete")
    public String deleteById(@RequestBody Employee emp)
    {
        return service.deleteById(emp);

    }

     @PostMapping("/punches/date-range")
    public ResponseEntity< ?> retrievepunches(@RequestBody Map<String,String> request )
    {

       
        String startDateStr = request.get("startDate");
        String endDateStr = request.get("endDate");

        if (startDateStr == null || endDateStr == null) {
            return ResponseEntity.badRequest()
                .body("startDate and endDate are required");
        }

        LocalDate startDate = LocalDate.parse(startDateStr);
        LocalDate endDate = LocalDate.parse(endDateStr);

        return ResponseEntity.ok(
                service.retrievePunches(startDate, endDate)
        );


    }


    @PostMapping("/punches/till-date")
    public ResponseEntity<?>punchesTillDate(@RequestBody Map<String, String>request)
    {

        LocalDate startdate=LocalDate.parse( request.get("startDate"));
        return ResponseEntity.ok(
            service.punchesTillDate(startdate)
        );
    }


    @PostMapping("/employees/punches/date-range")
    public ResponseEntity<?> employeePunchesDateRange(@RequestBody Map<String, String>request)
    {
        String employeeId=request.get("employeeId");
        LocalDate startDate=LocalDate.parse(request.get("startDate"));
        LocalDate endDate=LocalDate.parse(request.get("endDate"));

        return ResponseEntity.ok(
            service.employeePunchesDateRange(employeeId,startdate,enddate)
        );
    }

    @PostMapping("/employees/punches/till-date")
    public ResponseEntity<?> employeePunchesTillDate(@RequestBody Map<String,String>request)
    {
        String employeeId=request.get("employeeId");
        LocalDate startDate=LocalDate.parse(request.get("startDate"));

        return ResponseEntity.ok(
            service.employeePunchesTillDate(employeeId, startDate)
        );
    }
    
}





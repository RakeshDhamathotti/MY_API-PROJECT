
package Api.build.Service;

import java.time.LocalDate;
import java.util.List;

import Api.build.Entity.Employee;







public interface EmployeeApiService {



    public Api.build.Entity.Employee getEmployee(Employee emp);
    public List<Employee> getAllEmployees();
    public List<Employee> addEmployee(List<Employee> emp);
    // public Employee updateEmpById(String Id);
    public String deleteById(Employee emp);

    public List<Employee> retrievePunches(LocalDate startdate, LocalDate enddate);

    public List<Employee> punchesTillDate(LocalDate startdate);

    public List<Employee> employeePunchesDateRange(String empId,LocalDate startdate,LocalDate enddate);

    public List<Employee>  employeePunchesTillDate(String empid,LocalDate startDate);

}



package Api.build.Service;

import java.util.List;

import Api.build.Entity.Employee;







public interface EmployeeApiService {



    public Api.build.Entity.Employee getEmployee(Employee emp);
    public List<Employee> getAllEmployees();
    public String addEmployee(Employee emp);
    // public Employee updateEmpById(String Id);
    public String deleteById(Employee emp);

}


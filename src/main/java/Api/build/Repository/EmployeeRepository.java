
package Api.build.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Api.build.Entity.Employee;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee,String>{
    
    
    Optional<Employee> findByEmployeeId(String employeeId);

    boolean existsByEmployeeId(String employeeId);

    void deleteByEmployeeId(String employeeId);
      
}


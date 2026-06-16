package Api.build.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Api.build.Entity.Employee;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee,String>{
    
}

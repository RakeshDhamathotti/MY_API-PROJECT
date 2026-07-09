package Api.build.Service.implementation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import Api.build.Entity.Employee;
import Api.build.Entity.Punches;
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
        if(emp.getEmployeeId()==null || emp.getEmployeeId().isEmpty())
        {
            throw new RuntimeException("Employee Id is required..");
        }
        // if(!emprep.existsById(emp.getEmployee_Id()))
        // {
        //     throw new RuntimeException("Employee ID is not Present ");
        // }
       
        return  emprep.findByEmployeeId(emp.getEmployeeId()).orElseThrow(()->new RuntimeException("Employee id is not present "));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return emprep.findAll();
    }

    @Override
    @PostMapping("/employees")
    public List<Employee> addEmployee(@RequestBody List<Employee> employees)
    {

        List<Employee> employeesToSave = new ArrayList<>();

        for (Employee employeeIn : employees) 
        {

            String employeeId = employeeIn.getEmployeeId();

            if (employeeId == null || employeeId.isBlank()) 
            {
                throw new RuntimeException("Employee ID is required");
            }

            Optional<Employee> existingEmployee =
                    emprep.findByEmployeeId(employeeId);

            if (existingEmployee.isPresent()) 
            {

                Employee Employee = existingEmployee.get();

                Employee.setEmployeeName(
                        employeeIn.getEmployeeName());

                        
                for (Punches newPunch : employeeIn.getPunches())
                {

                    LocalDate newPunchDate = newPunch.getInpunch().toLocalDate();

                    boolean dateExists = Employee.getPunches()
                                                .stream()
                                                .anyMatch(existingPunch ->existingPunch.getInpunch()
                                                .toLocalDate()
                                                .equals(newPunchDate));

                    if (dateExists) 
                    {
                     throw new RuntimeException(
                                "Employee " + Employee.getEmployeeId() +
                                " already has a punch for date " + newPunchDate);
                    }
                    Employee.getPunches()
                            .addAll(employeeIn.getPunches());

                    employeesToSave.add(Employee);
                } 
            }
            else 
            {
                employeesToSave.add(employeeIn);
            }
        }

        return emprep.saveAll(employeesToSave);
    }

    // @Override
    // public Employee updateEmpById(String Id) {
        
    //     emprep.findById(Id)
    // }

    @Override
    public String deleteById(Employee emp) 
    {
        if(emp.getEmployeeId()==null || emp.getEmployeeId().isEmpty())
        {
            throw new RuntimeException("ID is Required");
            
        }
        emprep.deleteByEmployeeId(emp.getEmployeeId());

        return emp.getEmployeeId()+" Emloyee deleted successfully";

    }

    @Override
    public List<Employee> retrievePunches(LocalDate startdate, LocalDate enddate) {
        List<Employee> empall =emprep.findAll();
        List<Employee> emplist = new ArrayList<>();

        if(!enddate.isAfter(startdate))
        {
            throw new RuntimeException("the endDate should be after startDate");
        }
        for (Employee allemp : empall) 
        {
            List<Punches> newPunch=new ArrayList<>();
             for(Punches punch:allemp.getPunches())
            {
                LocalDate inPunchDate = punch.getInpunch().toLocalDate();
            
            
                if (!inPunchDate.isAfter(enddate) && !inPunchDate.isBefore(startdate)) 
                {
                    newPunch.add(punch);
                }
            }
            if(!newPunch.isEmpty())
            {

                Employee employeewithPunches= new Employee();
                employeewithPunches.setId(allemp.getId());
                employeewithPunches.setEmployeeId(allemp.getEmployeeId());
                employeewithPunches.setEmployeeName(allemp.getEmployeeName());
                employeewithPunches.setPunches(newPunch);

                emplist.add(employeewithPunches);


            }
        }
        return emplist;
    }

    @Override
    public List<Employee> punchesTillDate(LocalDate startdate) {
        LocalDate enddate=LocalDate.now();
         List<Employee> empall =emprep.findAll();
        List<Employee> emplist = new ArrayList<>();

        // if(!enddate.isAfter(startdate))
        // {
        //     throw new RuntimeException("the endDate should be after startDate");
        // }
        for (Employee allemp : empall) 
        {
            List<Punches> newPunch=new ArrayList<>();
             for(Punches punch:allemp.getPunches())
            {
                LocalDate inPunchDate = punch.getInpunch().toLocalDate();
            
            
                if (!inPunchDate.isAfter(enddate) && !inPunchDate.isBefore(startdate)) 
                {
                    newPunch.add(punch);
                }
            }
            if(!newPunch.isEmpty())
            {

                Employee employeewithPunches= new Employee();
                employeewithPunches.setId(allemp.getId());
                employeewithPunches.setEmployeeId(allemp.getEmployeeId());
                employeewithPunches.setEmployeeName(allemp.getEmployeeName());
                employeewithPunches.setPunches(newPunch);

                emplist.add(employeewithPunches);


            }
            

            
            
        }

        return emplist;
        
    }

    @Override
    public List<Employee> employeePunchesDateRange(String empId, LocalDate startdate, LocalDate enddate) {
        
        List<Employee> empall =emprep.findAll();
        List<Employee> emplist = new ArrayList<>();

        if(!enddate.isAfter(startdate))
        {
            throw new RuntimeException("the endDate should be after startDate");
        }
        for (Employee allemp : empall) 
        {
            if(allemp.getEmployeeId().equals(empId))
            {
            List<Punches> newPunch=new ArrayList<>();

             for(Punches punch:allemp.getPunches())
            {
                LocalDate inPunchDate = punch.getInpunch().toLocalDate();
            
            
                if (!inPunchDate.isAfter(enddate) && !inPunchDate.isBefore(startdate)) 
                {
                    newPunch.add(punch);
                }
            }
            if(!newPunch.isEmpty())
            {

                Employee employeewithPunches= new Employee();
                employeewithPunches.setId(allemp.getId());
                employeewithPunches.setEmployeeId(allemp.getEmployeeId());
                employeewithPunches.setEmployeeName(allemp.getEmployeeName());
                employeewithPunches.setPunches(newPunch);

                emplist.add(employeewithPunches);


            }
            }
        }
        return emplist;
    }

    @Override
    public List<Employee> employeePunchesTillDate(String empid, LocalDate startdate) {
         List<Employee> empall =emprep.findAll();
        List<Employee> empList = new ArrayList<>();
        LocalDate enddate=LocalDate.now();

        if(!enddate.isAfter(startdate))
        {
            throw new RuntimeException("the endDate should be after startDate");
        }
        for (Employee allemp : empall) 
        {
            if(allemp.getEmployeeId().equals(empid))
            {
            List<Punches> newPunch=new ArrayList<>();

             for(Punches punch:allemp.getPunches())
            {
                LocalDate inPunchDate = punch.getInpunch().toLocalDate();
            
            
                if (!inPunchDate.isAfter(enddate) && !inPunchDate.isBefore(startdate)) 
                {
                    newPunch.add(punch);
                }
            }
            if(!newPunch.isEmpty())
            {

                Employee employeewithPunches= new Employee();
                employeewithPunches.setId(allemp.getId());
                employeewithPunches.setEmployeeId(allemp.getEmployeeId());
                employeewithPunches.setEmployeeName(allemp.getEmployeeName());
                employeewithPunches.setPunches(newPunch);

                empList.add(employeewithPunches);


            }
            }
        }

        return empList;

    }
    
}


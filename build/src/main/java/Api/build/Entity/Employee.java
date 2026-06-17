package Api.build.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name="testtable")
public class Employee {
    

    @Id
    private String Employee_Id;
    private String Employee_Name;
    private String Punch_Date;
    private String In_Punch;
    private String Out_Punch;


}

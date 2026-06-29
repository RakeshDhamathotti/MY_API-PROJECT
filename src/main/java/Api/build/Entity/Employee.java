

package Api.build.Entity;


import java.time.LocalDateTime;

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
@Table(name="EmployeeTable")
public class Employee {
    

    @Id
    private String Employee_Id;
    private String Employee_Name;
    private LocalDateTime In_Punch;
    private LocalDateTime Out_Punch;


}
// >>>>>>> 606cd7d39036706b88a9651523fd3ec9a3d8ac67

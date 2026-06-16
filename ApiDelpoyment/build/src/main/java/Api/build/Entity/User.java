package Api.build.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name="UserDetails")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String userName;
    private String password;
    private String EmployeeName;
    
}

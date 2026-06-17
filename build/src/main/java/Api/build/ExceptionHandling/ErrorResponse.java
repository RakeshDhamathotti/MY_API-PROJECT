<<<<<<< HEAD
package Api.build.ExceptionHandling;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
public class ErrorResponse {
    
    private LocalDateTime timeStamp;
    private int status;
    private String message;

}
=======
package Api.build.ExceptionHandling;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
public class ErrorResponse {
    
    private LocalDateTime timeStamp;
    private int status;
    private String message;

}
>>>>>>> 606cd7d39036706b88a9651523fd3ec9a3d8ac67

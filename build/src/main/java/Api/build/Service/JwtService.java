<<<<<<< HEAD
package Api.build.Service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {

    public String generateToken(String username);

    public String extractUserName(String jwtToken);

    boolean validatToken(String token,UserDetails userDetails);
=======
package Api.build.Service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {

    public String generateToken(String username);

    public String extractUserName(String jwtToken);

    boolean validatToken(String token,UserDetails userDetails);
>>>>>>> 606cd7d39036706b88a9651523fd3ec9a3d8ac67
}
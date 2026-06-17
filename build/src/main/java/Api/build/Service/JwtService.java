package Api.build.Service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {

    public String generateToken(String username);

    public String extractUserName(String jwtToken);

    boolean validatToken(String token,UserDetails userDetails);
}
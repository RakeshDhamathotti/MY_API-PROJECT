package Api.build.Service.implementation;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import Api.build.Entity.User;
import Api.build.ExceptionHandling.InvalidCredentialException;
import Api.build.Repository.UserRepository;
import Api.build.Service.UserInfoService;



@Service
public class UserInfoServiceImple implements UserInfoService {

    final UserRepository userrep;

    final PasswordEncoder passwordEncoder;

    final AuthenticationManager authManager;

    final JwtUtilService jwtUtilService;


    UserInfoServiceImple(UserRepository userrep, PasswordEncoder passwordEncoder, AuthenticationManager authManager, JwtUtilService jwtUtilService) {
        this.userrep = userrep;
        this.passwordEncoder = passwordEncoder;
        this.authManager = authManager;
        this.jwtUtilService = jwtUtilService;
    }


    @Override
    public User createUser(User user) {
        
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userrep.save(user);
       
    }

    @Override
    public String getUSer(User user) {
       Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
       System.out.println(" hello ...Auth object"+authentication.isAuthenticated());
       if(authentication.isAuthenticated())
       {
        return jwtUtilService.generateToken(user.getUserName());

       }
        else{
            throw new InvalidCredentialException("Invalid Credentials");
        }
    }
    
}

package Api.build.Service.implementation;


import java.util.ArrayList;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Api.build.Entity.User;
import Api.build.Repository.UserRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;



@Service
public class CustUserDetailsService
implements UserDetailsService{


final UserRepository userrep;


    CustUserDetailsService(UserRepository userrep) {
        this.userrep = userrep;
    }


@Override
public UserDetails loadUserByUsername(String username){


    User user =userrep.findByUserName(username).orElseThrow();


    return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),new ArrayList<>());


}

}
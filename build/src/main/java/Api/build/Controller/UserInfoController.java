<<<<<<< HEAD
package Api.build.Controller;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Api.build.Entity.User;
import Api.build.Service.implementation.UserInfoServiceImple;




@RestController
@RequestMapping("/User")
public class UserInfoController {
    

    final UserInfoServiceImple userService;

    UserInfoController(UserInfoServiceImple userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String>createUser(@RequestBody User user)
    {

        User user1= userService.createUser(user);
        

        return new ResponseEntity<>("User"+user1.getUserName()+"is Created",HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String>getUser(@RequestBody User user)
    {
        return new ResponseEntity<>(userService.getUSer(user),HttpStatus.OK);
    }
}
=======
package Api.build.Controller;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Api.build.Entity.User;
import Api.build.Service.implementation.UserInfoServiceImple;




@RestController
@RequestMapping("/User")
public class UserInfoController {
    

    final UserInfoServiceImple userService;

    UserInfoController(UserInfoServiceImple userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String>createUser(@RequestBody User user)
    {

        User user1= userService.createUser(user);
        

        return new ResponseEntity<>("User"+user1.getUserName()+"is Created",HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String>getUser(@RequestBody User user)
    {
        return new ResponseEntity<>(userService.getUSer(user),HttpStatus.OK);
    }
}
>>>>>>> 606cd7d39036706b88a9651523fd3ec9a3d8ac67

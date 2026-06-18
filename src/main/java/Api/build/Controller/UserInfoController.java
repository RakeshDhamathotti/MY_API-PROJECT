
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
import org.springframework.http.MediaType;




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

    @PostMapping(value="/login" , consumes = {MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<String>getUser(@RequestBody User user)
    {
        return new ResponseEntity<>(userService.getUSer(user),HttpStatus.OK);
    }
}

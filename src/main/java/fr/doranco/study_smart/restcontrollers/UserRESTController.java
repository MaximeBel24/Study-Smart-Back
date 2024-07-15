package fr.doranco.study_smart.restcontrollers;

import fr.doranco.study_smart.entities.User;
import fr.doranco.study_smart.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserRESTController {

    @Autowired
    UserService userService;

    @GetMapping(path = "all")
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }

}

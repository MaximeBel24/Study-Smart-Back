package fr.doranco.study_smart.service.user;

import fr.doranco.study_smart.entities.Role;
import fr.doranco.study_smart.entities.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User findUserByUsername(String username);
    Role addRole(Role role);
    User addRoleToUser(String username, String rolename);
    List<User> findAllUsers();
}

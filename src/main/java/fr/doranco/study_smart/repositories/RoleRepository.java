package fr.doranco.study_smart.repositories;

import fr.doranco.study_smart.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRole(String role);
}

package io.server.repo;

import io.server.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findRoleByRoleName(String rolename);
}

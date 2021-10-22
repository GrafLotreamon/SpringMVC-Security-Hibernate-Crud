package web.repository;

import web.model.Role;

import java.util.List;

public interface RoleDao {
    Role getRoleByRole(String role);

    Role getRoleById(Long id);

    List<Role> allRoles();

    Role getDefaultRole();


    public void addRole(Role role);
}





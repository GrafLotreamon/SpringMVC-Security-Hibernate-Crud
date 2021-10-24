package web.service;

import web.model.Role;

import java.util.List;

public interface RoleService {

    Role getRoleByRole(String role);

    Role getRoleById(Long id);

    List<Role> allRoles();

    void addRole(Role role);
}

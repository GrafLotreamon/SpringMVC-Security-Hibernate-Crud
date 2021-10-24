package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.Role;
import web.repository.RoleDao;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;

    @Autowired
    public void setRoleRepo(RoleDao roleDao) {
        this.roleDao = roleDao;
    }


    @Override
    public Role getRoleByRole(String role) {
        return roleDao.getRoleByRole(role);
    }

    @Override
    public Role getRoleById(Long id) {
        return roleDao.getRoleById(id);
    }

    @Override
    public List<Role> allRoles() {
        return roleDao.allRoles();
    }


    @Override
    public void addRole(Role role) {
        roleDao.addRole(role);
    }


}

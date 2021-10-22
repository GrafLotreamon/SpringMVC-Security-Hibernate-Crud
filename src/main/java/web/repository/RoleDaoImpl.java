package web.repository;

import org.springframework.stereotype.Repository;
import web.model.Role;
import web.repository.RoleDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {
    @PersistenceContext
    private EntityManager entityManager;

    protected EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public Role getRoleByRole(String role) {
        Role rolename = null;
        try {
            rolename = getEntityManager()
                    .createQuery("SELECT r FROM Role r WHERE r.role=:role", Role.class)
                    .setParameter("role", role)
                    .getSingleResult();
        } catch (Exception e) {
            System.out.println("Роли с таким именем не существует!");
        }
        return rolename;
    }

    @Override
    public Role getRoleById(Long id) {
        return getEntityManager().find(Role.class, id);
    }

    @Override
    public List<Role> allRoles() {
        return getEntityManager()
                .createQuery("select r from Role r", Role.class)
                .getResultList();
    }

    @Override
    public Role getDefaultRole() {
        return getRoleByRole("ROLE_USER");
    }


    @Override
    public void addRole(Role role) {
        getEntityManager().persist(role);
    }


}

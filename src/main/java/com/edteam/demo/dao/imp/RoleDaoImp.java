package com.edteam.demo.dao.imp;

import com.edteam.demo.dao.RoleDao;
import com.edteam.demo.models.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional
@Repository
public class RoleDaoImp implements RoleDao {

    @PersistenceContext
    protected EntityManager entityManager;

    @Transactional
    @Override
    public List<Role> getAll() {
        String hql = "FROM Role as u ";
        return (List<Role>) entityManager.createQuery(hql).getResultList();
    }

    @Transactional
    @Override
    public Role get(long id) {
        return entityManager.find(Role.class, id);
    }

    @Transactional
    @Override
    public Role register(Role Role) {
        entityManager.merge(Role);
        return Role;
    }

    @Transactional
    @Override
    public Role update(Role Role) {
        entityManager.merge(Role);
        return Role;
    }

    @Transactional
    @Override
    public void delete(long id) {
        Role Role = get(id);
        entityManager.remove(Role);
    }
}

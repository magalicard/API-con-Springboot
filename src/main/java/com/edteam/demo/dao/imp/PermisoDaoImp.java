package com.edteam.demo.dao.imp;

import com.edteam.demo.dao.PermisoDao;
import com.edteam.demo.models.Permiso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional
@Repository
public class PermisoDaoImp implements PermisoDao {

    @PersistenceContext
    protected EntityManager entityManager;

    @Transactional
    @Override
    public List<Permiso> getAll() {
        String hql = "FROM Permiso as u ";
        return (List<Permiso>) entityManager.createQuery(hql).getResultList();
    }

    @Transactional
    @Override
    public Permiso get(long id) {
        return entityManager.find(Permiso.class, id);
    }

    @Transactional
    @Override
    public Permiso register(Permiso Permiso) {
        entityManager.merge(Permiso);
        return Permiso;
    }

    @Transactional
    @Override
    public Permiso update(Permiso Permiso) {
        entityManager.merge(Permiso);
        return Permiso;
    }

    @Transactional
    @Override
    public void delete(long id) {
        Permiso Permiso = get(id);
        entityManager.remove(Permiso);
    }
}

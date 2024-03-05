package com.edteam.demo.dao.imp;

import com.edteam.demo.dao.UserDao;
import com.edteam.demo.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional
@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    protected EntityManager entityManager;

    @Transactional
    @Override
    public List<User> getAll() {
        String hql = "FROM User as u ";
        return (List<User>) entityManager.createQuery(hql).getResultList();
    }

    @Transactional
    @Override
    public User get(long id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    @Override
    public User register(User user) {
        entityManager.merge(user);
        return user;
    }

    @Transactional
    @Override
    public User update(User user) {
        entityManager.merge(user);
        return user;
    }

    @Transactional
    @Override
    public void delete(long id) {
        User user = get(id);
        entityManager.remove(user);
    }
}
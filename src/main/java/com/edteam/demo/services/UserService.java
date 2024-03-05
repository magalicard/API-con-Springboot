package com.edteam.demo.services;

import com.edteam.demo.dao.UserDao;
import com.edteam.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public List<User> getAll() {
        return userDao.getAll();
    }

    public User get(long id) {
        return userDao.get(id);
    }

    public void register(User user) {
        userDao.register(user);
    }

    public User update(User user) {
        return userDao.update(user);
    }

    public void delete(long id) {
        userDao.delete(id);
    }

}
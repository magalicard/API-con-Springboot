package com.edteam.demo.services;

import com.edteam.demo.dao.UserDao;
import com.edteam.demo.models.User;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
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
        String hash = generarHash(user.getPassword());
        user.setPassword(hash); //cuando se registra el usuario lo hace con un hash
        userDao.register(user);
    }

    public User update(User user) {
        return userDao.update(user);
    }

    public void delete(long id) {
        userDao.delete(id);
    }

    //función para controlar Argon2
    private String generarHash(String password) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        return argon2.hash(1, 1024, 1, password);
    }

    public User login(User user) {
        return userDao.login(user);
    }

}
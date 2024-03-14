package com.edteam.demo.dao;

import com.edteam.demo.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    List<User> getAll();
    User get(long id);
    User register(User user);
    User update(User user);
    void delete(long id);

}

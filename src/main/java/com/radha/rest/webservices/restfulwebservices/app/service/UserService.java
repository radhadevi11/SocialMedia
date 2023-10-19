package com.radha.rest.webservices.restfulwebservices.app.service;

import com.radha.rest.webservices.restfulwebservices.app.dao.UserDao;
import com.radha.rest.webservices.restfulwebservices.app.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UserService {
    private UserDao userDao;
@Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<UserEntity> getAllUsers() {
        return userDao.getAllUsers();
    }

    public UserEntity getUSer(int id) throws NoSuchUserException{

    UserEntity userEntity = userDao.getUser(id);
    if (userEntity == null) {
        throw new NoSuchUserException(id);
    }
    return userEntity;
    }

    public void deleteUser (int id) throws NoSuchUserException {
    UserEntity userEntity = userDao.getUser(id);

    if (userEntity == null) {
        throw new NoSuchUserException(id);
    }
    userDao.deleteUser(id);
    }
}

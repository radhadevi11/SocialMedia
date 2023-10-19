package com.radha.rest.webservices.restfulwebservices.app.service;

import com.radha.rest.webservices.restfulwebservices.app.entities.UserEntity;
import com.radha.rest.webservices.restfulwebservices.app.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UserService {
    private UserRepo userRepo;
    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<UserEntity> getAllUsers() {
        return userRepo.findAll();
    }

    public UserEntity getUSer(int id) throws NoSuchUserException{

    UserEntity userEntity = userRepo.findById(id).get();
    if (userEntity == null) {
        throw new NoSuchUserException(id);
    }
    return userEntity;
    }

    public void deleteUser (int id) throws NoSuchUserException {
    UserEntity userEntity = userRepo.getReferenceById(id);

    if (userEntity == null) {
        throw new NoSuchUserException(id);
    }
    userRepo.deleteById(id);
    }
    public UserEntity saveUser (UserEntity user) {
        return userRepo.saveAndFlush(user);
    }

}

package com.radha.rest.webservices.restfulwebservices.app.dao;

import com.radha.rest.webservices.restfulwebservices.app.entities.UserEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
public class UserDao {
    List<UserEntity> userEntities = Arrays.asList (new UserEntity(1,
            "user_1",
            LocalDate.now().minusYears(25)),
            new UserEntity(2,
                    "user_2",
                    LocalDate.now().minusYears(25)));

    public List<UserEntity> getAllUsers () {
        return userEntities;
    }

    public UserEntity getUser (int id) {

        /*for(User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }*/
        return userEntities.stream()
                .filter(userEntity -> userEntity.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void deleteUser (int id) {
        userEntities.removeIf(userEntity -> userEntity.getId() == id);
    }
}

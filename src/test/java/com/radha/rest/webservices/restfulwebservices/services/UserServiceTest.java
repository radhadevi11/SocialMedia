package com.radha.rest.webservices.restfulwebservices.services;
import com.radha.rest.webservices.restfulwebservices.app.entities.UserEntity;
import com.radha.rest.webservices.restfulwebservices.app.repo.UserRepo;
import com.radha.rest.webservices.restfulwebservices.app.service.NoSuchUserException;
import com.radha.rest.webservices.restfulwebservices.app.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.InstanceOfAssertFactories.OPTIONAL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    public static final int USER_ID = 1001;
    public static final String NAME = "user1";

    @InjectMocks
    @Spy
    UserService userService;

    @Spy
    UserRepo userRepo;

    @Test
    public void testGetUser() throws NoSuchUserException {
        UserEntity user = mock (UserEntity.class);
        Optional<UserEntity> userEntityOptional = mock(Optional.class);
        doReturn(userEntityOptional).when(userRepo).findById(USER_ID);
        doReturn(user).when(userEntityOptional).get();
        doReturn(USER_ID).when(user).getId();
        doReturn(NAME).when(user).getName();

        UserEntity actual = userService.getUSer(USER_ID);

        assertEquals(USER_ID, actual.getId());
        assertEquals(NAME, actual.getName());


    }

    @Test
    public void testGetUserWithInvalidID () throws NoSuchUserException {
        Optional<UserEntity> userEntityOptional = mock(Optional.class);
        doReturn(userEntityOptional).when(userRepo).findById(USER_ID);
        doReturn(null).when(userEntityOptional).get();

        assertThatThrownBy(() -> userService.getUSer(USER_ID))
                .isInstanceOf(NoSuchUserException.class)
                .hasMessage("No such user having the Id : "+USER_ID);


    }

    @Test
    public void testGetAllUsers() {
        UserEntity user1 = mock(UserEntity.class);
        UserEntity user2 = mock(UserEntity.class);
        UserEntity user3 = mock(UserEntity.class);
        List<UserEntity> expected = Arrays.asList(user1, user2, user3);
        doReturn(expected).when(userRepo).findAll();

        List<UserEntity> actual = userService.getAllUsers();

        assertThat(actual).containsExactly(user1, user2, user3);
    }

    @Test
    public void testSaveUser () {
        UserEntity expected = mock(UserEntity.class);
        doReturn(expected).when(userRepo).saveAndFlush(expected);

        UserEntity actual = userService.saveUser(expected);

        assertThat(actual).isEqualTo(expected);

    }
}
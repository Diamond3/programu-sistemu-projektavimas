package com.app.web.appweb.service;

import com.app.web.appweb.model.User;
import com.app.web.appweb.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository repo;

    @InjectMocks
    UserService userService;

    @Test
    void testShowAll() {
        User user1 = new User(1L, "Var1", "Pav1", "+33", "emailas@gmail.com", "add", "Pass123!");
        User user2 = new User(2L, "Var2", "Pav2", "+33", "emailas@gmail.com", "add", "Pass123!");
        var userList = List.of(user1, user2);
        when(repo.findAll()).thenReturn(userList);
        var users = userService.findAll();
        assertEquals(2, users.size());
        assertEquals("Var1", users.get(0).getFirstName());
        assertEquals("Var2", users.get(1).getFirstName());
    }

    @Test
    void testAdd() {
        var user = new User("Var", "Pav", "+33", "emailas@gmail.com", "add", "Pass123!");
        when(repo.save(Mockito.any(User.class))).thenReturn(user);

        User added = userService.add(user);
        verify(repo).save(Mockito.any(User.class));
        assertNotNull(added);
    }

    @Test
    void testUpdateUser(){
        User newUser = new User(1L, "Var", "Pav", "+33", "emailas@gmail.com", "add", "Pass123!");
        when(repo.save(Mockito.any(User.class))).thenReturn(newUser);

        User user = new User(1L, "Var2", "Pav2", "+33", "emailas2@gmail.com", "add2", "Pass123!");
        userService.update(user);
        verify(repo).save(Mockito.any(User.class));
    }

    @Test
    void testFindUserById() {
        User user = new User(1L, "Var", "Pav", "+33", "emailas@gmail.com", "add", "Pass123!");
        when(repo.findById(1L)).thenReturn(java.util.Optional.of(user));
        assertNotNull(userService.findById(1L));
        assertThrows(NoSuchElementException.class, () -> userService.findById(2L));
    }

    @Test
    void testDeleteById() {
        userService.deleteById(1L);
        verify(repo).deleteById(Mockito.anyLong());
    }
}
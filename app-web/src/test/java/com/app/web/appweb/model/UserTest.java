package com.app.web.appweb.model;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testUserConstructor() {
        User user = new User(1L, "Var1", "Pav1", "+33", "emailas@gmail.com", "add", "Pass123!");

        assertEquals(1L, user.getUserID());
        assertEquals("Var1", user.getFirstName());
        assertEquals("Pav1", user.getLastName());
        assertEquals("+33", user.getPhoneNum());
        assertEquals("emailas@gmail.com", user.getEmail());
        assertEquals("add", user.getAddress());
        assertEquals("Pass123!", user.getPassword());
    }
}
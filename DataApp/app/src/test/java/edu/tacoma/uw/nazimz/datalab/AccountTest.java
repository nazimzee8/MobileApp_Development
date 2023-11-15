package edu.tacoma.uw.nazimz.datalab;

import org.junit.Test;

import authenticate.Account;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertFalse;

public class AccountTest {

    @Test
    public void testAccountConstructor() {
        assertNotNull(new Account("nazimz@uw.edu", "test1@3"));
    }

    @Test
    public void testAccountConstructorBadEmail() {
        try {
            new Account("nazimzuw.edu", "test1@3");
            fail("Account created with invalid email");
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    public void testSetEmail() {
        String email = "nazimzuw.edu";
        assertFalse(Account.isValidEmail(email));
    }

    @Test
    public void testSetPwd() {
        String pwd = "nazim";
        assertFalse(Account.isValidPassword(pwd));
    }
}

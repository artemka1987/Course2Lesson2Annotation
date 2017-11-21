package ru.kupchenkov;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginProcessorTest {


    @Test
    public void testStartProcess_validParams_invertNameToLogin() throws NoSuchFieldException, IllegalAccessException {

        String name = "Artem";
        LoginExample loginExample = new LoginExample("Login", name);
        LoginProcessor.startProcess(loginExample);

        assertTrue(loginExample.getLogin().equals(new StringBuffer(name).reverse().toString()));
    }

    @Test
    public void testStartProcess_invalidParams_throwNoSuchFieldException() throws NoSuchFieldException, IllegalAccessException {
        LoginExample loginExample = null;
        assertThrows(IllegalArgumentException.class, () ->{
            LoginProcessor.startProcess(loginExample);
        } );
    }

}
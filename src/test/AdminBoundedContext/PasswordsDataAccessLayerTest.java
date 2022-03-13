package test.AdminBoundedContext;

import main.AuthenticationBoundedContext.PasswordsDataAccessLayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordsDataAccessLayerTest {

    @Test
    void getPassword() {
        PasswordsDataAccessLayer p = new PasswordsDataAccessLayer();
        assertEquals(p.getPassword(10821),"password1");

    }
}
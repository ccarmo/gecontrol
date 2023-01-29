package test.java.dev.gecontrol.api.domain.entity;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import dev.gecontrol.api.domain.entity.*;
import dev.gecontrol.api.domain.vo.*;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    void testUserCreation() {
        Name name = new Name("John", "Smith");
        Email email = new Email("john.smith@example.com");
        Password password = new Password("password123");
        UserPermission permissions = UserPermission.ADMIN;
        User user = new User(name, email, password, permissions);

        assertEquals(name, user.getName());
        assertEquals(email, user.getEmail());
        assertEquals(password, user.getPassword());
        assertEquals(permissions, user.getPermissions());
        assertEquals(Status.ACTIVE, user.getStatus());
        assertTrue(LocalDateTime.now().isAfter(user.getCreatedAt()));
        assertNull(user.getUpdatedAt());
    }


}

package workout_manager.test.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import workout_manager.model.User;

/**
 * test user class
 */
public class TestUser {
    @Test
    void testValidConstruction() {
        User user = new User("Billy West", "Bwest101");
        assertAll(
                () -> assertEquals(user.getUserName(), "Billy West"),
                () -> assertEquals(user.getPassWord(), "Bwest101"));
    }

    @Test
    void testInvalidConstructionNullName() {
        assertThrows(NullPointerException.class, () -> {
            new User(null, "Bwest101");
        });

    }

    @Test
    void testInvalidConstructionNullPassword() {
        assertThrows(NullPointerException.class, () -> {
            new User("Billy West", null);
        });

    }

    @Test
    void testInvalidConstructionEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new User("", "Bwest101");
        });

    }

    @Test
    void testInvalidConstructionEmptyPassword() {
        assertThrows(IllegalArgumentException.class, () -> {
            new User("Billy West", "");
        });

    }

}

package org.factoriaf5.zootopia.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {

    private User user;
    private Profile profile;

    @BeforeEach
    void setUp() {

        profile = new Profile();
        user = new User("admin", "password", profile);
        user.setId(1L);
    }

    @Test
    void testUserHasAttributes() {
        assertThat(user.getId(), is(notNullValue()));
        assertThat(user.getUsername(), is(notNullValue()));
        assertThat(user.getPassword(), is(notNullValue()));
        assertThat(user.getProfile(), is(notNullValue()));
    }

    @Test
    void testUserGetters() {
        assertThat(user.getId(), is(1L));
        assertThat(user.getUsername(), is("admin"));
        assertThat(user.getPassword(), is("password"));

    }

    @Test
    void testSetters() {
        user.setUsername("newadmin");
        user.setPassword("newpassword");

        Profile newProfile = new Profile();

        user.setProfile(newProfile);

        assertThat(user.getUsername(), is("newadmin"));
        assertThat(user.getPassword(), is("newpassword"));

    }

    @Test
    void testUserConstructorWithoutId() {
        User userWithoutId = new User("user2", "password2", profile);
        assertThat(userWithoutId.getId(), is(nullValue()));
        assertThat(userWithoutId.getUsername(), is("user2"));
        assertThat(userWithoutId.getPassword(), is("password2"));
        assertThat(userWithoutId.getProfile(), is(profile));
    }
}

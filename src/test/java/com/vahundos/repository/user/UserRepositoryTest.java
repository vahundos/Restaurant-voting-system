package com.vahundos.repository.user;

import com.vahundos.TestUtil;
import com.vahundos.UserTestData;
import com.vahundos.model.User;
import com.vahundos.repository.AbstractRepositoryTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static com.vahundos.TestUtil.*;
import static com.vahundos.UserTestData.USER1;
import static com.vahundos.UserTestData.USER1_ID;
import static org.assertj.core.api.Assertions.assertThat;

public class UserRepositoryTest extends AbstractRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void testCreate() {
        User created = new User("Новый юзер", "test.mail@mail.ru", "pass123", false);
        User actualSaved = repository.save(created);
        created.setId(actualSaved.getId());

        assertMatch(actualSaved, created);
    }

    @Test
    public void testUpdate() {
        User updated = new User(USER1);
        updated.setPassword("new-password");
        User actualUpdated = repository.save(updated);

        assertMatch(actualUpdated, updated);
    }

    @Test
    public void testGet() {
        assertMatch(repository.get(USER1_ID), USER1);
    }

    @Test
    public void testGetByEmail() {
        assertMatch(repository.getByEmail(USER1.getEmail()), USER1);
    }
}
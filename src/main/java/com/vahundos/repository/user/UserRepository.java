package com.vahundos.repository.user;

import com.vahundos.model.User;

public interface UserRepository {
    User save(User user);

    // null if not found
    User get(int id);

    // null if not found
    User getByEmail(String email);
}

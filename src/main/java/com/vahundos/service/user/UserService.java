package com.vahundos.service.user;

import com.vahundos.model.User;
import com.vahundos.util.exception.NotFoundException;

public interface UserService {

    User create(User user);

    void update(User user);

    User get(int id) throws NotFoundException;

    User getByEmail(String email) throws NotFoundException;
}

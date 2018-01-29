package com.vahundos;

import com.vahundos.model.AbstractBaseEntity;

public class AuthorizedUser {
    private static int id = AbstractBaseEntity.START_SEQ + 1;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        AuthorizedUser.id = id;
    }
}

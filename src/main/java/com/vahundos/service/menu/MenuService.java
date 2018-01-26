package com.vahundos.service.menu;

import com.vahundos.model.Menu;
import com.vahundos.to.menu.MenuTo;

import java.time.LocalDate;

public interface MenuService {
    void create(MenuTo menu);

    void update(MenuTo menu);

    void makeVote(int menuId, int userId, LocalDate date);
}

package com.ohgiraffers.section03.remix.model;

import com.ohgiraffers.dto.MenuDTO;

import java.util.List;
import java.util.Map;

public interface MenuMapper {
    List<MenuDTO> selectAllMenu();

    MenuDTO selectMenuByCode(Map<String, String> stringStringMap);

    int registMenu(MenuDTO menu);

    int updateMenu(MenuDTO menu);

    int deleteMenu(MenuDTO menu);
}

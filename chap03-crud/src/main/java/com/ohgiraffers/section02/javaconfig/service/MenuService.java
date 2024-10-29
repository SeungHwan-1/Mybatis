package com.ohgiraffers.section02.javaconfig.service;

import com.ohgiraffers.dto.MenuDTO;
import com.ohgiraffers.section02.javaconfig.model.MenuMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static com.ohgiraffers.common.Template.getJavaSqlSession;

public class MenuService {

    private MenuMapper menuMapper;

    public List<MenuDTO> selectAllMenu() {
        SqlSession sqlSession = getJavaSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDTO> menuList = menuMapper.selectAllMenu();
        sqlSession.close();
        return menuList;

    }

    public MenuDTO selectMenuByCode(Map<String, String> stringStringMap) {
        SqlSession sqlSession = getJavaSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
        MenuDTO menu = menuMapper.selectMenuByCode(stringStringMap);
        sqlSession.close();
        return menu;
    }

    public boolean registMenu(MenuDTO menuDTO) {
        SqlSession sqlSession = getJavaSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
        int result = menuMapper.registMenu(menuDTO);


        if(result > 0) {
            sqlSession.commit();
        }
        else
            sqlSession.rollback();

        sqlSession.close();

        return result > 0 ? true : false;
    }

    public boolean updateMenu(MenuDTO menu) {
        SqlSession sqlSession = getJavaSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
        int result = menuMapper.updateMenu(menu);


        if(result > 0) {
            sqlSession.commit();
        }
        else
            sqlSession.rollback();

        sqlSession.close();

        return result > 0 ? true : false;
    }

    public boolean deleteMenu(MenuDTO menu) {
        SqlSession sqlSession = getJavaSqlSession();
        menuMapper = sqlSession.getMapper(MenuMapper.class);
        int result = menuMapper.deleteMenu(menu);

        if(result > 0) {
            sqlSession.commit();
        }
        else
            sqlSession.rollback();

        sqlSession.close();
        return result > 0 ? true : false;
    }
}

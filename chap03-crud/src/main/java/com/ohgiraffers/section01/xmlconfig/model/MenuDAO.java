package com.ohgiraffers.section01.xmlconfig.model;

import com.ohgiraffers.dto.MenuDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class MenuDAO {
    public List<MenuDTO> selectAllMenu(SqlSession sqlSession) {

        return sqlSession.selectList("MenuMapper.selectAllMenu");
    }

    public  MenuDTO selectMenuById(SqlSession sqlSession, Map<String, String> stringStringMap) {

        return sqlSession.selectOne("MenuMapper.selectMenuByCode", stringStringMap);
    }

    public int insertMenu(SqlSession sqlSession, MenuDTO menu) {
        return sqlSession.insert("MenuMapper.insertMenu", menu);
    }

    public int updateMenu(SqlSession sqlSession, MenuDTO menu) {
        return sqlSession.update("MenuMapper.updateMenu", menu);
    }

    public int deleteMenu(SqlSession sqlSession, MenuDTO menu) {
        return sqlSession.delete("MenuMapper.deleteMenu", menu);
    }
}

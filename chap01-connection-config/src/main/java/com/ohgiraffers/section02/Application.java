package com.ohgiraffers.section02;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class Application {
    public static void main(String[] args) {
        //mybatis 는 기본적으로 resources 폴더를
        //기준으로 XML 파일을 찾을 수 있다.
        String resource = "mybatis-config.xml";

        SqlSession session = null;
        try {
            //정보를 읽이위한 객체이다.
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            session = sqlSessionFactory.openSession(false);
            //권장 오토커밋지정해줘야 발생할 오류를 예방

            Date date = session.selectOne("mapper.selectSysDate");
            System.out.println(date);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            session.close();
        }
    }
}

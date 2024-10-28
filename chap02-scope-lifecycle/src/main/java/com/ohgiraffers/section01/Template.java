package com.ohgiraffers.section01;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Template {
    /*
     * SQLSessionFactory 는 어플리케이션이 실행되는 동아 ㄴ존재한다.
     * 어플리케이션이 실행되는 동안 여러 차례 SqlSessionFactory를
     * 다시 빌드하지 않는 것이 가장 좋은 형태이다.
     * 어플리케이션 스코프로 관리하기 위한 가장 간단한 방법은
     * 싱글톤 패턴을 이용하는 것이다.
     */
    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSession getSqlSession() {
        if (sqlSessionFactory == null) {
            String resource = "mybatis-config.xml";
            try {

                InputStream inputStream = Resources.getResourceAsStream(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);

            }
        }
        System.out.println("sqlSessionFactory의 해쉬코드 :" + sqlSessionFactory.hashCode());
        return sqlSessionFactory.openSession(false);
        /*
         * openSession() : SqlSession 인터페이스 타입의 객체를 반환하는 메소드
         *
         * SqlSessionFactory는 하나 만들어 둔 후 계속 사용하지만,
         * 그에 반환되는 SqlSession은 호출시마다 새롭게 만들어 리턴해준다..
         * 메모리 효율 측면에서 공장은 한번만 짓고 session이라는 내용물만 매번
         * 새롭게 만들어서 뿌려준다고 생각하면 된다..
         */
    }
}
package com.ohgiraffers.section01;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.util.Date;

public class Application {

    //db정보 필드 작성 1
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";

    private static String URL = "jdbc:mysql://localhost:3306/menudb";

    private static String USER = "gangnam";

    private static String PASS = "gangnam";

    public static void main(String[] args) {

        /*
        * JdbcTransactionFactory : 수동 커밋
        * ManagedTransactionFactory : 오토 커밋
        *
        * ====================================
        * PooledDateSource : ConnectionPool 을 사용함.
        * UnPooledDateSource : 사용하지 않음
        *
         */
        //환경 정보 저장 객체 아이디 트랜잭션종류 풀 사용여부. 2
        Environment environment = new Environment(
            "dev", new JdbcTransactionFactory(),
                new PooledDataSource(DRIVER,URL,USER,PASS)
        );

        //생성한 환경 설정 정보로 Mybatis 설정 객체 생성 4
        Configuration config = new Configuration(environment);
        // 6
        config.addMapper(Mapper.class);
        
        /*
        * sqlSessionFactory : sqlSession 객체를 생성하기 위한 팩토리 역할의 인터페이스
        * sqlSessionFactoryBuilder : sqlSessionFactory 타입의 객체를 생성하기 위한 빌드 역할
        * build() : 설정에 대한 정보를 담고 있는 configuration 타입의 객체 혹은 외부 설정
        * 파일과 연관된 데이터를 매개변수로 전달하면 sqlSessionFactory 타입의 객체를 반환하는 메소드
        *
        * sqlSession : jdbc 의 connection 같은 객체
         */
        // 5 기본적으로 인터페이스 구현체에 넣어서 사용해야하는데
        // 디폴트 sql세션팩토리가 들어있는데 빌드랑 메소드를 통해서 받은거
        // 우린 디폴트 안쓰고 딴거 쓸거야 직접넣어주면 ㅇㅋ몰라

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        System.out.println("sqlSessionFactory = " + sqlSessionFactory);
        SqlSession session = sqlSessionFactory.openSession(false);
        //공장통해서 받을걸 받아서 사용해라 제공해주는걸

        // 7 매퍼중에꺼내온다 어떤 쿼리를 날릴건지
        Mapper mapper = session.getMapper(Mapper.class);
        Date date = mapper.selectDate();
        System.out.println(date);
        session.close();
    }
}

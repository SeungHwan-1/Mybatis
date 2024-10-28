package com.ohgiraffers.section01;

import org.apache.ibatis.annotations.Select;

import java.util.Date;

public interface Mapper {

    //현재 날짜알게해주는 mysql에서 제공해주는거 3
    @Select("SELECT CURDATE() FROM DUAL")
    Date selectDate();
}

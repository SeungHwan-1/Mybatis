package com.ohgiraffers.common;

import com.ohgiraffers.dto.MenuDTO;

import java.util.List;

//결과값을 출력해줄 클래스
public class PrintResult {
    public void printMenuList(List<MenuDTO> menuList) {
        for (MenuDTO menu : menuList){
            System.out.println(menu);
        }
    }

    public void printErrorMessage(String code) {
        String message;
        switch (code){
            case "selectList" : message = "메뉴 전체 조회 실패"; break;
            case "slectbyCode" : message = "코드메뉴실패"; break;
            case "insert" : message = "안됨"; break;
            case "update" : message = "수정안됨";break;
            case "delete" : message = "삭제안됨";break;
            default:message = "잘못된 처리";break;
        }
    }

    public void printMenu(MenuDTO menu) {
        System.out.println(menu);
    }

    public void printSuccessMessage(String code) {
        String message;
        switch (code){
            case "update" : message = "수정성공"; break;
            case "delete" : message = "삭제성공"; break;
            case "insert" : message = "등록성공"; break;
            default:message = "잘못된 처리";break;
        }
        System.out.println(message);
    }
    //결과리턴해주는 html 페이지 용도
}

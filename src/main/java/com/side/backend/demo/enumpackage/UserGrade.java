package com.side.backend.demo.enumpackage;

import java.util.*;

public enum UserGrade {
    ADMIN("관리자"),
    NORMAL("일반 회원"),
    DEVELOPER("개발자 회원"),
    GUEST("미등록 회원");

    private final String label;

    UserGrade(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static List<UserGrade> getUserGradeList() {
        return List.of(UserGrade.ADMIN, UserGrade.NORMAL, UserGrade.DEVELOPER, UserGrade.GUEST);
    }

    public static Map<UserGrade, String> getUserGradeMap() {
        Map<UserGrade, String> userGradeMap = new HashMap<>();
        userGradeMap.put(UserGrade.ADMIN, UserGrade.ADMIN.getLabel());
        userGradeMap.put(UserGrade.NORMAL, UserGrade.NORMAL.getLabel());
        userGradeMap.put(UserGrade.DEVELOPER, UserGrade.DEVELOPER.getLabel());
        userGradeMap.put(UserGrade.GUEST, UserGrade.GUEST.getLabel());
        return userGradeMap;
    }

}

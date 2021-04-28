package me.practice.demo.domains.member;

public enum MemberSex {

    MALE("남성"), FEMALE("여성");

    private String sex;

    MemberSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

}

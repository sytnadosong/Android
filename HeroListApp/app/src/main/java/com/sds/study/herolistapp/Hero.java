package com.sds.study.herolistapp;

/**
 * Created by student on 2016-11-10.
 */
//아무것도 섞여있지 않은 순수한 java 코드를 POJO라고 한다.
public class Hero {
    private String name;
    private String phone;
    private int img;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}

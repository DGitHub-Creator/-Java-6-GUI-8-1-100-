package model;

import java.io.*;
import java.util.Objects;

public class Student implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private String stuNo;
    private String stuName;
    private String stuBirthYear;
    private String stuBirthMonth;
    private String stuBirthDay;
    private String stuSex;
    private String stuProfessionClass;
    private String stuPersonalInformation;
    private String stuAge;

    public Student(String stuNo, String stuName, String stuBirthYear, String stuBirthMonth, String stuBirthDay, String stuSex, String stuProfessionClass, String stuPersonalInformation) {
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.stuBirthYear = stuBirthYear;
        this.stuBirthMonth = stuBirthMonth;
        this.stuBirthDay = stuBirthDay;
        this.stuSex = stuSex;
        this.stuProfessionClass = stuProfessionClass;
        this.stuPersonalInformation = stuPersonalInformation;
        if (Integer.parseInt(stuBirthMonth) < 10) {
            this.stuBirthMonth = "0" + Integer.parseInt(stuBirthMonth);
        }
        if (Integer.parseInt(stuBirthDay) < 10) {
            this.stuBirthDay = "0" + Integer.parseInt(stuBirthDay);
        }
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getStuBirthYear() {
        return stuBirthYear;
    }

    public void setStuBirthYear(String stuBirthYear) {
        this.stuBirthYear = stuBirthYear;
    }

    public String getStuBirthMonth() {
        return stuBirthMonth;
    }

    public void setStuBirthMonth(String stuBirthMonth) {
        this.stuBirthMonth = stuBirthMonth;
    }

    public String getStuBirthDay() {
        return stuBirthDay;
    }

    public void setStuBirthDay(String stuBirthDay) {
        this.stuBirthDay = stuBirthDay;
    }


    public String getStuProfessionClass() {
        return stuProfessionClass;
    }

    public void setStuProfessionClass(String stuProfessionClass) {
        this.stuProfessionClass = stuProfessionClass;
    }

    public String getStuPersonalInformation() {
        return stuPersonalInformation;
    }

    public void setStuPersonalInformation(String stuPersonalInformation) {
        this.stuPersonalInformation = stuPersonalInformation;
    }

    public Student(String stuNo, String stuName, String stuSex, String stuAge) {

        this.stuNo = stuNo;
        this.stuName = stuName;
        this.stuSex = stuSex;
        this.stuAge = stuAge;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public String getStuAge() {
        return stuAge;
    }

    public void setStuAge(String stuAge) {
        this.stuAge = stuAge;
    }

    @Override
    public String toString() {

        return "学号：" + stuNo + "\n" +
                "学生姓名：" + stuName + "\n" +
                "出生日期：" + Integer.parseInt(stuBirthYear) + "年" + stuBirthMonth + "月" + stuBirthDay + "日" + "\n" +
                "性别：" + stuSex + "\n" +
                "专业班级：" + stuProfessionClass + "\n" +
                "个人信息说明：" + stuPersonalInformation + "\n";

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(stuNo, student.stuNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stuNo);
    }
}

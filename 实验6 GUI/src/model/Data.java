package model;

import java.io.*;
import java.util.*;

import model.Student;

public class Data {
    public static List<Student> stus = new ArrayList<>();

    public static List<String> selAllStusNo() {
        List<String> stuNos = new ArrayList<>();
        for (Student s : stus) {
            String stuNo = s.getStuNo();
            stuNos.add(stuNo);
        }
        return stuNos;
    }

    public static Student findStuByNo(String stuNo, String filename) {
        try {
            stus = readStus(filename);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (stus != null) {
            for (Student s : stus) {
                String str = s.getStuNo();
                if (stuNo.equals(str)) {
                    System.out.println(s);
                    return s;
                }
            }
        }

        return null;
    }

    public static boolean delStuByNo(String stuNo) {
        for (Student s : stus) {
            String str = s.getStuNo();
            if (str.equals(stuNo)) {
                stus.remove(s);
                return true;
            }
        }
        return false;
    }

    public static boolean insStudent(Student stu) {
        if (!stus.contains(stu)) {
            stus.add(stu);
            return true;
        } else {
            System.out.println("此学生已存在，请检查输入信息。");
            return false;
        }

    }

    public static void writeStus(String file) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(stus);
    }

    public static List<Student> readStus(String file) throws Exception {
        File f = new File(file);
        if (!f.exists()) {
            return null;
        }
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Object o = ois.readObject();
        if (o instanceof List) {
            stus = (List<Student>) o;
            System.out.println("-----文件已读出-----");
            return stus;
        }
        return null;
    }

}

package main;

import model.Data;
import model.Student;
import view.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        String filename = "Students.data";

        new MainFrame(filename);

        List<Student> stus;
        try {
            stus = Data.readStus(filename);
            if (stus != null) {
                for (Student s : stus) {
                    System.out.println(s.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

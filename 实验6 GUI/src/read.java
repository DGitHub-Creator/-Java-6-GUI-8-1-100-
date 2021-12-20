import model.Data;
import model.Student;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class read {

    public static void main(String[] args) {

        String[] str;
        int year = 1900;
        Data time = new Data();
        System.out.println(time);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String ss = df.format(new Date());
        System.out.println(ss.substring(0, 4));
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间

        List<Student> stus;
        try {
            stus = Data.readStus("Students.data");
            if (stus != null) {
                System.out.println("--------stuList的长度：" + stus.size());
                for (Student s : stus) {
                    System.out.println("==========");
                    System.out.println(s.toString());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

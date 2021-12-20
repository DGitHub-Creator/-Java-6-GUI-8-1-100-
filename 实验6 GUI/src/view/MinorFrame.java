package view;

import java.awt.*;

import model.Student;

import javax.swing.*;

public class MinorFrame extends JFrame {


    JLabel titel = new JLabel("学生基本信息", JLabel.CENTER);
    JTextArea stuInformation = new JTextArea();

    public MinorFrame(Student s) {

        Dimension di = Toolkit.getDefaultToolkit().getScreenSize(); // 获取屏幕大小
//        System.out.println(di.width + "*" + di.height);

        this.setLayout(null);
        this.setTitle("学生基本信息");
        this.setSize(600, 400);
        this.setLocation((di.width - 600) / 2, (di.height - 600) / 2);

        titel.setFont(new Font("仿宋", Font.BOLD, 30));
        titel.setBounds(0, 0, 600, 50);


        stuInformation.append(s.toString());
        stuInformation.setLineWrap(true);
        JScrollPane jsp = new JScrollPane(stuInformation);

        stuInformation.setFont(new Font("宋体", Font.BOLD, 20));
        stuInformation.setBounds(100, 60, 400, 250);
        stuInformation.setEditable(false);

        this.add(titel);
        this.add(stuInformation);
        this.add(jsp);
        this.setVisible(true);

    }
}

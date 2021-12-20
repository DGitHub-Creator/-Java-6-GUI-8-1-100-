package view;

import model.Data;
import model.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InquireFrame extends JFrame {


    JTextField stuNoTxt = new JTextField();
    JLabel stuNoLabel = new JLabel("请输入学号:");
    JLabel titel = new JLabel("查询学生基本信息", JLabel.CENTER);
    JButton demandButton = new JButton("查询");
    JTextArea stuInformation = new JTextArea();

    public String filename = null;

    public InquireFrame(String filename) {
        this.filename = filename;

        Dimension di = Toolkit.getDefaultToolkit().getScreenSize(); // 获取屏幕大小

        this.setLayout(null);
        this.setTitle("查询学生基本信息");
        this.setSize(600, 500);
        this.setLocation((di.width - 600) / 2, (di.height - 600) / 2);

        titel.setFont(new Font("仿宋", Font.BOLD, 30));
        titel.setBounds(0, 0, 600, 50);

        stuNoLabel.setFont(new Font("宋体", Font.BOLD, 20));
        stuNoLabel.setBounds(100, 60, 120, 30);
        stuNoTxt.setBounds(220, 60, 180, 30);
        demandButton.setBounds(420, 60, 80, 30);

        stuInformation.setLineWrap(true);
        JScrollPane jsp = new JScrollPane(stuInformation);

        stuInformation.setFont(new Font("宋体", Font.BOLD, 20));
        stuInformation.setBounds(100, 100, 400, 300);
        stuInformation.setEditable(false);

        demandButton.addActionListener(new AC());

        this.addWindowListener(new InquireFrame.WA());

        this.add(titel);
        this.add(stuNoLabel);
        this.add(stuNoTxt);
        this.add(demandButton);

        this.add(stuInformation);
        this.add(jsp);

        this.addWindowListener(new WA());

        this.setVisible(true);


    }

    class AC implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            Object o = e.getSource();
            JButton button = null;
            String str = null;
            if (o instanceof JButton) {
                button = (JButton) o;
                str = button.getText();
            }
            if ("查询".equals(str)) {
                stuInformation.setText("");
                String stuNo = stuNoTxt.getText();
                System.out.println(stuNo);
                if (stuNo.equals("")) {
                    JOptionPane.showMessageDialog(null, "输入信息为空，请输入正确的信息.", "标题", JOptionPane.ERROR_MESSAGE);
                } else {
                    Student student = Data.findStuByNo(stuNo, filename);
//                    System.out.println(student.toString());
                    if (student != null) {
                        stuInformation.append(student.toString());
                    } else {
                        stuInformation.append("查无此人，请检查输入信息。");
                    }

                }

            }
        }


    }

    class WA extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            // TODO Auto-generated method stub
            InquireFrame.this.dispose();
        }

    }

}

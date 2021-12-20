package view;

import model.Data;
import model.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MainFrame extends JFrame {

    List stuList = new List();

    JTextField stuNoTxt = new JTextField();
    JTextField stuNameTxt = new JTextField();
    JTextField stuBirthTxt = new JTextField();
    JTextField stuProfesClassTxt = new JTextField();
    JTextField stuPersonInforTxt = new JTextField();

    JTextArea stuPersonInformation = new JTextArea();

    JLabel stuNoLabel = new JLabel("学号:");
    JLabel stuNameLabel = new JLabel("姓名:");
    JLabel stuBirthLabel = new JLabel("出生日期:");
    JLabel stuSexLabel = new JLabel("性别:");
    JLabel stuProfesClassLabel = new JLabel("专业班级:");
    JLabel stuPersonInforLabel = new JLabel("个人信息说明:");

    JLabel stuBirthYearLabel = new JLabel("年");
    JLabel stuBirthMonthLabel = new JLabel("月");
    JLabel stuBirthDayLabel = new JLabel("日");

    String[] stuSex = {"", "男", "女"};
    JComboBox<String> stuSexBox = new JComboBox<>(stuSex);
    JComboBox<String> stuYearBox = new JComboBox<>(initYear());
    String[] stuMonth = {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
    JComboBox<String> stuMonthBox = new JComboBox<>(stuMonth);
    JComboBox<String> stuDayBox = new JComboBox<>();

    public String[] initYear() {

        int beginYear = 1900;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String ss = df.format(new Date()).substring(0, 4);

        int endYear = Integer.parseInt(ss);
        String[] str = new String[endYear - beginYear + 2];
        str[0] = "";
        int fg = 1;
        for (int i = endYear; i >= beginYear; i--) {
            str[fg] = String.valueOf(i);
            fg++;
        }
        return str;

    }


    public String[] initDay(int day) {
        String[] str = new String[day + 1];
        str[0] = "";
        for (int i = 1; i <= day; i++) {
            str[i] = String.valueOf(i);
        }
        return str;
    }

    JLabel titel = new JLabel("学生基本信息录入界面");
    JButton confirmButton = new JButton("确定");
    JButton cancelButton = new JButton("取消");
    JButton inquireButton = new JButton("查询");

    public String filename = null;

    public MainFrame(String filename) {

        this.filename = filename;

        Dimension di = Toolkit.getDefaultToolkit().getScreenSize(); // 获取屏幕大小
//        System.out.println(di.width + "*" + di.height);

        this.setLayout(null);
        this.setTitle("学生基本信息录入界面");
        this.setSize(1000, 600);

        this.setLocation((di.width - 1000) / 2, (di.height - 800) / 2);

        titel.setFont(new Font("仿宋", Font.BOLD + Font.ITALIC, 30));
        titel.setBounds(350, 50, 400, 50);

        stuNoLabel.setFont(new Font("宋体", Font.BOLD, 20));
        stuNameLabel.setFont(new Font("宋体", Font.BOLD, 20));
        stuBirthLabel.setFont(new Font("宋体", Font.BOLD, 20));
        stuSexLabel.setFont(new Font("宋体", Font.BOLD, 20));
        stuProfesClassLabel.setFont(new Font("宋体", Font.BOLD, 20));
        stuPersonInforLabel.setFont(new Font("宋体", Font.BOLD, 20));
        stuBirthYearLabel.setFont(new Font("宋体", Font.BOLD, 20));
        stuBirthMonthLabel.setFont(new Font("宋体", Font.BOLD, 20));
        stuBirthDayLabel.setFont(new Font("宋体", Font.BOLD, 20));


        stuNoLabel.setBounds(230, 150, 100, 20);
        stuNameLabel.setBounds(230, 200, 100, 20);
        stuPersonInforLabel.setBounds(190, 310, 140, 20);
        stuSexLabel.setBounds(560, 150, 100, 20);
        stuProfesClassLabel.setBounds(520, 200, 100, 20);

        stuNoTxt.setBounds(330, 150, 120, 20);
        stuNameTxt.setBounds(330, 200, 120, 20);
        stuPersonInformation.setBounds(330, 310, 450, 100);
        stuSexBox.setBounds(660, 150, 120, 20);
        stuProfesClassTxt.setBounds(660, 200, 120, 20);

        stuBirthLabel.setBounds(230, 250, 100, 20);
        stuYearBox.setBounds(330, 250, 60, 20);
        stuBirthYearLabel.setBounds(390, 250, 30, 20);
        stuMonthBox.setBounds(420, 250, 45, 20);
        stuBirthMonthLabel.setBounds(465, 250, 30, 20);
        stuDayBox.setBounds(495, 250, 45, 20);
        stuBirthDayLabel.setBounds(540, 250, 30, 20);

        stuYearBox.addActionListener(e -> {
            if (!(stuMonthBox.getSelectedItem() == "") && !(stuYearBox.getSelectedItem() == "")) {
                String stryear = ((String) stuYearBox.getSelectedItem());
                assert stryear != null;
                int year = Integer.parseInt(stryear);
                String month = (String) stuMonthBox.getSelectedItem();
                String[] stuDay = initDay(30);
                String[] bigMonth = {"1", "3", "5", "7", "8", "10", "12"};
                if (Arrays.asList(bigMonth).contains(month))
                    stuDay = initDay(31);
                if (month == "2") {
                    if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
                        stuDay = initDay(29);
                    else
                        stuDay = initDay(28);
                }
                stuDayBox.setModel(new DefaultComboBoxModel<>(stuDay));
            }

        });

        stuMonthBox.addActionListener(e -> {
            if (!(stuMonthBox.getSelectedItem() == "") && !(stuYearBox.getSelectedItem() == "")) {
                String stryear = ((String) stuYearBox.getSelectedItem());
                assert stryear != null;
                int year = Integer.parseInt(stryear);
                String month = (String) stuMonthBox.getSelectedItem();
                String[] stuDay = initDay(30);
                String[] bigMonth = {"1", "3", "5", "7", "8", "10", "12"};
                if (Arrays.asList(bigMonth).contains(month))
                    stuDay = initDay(31);
                if ((month == "2")) {
                    if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
                        stuDay = initDay(29);
                    else
                        stuDay = initDay(28);
                }
                stuDayBox.setModel(new DefaultComboBoxModel<>(stuDay));
            }

        });


        confirmButton.setBounds(300, 450, 100, 30);
        cancelButton.setBounds(600, 450, 100, 30);
        inquireButton.setBounds(900, 450, 100, 30);

        confirmButton.addActionListener(new AC());
        cancelButton.addActionListener(new AC());
        inquireButton.addActionListener(new AC());

        this.addWindowListener(new WA());

        this.add(titel);
        this.add(stuNoLabel);
        this.add(stuNameLabel);
        this.add(stuBirthLabel);
        this.add(stuSexLabel);
        this.add(stuProfesClassLabel);
        this.add(stuPersonInforLabel);

        this.add(stuNoTxt);
        this.add(stuNameTxt);
        this.add(stuBirthTxt);
        this.add(stuSexBox);
        this.add(stuProfesClassTxt);
        this.add(stuPersonInforTxt);
        this.add(stuPersonInformation);

        this.add(stuBirthYearLabel);
        this.add(stuYearBox);
        this.add(stuBirthMonthLabel);
        this.add(stuMonthBox);
        this.add(stuBirthDayLabel);
        this.add(stuDayBox);

        this.add(confirmButton);
        this.add(cancelButton);
        this.add(inquireButton);

        this.add(stuList);
        this.setVisible(true);

        this.addWindowListener(new WA());
    }


    class AC implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            Object o = e.getSource();
            JButton button = null;
            String buttonLabel = null;
            if (o instanceof JButton) {
                button = (JButton) o;
                buttonLabel = button.getText();
            }

            if ("确定".equals(buttonLabel)) {
                String stuNo = stuNoTxt.getText();
                String stuName = stuNameTxt.getText();
                String stuBirthYear = (String) stuYearBox.getSelectedItem();
                String stuBirthMonth = (String) stuMonthBox.getSelectedItem();
                String stuBirthDay = (String) stuDayBox.getSelectedItem();
                String stuSex = (String) stuSexBox.getSelectedItem();
                String stuProfesClass = stuProfesClassTxt.getText();
                String stuPersonInforma = stuPersonInformation.getText();
                if ((stuNo.equals(""))
                        || (stuName.equals(""))
                        || (stuBirthYear.equals(""))
                        || (stuBirthMonth.equals(""))
                        || (stuBirthDay.equals(""))
                        || (stuSex.equals(""))
                        || (stuProfesClass.equals(""))
                        || (stuPersonInforma.equals(""))) {
                    JOptionPane.showMessageDialog(null, "输入信息为空，请输入正确的信息.", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else if (!(Integer.parseInt(stuBirthYear) > 1900 && (Integer.parseInt(stuBirthYear) < 2022))
                        || (!(Integer.parseInt(stuBirthMonth) > 0 && Integer.parseInt(stuBirthMonth) <= 12))
                        || (!(Integer.parseInt(stuBirthDay) > 0 && Integer.parseInt(stuBirthDay) <= 31))) {
                    JOptionPane.showMessageDialog(null, "出生日期错误，请输入正确的日期.", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    Student stu = new Student(stuNo, stuName, stuBirthYear, stuBirthMonth, stuBirthDay, stuSex, stuProfesClass, stuPersonInforma);
//                System.out.println(stu);
//                MainFrame.this.dispose();
                    if (Data.insStudent(stu)) {
                        try {
                            Data.writeStus(filename);
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
//                        JOptionPane.showMessageDialog(null, stu.toString(),"信息已录入", JOptionPane.INFORMATION_MESSAGE);
                        new MinorFrame(stu);
                        stuNoTxt.setText("");
                        stuNameTxt.setText("");
                        stuYearBox.setSelectedIndex(0);
                        stuMonthBox.setSelectedIndex(0);
                        stuDayBox.setSelectedIndex(0);
                        stuPersonInformation.setText("");
                        stuSexBox.setSelectedIndex(0);
                        stuProfesClassTxt.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "此学生已存在，请检查输入信息.", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }


                }

            }
            if ("取消".equals(buttonLabel)) {
                try {
                    Data.writeStus(filename);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                System.exit(0);
            }
            if ("查询".equals(buttonLabel)) {
                new InquireFrame(filename);
            }
        }

    }

    class WA extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            // TODO Auto-generated method stub
            try {
                Data.writeStus(filename);
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } finally {
                System.exit(0);
            }
        }

    }
}

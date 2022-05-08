package ddd.start;

import ddd.util.Const;

import javax.swing.*;
import java.awt.*;


public class Carculator extends JFrame {
    private JPanel jp_north = new JPanel();
    private JTextArea textArea;
    private JTextField txt = new JTextField();
    private JButton[][] button = new JButton[5][4]; //20个按钮

    public Carculator() throws HeadlessException {
        this.init();
        this.addNorthComponent();
        this.addCenterButton();
        this.event();
    }

    public void init(){
        this.setTitle("计算器");
        this.setSize(Const.FRAME_W,Const.FRAME_H);
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        this.setLocation(Const.FRAME_X,Const.FRAME_Y);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //程序窗体的设置

    }
    /*北部控件*/
    public void addNorthComponent(){
        this.txt.setPreferredSize(new Dimension(400,80));
        jp_north.add(txt);
        txt.setFont(new Font("宋体", Font.PLAIN, 28));
        // 设置字体，风格和字号

        this.add(jp_north,BorderLayout.NORTH);
        //文本框设置
    }
    /*中间控件*/
    public void addCenterButton(){
        String [][] str = {
                {"(", ")", "c", "<—"},
                {"7", "8", "9", "+"},
                {"4", "5", "6", "-"},
                {"1", "2", "3", "*"},
                {"0", ".", "=", "/"},
        };
        JPanel jp_center = new JPanel();
        jp_center.setLayout(new GridLayout(5, 4));
        for (int i = 0; i < 5; i++) { //插入各个功能、数字按钮
            for (int j = 0; j < 4; j++) {
                button[i][j] = new JButton(str[i][j]);
                button[i][j].setFont(new Font("Times New Roman", Font.PLAIN, 28)); //设置按钮字体、样式、大小
                jp_center.add(button[i][j]);
            }
        }
        add(jp_center);
    }
    //监视器设置
    public void event(){
        StringBuffer r=new StringBuffer();
        button[1][0].addActionListener(e -> {
            r.append("7");
            txt.setText(r.toString());
        });
        button[1][1].addActionListener(e -> {
            r.append("8");
            txt.setText(r.toString());
        });
        button[1][2].addActionListener(e -> {
            r.append("9");
            txt.setText(r.toString());
        });
        button[2][0].addActionListener(e -> {
            r.append("4");
            txt.setText(r.toString());
        });
        button[2][1].addActionListener(e -> {
            r.append("5");
            txt.setText(r.toString());
        });
        button[2][2].addActionListener(e -> {
            r.append("6");
            txt.setText(r.toString());
        });
        button[0][0].addActionListener(e -> {
            r.append("(");
            txt.setText(r.toString());
        });
        button[0][1].addActionListener(e -> {
            r.append(")");
            txt.setText(r.toString());
        });
        button[3][0].addActionListener(e -> {
            r.append("1");
            txt.setText(r.toString());
        });
        button[3][1].addActionListener(e -> {
            r.append("2");
            txt.setText(r.toString());
        });
        button[3][2].addActionListener(e -> {
            r.append("3");
            txt.setText(r.toString());
        });
        button[4][0].addActionListener(e -> {
            r.append("0");
            txt.setText(r.toString());
        });
        button[1][3].addActionListener(e -> {
            r.append("+");
            txt.setText(r.toString());
        });
        button[4][3].addActionListener(e -> {
            r.append("/");
            txt.setText(r.toString());
        });
        button[3][3].addActionListener(e -> {
            r.append("*");
            txt.setText(r.toString());
        });
        button[4][1].addActionListener(e -> {
            r.append(".");
            txt.setText(r.toString());
        });
        button[2][3].addActionListener(e -> {
            r.append("-");
            txt.setText(r.toString());
        });
        button[0][2].addActionListener(e -> {
            r.delete(0,r.length());   //清空字符串中的内容
            txt.setText(r.toString());  //将结果显示在文本框中
        });
        button[4][2].addActionListener(e -> {
            r.append("=");
            String str=r.toString();
            txt.setText("");
            double result= Computer.solution(str);
            String string=String.valueOf(result);
            r.delete(0,r.length());
            r.append(string);
            txt.setText(string);
        });
        button[0][3].addActionListener(e -> {
            r.delete(r.length()-1,r.length());
            txt.setText(r.toString());
        });
    }

    public static void main(String[] args) {
        Carculator carculator=new Carculator();
        carculator.setVisible(true);
    }
}
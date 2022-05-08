package text;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class text {
    public static String s;
    public static int num[] = new int[2] , k = 0;
    public static JFrame JF;
    public static JButton jb,p1,p2,p3,p4,p5;
    public static JTextField jt;
    public static JPanel jp;

    public static void main(String[] args) {
        JF = new JFrame("计算器");
        JF.setLocation(450,250);
        JF.setSize(300,400);//设置窗口

        jt = new JTextField(30);
        jt.setPreferredSize(new Dimension(300,100));
        jt.setEditable(false);
        jt.setHorizontalAlignment(JTextField.RIGHT);
        jt.setFont(new Font("chuTi",Font.BOLD,20){

        });
        JF.add( jt , BorderLayout.NORTH);//文本框


        jp = new JPanel();
        jp.setLayout(new GridLayout(3,5,10,10));//网格布局

        Actions as = new Actions();//监听事件
        for (int i = 0; i < 10; i++) {
            jb =  new JButton(i+"");
            jp.add(jb);
            jb.addActionListener(as);//添加时间
        }


        p1 = new JButton("+");
        p2 = new JButton("-");
        p3 = new JButton("*");
        p4 = new JButton("/");
        p5 = new JButton("=");
        p1.addActionListener(as);
        p2.addActionListener(as);
        p3.addActionListener(as);
        p4.addActionListener(as);
        p5.addActionListener(as);
        jp.add(p1);
        jp.add(p2);
        jp.add(p3);//运算符
        jp.add(p4);
        jp.add(p5);

        JF.add(jp);

        JF.setDefaultCloseOperation(JF.EXIT_ON_CLOSE);
        JF.setVisible(true);
    }

    public static class Actions implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            jt.setText(e.getActionCommand());

            if (    Objects.equals(e.getActionCommand(), "*") |
                    Objects.equals(e.getActionCommand(), "-") |
                    Objects.equals(e.getActionCommand(), "+") |
                    Objects.equals(e.getActionCommand(), "/") ){
                s = e.getActionCommand();
                k++;
                jt.setText(num[k-1] + " " + s + "");
            }else if (Objects.equals(e.getActionCommand(), "=")  ){
                if (s.equals("+")){
                    jt.setText(num[0] + " + " + num[1] + "" + " = " +(num[0] + num[1]) + "");
                }else if (s.equals("-")){
                    jt.setText(num[0] + " - " + num[1] + "" + " = " +(num[0] - num[1]) + "");
                }else if (s.equals("*")){
                    jt.setText(num[0] + " × " + num[1] + "" + " = " +(num[0] * num[1]) + "");
                }else if (s.equals("/")){
                    jt.setText(num[0] + " ÷ " + num[1] + "" + " = " +(num[0] / (num[1] + 0.0)) + "");
                }




            }else {
                if (s == null){
                    num[k] = num[k] * 10 + Integer.parseInt(e.getActionCommand());
                    jt.setText(num[k] + "");
                }else {
                    num[k] = num[k] * 10 + Integer.parseInt(e.getActionCommand());
                    jt.setText(num[k-1] + " " + s +" "+ num[k] + "");
                }

            }


        }
    }
}

package ddd.start;
import java.util.Stack;

public class Computer {
    public static double solution(String str) {
        Stack<Double> numStack = new Stack<>();
        Stack<Character> signalStack = new Stack<>();
        int index = 0;// 记录已经执行的符号数
        int len = str.length();
        while (index < len) {
            char c = str.charAt(index); // 取出这一步的符号
            if (c == '(') {
                signalStack.push(c);// 若是左括号就进栈
            }
            // 否则要先判断优先级
            else if (c == '+' || c == '-' || c == '*' || c == '/') {
                int currOperLevel = getOperlevel(c);// 当前符号的优先级
                while (true) {
                    int stackOperLevel = 0;// 栈顶元素的优先级
                    if (!signalStack.isEmpty()) {
                        Object obj = signalStack.peek();
                        stackOperLevel = getOperlevel((char) obj);
                    }
                    // 若当前元素优先级大于栈顶元素的优先级则入栈
                    if (currOperLevel > stackOperLevel) {
                        signalStack.push(c);
                        break;// 直到让比自己优先级高的符号都出栈运算了再把自己进栈
                    } else {// 不能入栈就进行计算
                        try {
                            char optemp = '0';
                            double num1 = 0;
                            double num2 = 0;
                            if (!signalStack.isEmpty()) {
                                optemp = signalStack.pop();// 取出优先级大的那个符号
                            }
                            if (!numStack.isEmpty()) {
                                num1 = numStack.pop();
                                num2 = numStack.pop();// 取出数据栈中的两个数
                            }
                            numStack.push(caculateResult(optemp, num2, num1));// 将算出来的结果数据再次进入数据栈
                        } catch (Exception e) {
                            // TODO: handle exception
                            e.printStackTrace();
                        }
                    }
                }
            } else if (c == ')') {// 右括号就返回栈顶元素，右括号是不进栈的
                while (true) {
                    char theop = signalStack.pop();
                    if (theop == '(') {
                        break;
                    } else {
                        try {
                            double num1 = numStack.pop();
                            double num2 = numStack.pop();
                            numStack.push(caculateResult(theop, num2, num1));// 运算括号内的内容
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else if (c >= '0' && c <= '9') {
                int tempIndex = index + 1;
                while (tempIndex < len) {
                    char temp = str.charAt(tempIndex);// 取字符串中处于当前字符的下一位
                    if ((temp >= '0' && temp <= '9') || temp == '.') {
                        tempIndex++;// 若为数字则继续向后取
                    } else {
                        break;// 证明数字去完
                    }
                }
                String numstr = str.substring(index, tempIndex);// 截取这个字符串则为两个符号之间的数字
                try {
                    double numnum = Double.parseDouble(numstr);// 将数字转换成整型便于运算
                    numStack.push(numnum);
                    index = tempIndex - 1;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            index++;
        }
        // 检查符号栈是否为空
        while (true) {
            Object obj = null;
            if (!signalStack.isEmpty()) {
                obj = signalStack.pop();
            }
            if (obj == null) {
                break;// 为空证明运算已结束
            } else {// 不为空就出栈运算
                char opterTemp = (char) obj;
                double num1 = numStack.pop();
                double num2 = numStack.pop();
                numStack.push(caculateResult(opterTemp, num2, num1));
            }
        }
        double result = 0;
        try {
            result = numStack.pop();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return result;
    }

    //计算加减乘除余
    private static Double caculateResult(char optemp, double num1, double num2) {

        switch (optemp) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
        }
        return 0.0;
    }

    //返回符号优先级
    private static int getOperlevel(char c) {

        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }
}



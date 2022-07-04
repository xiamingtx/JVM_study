package java1;

/**
 * @author 夏明
 * @version 1.0
 *
 * 方法的结束方式分为两种:
 *  1. 正常结束 以return为代表
 *  2. 方法执行中出现未捕获的异常, 以抛出异常的方式结束
 *
 *  栈帧的内部结构
 *  每个栈帧中存储着:
 *      局部变量表（Local variables)
 *      操作数栈（operand stack）(或表达式栈)
 *      动态链接(Dynamic Linking)(或指向运行时常量池的方法引用)
 *      方法返回地址(Return Address)(或方法正常退出或者异常退出的定义)
 *      一些附加信息
 */
public class StackFrameTest {
    public static void main(String[] args) {
        try {
            StackFrameTest test = new StackFrameTest();
            test.method1();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("main()正常结束");
    }

    public void method1() {
        System.out.println("method1()开始执行");
        method2();
        System.out.println("method1()执行结束");
        System.out.println(10 / 0);
    }

    public int method2() {
        System.out.println("method2()开始执行");
        int i = 10;
        int m = (int)method3();
        System.out.println("method2()即将结束");
        return i + m;
    }

    public double method3() {
        System.out.println("method3()开始执行");
        double j = 20.0;
        System.out.println("method3()即将结束");
        return j;
    }
}

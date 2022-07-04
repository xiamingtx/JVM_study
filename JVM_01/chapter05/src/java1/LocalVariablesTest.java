package java1;

import java.util.Date;

/**
 * @author 夏明
 * @version 1.0
 *
 * 局部变量表也被称之为局部变量数组或本地变量表
 * 定义为一个数字数组，主要用于存储方法参数和定义在方法体内的局部变量这些数据类型包括各类基本数据类型、对象引用(reference)，以及returnAddress类型。
 * 由于局部变量表是建立在线程的栈上，是线程的私有数据，因此不存在数据安全问题
 * 局部变量表所需的容量大小是在编译期确定下来的，并保存在方法的Code属性的maximum local variables数据项中。在方法运行期间是不会改变局部变量表的大小的。
 */
public class LocalVariablesTest {
    private int count = 0;

    public static void main(String[] args) {
        LocalVariablesTest test = new LocalVariablesTest();
        int num = 10;
        test.test1();
    }

    public LocalVariablesTest() {
        this.count = 1;
    }

    // 练习
    public static void testStatic() {
        LocalVariablesTest test = new LocalVariablesTest();
        Date date = new Date();
        int count = 10;
        System.out.println(count);
        // 因为this变量不存在于当前方法的局部变量表中! 所以无法使用this
//        System.out.println(this.count);
    }

    // 关于slot的使用的理解
    public void test1() {
        Date date = new Date();
        String name1 = "atguigu.com";
//        String info = test2(date, name1);
        test2(date, name1); // 这样就不占据局部变量的位置
        System.out.println(date + name1);
    }

    public String test2(Date dateP, String name2) {
        dateP = null;
        name2 = "xm";
        double weight = 130.5; // 占据两个slot
        char gender = '男';
        return dateP + name2;
    }

    public void test3() {
        count++;
    }

    public void test4() {
        int a = 0;
        {
            int b = 4;
            b = a + 1;
        }
        // 变量c使用之前已经销毁的变量b占据的slot的位置
        int c = a + 1;
    }

    /**
     * 变量的分类:
     *      按照数据类型分: 1.基本数据类型 2.引用数据类型
     *      按照在类中声明的位置分: 1. 成员变量: 在使用前都经历过默认初始化赋值
     *                                  类变量: linking的prepare阶段: 给类变量默认赋值 ---> initial阶段: 给类变量显式赋值即静态代码块赋值
     *                                  实例变量: 随着对象的创建, 会在堆空间中分配实例变量空间, 并进行默认赋值
     *                          2. 局部变量: 在使用前, 必须要进行显式赋值! 否则, 编译不通过
     *
     * 补充说明
     *      在栈帧中，与性能调优关系最为密切的部分就是前面提到的局部变量表。
     *          在方法执行时，虚拟机使用局部变量表完成方法的传递。
     *      局部变量表中的变量也是重要的垃圾回收根节点，只要被局部变量表中直接或间接引用的对象都不会被回收。
     * @author 夏明
     *
     * @date 2022/5/28 15:04
     * @param
     */
    public void test5Temp() {
        int num;
        // System.out.println(num); // 错误信息 Variable 'num' might not have been initialized
    }
}

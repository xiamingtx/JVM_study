package java1;

/**
 * 《深入理解Java虚拟机》中的案例:
 * staticObj、 instanceObj、 localObj存放在哪里?
 * @author 夏明
 * @version 1.0
 */
public class StaticObjTest {
    static class Test {
        static ObjectHolder staticObj = new ObjectHolder();
        ObjectHolder instanceObj = new ObjectHolder();

        void foo() {
            ObjectHolder localObj = new ObjectHolder();
            System.out.println("done");
        }
    }

    private static class ObjectHolder {

    }

    public static void main(String[] args) {

    }
}

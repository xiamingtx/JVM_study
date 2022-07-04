package java1;

/**
 * @author 夏明
 * @version 1.0
 */
public class DynamicLinkingTest {

    int num = 10;

    public void methodA() {
        System.out.println("methodA()......");
    }

    public void methodB() {
        System.out.println("methodB()......");

        methodA();

        num ++ ;
    }
}

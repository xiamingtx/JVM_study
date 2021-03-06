package java1;

/**
 * 结论:
 * 静态引用对应的对象实体始终都存在堆空间
 *
 * jdk7:
 * -Xms200m -Xmx200m -XX:PermSize=300m -XX:MaxPermSize=300m -XX:+PrintGCDetails
 * jdk 8:
 * -Xms200m -Xmx200m -XX:MetaSpaceSize=300m -XX:MaxMetaspaceSize=300m -XX: +PrintGCDetails
 * @author 夏明
 * @version 1.0
 */
public class StaticFieldTest {
    private static byte[] arr = new byte[1024 * 1024 * 100]; // 100MB

    public static void main(String[] args) {
        System.out.println(StaticFieldTest.arr);

    }
}

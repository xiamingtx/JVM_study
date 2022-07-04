package java1;

/**
 * 测试-XX:UseTLAB参数是否开启的情况: 默认情况是开启的
 *
 * TLAB的再说明:
 *  1.尽管不是所有的对象实例都能够在TLAB中成功分配内存，但JVM确实是将TLAB作为内存分配的首选。
 *  2.在程序中，开发人员可以通过选项“-XX:UseTLAB”设置是否开启TLAB空间。
 *  3.默认情况下，TLAB空间的内存非常小，仅占有整个Eden空间的1%,
 *  当然我们可以过选项“-XX:TLABWasteTargetPercent”设置TLAB空间所占用Eden空间的百分比大小。
 *  4.一旦对象在TLAB空间分配内存失败时，JVM就会尝试着通过使用加锁机制确保数据操作的原子性, 从而直接在Eden空间中分配内存
 * @author 夏明
 * @version 1.0
 */
public class TLABArgsTest {
    public static void main(String[] args) {
        System.out.println("我只是来打个酱油");
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

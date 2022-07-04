package java1;

/**
 *  测试:大对象直接进入老年代
 * -Xms60m -Xmx60m -XX:NewRatio=2 -Xx:SurvivorRatio=8 -XX:+PrintGCDetails
 * @author 夏明
 * @version 1.0
 */
public class YoungOldAreaTest {
    public static void main(String[] args) {
        byte[] buffer = new byte[1024 * 1024 * 20]; // 20m
    }
}

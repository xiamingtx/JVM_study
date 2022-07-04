package java1;

/**
 * @author 夏明
 * @version 1.0
 */
public class OperandStackTest {
    public void testAddOperation() {
        // byte、short、char、boolean: 都以int型来保存

        byte i = 15;
        int j = 8;
        int k = i + j;

//        int m = 800;
    }

    public int getSum() {
        int m = 10;
        int n = 20;
        int k = m + n;
        return k;
    }

    public void testGetSum() {
        int i = getSum();
        int j = 10;
    }

    /**
     *
     * @author 夏明
     * @date 2022/5/28 16:08
     * 程序员面试的过程中, 常见的 i ++ 和 ++ i的区别, 放到字节码篇章再做解释
     */

    public void add() {
        // 第一类问题
        int i1 = 10;
        i1 ++ ;

        int i2 = 10;
        ++ i2;

        // 第二类问题
        int i3 = 10;
        int i4 = i3 ++ ;

        int i5 = 10;
        int i6 = ++ i5;

        // 第三类问题
        int i7 = 10;
        i7 = i7 ++ ;

        int i8 = 10;
        i8 = ++ i8;

        // 第四类问题
        int i9 = 10;
        int i10 = i9 ++  + ++ i9;
    }
}

package com.atguigu.java2;

/**
 * 逃逸分析
 *
 * 如何快速的判断是否发生了逃逸分析, 大家就看new的对象是否可能在方法外被调用
 * 参数设置:
 * 在JDK 6u23版本之后，HotSpot中默认就已经开启了逃逸分析。。如果使用的是较早的版本，开发人员则可以通过:
 * >选项“一xx:+DOEscapeAnalysis"显式开启逃逸分析
 * >通过选项“-XX: +PrintEscapeAnalysis"查看逃逸分析的筛选结果。
 * @author 夏明
 * @version 1.0
 */
public class EscapeAnalysis {
    public EscapeAnalysis obj;

    /**
     *方法返回EscapeAnalysis对象, 发生逃逸
     * @author 夏明
     * @date 2022/5/30 12:56
     */
    public EscapeAnalysis getInstance() {
        return obj == null ? new EscapeAnalysis() : obj;
    }

    /**
     * 为成员属性赋值, 发生逃逸
     * @author 夏明
     * @date 2022/5/30 12:58
     */
    public void setObj() {
        this.obj = new EscapeAnalysis();
    }

    // 思考, 如果当前的obj引用声明为static的? 仍然会发生逃逸
    /**
     * 对象的作用域仅在当前方法中有效, 没有发生逃逸
     * @author 夏明
     * @date 2022/5/30 13:00
     */
    public void useEscapeAnalysis() {
        EscapeAnalysis e = new EscapeAnalysis();
    }

    /**
     * 引用成员变量的值, 发生逃逸
     * @author 夏明
     * @date 2022/5/30 13:01
     */
    public void useEscapeAnalysis1() {
        EscapeAnalysis e = getInstance();
        // getInstance().xxx() 同样会发生逃逸
    }

}

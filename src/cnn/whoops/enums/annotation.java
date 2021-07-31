package cnn.whoops.enums;

/**
 * @author: whoops
 * @date: 2021/7/28 - 15:27
 * @description:
 *
 * 注解：Annotation
 * JDK中的元注解
 * Retention：指定所修饰的 Annotation 的生命周期：SOURCE\CLASS(默认行为)\RUNTIME
 *              只有声明为RUNTIME生命周期的注解，才能通过反射获取
 * Target：用于指定被修饰的 Annotation 能用于修饰哪些程序元素
 * Documented：表示所修饰的注解在被 javadoc 解析时，保留下来
 * Inherited：被它修饰的 Annotation 将具有继承性
 *
 * JDK 8 中注解的新特性：
 *
 * 可重复性注解：@Repeatable
 *
 * 类型注解：
 *  ElementType.TYPE_PARAMETER 表示该注解能写在类型变量的声明语句中（如：泛型声明）。
 *  ElementType.TYPE_USE 表示该注解能写在使用类型的任何语句中。
 *
 */
public class annotation {
}

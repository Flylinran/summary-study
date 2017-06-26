package lambda;

import java.util.function.Supplier;

/**
 * author: Flyli
 * date: 2017/6/25 16:13
 * description: 自定义函数式接口
 * <p>
 * Java 8用默认方法与静态方法这两个新概念来扩展接口的声明。
 * 默认方法使接口有点像Traits（Scala中特征(trait)类似于Java中的Interface，但它可以包含实现代码，也就是目前Java8新增的功能），
 * 但与传统的接口又有些不一样，它允许在已有的接口中添加新方法，而同时又保持了与旧版本代码的兼容性。
 * <p>
 * 默认方法与抽象方法不同之处在于抽象方法必须要求实现，但是默认方法则没有这个要求。
 * 相反，每个接口都必须提供一个所谓的默认实现，
 * 这样所有的接口实现者将会默认继承它（如果有必要的话，可以覆盖这个默认实现）。
 */
@FunctionalInterface
public interface MyPredicate<T> {

    boolean filter(T t);

    /**
     * 用关键字default声明了一个默认方法
     */
    default void defaultMethod() {
    }

    /**
     * 接口可以声明（并且可以提供实现）静态方法
     *
     * @param supplier
     * @return
     */
    static MyPredicate create(Supplier<MyPredicate> supplier) {
        return supplier.get();
    }
}

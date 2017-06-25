package lambda;

/**
 * author: Flyli
 * date: 2017/6/25 16:13
 * description: 自定义函数式接口
 */
@FunctionalInterface
public interface MyPredicate<T> {

    boolean filter(T t);
}

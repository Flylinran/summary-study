package lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * author: Flyli
 * date: 2017/6/25
 * description: java8 内置的四大函数式接口
 * <p>
 *
 * @see java.util.function.Consumer 1-消费型接口
 * @see java.util.function.Supplier 2-供给型接口
 * @see java.util.function.Function 3-函数型接口
 * @see java.util.function.Predicate 4-断言型接口
 */
public class Demo03 {

    /**
     *
     */
    @Test
    public void test() {
        //消费
        happy(100.0, (x) -> System.out.println("吃饭花了" + x));

        //供给
        List<Integer> nums = getNums(10, () -> (int) (Math.random() * 100));
        nums.parallelStream().forEach(System.out::println);

        //函数式
        String msg = "Hello World!";
        System.out.println(strHandle(msg, (x) -> x.toUpperCase()));
        
        //断言
        System.out.println(assertNull(nums, o -> null == o));
    }

    /**
     * 4-断言型接口 Predicate<T>
     *
     * @param o
     * @param predicate
     * @return
     */
    public boolean assertNull(Object o, Predicate predicate) {
        return predicate.test(o);
    }

    /**
     * 3-函数型接口 Function<T, R>
     *
     * @param str
     * @param function
     * @return
     */
    public String strHandle(String str, Function<String, String> function) {
        return function.apply(str);
    }

    /**
     * 2-供给型接口 Supplier<T>
     */
    public List<Integer> getNums(int nums, Supplier<Integer> supplier) {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < nums; i++) {
            integers.add(supplier.get());
        }
        return integers;
    }

    /**
     * 1-消费型接口 Consumer<T>
     */
    public void happy(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }
}

package lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * author: Flyli
 * date: 2017/6/22 18:18
 * description: Lambda表达式语法：参数 + lambda体
 * <p>
 *      横批：能省则省
 *      上联：左右遇一括号省
 *      下联：左侧推断类型省
 * <p>
 * lambda表达式需要"函数式接口"的支持
 *      函数是接口：接口中只有一个抽象方法的接口，称为函数式接口。可以使用注解 @FunctionalInterface修饰，可以检查是否是函数式接口
 */
public class Demo02 {

    /**
     * 语法格式一：无参无返回值
     * () -> System.out.println("hello Lambda");
     */
    @Test
    public void test1() {
        int num = 0;
        new Thread(new Runnable() {
            @Override
            public void run() {
                //java8之后不需要显式定义为 num为final
                System.out.println("hello world" + num);
            }
        }).start();

        Runnable runnable = () -> System.out.println("Hello world" + num);
        new Thread(runnable).start();

    }

    /**
     * 语法格式二：有一个参数，无返回值，左侧小括号可以省略
     * (x) -> System.out.println(x)
     */
    @Test
    public void test2() {
        Consumer<String> consumer = (x) -> System.out.println(x);
        consumer.accept("Hello Lambda");
    }

    /**
     * 语法格式三：有两个以上的参数，有返回值，并且lambda体中有多条语句
     * Comparator<Integer> comparator = (x, y) -> {
     *      System.out.println("函数式接口");
     *      return Integer.compare(x, y);
     * };
     */
    @Test
    public void test3() {
        Comparator<Integer> comparator = (x, y) -> {
            System.out.println("函数式接口");
            return Integer.compare(x, y);
        };
    }

    /**
     * 语法格式四：若Lambda体中只有一条语句，return和大括号都可以省略
     */
    @Test
    public void test4() {
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
    }

    /**
     * 语法格式六：类型推断，Lambda参数类型可以不写，通过目标上下文推断出来
     * (x, y) -> Integer.compare(x, y)
     * 类型推断：String[] arrs = {"aa", "bb", "cc"}
     * List<String> list = new ArrayList<>();
     */
    @Test
    public void test5() {
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
    }

}

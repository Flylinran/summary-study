package lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * author: Flyli
 * date: 2017/6/25
 * description: Stream API
 */
public class Demo04 {

    List<String> myList =
            Arrays.asList("a1", "a2", "b1", "c2", "c1");

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 22, 2222.22),
            new Employee("李四", 44, 4444.44),
            new Employee("王五", 55, 5555.55),
            new Employee("赵六", 55, 3333.33),
            new Employee("田七", 66, 6666.66)
    );

    /**
     * 常规对象流
     */
    @Test
    public void demo01() {
        myList.stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
        System.out.println();

        myList.stream()
                .findFirst()
                .ifPresent(System.out::println);
        System.out.println();

        Stream.of("a1", "a2", "a3")
                .findFirst()
                .ifPresent(System.out::println);
        System.out.println();
    }

    /**
     * 基本类型流
     */
    @Test
    public void demo02() {
        IntStream.range(1, 4)
                .forEach(System.out::println);
        System.out.println();

        Arrays.stream(new int[]{1, 2, 3})
                .filter(i -> i > 1)
                .map(Integer::bitCount)//接受同类型参数，并返回
                .average()
                .ifPresent(System.out::println);  // 5.0
        System.out.println();

        IntStream.range(1, 4)
                .mapToObj(value -> "object" + value)
                .forEach(System.out::println);
        System.out.println();

        Stream.of(1.0, 2.0, 3.0)
                .mapToInt(Double::intValue)
                .mapToObj(v -> "object" + v) //映射成String类型
                .forEach(System.out::println);
        System.out.println();
    }

    @Test
    public void demo03() {
        employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .ifPresent(System.out::println);
        System.out.println();
    }

    /**
     * Java 8 streams不能被复用，当你执行完任何一个最终操作（terminal operation）的时候流就被关闭了
     * <p>
     * 可以通过为每个最终操作（terminal operation）创建一个新的stream链的方式来解决上面的重用问题，
     * Stream api中已经提供了一个stream supplier类来在已经存在的中间操作（intermediate operations ）的stream基础上构建一个新的stream。
     */
    @Test
    public void demo04() {
        Supplier<Stream<String>> streamSupplier =
                () -> Stream.of("d2", "a2", "b1", "b3", "c")
                        .filter(s -> s.startsWith("a"));

        streamSupplier.get().anyMatch(s -> true);   // ok
        streamSupplier.get().noneMatch(s -> true);  // ok
    }

    /**
     * Collect(收集)
     */
    @Test
    public void demo05() {
        List<Employee> collect = employees.stream()
                .filter(e -> e.getSalary() > 5000)
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
        System.out.println();

//        将用户按年龄分组
        Map<Integer, List<Employee>> groupByAge = employees.stream()
                .collect(Collectors.groupingBy(e -> e.getAge()));
        groupByAge.forEach((x, y) -> System.out.println(x + " - " + y));

        //计算所有用户的年纪。
        Double age = employees.stream()
                .collect(Collectors.averagingDouble(Employee::getAge));
        System.out.println(age);
        System.out.println();

        //对用户年龄进行统计
        DoubleSummaryStatistics ageSu = employees.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(ageSu);
        System.out.println();
    }

    /**
     * FlatMap
     */
    @Test
    public void demo06() {

    }

    /**
     * Reduce(减少)
     */
    @Test
    public void demo07() {

    }

    /**
     * Parallel Streams（并行流）
     */
    @Test
    public void demo08() {

    }

}

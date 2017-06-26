package lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * author: Flyli
 * date: 2017/6/25
 * description: Stream API
 */
public class Demo04 {

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 22, 2222.22),
            new Employee("李四", 44, 4444.44),
            new Employee("王五", 55, 5555.55),
            new Employee("赵六", 55, 3333.33),
            new Employee("田七", 66, 6666.66)
    );

    @Test
    public void demo01() {
        employees.forEach(System.out::println);
        employees.forEach(e -> System.out.println(e.getName()));
        IntStream intStream = employees.stream()
                .map(employee -> employee.getAge() == 22)
                .mapToInt(value -> 1);
        //TODO next study from here
    }
}

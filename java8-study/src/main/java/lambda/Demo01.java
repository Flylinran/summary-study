package lambda;

import org.junit.Test;

import java.util.*;

/**
 * author: Flyli
 * date: 2017/6/22 18:18
 * description: 一般使用
 */
public class Demo01 {

    /**
     * 匿名内部类
     */
    @Test
    public void test1() {
        //使用lambda表达式之前
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        TreeSet<Integer> treeSet = new TreeSet<>(com);

        //使用lambda后
        Comparator<Integer> com2 = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> treeSet2 = new TreeSet<>(com2);
    }

    List<Employee> employees = Arrays.asList(
            new Employee("张三", 22, 2222.22),
            new Employee("李四", 44, 4444.44),
            new Employee("王五", 55, 5555.55),
            new Employee("赵六", 55, 3333.33),
            new Employee("田七", 66, 6666.66)
    );

    /**
     * predicate
     */
    @Test
    public void test2() {

        //使用lambda之前
        List<Employee> filterEmployees = filterByPredicate(employees, new MyPredicate<Employee>() {
            @Override
            public boolean filter(Employee employee) {
                return employee.getAge() > 35;
            }
        });
        System.out.println(filterEmployees);
        System.out.println("------------------------");

        //使用lambda之后 - 1
        List<Employee> filterEmployees2 = filterByPredicate(employees, e -> e.getAge() > 50);
        filterEmployees2.forEach(System.out::println);
        System.out.println("------------------------");

        //使用lambda之后 - 2
        employees.stream()
                .filter(e -> e.getAge() > 30)
                .filter(e -> e.getSalary() > 5555)
                .limit(1)
                .forEach(System.out::println);

        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }

    @Test
    public void test3() {
        employees.forEach(System.out::println);
        System.out.println("---------------------");
        Collections.sort(employees, (x, y) -> {
            if (x.getAge() == y.getAge())
                return Double.compare(x.getSalary(), y.getSalary());
            return Integer.compare(x.getAge(), y.getAge());
        });
        employees.forEach(System.out::println);
    }

    /**
     * 策略模式
     *
     * @param employees
     * @param myPredicate
     * @return
     */
    public List<Employee> filterByPredicate(List<Employee> employees, MyPredicate<Employee> myPredicate) {
        List<Employee> result = new ArrayList<>();
        for (Employee e : employees) {
            if (myPredicate.filter(e)) {
                result.add(e);
            }
        }
        return result;
    }
}

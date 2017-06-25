package demo;

/**
 * author: Flyli
 * date: 2017/6/25
 * description:
 */
public class Calculate {

    private int num;

    public Calculate(int num) {
        this.num = num;
    }

    public int add(int a) {
        return num + a;
    }

    public int reduce(int a) {
        return num - a;
    }

    public int compare(int a) {
        return reduce(a);
    }
}

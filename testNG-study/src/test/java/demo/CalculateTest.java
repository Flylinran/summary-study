package demo;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * author: Flyli
 * date: 2017/6/25
 * description:
 */
public class CalculateTest {

    @Test(enabled = false)
    public void testAdd() throws Exception {
        Calculate calculate = new Calculate(100);
        int add = calculate.add(10);
        Assert.assertEquals(add, 110); //(实际结果，预期结果)
        Assert.assertEquals(add, 100, "实际结果不等于预期结果");
    }

    @Test
    public void testReduce() throws Exception {
    }

    @Test
    public void testCompare() throws Exception {
    }

}
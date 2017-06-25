package demo;

import org.junit.Assert;
import org.junit.Test;

/**
 * author: Flyli
 * date: 2017/6/22 17:55
 * description:
 */
public class CalculateTest {

    @Test
    public void add() throws Exception {
        Calculate calculate = new Calculate();
        Assert.assertEquals(5, calculate.add(2, 3));
        Assert.assertEquals(6, calculate.add(2, 3));
    }

}
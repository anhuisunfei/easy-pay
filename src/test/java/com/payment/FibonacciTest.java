package com.payment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * TODO
 *
 * @author sunf
 * @version 1.0
 * @date 2020/12/18 15:09
 */
@RunWith(SpringRunner.class)
public class FibonacciTest {
    @Test
    public void testFibonacci() {
        for (int n = 0; n < 10; n++) {
            int ret = Fibonacci(n);
            System.out.println(ret);
        }

    }

    int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int l = 1, ll = 0;
        for (int i = 2; i <= n; i++) {
            int t = ll + l;
            ll = l;
            l = t;
        }
        return l;
    }
}

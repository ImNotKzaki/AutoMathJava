package com.math;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class FibonacciNumbers {

    public List<BigInteger> getFibonacciNumbers(int loops) {
        List<BigInteger> fibonacciList = new ArrayList<>();

        if (loops <= 0) {
            return fibonacciList;
        }

        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;

        for (int i = 0; i < loops; i++) {
            fibonacciList.add(a);
            BigInteger temp = a;
            a = b;
            b = temp.add(a);
        }

        return fibonacciList;
    }
}
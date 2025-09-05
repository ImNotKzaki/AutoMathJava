package com.math;

import java.util.ArrayList;
import java.util.List;

public class FindPrimeFactors {
    public List<Integer> findPrimeFactors(int n) {
        List<Integer> factors = new ArrayList<>();

        // Gestione del fattore 2
        while (n % 2 == 0) {
            factors.add(2);
            n /= 2;
        }

        // Gestione dei fattori dispari
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }

        // Gestione del numero primo rimanente
        if (n > 2) {
            factors.add(n);
        }

        return factors;
    }
}
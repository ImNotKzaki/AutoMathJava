package com.math;

public class SieveOfErathosteles {

    int count;


    public int Sieve(int n){

        boolean[] primeNumbers = new boolean[n + 1];

        for (int i = 0; i <= n; i++){
            primeNumbers[i] = true;
        }

        primeNumbers[0] = false;
        primeNumbers[1] = false;

        for (int numberSieving = 2; numberSieving*numberSieving <= n; numberSieving++){
            if(primeNumbers[numberSieving]){
                for (int multipleOfNumber = numberSieving*numberSieving; multipleOfNumber <= n; multipleOfNumber += numberSieving){
                    primeNumbers[multipleOfNumber] = false;
                }
            }
        }

        count = 0;
        for (int i = 2; i <= n; i++){
            if(primeNumbers[i]){
                count += 1;
            }
        }
        return count;
    }
}

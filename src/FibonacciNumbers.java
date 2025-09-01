import java.math.BigInteger;

public class FibonacciNumbers {
    BigInteger a;
    BigInteger b;
    BigInteger c;

    public void PrintFibonacciNumbers(int loops){
        a = BigInteger.ZERO;
        b = BigInteger.ONE;
        c = BigInteger.ZERO;

        for (int i = 0; i < loops; i++){
            System.out.print(a + " ");
            c = a;
            a = b;
            b = c.add(a);
        }


    }
}

import java.util.Scanner;

public class Main {
    static int number;
    static int toDo;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        FindPrimeFactors primeFactors = new FindPrimeFactors();

        while (true){

            System.out.println("Tell what to do:");
            System.out.println("Option 0: Count primes");
            System.out.println("Option 1: Find prime factors");
            toDo = Integer.parseInt(scanner.nextLine());

            switch(toDo){
                case 0:
                    System.out.println("Count primes up to:");
                    number = Integer.parseInt(scanner.nextLine());

                    startSieve(number);
                    System.out.println(" ");
                    break;
                case 1:
                    System.out.println("Find prime factors of:");
                    number = Integer.parseInt(scanner.nextLine());

                    primeFactors.findAndPrintPrimeFactors(number);
                    break;
                default:
                    System.out.println("Invalid thing to do");
            }



        }

    }

    public static void startSieve(int n){

        SieveOfErathosteles sieve = new SieveOfErathosteles();

        long startTime = System.nanoTime();
        System.out.println("Primes found: " + sieve.Sieve(n));
        long endTime = System.nanoTime();

        double duration = (endTime - startTime) / 1_000_000_000.0;
        System.out.println("Time taken: " + duration);
    }
}

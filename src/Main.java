import java.util.Scanner;

public class Main {
    static int number;
    static int number2;
    static String toDo;
    static boolean open = true;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        FindPrimeFactors primeFactors = new FindPrimeFactors();
        FindMCDOrmcm findMcdOrMcm = new FindMCDOrmcm();
        FibonacciNumbers fibonacciNumbers = new FibonacciNumbers();

        while (open){

            System.out.println("Tell what to do:");
            System.out.println("Option 0: Count primes");
            System.out.println("Option 1: Find prime factors");
            System.out.println("Option 2: Find MCD");
            System.out.println("Option 3: Find mcm");
            System.out.println("Option 4: Find Fibonacci numbers");
            toDo = scanner.nextLine();

            switch(toDo){
                case "0":
                    System.out.println("Count primes up to:");
                    number = Integer.parseInt(scanner.nextLine());

                    startSieve(number);
                    System.out.println(" ");
                    break;
                case "1":
                    System.out.println("Find prime factors of:");
                    number = Integer.parseInt(scanner.nextLine());

                    primeFactors.findAndPrintPrimeFactors(number);
                    break;
                case "2":
                    System.out.println("Find MCD of:");
                    number = Integer.parseInt(scanner.nextLine());
                    System.out.println("And:");
                    number2 = Integer.parseInt(scanner.nextLine());
                    System.out.println(" ");
                    System.out.println(findMcdOrMcm.MCD(number, number2));
                    System.out.println(" ");
                    break;
                case "3":
                    System.out.println("Find mcm of:");
                    number = Integer.parseInt(scanner.nextLine());
                    System.out.println("And:");
                    number2 = Integer.parseInt(scanner.nextLine());
                    System.out.println(" ");
                    System.out.println(findMcdOrMcm.mcm(number, number2));
                    System.out.println(" ");
                    break;
                case "4":
                    System.out.println("Find how many numbers:");
                    number = Integer.parseInt(scanner.nextLine());
                    fibonacciNumbers.PrintFibonacciNumbers(number);
                    System.out.println(" ");
                    break;
                case "exit":
                    open = false;
                    break;
                default:
                    System.out.println("Invalid thing to do");
                    System.out.println(" ");
            }

            System.out.println(" ");

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

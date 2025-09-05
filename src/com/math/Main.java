package com.math;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// import java.util.Scanner;

public class Main {
    static int number;
    static int number2;
    static String toDo;
    static boolean open = true;

    static JFrame frame = new JFrame("AutoMath");
    static JPanel cardHolder = new JPanel(new CardLayout());
    static CardLayout cl = (CardLayout) cardHolder.getLayout();

    static JPanel sievePanel = new JPanel();
    static JPanel primeFactorsPanel = new JPanel();
    static JPanel MCDorMcmPanel = new JPanel();
    static JPanel fibonacciPanel = new JPanel();

    static JPanel mainPanel = new JPanel();

    static FindPrimeFactors primeFactors = new FindPrimeFactors();
    static FindMCDOrmcm findMcdOrMcm = new FindMCDOrmcm();
    static FibonacciNumbers fibonacciNumbers = new FibonacciNumbers();


    public static void main(String[] args){

        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }catch (Exception e){
            e.printStackTrace();
        }


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 550);

        setupSievePanel();
        setupPrimeFactorsPanel();
        setupMCDorMcmPanel();
        setupFibonaciPanel();

        setupMainPanel();

        frame.add(cardHolder);

        cl.show(cardHolder, "MainCard");


        frame.setVisible(true);




        //Scanner scanner = new Scanner(System.in);



        /*while (open){

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

        }*/

    }

    public static int startSieve(int n){

        SieveOfErathosteles sieve = new SieveOfErathosteles();

        long startTime = System.nanoTime();
        //System.out.println("Primes found: " + sieve.Sieve(n));
        long endTime = System.nanoTime();

        double duration = (endTime - startTime) / 1_000_000_000.0;
        System.out.println("Time taken: " + duration);
        return sieve.Sieve(n);
    }

    public static void setupSievePanel(){
        cardHolder.add(sievePanel, "SieveCard");

        JButton sieveButton = new JButton("Start");
        sievePanel.add(sieveButton);

        JLabel sieveLabel = new JLabel("Count primes up to: ");
        sievePanel.add(sieveLabel);

        JTextField sieveInputBar = new JTextField(20);
        sievePanel.add(sieveInputBar);

        JButton backButton = new JButton("Go back");
        sievePanel.add(backButton);


        sieveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    number = Integer.parseInt(sieveInputBar.getText());
                    JOptionPane.showMessageDialog(frame, "Primes found: " + startSieve(number));
                }catch (NumberFormatException i){
                    JOptionPane.showMessageDialog(frame, "Please input a number");
                }

            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(cardHolder, "MainCard");
            }
        });

        sievePanel.setVisible(false);
    }

    public static void setupPrimeFactorsPanel(){
        cardHolder.add(primeFactorsPanel, "primeFactorsCard");

        JButton primeFactorButton = new JButton("Start");
        primeFactorsPanel.add(primeFactorButton);

        JLabel primeFactorLabel = new JLabel("Find prime factors of: ");
        primeFactorsPanel.add(primeFactorLabel);

        JTextField primeFactorInputBar = new JTextField(20);
        primeFactorsPanel.add(primeFactorInputBar);

        JButton backButton = new JButton("Go back");
        primeFactorsPanel.add(backButton);


        primeFactorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    number = Integer.parseInt(primeFactorInputBar.getText());
                    JOptionPane.showMessageDialog(frame, "The prime factors of " + number + " are " + primeFactors.findPrimeFactors(number));
                }catch (NumberFormatException i){
                    JOptionPane.showMessageDialog(frame, "Please input a number");
                }

            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(cardHolder, "MainCard");
            }
        });

        sievePanel.setVisible(false);

    }

    public static void setupMCDorMcmPanel(){
        cardHolder.add(MCDorMcmPanel, "MCDorMcmCard");

        JButton MCDButton = new JButton("Find MCM");
        MCDorMcmPanel.add(MCDButton);

        JLabel label = new JLabel("Input two numbers: ");
        MCDorMcmPanel.add(label);

        JTextField firstNumberInputBar = new JTextField(20);
        MCDorMcmPanel.add(firstNumberInputBar);

        JTextField secondNumberInputBar = new JTextField(20);
        MCDorMcmPanel.add(secondNumberInputBar);

        JButton backButton = new JButton("Go back");
        MCDorMcmPanel.add(backButton);

        JButton mcmButton = new JButton("Find mcm");
        MCDorMcmPanel.add(mcmButton);


        MCDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    number = Integer.parseInt(firstNumberInputBar.getText());
                    number2 = Integer.parseInt(secondNumberInputBar.getText());
                    JOptionPane.showMessageDialog(frame, "The MCD of " + number + " and " + number2 + " is " + findMcdOrMcm.MCD(number, number2));
                }catch (NumberFormatException i){
                    JOptionPane.showMessageDialog(frame, "Please two numbers");
                }

            }
        });

        mcmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    number = Integer.parseInt(firstNumberInputBar.getText());
                    number2 = Integer.parseInt(secondNumberInputBar.getText());
                    JOptionPane.showMessageDialog(frame, "The mcm of " + number + " and " + number2 + " is " + findMcdOrMcm.mcm(number, number2));
                }catch (NumberFormatException i){
                    JOptionPane.showMessageDialog(frame, "Please two numbers");
                }

            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(cardHolder, "MainCard");
            }
        });

        sievePanel.setVisible(false);

    }


    public static void setupFibonaciPanel(){
        cardHolder.add(fibonacciPanel, "fibonacciCard");

        JButton primeFactorButton = new JButton("Start");
        fibonacciPanel.add(primeFactorButton);

        JLabel primeFactorLabel = new JLabel("Find how many fibonacci numbers: ");
        fibonacciPanel.add(primeFactorLabel);

        JTextField primeFactorInputBar = new JTextField(20);
        fibonacciPanel.add(primeFactorInputBar);

        JButton backButton = new JButton("Go back");
        fibonacciPanel.add(backButton);


        primeFactorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    number = Integer.parseInt(primeFactorInputBar.getText());
                    JOptionPane.showMessageDialog(frame, fibonacciNumbers.getFibonacciNumbers(number));
                }catch (NumberFormatException i){
                    JOptionPane.showMessageDialog(frame, "Please input a number");
                }

            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(cardHolder, "MainCard");
            }
        });

        sievePanel.setVisible(false);

    }




    public static void setupMainPanel(){
        cardHolder.add(mainPanel, "MainCard");

        JButton sieveButton = new JButton("Count prime numbers");
        mainPanel.add(sieveButton);

        JButton primeFactorsButton = new JButton("Find prime factors");
        mainPanel.add(primeFactorsButton);

        JButton MCDorMcmButton = new JButton("Find MCD or mcm");
        mainPanel.add(MCDorMcmButton);

        JButton fibonacciButton = new JButton("Find fibonacci numbers");
        mainPanel.add(fibonacciButton);


        sieveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(cardHolder, "SieveCard");
            }
        });

        primeFactorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(cardHolder, "primeFactorsCard");
            }
        });

        MCDorMcmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(cardHolder, "MCDorMcmCard");
            }
        });

        fibonacciButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(cardHolder, "fibonacciCard");
            }
        });


    }
}

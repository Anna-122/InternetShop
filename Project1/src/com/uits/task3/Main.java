package com.uits.task3;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int x, i,k;
        x = plus (i=23,k=89);
            System.out.println (x);
        x = devision(i =45,k =9);
            System.out.println (x);
        x = minus (i=456,k=45);
            System.out.println (x);
        x = multiplication ( i =89, k=90);
            System.out.println (x);

        System.out.println ();
        System.out.println("Вызов метода main класса Convert:");
        Convert.main();
    }


    public static int plus( int i, int k ) {
        return i + k;
    }

    public static int devision( int i, int k ) {
        return i / k;
    }

    public static int minus( int i, int k ) {
        return i - k;
    }

    public static int multiplication( int i, int k ) {
        return i * k;
    }

}

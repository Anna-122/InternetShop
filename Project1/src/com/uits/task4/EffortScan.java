package com.uits.task4;

import java.util.Scanner;


public class EffortScan {
    public static void main( String[] args ) {
        int i = 0, f = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целое число: ");
        if (scanner.hasNextInt()) {
            i = scanner.nextInt();
            System.out.println(i);
        } else {
            System.out.println("Вы ввели не целое число");
        }

        System.out.print("Введите целое число: ");
        if (scanner.hasNextInt()) {
            f = scanner.nextInt();
            System.out.println(f);
        } else {
            System.out.println("Вы ввели не целое число");
        }
        int str = i+f;
        System.out.println("Сумма заданных вами чисел = "+str );
        }
    }


    /*int i;int k;
    public static int plus( int i, int k ){
    return i + k; }
}*/
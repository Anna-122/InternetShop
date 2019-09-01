package com.uits.task4;

import java.util.Scanner;

public class EffortScan2 {
    public static void main( String[] args ) {
        boolean f1=true, f2=true;
        int input = 0;
        input = intInput();
        int a = 0;
        if (input != 0) {
            a = input;
//            System.out.println("Вы ввели " + a);
        } else {
            f1 = false;
            System.out.println("Вы ввели не целое число");
        }

        input = intInput();
        int b = 0;
        if (input != 0) {
            b = input;
//            System.out.println("Вы ввели " + b);
        } else {
            f2=false;
            System.out.println("Вы ввели не целое число");
        }

        if (f1 && f2) {
            int sum = a + b;
            System.out.println("Сумма веденных вами чисел = " + sum);
        } else {
            System.out.println("Просуммировать невозможно");
        }

    }
    static int intInput  () {
        int i = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целое число: ");
        if (scanner.hasNextInt()) {
            i = scanner.nextInt();
            return i;
        } else {
            return 0;
        }
    }
}
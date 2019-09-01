/*Имеется гирлянда, состоящая из 32 лампочек. Каждая лампочка имеет два состояния - включена или выключена. В начале работы программы случайным образом задайте какие лампочки будут включены. Напишите следующие методы:
        a) метод который будет мигать лампочками гирлянды заданное количество раз (операция ~);
        б) метод, который будет запускать гирлянду в режим бегущей строки (операция << или >>);
        в) метод, который будет выяснять включена ли лампочки на первой позиции (наложение маски с помощью &);
        г) метод который будет распечатывать текущее состояние гирлянды.
        Используйте побитовые операции. Для получения двоичного формата числа используйте метод Integer.toBinaryString(a).*/
package com.uits.task4;

public class Festoon {
    public static void main( String[] args ) {
        int f = 20;
        System.out.println("вариант А");
        System.out.println("исходное значение = " + f);
        System.out.println("перевод в двоичную систему = " + Integer.toBinaryString(f));
        System.out.println("вызов метода Мигание гирлянды  " + festoonBlink(f));
        System.out.println("значение после инверсии = " + Integer.toBinaryString(festoonBlink(f)));

        int garland = 4;
        int Mask = 1;
        System.out.println("вариант В");
        System.out.println("исходное значение = " + garland);
        System.out.println("перевод в двоичную систему значения garland = " + Integer.toBinaryString(garland));
        System.out.println("вызов метода Наложение маски (состояние первой лампочки с права) = " + festoonMask(garland, Mask));
        if (festoonMask(garland, Mask) > 0) {
            System.out.println(" лампочка  горит");
        } else {
            System.out.println(" лампочка не горит");

        }
        int festoon = 3;

        System.out.println("вариант Б");
        System.out.println("исходное значение = " + festoon);
        System.out.println("перевод в двоичную систему значения festoon = " + Integer.toBinaryString(festoon));
        System.out.println("вызов метода Бегущая строка = " + festoonTicker(festoon));
        System.out.println("преобразование метода 'Бегущая строка'  в двоичную систему= " + Integer.toBinaryString(festoonTicker(festoon)));


        int chaplet = 3;
        System.out.println(" Вызов метода 'Текущие состояние' = "+ Integer.toBinaryString(chaplet) );
    }
    public static int festoonBlink( int f ) {
        return f = ~f;
    }
    public static int festoonTicker( int festoon ) {
        return festoon =festoon>>1 ;
    }
    public static int festoonMask( int garland, int Mask) {
        return garland= garland & Mask;
    }
    /*public static int festoonCurrentState( int chaplet ) {
        return chaplet = Integer.toBinaryString(chaplet);
    }*/
}
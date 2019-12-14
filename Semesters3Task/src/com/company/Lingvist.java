package com.company;
import java.io.File;
import java.io.IOException;

public class Lingvist {
    public static void main( String[] args ) {
        System.out.print("Добро пожаловать! Чтобы провести транслитерацию имен собсвенных  выбырете таблицу\n");

        File myFile = new File("/home/anna/TranslitTables");
        System.out.println("File name: " + myFile.getName());
        System.out.println("Parent folder: " + myFile.getParent());
        if(myFile.exists())
            System.out.println("File exists");
        else
            System.out.println("File not found");

        System.out.println("File size: " + myFile.length());
        if(myFile.canRead())
            System.out.println("File can be read");
        else
            System.out.println("File can not be read");

        if(myFile.canWrite())
            System.out.println("File can be written");
        else
            System.out.println("File can not be written");


    }

}
package com.uits.task13;
    import java.util.Scanner;
    class Authentification {


        public static void main( String[] args ) {

            Scanner in = new Scanner(System.in);
            System.out.print("Input username: ");
            String username = in.nextLine();
            System.out.print("Input password: ");
            String password = in.nextLine();

            System.out.printf("Username: %s  Password: %s   \n", username, password);
            in.close();
        }
    }
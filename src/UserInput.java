import java.util.Scanner;

public class UserInput {
    private static Scanner scanner = new Scanner(System.in);
    static int readRowSeat(){
        System.out.println("\nEnter a row number:");
        return scanner.nextInt();
    }
    static int readColumnSeat(){
        System.out.println("Enter a seat number in that row:");
        return scanner.nextInt();
    }
    public static int readRows() {
        System.out.println("Enter the number of rows:");
        return scanner.nextInt();
    }
    public static int readColumns() {
        System.out.println("Enter the number of seats in each row:");
        return scanner.nextInt();
    }
    static int menu(){
        System.out.println("\n1. Show the seats\n" +
                "2. Buy a ticket\n" +
                "3. Statistics\n" +
                "0. Exit");
        return scanner.nextInt();
    }
}

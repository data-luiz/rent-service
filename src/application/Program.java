package application;

import service.Rent;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("How many rooms will be rented? ");
        int quantityRooms = sc.nextInt();

        Rent[] rooms = new Rent[10];

        for(int i = 0; i < quantityRooms; i++){
            System.out.println("Rent " + (i + 1) + ":");

            System.out.println("Name: ");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.println("Email: ");
            String email = sc.next();

            System.out.println("Room (1 to 10): ");
            int roomNumber = sc.nextInt();

            int index = roomNumber - 1;
            while (index < 0 || index >= rooms.length || rooms[index] != null) {
                System.out.print("Room unavailable or invalid. Choose another room (1 to 10): ");
                roomNumber = sc.nextInt();
                index = roomNumber - 1;
            }

            rooms[index] = new Rent(name, email);
        }

        System.out.println("Busy rooms:");
        for(int i = 0; i < rooms.length; i++){
            if(rooms[i] != null){
                System.out.print("Room " + (i + 1) + ":");
                System.out.println(rooms[i].toString());
            }

        }

        sc.close();
    }

}

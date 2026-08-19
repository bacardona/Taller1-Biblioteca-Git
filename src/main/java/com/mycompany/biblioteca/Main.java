package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Client> clients = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

    }
    static String readText(String message) {
    System.out.print(message);
    return sc.nextLine();
    }
    
    static void createClient() {
    System.out.println("\n-- Create Client --");

    String id = readText("Id: ");

    String name = readText("Name: ");
    String phone = readText("Phone: ");
    String email = readText("Email: ");

    clients.add(new Client(id, name, phone, email));

    System.out.println("Client created successfully.");
}
}

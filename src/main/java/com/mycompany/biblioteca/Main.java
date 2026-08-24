package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Client> clients = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Loan> loans = new ArrayList<>();

    public static void main(String[] args) {

}
    static String readText(String message) {
    System.out.print(message);
    return sc.nextLine();
}
    
    static int readInt(String message) {
    System.out.print(message);
    while (!sc.hasNextInt()) {
        System.out.print("Enter a valid number: ");
        sc.next();
    }
    int value = sc.nextInt();
    sc.nextLine();
    return value;
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
    
    static void createBook() {
    System.out.println("\n-- Create Book --");

    String code = readText("Code: ");
    String title = readText("Title: ");
    int year = readInt("Publication year: ");
    String author = readText("Author: ");

    books.add(new Book(code, title, year, author, true));

    System.out.println("Book created successfully.");
}
    static void listBooks() {
    System.out.println("\n-- Book List --");

    if (books.isEmpty()) {
        System.out.println("No books registered.");
        return;
    }

    for (Book b : books) {
        System.out.println(b);
    }
}
    
    static Book findBookByCode(String code) {
    for (Book b : books) {
        if (b.getCode().equalsIgnoreCase(code)) {
            return b;
        }
    }
    return null;
}

static void searchBook() {
    System.out.println("\n-- Search Book --");

    String code = readText("Code to search: ");

    Book b = findBookByCode(code);

    System.out.println(b != null ? b : "Book not found.");
}

static void updateBook() {
    System.out.println("\n-- Update Book --");

    String code = readText("Code of the book to update: ");

    Book b = findBookByCode(code);

    if (b == null) {
        System.out.println("Book not found.");
        return;
    }

    b.setTitle(readText("New title: "));
    b.setPublicationYear(readInt("New publication year: "));
    b.setAuthor(readText("New author: "));

    System.out.println("Book updated successfully.");
}
    static void deleteBook() {
    System.out.println("\n-- Delete Book --");

    String code = readText("Code of the book to delete: ");

    Book b = findBookByCode(code);

    if (b == null) {
        System.out.println("Book not found.");
        return;
    }

    books.remove(b);

    System.out.println("Book deleted successfully.");
}
    
    static void createLoan() {
    System.out.println("\n-- Create Loan --");

    String loanId = readText("Loan ID: ");
    String clientId = readText("Client ID: ");
    String bookCode = readText("Book code: ");

    Client client = findClientById(clientId);
    if (client == null) {
        System.out.println("Client not found.");
        return;
    }

    Book book = findBookByCode(bookCode);
    if (book == null) {
        System.out.println("Book not found.");
        return;
    }

    if (!book.isAvailable()) {
        System.out.println("Book is not available.");
        return;
    }

    Loan loan = new Loan(
            loanId,
            client,
            book,
            java.time.LocalDate.now(),
            "ACTIVE"
    );

    loans.add(loan);
    book.setAvailable(false);

    System.out.println("Loan created successfully.");
}
    
    static void returnBook() {
    System.out.println("\n-- Return Book --");

    String loanId = readText("Loan ID to return: ");

    Loan loan = findLoanById(loanId);

    if (loan == null) {
        System.out.println("Loan not found.");
        return;
    }

    if (loan.getStatus().equals("RETURNED")) {
        System.out.println("Loan already returned.");
        return;
    }

    loan.setStatus("RETURNED");
    loan.getBook().setAvailable(true);

    System.out.println("Book returned successfully.");
}
    
    static Loan findLoanById(String loanId) {
    for (Loan loan : loans) {
        if (loan.getLoanId().equalsIgnoreCase(loanId)) {
            return loan;
        }
    }
    return null;
}
    
    static void listLoans() {
    System.out.println("\n-- Loan List --");

    if (loans.isEmpty()) {
        System.out.println("No loans registered.");
        return;
    }

    for (Loan loan : loans) {
        System.out.println(loan);
    }
}
    
    
    static void listClients() {
    System.out.println("\n-- Client List --");

    if (clients.isEmpty()) {
        System.out.println("No clients registered.");
        return;
    }

    for (Client c : clients) {
        System.out.println(c);
    }
}
    static Client findClientById(String id) {
    for (Client c : clients) {
        if (c.getId().equalsIgnoreCase(id)) {
            return c;
        }
    }
    return null;
}
    static void searchClient() {
    System.out.println("\n-- Search Client --");

    String id = readText("Id to search: ");

    Client c = findClientById(id);

    System.out.println(c != null ? c : "Client not found.");
}
    static void updateClient() {
    System.out.println("\n-- Update Client --");

    String id = readText("Id of the client to update: ");

    Client c = findClientById(id);

    if (c == null) {
        System.out.println("Client not found.");
        return;
    }

    c.setName(readText("New name: "));
    c.setPhone(readText("New phone: "));
    c.setEmail(readText("New email: "));

    System.out.println("Client updated successfully.");
}
    static void deleteClient() {
    System.out.println("\n-- Delete Client --");

    String id = readText("Id of the client to delete: ");

    Client c = findClientById(id);

    if (c == null) {
        System.out.println("Client not found.");
        return;
    }

    clients.remove(c);

    System.out.println("Client deleted successfully.");
}
    
}

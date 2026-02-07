package com.lms;

import java.util.Scanner;
import java.util.List;
import java.util.Date;
import com.lms.model.*;
import com.lms.dao.GeneralDao;

public class App {
    private Scanner sc = new Scanner(System.in);
    private GeneralDao dao = new GeneralDao();

    public static void main(String[] args) {
        App app = new App();
        app.mainMenu();
    }

    public void mainMenu() {
        while (true) {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Publisher Management");
            System.out.println("2. Member Management");
            System.out.println("3. Book Management");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1": publisherMenu(); break;
                case "2": memberMenu(); break;
                case "3": bookMenu(); break;
                case "4": System.out.println("\n***********************************");
                          System.out.println("   THANK YOU FOR USING THE LMS!   ");
                          System.out.println("***********************************");
                	      System.exit(0);
                default: System.out.println("Invalid Choice!");
            }
        }
    }

    // --- PUBLISHER METHODS ---
    private void publisherMenu() {
        System.out.println("\n1. Add Publisher\n2. View Publishers\n3. Delete Publisher");
        String ch = sc.nextLine();
        if (ch.equals("1")) {
            Publisher p = new Publisher();
            System.out.print("Pub ID: "); p.setPubId(sc.nextLine());
            System.out.print("Name: "); p.setName(sc.nextLine());
            System.out.print("Address: "); p.setAddress(sc.nextLine());
            dao.saveObject(p);
        } else if (ch.equals("2")) {
            List<Publisher> list = dao.getAll(Publisher.class);
            list.forEach(p -> System.out.println(p.getPubId() + " | " + p.getName()));
        } else if (ch.equals("3")) {
            System.out.print("Enter ID to delete: ");
            dao.deleteObject(Publisher.class, sc.nextLine());
        }
    }

    // --- MEMBER METHODS ---
    private void memberMenu() {
        System.out.println("\n1. Add Member\n2. View Members\n3. Delete Member");
        String ch = sc.nextLine();
        if (ch.equals("1")) {
            Member m = new Member();
            System.out.print("Member ID: "); m.setMemberId(sc.nextLine());
            System.out.print("Name: "); m.setName(sc.nextLine());
            System.out.print("Type: "); m.setMemberType(sc.nextLine());
            m.setMemberDate(new Date()); // Current date
            dao.saveObject(m);
        } else if (ch.equals("2")) {
            List<Member> list = dao.getAll(Member.class);
            list.forEach(m -> System.out.println(m.getMemberId() + " | " + m.getName()));
        } else if (ch.equals("3")) {
            System.out.print("Enter Member ID to delete: ");
            dao.deleteObject(Member.class, sc.nextLine());
        }
    }

    // --- BOOK METHODS ---
    private void bookMenu() {
        System.out.println("\n1. Add Book\n2. View Books\n3. Delete Book");
        String ch = sc.nextLine();
        if (ch.equals("1")) {
            book b = new book();
            System.out.print("Book ID: "); b.setBookId(sc.nextLine());
            System.out.print("Title: "); b.setTitle(sc.nextLine());
            System.out.print("Price: "); b.setPrice(Double.parseDouble(sc.nextLine()));
            System.out.print("Publisher ID: ");
            Publisher p = new Publisher(); p.setPubId(sc.nextLine());
            b.setPublisher(p);
            b.setAvailable("YES");
            dao.saveObject(b);
        } else if (ch.equals("2")) {
            List<book> list = dao.getAll(book.class);
            list.forEach(b -> System.out.println(b.getBookId() + " | " + b.getTitle() + " | " + b.getAvailable()));
        } else if (ch.equals("3")) {
            System.out.print("Enter Book ID to delete: ");
            dao.deleteObject(book.class, sc.nextLine());
        }
    }
}
package com.siit.homework.course4.library;

import java.util.Scanner;

public class LibraryCatalogDynamic {
    public static void main(String[] args) throws Exception {
        Book books = new Book();
        books = addBooks(books);

        Scanner scanner = new Scanner(System.in);
        System.out.println("What's your next action? Add/Delete");
        String inputAction = scanner.next();

        books = action(inputAction, books);

        books.listBooks();
    }

    public static Book addBooks(Book books) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter the number for books: ");
        int inputNumber = scanner.nextInt();

        if (inputNumber <= 0) {
            throw new Exception("The number of books must be greater than 0!");
        }

        for (int i = 0; i < inputNumber; i++) {
            System.out.println("\nEnter a novel or album: Press A for album or N for novel ");
            String inputLine = scanner.next();

            if (inputLine.toUpperCase().equals("N")) {
                Novel novel = new Novel();

                System.out.println("Enter the name of Novel:");
                String inputName = scanner.next();
                novel.setName(inputName);

                System.out.println("Enter the number of pages:");
                int inputPages = scanner.nextInt();
                novel.setPages(inputPages);

                System.out.println("Enter novel type:");
                String inputType = scanner.next();
                novel.setType(inputType);

                books.addNovel(novel);
            }

            if (inputLine.toUpperCase().equals("A")) {
                Album album = new Album();

                System.out.println("Enter the name of Album:");
                String inputName = scanner.next();
                album.setName(inputName);

                System.out.println("Enter the number of pages:");
                int inputPages = scanner.nextInt();
                album.setPages(inputPages);

                System.out.println("Enter album paper quality:");
                String inputType = scanner.next();
                album.setPaperQuality(inputType);

                books.addAlbum(album);
            }
        }

        return books;
    }

    public static Book deleteBooks(Book books, String bookToBeDeleted, boolean deleteAllBooks) {
        if (deleteAllBooks) {
            books.deleteBooks(books);
            return books;
        }

        books.deleteBookByName(books, bookToBeDeleted);
        System.out.println("Book " + bookToBeDeleted + " have been deleted!");
        return books;
    }

    public static Book action(String inputAction, Book books) throws Exception {
        Scanner scanner = new Scanner(System.in);
        if (inputAction.equals("Add")) {
            books = addBooks(books);
            return books;
        }

        if (inputAction.equals("Delete")) {
            System.out.println("Delete all books? Yes/No");
            String inputAnswer = scanner.next();
            if (inputAnswer.equals("Yes")) {
                books = deleteBooks(books, "", true);
            }

            if (inputAnswer.equals("No")) {
                System.out.println("Enter which book do you want to delete: Name");
                String inputAnswerBook = scanner.next();
                books = deleteBooks(books, inputAnswerBook, false);
            }
            return books;
        }

        return books;
    }
}

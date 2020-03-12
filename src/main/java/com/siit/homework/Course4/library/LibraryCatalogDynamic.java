package com.siit.homework.Course4.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryCatalogDynamic {
    public static void main(String[] args) throws Exception {
        List<Book> booksList = new ArrayList<Book>();
        List<Book> booksAfterDelete = null;

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter the number for books: ");
        int inputNumber = scanner.nextInt();

        if (inputNumber <= 0) {
            throw new Exception("The number of books must be greater than 0!");
        }

        Book books = addBooks(inputNumber);
        booksList.add(books);

        System.out.println("What's your next action? Add/Delete/Modify");
        String inputAction = scanner.next();

        if (inputAction.equals("Add")) {
            System.out.println("Enter the number for books:");
            int inputNumberAdd = scanner.nextInt();
            Book booksLaterAdded = addBooks(inputNumberAdd);
            booksList.add(booksLaterAdded);
        }

        booksAfterDelete = booksList;
        if (inputAction.equals("Delete")) {
            System.out.println("Delete all books? Yes/No");
            String inputAnswer = scanner.next();
            if (inputAnswer.equals("Yes")) {
                booksAfterDelete = deleteBooks(booksList, "", true);
            }

            if (inputAnswer.equals("No")) {
                System.out.println("Enter which book do you want to delete: Name");
                String inputAnswerBook = scanner.next();
                booksAfterDelete = deleteBooks(booksList, inputAnswerBook, false);
            }
        }

        System.out.println(booksAfterDelete.isEmpty());
        for (Book book : booksAfterDelete) {
            book.listBooks();
        }
    }

    public static Book addBooks(int number) {
        Book books = new Book();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < number; i++) {
            System.out.println("\nEnter a novel or album: Press A for album or N for novel ");
            String inputLine = scanner.next();

            if (inputLine.equals("N")) {
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

            if (inputLine.equals("A")) {
                Album album = new Album();

                System.out.println("Enter the name of Album:");
                String inputName = scanner.next();
                album.setName(inputName);

                System.out.println("Enter the number of pages:");
                int inputPages = scanner.nextInt();
                album.setPages(inputPages);

                System.out.println("Enter novel type:");
                String inputType = scanner.next();
                album.setPaperQuality(inputType);

                books.addAlbum(album);
            }
        }

        return books;
    }

    public static List<Book> deleteBooks(List<Book> books, String bookToBeDeleted, boolean deleteAllBooks) {
        List<Book>booksAfterDelete = new ArrayList<Book>();
        if (deleteAllBooks) {
            books.clear();

            return booksAfterDelete;
        }

        for (Book book:books) {
            if (!book.getName().equals(bookToBeDeleted)) {
                booksAfterDelete.add(book);
            }

            if (book.getName().equals(bookToBeDeleted)) {
                System.out.println("Book " + bookToBeDeleted + " have been deleted!");
            }
        }
        return booksAfterDelete;
    }

    public static void displayBooks(List<Book>books) {
        for (Book book:books) {
            book.listBooks();
        }
    }
}

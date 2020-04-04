package com.siit.homework.course4.library;

public class LibraryCatalog {
    public static void main(String[] args) {
        Album album1 = new Album();
        album1.setName("Java");
        album1.setPages(320);
        album1.setPaperQuality("High");

        Album album2 = new Album();
        album2.setName("PHP");
        album2.setPages(100);
        album2.setPaperQuality("Medium");

        Novel novel1 = new Novel();
        novel1.setName("THE GREAT GATSBY");
        novel1.setPages(250);
        novel1.setType("SF");

        Novel novel2 = new Novel();
        novel2.setName("MAIN STREET");
        novel2.setPages(145);
        novel2.setType("SF");

        Book books = new Book();
        books.addAlbum(album1);
        books.addNovel(novel1);
        books.addAlbum(album2);
        books.addNovel(novel2);
        System.out.println("\nDisplay all books:");
        books.listBooks();

        //Remove one book.
        System.out.println("\nBooks after delete:");
        books.deleteAlbum(album2);
        books.listBooks();
    }
}

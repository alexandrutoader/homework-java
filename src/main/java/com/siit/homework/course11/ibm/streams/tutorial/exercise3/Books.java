package com.siit.homework.course11.ibm.streams.tutorial.exercise3;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Domain object representing a collection of books
 */
public class Books {
    
    /**
     * Apply a mapping of Books to titles (Strings)
     * 
     * @param books - books to transform
     * @return list of book titles
     */
    public static List<String> titlesOf(List<Book> books) {
        // [your code here]
        return books.stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    /**
     * Apply a mapping of Books to their author's full names
     *  
     * @param books - books to transform
     * @return list of author full names
     */
    public static List<String> namesOfAuthorsOf(List<Book> books) {
        // [your code here]
        return books.stream()
                .map(book -> book.getAuthor().fullName())
                .collect(Collectors.toList());
    }

    /**
     * Apply a mapping of Books to a unique set of their publishers
     * 
     * @param books - books to transform
     * @return set of publishers
     */
    public static Set<Publisher> publishersRepresentedBy(List<Book> books) {
        // [your code here]
        return books.stream()
                .map(Book::getPublisher)
                .collect(Collectors.toSet());
    }
}

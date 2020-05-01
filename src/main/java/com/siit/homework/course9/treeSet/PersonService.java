package com.siit.homework.course9.treeSet;

import lombok.Builder;
import java.util.TreeSet;

@Builder
public class PersonService {
    public static void main(String[] args) {
        TreeSet<Person> treeSetSortedByName = new TreeSet<>(new PersonCompByName());

        Person alex = Person.builder()
                .age(20)
                .name("Alex")
                .build();

        Person andrei = Person.builder()
                .age(23)
                .name("Bogdan")
                .build();

        Person andreea = Person.builder()
                .age(21)
                .name("Mircea")
                .build();

        Person alexandra = Person.builder()
                .age(32)
                .name("Florin")
                .build();

        treeSetSortedByName.add(alex);
        treeSetSortedByName.add(andrei);
        treeSetSortedByName.add(andreea);
        treeSetSortedByName.add(alexandra);

        System.out.println("\nCompared by name:");
        for (Person currentElement : treeSetSortedByName) {
            System.out.println(currentElement.getName());
        }

        TreeSet<Person> treeSetSortedByAge = new TreeSet<>(new PersonCompByAge());
        treeSetSortedByAge.addAll(treeSetSortedByName);

        System.out.println("\nCompared by age:");
        for (Person currentElement : treeSetSortedByAge) {
            System.out.println(currentElement.getAge());
        }
    }
}

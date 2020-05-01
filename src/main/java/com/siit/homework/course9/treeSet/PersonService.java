package com.siit.homework.course9.treeSet;

import java.util.Comparator;
import java.util.TreeSet;

public class PersonService {
    public static void main(String[] args) {
        Person person1 = new Person("Alex", 20);
        Person person2 = new Person("Andrei", 23);
        Person person3 = new Person("Andreea", 21);
        Person person4 = new Person("Alexandra", 32);
        Person person5 = new Person("Mircea", 26);
        Person person6 = new Person("Mircea", 26);

        Comparator<Person> personComparatorAfterNameAndAge = new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                int i = o1.getName().compareTo(o2.getName());
                if (i == 0) {
                    if (o1.getAge() == o2.getAge()) {
                        return 0;
                    } else if (o1.getAge() < o2.getAge()) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
                return i;
            }
        };

        TreeSet<Person> persons = new TreeSet<>(personComparatorAfterNameAndAge);
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);
        persons.add(person5);
        persons.add(person6);

        persons.forEach((person) -> {
            System.out.println(person.getName() + " " + person.getAge());
        });
    }
}

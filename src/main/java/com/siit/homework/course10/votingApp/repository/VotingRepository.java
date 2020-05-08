package com.siit.homework.course10.votingApp.repository;

import com.siit.homework.course10.votingApp.entity.ComparatorByCnp;
import com.siit.homework.course10.votingApp.entity.Person;

import java.util.TreeSet;

public abstract class VotingRepository {
    public final static TreeSet<Person> personsTreeSet = new TreeSet<>(new ComparatorByCnp());

    static {
        Person person1 = Person.builder()
                .name("Andrei")
                .surname("Popescu")
                .address("Str. Victoriei, nr. 106")
                .cnp("1923121251")
                .cnpNo("1234")
                .cnpSeries("RX")
                .build();

        Person person2 = Person.builder()
                .name("Adrian")
                .surname("Mihai")
                .address("Str. Unirii, nr. 23")
                .cnp("1923121131")
                .cnpNo("6452")
                .cnpSeries("RT")
                .build();

        Person person3 = Person.builder()
                .name("Bogdan")
                .surname("Ionescu")
                .address("Str. Obor, nr. 15")
                .cnp("1923121222")
                .cnpNo("8532")
                .cnpSeries("RH")
                .build();

        Person person4 = Person.builder()
                .name("Dan")
                .surname("Ene")
                .address("Str. Tineretului, nr. 5")
                .cnp("1923121112")
                .cnpNo("6322")
                .cnpSeries("RB")
                .build();

        Person person5 = Person.builder()
                .name("Andrei")
                .surname("Popescu")
                .address("Str. Victoriei, nr. 106")
                .cnp("1923121251")
                .cnpNo("7234")
                .cnpSeries("RC")
                .build();

        Person person6 = Person.builder()
                .name("Mircea")
                .surname("Gheorghe")
                .address("Str. Basarab, nr. 55")
                .cnp("1923121421")
                .cnpNo("8943")
                .cnpSeries("RI")
                .build();

        Person person7 = Person.builder()
                .name("Larisa")
                .surname("Ionescu")
                .address("Str. Panduri, nr. 18")
                .cnp("2923121892")
                .cnpNo("7642")
                .cnpSeries("TN")
                .build();

        Person person8 = Person.builder()
                .name("Andrei")
                .surname("Barbu")
                .address("Str. Pancota, nr. 2")
                .cnp("1923121149")
                .cnpNo("9021")
                .cnpSeries("PO")
                .build();

        Person person9 = Person.builder()
                .name("Florin")
                .surname("Dumitru")
                .address("Str. Metalurgiei, nr. 7")
                .cnp("1923121666")
                .cnpNo("5678")
                .cnpSeries("AD")
                .build();

        Person person10 = Person.builder()
                .name("Marin")
                .surname("Ion")
                .address("Str. Rahova, nr. 7")
                .cnp("1923121864")
                .cnpNo("6957")
                .cnpSeries("PS")
                .build();

        personsTreeSet.add(person1);
        personsTreeSet.add(person2);
        personsTreeSet.add(person3);
        personsTreeSet.add(person4);
        personsTreeSet.add(person5);
        personsTreeSet.add(person6);
        personsTreeSet.add(person7);
        personsTreeSet.add(person8);
        personsTreeSet.add(person9);
        personsTreeSet.add(person10);
    }
}

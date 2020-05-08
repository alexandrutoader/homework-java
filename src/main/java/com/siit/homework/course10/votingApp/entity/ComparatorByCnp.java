package com.siit.homework.course10.votingApp.entity;

import java.util.Comparator;

public class ComparatorByCnp implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        return p1.getCnp().compareTo(p2.getCnp());
    }
}

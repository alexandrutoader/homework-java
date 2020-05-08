package com.siit.homework.course10.votingApp.entity;

import lombok.*;

import java.util.Comparator;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
@ToString
public class Person implements Comparable<Person> {
    private String name;
    private String surname;
    private String address;
    private String cnp;
    private String cnpSeries;
    private String cnpNo;
    private boolean voted;

    @Override
    public int compareTo(Person person) {
        return (this.cnp).compareTo(person.cnp);
    }
}

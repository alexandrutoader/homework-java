package com.siit.homework.course9.treeSet;

import lombok.*;

@Getter
@EqualsAndHashCode
@ToString
public class Person {
    private String name;
    private int age;

    @Builder
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

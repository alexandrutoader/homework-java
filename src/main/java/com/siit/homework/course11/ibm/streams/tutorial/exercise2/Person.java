package com.siit.homework.course11.ibm.streams.tutorial.exercise2;

public final class Person {

    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }
    
    public String getName() {
        return name;
    }
}
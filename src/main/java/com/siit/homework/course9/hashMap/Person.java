package com.siit.homework.course9.hashMap;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@EqualsAndHashCode
@ToString
public class Person {
    private String name;
    private int age;
    private List<Hobby> hobbies;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, List<Hobby>hobby) {
        this.name = name;
        this.age = age;
        this.hobbies = hobby;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Person setAge(int age) {
        this.age = age;
        return this;
    }

    public List<Hobby> getHobbies() {
        return hobbies;
    }

    public Person setHobbies(List<Hobby> hobbies) {
        this.hobbies = hobbies;
        return this;
    }
}

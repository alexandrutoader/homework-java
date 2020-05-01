package com.siit.homework.course9.hashMap;

import java.util.*;

public class PersonService {
    public static void main(String[] args) {
        Person alex = Person.builder()
                .age(20)
                .name("Alex")
                .build();

        Person bogdan = Person.builder()
                .age(23)
                .name("Bogdan")
                .build();

        Person mircea = Person.builder()
                .age(21)
                .name("Mircea")
                .build();

        Person florin = Person.builder()
                .age(32)
                .name("Florin")
                .build();

        List<Address> kayakingAddress1 = new ArrayList<>();
        Address runningAddress1 = Address.builder()
                .street("Brasov")
                .country("Romania")
                .build();

        Address kayakingAddress2 = Address.builder()
                .street("Buzau")
                .country("Romania")
                .build();

        kayakingAddress1.add(runningAddress1);
        kayakingAddress1.add(kayakingAddress2);

        Hobby kayakingHobby = Hobby.builder()
                .name("Kayaking")
                .frequency(3)
                .addresses(kayakingAddress1)
                .build();

        List<Address> swimmingAddress = new ArrayList<>();
        Address swimAddress1 = Address.builder()
                .street("Bd. Timisoara")
                .country("Romania")
                .build();

        Address swimAddress2 = Address.builder()
                .street("Bd. Tineretului")
                .country("Romania")
                .build();

        swimmingAddress.add(swimAddress1);
        swimmingAddress.add(swimAddress2);

        Hobby swimHobby = Hobby.builder()
                .name("Swim")
                .frequency(4)
                .addresses(swimmingAddress)
                .build();

        List<Hobby> alexHobbies = new ArrayList<>();
        alexHobbies.add(kayakingHobby);
        alexHobbies.add(swimHobby);

        List<Hobby> mirceaHobbies = new ArrayList<>();
        mirceaHobbies.add(swimHobby);
        mirceaHobbies.add(swimHobby);

        Map<Person, List<Hobby>> hashMap = new HashMap<>();

        hashMap.put(alex, alexHobbies);
        hashMap.put(mircea, mirceaHobbies);

        Set set = hashMap.entrySet();

        for (Object o : set) {
            Map.Entry me = (Map.Entry) o;
            System.out.println(me.getKey() + " " + me.getValue());
        }
    }
}

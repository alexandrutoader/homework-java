package com.siit.homework.course11.fibonacci;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FibonacciSeries {
    public static void main(String[] args) {
        List<Integer> numbers = Stream.iterate(new int[]{0, 1}, i -> new int[]{i[1], i[0] + i[1]})
                .limit(100)
                .map(i -> i[0])
                .collect(Collectors.toList());

        System.out.println("First 100 Fibonacci numbers: " + numbers);
    }
}

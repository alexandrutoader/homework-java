package com.siit.homework.course7.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Circle implements Shape {
    private double radius;
    private double pi = Math.PI;

    public Circle() {
        this(1);
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        // A = π r^2
        return pi * Math.pow(radius, 2);
    }

    @Override
    public double perimeter() {
        // P = 2πr
        return 2 * pi * radius;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Circle)) {
            return false;
        }

        Circle c = (Circle) o;
        return Double.compare(radius, c.radius) == 0
                && Double.compare(pi, c.pi) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius, pi);
    }
}

package com.siit.homework.course7.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Rectangle implements Shape {
    private double width;
    private double length;

    public Rectangle() {
        this(1, 1);
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    @Override
    public double area() {
        // A = w * l;
        return width * length;
    }

    @Override
    public double perimeter() {
        // P = 2 * (w + l);
        return 2 * (width + length);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Rectangle)) {
            return false;
        }

        Rectangle c = (Rectangle) o;
        return Double.compare(width, c.width) == 0
                && Double.compare(length, c.length) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, length);
    }
}

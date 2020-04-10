package com.siit.homework.course7.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Square extends Shape {
    private final double side;

    public Square() {
        this(1);
    }

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        // A = l * 2
        return side * 2;
    }

    @Override
    public double perimeter() {
        // P = side * 4;
        return side * 4;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Square)) {
            return false;
        }

        Square square = (Square) o;
        return Double.compare(side, square.side) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(side);
    }
}

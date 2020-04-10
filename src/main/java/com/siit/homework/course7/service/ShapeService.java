package com.siit.homework.course7.service;

import com.siit.homework.course7.entity.*;

import java.util.ArrayList;
import java.util.List;

public class ShapeService {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();

        Shape rectangle = new Rectangle(5, 7);
        Shape rectangle2 = new Rectangle(5, 7);
        Shape circle = new Circle(5);
        Shape circle2 = new Circle(4);
        Shape triangle = new Triangle(4, 5, 6);
        Shape triangle2 = new Triangle(4, 5, 7);
        Shape square = new Square(4);
        Shape square2 = new Square(4);

        shapes.add(rectangle);
        boolean isSimilarRectangle = shapes.contains(rectangle2);
        if (isSimilarRectangle) {
            System.out.println("\n==============Exception on adding object type Rectangle=============");
            System.out.println("\nThe object reference of " + rectangle2 + " is similar with another rectangle included in the list and can't be added.");
        } else {
            shapes.add(rectangle2);
        }

        shapes.add(circle);
        boolean isSimilarCircle = shapes.contains(circle2);
        if (isSimilarCircle) {
            System.out.println("\n==============Exception on adding object type Circle================");
            System.out.println("\nThe object reference of " + circle2 + " is similar with another circle included in the list and can't be added.");
        } else {
            shapes.add(circle2);
        }

        shapes.add(triangle);
        boolean isSimilarTriangle = shapes.contains(triangle2);
        if (isSimilarTriangle) {
            System.out.println("\n==============Exception on adding object type Triangle===============");
            System.out.println("\nThe object reference of " + triangle2 + " is similar with another triangle included in the list and can't be added.");
        } else {
            shapes.add(triangle2);
        }

        shapes.add(square);
        boolean isSimilarSquare = shapes.contains(square2);
        if (isSimilarSquare) {
            System.out.println("\n==============Exception on adding object type Square==================");
            System.out.println("\nThe object reference of " + square2 + " is similar with another square included in the list and can't be added.");
        } else {
            shapes.add(square2);
        }

        System.out.println("\n================================================");
        calculateAreaAndPerimeterForShapes(shapes);
    }

    private static void calculateAreaAndPerimeterForShapes(List<Shape> shapes) {
        int counter = 1;
        for (Shape shape : shapes) {
            if (shape instanceof Rectangle) {
                System.out.println("\n" + counter + ") Rectangle area and perimeter for reference " + shape + ":"
                        + "\nArea result: " + shape.area()
                        + "\nPerimeter result: " + shape.perimeter() + "\n");
            }
            if (shape instanceof Circle) {
                System.out.println("\n" + counter + ") Circle area and perimeter for reference " + shape + ":"
                        + "\nArea result: " + shape.area()
                        + "\nPerimeter result: " + shape.perimeter() + "\n");
            }
            if (shape instanceof Triangle) {
                System.out.println("\n" + counter + ") Triangle area and perimeter for reference " + shape + ":"
                        + "\nArea result: " + shape.area()
                        + "\nPerimeter result: " + shape.perimeter() + "\n");
            }
            if (shape instanceof Square) {
                System.out.println("\n" + counter + ") Square area and perimeter for reference " + shape + ":"
                        + "\nArea result: " + shape.area()
                        + "\nPerimeter result: " + shape.perimeter() + "\n");
            }
            counter++;
        }
    }

    public void calculateAreaAndPerimeterForShapesTest(List<Shape> shapes) {
        int counter = 1;
        for (Shape shape : shapes) {
            if (shape instanceof Rectangle) {
                System.out.println("\n" + counter + ") Rectangle area and perimeter for reference " + shape + ":"
                        + "\nArea result: " + shape.area()
                        + "\nPerimeter result: " + shape.perimeter() + "\n");
            }
            if (shape instanceof Circle) {
                System.out.println("\n" + counter + ") Circle area and perimeter for reference " + shape + ":"
                        + "\nArea result: " + shape.area()
                        + "\nPerimeter result: " + shape.perimeter() + "\n");
            }
            if (shape instanceof Triangle) {
                System.out.println("\n" + counter + ") Triangle area and perimeter for reference " + shape + ":"
                        + "\nArea result: " + shape.area()
                        + "\nPerimeter result: " + shape.perimeter() + "\n");
            }
            if (shape instanceof Square) {
                System.out.println("\n" + counter + ") Square area and perimeter for reference " + shape + ":"
                        + "\nArea result: " + shape.area()
                        + "\nPerimeter result: " + shape.perimeter() + "\n");
            }
            counter++;
        }
    }
}

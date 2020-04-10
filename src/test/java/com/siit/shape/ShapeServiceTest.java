package com.siit.shape;

import com.siit.homework.course7.entity.*;
import com.siit.homework.course7.service.ShapeService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ShapeServiceTest {
    private ShapeService ss;

    @Before
    public void setup() {
        ss = new ShapeService();
    }

    @Test
    public void given_all_types_shape_input_when_compute_inverse_then_area_and_parameter_is_returned() {
        System.out.println("\n=====================================");
        List<Shape> shapes = new ArrayList<>();

        Shape rectangle = new Rectangle(5, 7);
        Shape circle = new Circle(5);
        Shape triangle = new Triangle(4, 5, 6);
        Shape square = new Square(4);
        shapes.add(rectangle);
        shapes.add(circle);
        shapes.add(triangle);
        shapes.add(square);

        ss.calculateAreaAndPerimeterForShapesTest(shapes);
    }

    @Test
    public void given_duplicates_shapes_input_when_compute_inverse_then_area_and_parameter_is_returned() {
        System.out.println("\n=====================================");
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
        shapes.add(rectangle2);
        shapes.add(circle);
        shapes.add(circle2);
        shapes.add(triangle);
        shapes.add(triangle2);
        shapes.add(square);
        shapes.add(square2);

        ss.calculateAreaAndPerimeterForShapesTest(shapes);
    }

    @Test
    public void given_single_shape_input_when_compute_inverse_then_area_and_parameter_is_returned() {
        System.out.println("\n=====================================");
        List<Shape> shapes = new ArrayList<>();

        Shape rectangle = new Rectangle(4.0, 6.0);
        shapes.add(rectangle);

        ss.calculateAreaAndPerimeterForShapesTest(shapes);
    }

    @Test
    public void given_pairs_of_shapes_input_when_compute_inverse_then_area_and_parameter_is_returned() {
        System.out.println("\n=====================================");
        List<Shape> shapes = new ArrayList<>();

        Shape rectangle = new Rectangle(5, 7);
        Shape rectangle2 = new Rectangle(5, 5);
        Shape circle = new Circle(5);
        Shape circle2 = new Circle(5);
        Shape triangle = new Triangle(4, 5, 6);
        Shape triangle2 = new Triangle(4, 5, 6);
        Shape square = new Square(4);
        Shape square2 = new Square(4);

        shapes.add(rectangle);
        shapes.add(rectangle2);
        shapes.add(circle);
        shapes.add(circle2);
        shapes.add(triangle);
        shapes.add(triangle2);
        shapes.add(square);
        shapes.add(square2);

        ss.calculateAreaAndPerimeterForShapesTest(shapes);
    }
}

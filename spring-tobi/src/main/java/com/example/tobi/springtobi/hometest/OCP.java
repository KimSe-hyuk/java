package com.example.tobi.springtobi.hometest;
import java.util.ArrayList;
import java.util.List;
public class OCP {

    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle());
        shapes.add(new Rectangle());
        shapes.add(new Triangle());  // 새로운 도형 추가

        DrawingManager drawingManager = new DrawingManager();
        drawingManager.drawShapes(shapes);  // 모든 도형 그리기
    }


    // 1. 도형의 공통 동작을 추상화한 인터페이스
    interface Shape {
        void draw();
    }

    // 2. 구체적인 도형 클래스들
    static class Circle implements Shape {
        @Override
        public void draw() {
            System.out.println("Draw Circle");
        }
    }

    static class Rectangle implements Shape {
        @Override
        public void draw() {
            System.out.println("Draw Rectangle");
        }
    }
    static class Triangle implements Shape {
        @Override
        public void draw() {
            System.out.println("Draw Triangle");
        }
    }
    // 3. 도형을 그리는 책임만을 가진 DrawingManager
    static class DrawingManager {
        public void drawShapes(List<Shape> shapes) {
            for (Shape shape : shapes) {
                shape.draw();  // 각 도형이 자신을 그리는 방법을 스스로 결정
            }
        }
    }




}





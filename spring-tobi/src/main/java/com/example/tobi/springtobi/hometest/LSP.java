package com.example.tobi.springtobi.hometest;

public class LSP {
    public class Main {
        public static void main(String[] args) {
            Shape rectangle = new Rectangle(10, 5);
            System.out.println("Rectangle area: " + rectangle.getArea());  // 10 * 5 = 50

            Shape square = new Square(5);
            System.out.println("Square area: " + square.getArea());  // 5 * 5 = 25
        }
    }
    // 도형의 공통 인터페이스
    interface Shape {
        int getArea();
    }

    // 직사각형 클래스
    static class Rectangle implements Shape {
        protected int width;
        protected int height;

        public Rectangle(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public int getArea() {
            return width * height;
        }
    }

    // 정사각형 클래스
    static class Square implements Shape {
        private int side;

        public Square(int side) {
            this.side = side;
        }

        public int getArea() {
            return side * side;
        }
    }


}

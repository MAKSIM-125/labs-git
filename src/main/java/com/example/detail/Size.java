package com.example.detail;

/**
 * Класс, описывающий размеры детали (композиция внутри {@link Detail}).
 */
public class Size {
    private final double length;
    private final double width;
    private final double height;

    /**
     * @param length длина
     * @param width  ширина
     * @param height высота
     */
    public Size(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    /** @return длина */
    public double getLength() { return length; }
    /** @return ширина */
    public double getWidth()  { return width;  }
    /** @return высота */
    public double getHeight() { return height; }

    /** @return объём детали */
    public double volume() {
        return length * width * height;
    }

    @Override
    public String toString() {
        return String.format("Size{%.1f x %.1f x %.1f}", length, width, height);
    }
}
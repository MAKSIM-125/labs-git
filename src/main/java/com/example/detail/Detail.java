package com.example.detail;

/**
 * Базовый класс иерархии — деталь.
 * Содержит информацию о форме, материале, весе и размере.
 */
public class Detail {
    private final String name;
    private final Shape shape;
    private final Material material;
    private final double weight;
    private final Size size; // композиция

    /**
     * @param name     название детали
     * @param shape    форма
     * @param material материал
     * @param weight   вес (кг)
     * @param size     размер
     */
    public Detail(String name, Shape shape, Material material, double weight, Size size) {
        this.name = name;
        this.shape = shape;
        this.material = material;
        this.weight = weight;
        this.size = size;
    }

    /** @return название */
    public String getName() { return name; }
    /** @return форма */
    public Shape getShape() { return shape; }
    /** @return материал */
    public Material getMaterial() { return material; }
    /** @return вес */
    public double getWeight() { return weight; }
    /** @return размер */
    public Size getSize() { return size; }

    @Override
    public String toString() {
        return String.format("%s [shape=%s, material=%s, weight=%.2f, %s]",
                name, shape, material, weight, size);
    }
}
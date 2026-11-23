package com.example.detail.mechanical;

import com.example.detail.Detail;
import com.example.detail.Material;
import com.example.detail.Shape;
import com.example.detail.Size;

/**
 * Подшипник — специализированный вид детали.
 */
public class Bearing extends Detail {
    private final double innerDiameter;

    public Bearing(String name, Shape shape, Material material, double weight,
                   Size size, double innerDiameter) {
        super(name, shape, material, weight, size);
        this.innerDiameter = innerDiameter;
    }

    /** @return внутренний диаметр */
    public double getInnerDiameter() { return innerDiameter; }

    @Override
    public String toString() {
        return super.toString() + " innerD=" + innerDiameter;
    }
}
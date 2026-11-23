package com.example.detail.mechanical;

import com.example.detail.Detail;
import com.example.detail.Material;
import com.example.detail.Shape;
import com.example.detail.Size;

/**
 * Шестерня — специализированный вид детали.
 */
public class Gear extends Detail {
    private final int teethCount;

    public Gear(String name, Shape shape, Material material, double weight,
                Size size, int teethCount) {
        super(name, shape, material, weight, size);
        this.teethCount = teethCount;
    }

    /** @return количество зубьев */
    public int getTeethCount() { return teethCount; }

    @Override
    public String toString() {
        return super.toString() + " teeth=" + teethCount;
    }
}
package com.example.detail;

import com.example.detail.mechanical.Bearing;
import com.example.detail.mechanical.Gear;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Консольное приложение для демонстрации работы иерархии классов.
 */
public class App {

    public static void main(String[] args) {
        List<Detail> details = buildDetails();

        System.out.println("=== Все детали ===");
        details.forEach(System.out::println);

        // 4. Вывести количество деталей
        System.out.println("\nКоличество деталей: " + details.size());

        // 3. Общий вес деталей, имеющих одинаковую форму
        Map<Shape, Double> weightByShape = details.stream()
                .collect(Collectors.groupingBy(
                        Detail::getShape,
                        Collectors.summingDouble(Detail::getWeight)));
        System.out.println("\n=== Общий вес по форме ===");
        weightByShape.forEach((shape, w) ->
                System.out.printf("%s -> %.2f кг%n", shape, w));

        // 5. Деталь, отличающаяся своей формой (уникальная форма)
        Map<Shape, Long> countByShape = details.stream()
                .collect(Collectors.groupingBy(
                        Detail::getShape, Collectors.counting()));

        List<Detail> uniqueShapeDetails = details.stream()
                .filter(d -> countByShape.get(d.getShape()) == 1)
                .collect(Collectors.toList());

        System.out.println("\n=== Детали с уникальной формой ===");
        if (uniqueShapeDetails.isEmpty()) {
            System.out.println("Нет уникальных по форме деталей.");
        } else {
            uniqueShapeDetails.forEach(System.out::println);
        }
    }

    /** Формирует список из 10+ объектов-деталей. */
    private static List<Detail> buildDetails() {
        List<Detail> list = new ArrayList<>();
        list.add(new Detail("Болт",      Shape.ROUND,   Material.STEEL,    0.05, new Size(1, 1, 1)));
        list.add(new Detail("Гайка",     Shape.HEXAGON, Material.STEEL,    0.02, new Size(1, 1, 1)));
        list.add(new Detail("Шайба",     Shape.ROUND,   Material.STEEL,    0.01, new Size(1, 1, 1)));
        list.add(new Detail("Пластина",  Shape.SQUARE,  Material.ALUMINUM, 0.30, new Size(5, 5, 1)));
        list.add(new Detail("Втулка",    Shape.ROUND,   Material.BRASS,    0.10, new Size(2, 2, 2)));
        list.add(new Detail("Уголок",    Shape.TRIANGLE,Material.STEEL,    0.25, new Size(3, 3, 3)));
        list.add(new Gear("Шестерня A",  Shape.ROUND,   Material.STEEL,    0.40, new Size(2, 2, 2), 24));
        list.add(new Gear("Шестерня B",  Shape.ROUND,   Material.STEEL,    0.35, new Size(2, 2, 2), 18));
        list.add(new Bearing("Подшипник",Shape.ROUND,   Material.BRASS,    0.15, new Size(1, 1, 1), 5.0));
        list.add(new Detail("Крышка",    Shape.SQUARE,  Material.PLASTIC,  0.05, new Size(4, 4, 1)));
        list.add(new Detail("Прокладка", Shape.TRIANGLE,Material.PLASTIC,  0.02, new Size(2, 2, 1)));
        return list;
    }
}
package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    private HashMap<String, ArrayList<String>> allDishes;

    public DinnerConstructor() {
        allDishes = new HashMap<>();
    }

    public void appData(String key, String value) {
        if (!allDishes.containsKey(key)) {
            allDishes.put(key, new ArrayList<>());
        }
        allDishes.get(key).add(value);
    }

    public String getRandomDish(String key) {
        ArrayList<String> dishes = allDishes.get(key);
        if (dishes == null || dishes.isEmpty()) {
            return "Нет доступных блюд этого типа";
        }
        Random random = new Random();
        return dishes.get(random.nextInt(dishes.size()));
    }
}
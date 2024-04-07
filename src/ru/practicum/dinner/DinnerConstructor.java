package ru.practicum.dinner;
import java.util.ArrayList;
import java.util.HashMap;
public class DinnerConstructor {
    private HashMap<String, ArrayList<String>> allDishes;

    public DinnerConstructor() {
        allDishes = new HashMap<>();
    }

    public void appData(String key, ArrayList<String> values) {
        allDishes.put(key, values);
    }

}

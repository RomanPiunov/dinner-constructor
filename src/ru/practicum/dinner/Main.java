package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();

        dc.appData(dishType, dishName); // Изменение в этой строке

        System.out.println("Блюдо добавлено!");
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        ArrayList<String> selectedTypes = new ArrayList<>();
        System.out.println("Вводите типы блюд, разделяя символом переноса строки (enter). Для завершения ввода оставьте строку пустой:");
        String nextType = scanner.nextLine();

        while (!nextType.isEmpty()) {
            selectedTypes.add(nextType);
            nextType = scanner.nextLine();
        }

        for (int i = 0; i < numberOfCombos; i++) {
            System.out.println("Комбинация " + (i + 1) + ":");
            for (String type : selectedTypes) {
                String dish = dc.getRandomDish(type);
                System.out.println(dish);
            }
            System.out.println();
        }
    }
}
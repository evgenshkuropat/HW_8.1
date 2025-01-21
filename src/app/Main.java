package app;

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Створення масиву з 15 елементами
        int[] array = new int[15];
        Random random = new Random();

        // Заповнення масиву випадковими числами від 1 до 100
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100) + 1; // Генеруємо числа від 1 до 100
        }

        // Виведення початкового вигляду масиву
        System.out.print("Початковий вигляд масиву: ");
        printArray(array);

        // Сортування масиву методом вставки
        insertionSort(array);

        // Виведення відсортованого масиву
        System.out.print("Відсортований масив: ");
        printArray(array);

        // Запит числа для пошуку
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть число для пошуку: ");
        int target = scanner.nextInt();

        // Виконання бінарного пошуку
        int index = binarySearch(array, target);

        // Виведення результату пошуку
        if (index != -1) {
            System.out.println("Індекс числа " + target + " у відсортованому масиві: " + index);
        } else {
            System.out.println("Число " + target + " відсутнє у масиві.");
        }
    }

    // Метод для виведення масиву
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Алгоритм сортування вставкою
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            // Зсув елементів, більших за key, на одну позицію вперед
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    // Алгоритм бінарного пошуку
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid; // Знайшли елемент
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Елемент не знайдено
    }
}

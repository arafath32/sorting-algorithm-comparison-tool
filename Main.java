package sorter;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static int[] data = {};
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Data Sorter: Sorting Algorithm Comparison Tool ---");
            System.out.println("1. Enter numbers manually");
            System.out.println("2. Generate random numbers");
            System.out.println("3. Perform Bubble Sort");
            System.out.println("4. Perform Merge Sort");
            System.out.println("5. Perform Quick Sort");
            System.out.println("6. Compare all algorithms");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = getIntInput();

            switch (choice) {
                case 1:
                    enterNumbers();
                    break;
                case 2:
                    generateRandomNumbers();
                    break;
                case 3:
                    performSingleSort("Bubble");
                    break;
                case 4:
                    performSingleSort("Merge");
                    break;
                case 5:
                    performSingleSort("Quick");
                    break;
                case 6:
                    compareAll();
                    break;
                case 7:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }

        } while (choice != 7);

        scan.close();
    }

  

    private static void enterNumbers() {
        System.out.print("How many numbers do you want to enter? ");
        int size = getIntInput();

        data = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            data[i] = getIntInput();
        }

        System.out.println("Your list: " + Arrays.toString(data));
    }

    private static void generateRandomNumbers() {
        System.out.print("Enter number of elements to generate: ");
        int size = getIntInput();
        Random rand = new Random();

        data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = rand.nextInt(100);
        }

        System.out.println("Randomly generated list: " + Arrays.toString(data));
    }

    private static void performSingleSort(String type) {
        if (data.length == 0) {
            System.out.println("⚠️ Please enter or generate data first!");
            return;
        }

        int[] copy = Arrays.copyOf(data, data.length);
        PerformanceResult result = null;

        switch (type) {
            case "Bubble":
                result = BubbleSort.sort(copy);
                break;
            case "Merge":
                result = MergeSort.sort(copy);
                break;
            case "Quick":
                result = QuickSort.sort(copy);
                break;
        }

        System.out.println("\nSorted Array: " + Arrays.toString(copy));
        System.out.println(result);
    }

    private static void compareAll() {
        if (data.length == 0) {
            System.out.println("⚠️ Please enter or generate data first!");
            return;
        }

        int[] arr1 = Arrays.copyOf(data, data.length);
        int[] arr2 = Arrays.copyOf(data, data.length);
        int[] arr3 = Arrays.copyOf(data, data.length);

        PerformanceResult bubble = BubbleSort.sort(arr1);
        PerformanceResult merge = MergeSort.sort(arr2);
        PerformanceResult quick = QuickSort.sort(arr3);

        System.out.println("\n--- Performance Comparison ---");
        System.out.println("Algorithm     | Time (ms)   | Steps");
        System.out.println("-----------------------------------");
        System.out.println(bubble);
        System.out.println(merge);
        System.out.println(quick);
    }

    private static int getIntInput() {
        while (!scan.hasNextInt()) {
            System.out.print("Invalid input. Please enter a valid integer: ");
            scan.next();
        }
        return scan.nextInt();
    }
}

package testingCollections;

import java.util.LinkedList;
import java.util.Collection;

public class LinkedListPerformanceTest1 {

    private static final int COLLECTION_SIZE = 100000;
    private static final int NUM_TESTS = 100;

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        // Test "add" performance
        testAdd(linkedList);

        // Test "contains" performance
        testContains(linkedList);

        // Test "remove" performance
        testRemove(linkedList);

        // Test "clear" performance
        testClear(linkedList);
    }

    private static void testAdd(LinkedList<Integer> linkedList) {
        System.out.println("Add Performance Test");
        long totalTime = 0;

        for (int i = 0; i < NUM_TESTS; i++) {
            Collection<Integer> items = generateRandomItems();
            linkedList.addAll(items);
            
            int elementToAdd = (int) (Math.random() * 100000);

            long startTime = System.nanoTime();
            linkedList.add(elementToAdd); // add a value for linked list
            long endTime = System.nanoTime();

            totalTime += (endTime - startTime);
            linkedList.clear(); // Clear the list for the next test
        }

        long averageTime = totalTime / NUM_TESTS;
        System.out.println("LinkedList - Add: " + averageTime + " ns");
    }

    private static void testContains(LinkedList<Integer> linkedList) {
        System.out.println("Contains Performance Test");
        long totalTime = 0;

        for (int i = 0; i < NUM_TESTS; i++) {
            Collection<Integer> items = generateRandomItems();
            linkedList.addAll(items); // Load the list with items
            
            Integer itemToCheck = (int) (Math.random() * 100000);
            
            long startTime = System.nanoTime();
            linkedList.contains(itemToCheck);
            long endTime = System.nanoTime();

            totalTime += (endTime - startTime);
            linkedList.clear(); // Clear the list for the next test
        }

        long averageTime = totalTime / NUM_TESTS;
        System.out.println("LinkedList - Contains: " + averageTime + " ns");
    }

    private static void testRemove(LinkedList<Integer> linkedList) {
        System.out.println("Remove Performance Test");
        long totalTime = 0;

        for (int i = 0; i < NUM_TESTS; i++) {
            // Get the first item from the iterator
            Collection<Integer> items = generateRandomItems();
            linkedList.addAll(items);// Load the list with items
            
            Integer itemToRemove= (int) (Math.random() * 100000);
            
            long startTime = System.nanoTime();
            linkedList.remove(itemToRemove);
            long endTime = System.nanoTime();

            totalTime += (endTime - startTime);
            linkedList.clear(); // Clear the list for the next test
        }

        long averageTime = totalTime / NUM_TESTS;
        System.out.println("LinkedList - Remove: " + averageTime + " ns");
    }

    private static void testClear(LinkedList<Integer> linkedList) {
        System.out.println("Clear Performance Test");
        long totalTime = 0;

        for (int i = 0; i < NUM_TESTS; i++) {
            Collection<Integer> items = generateRandomItems();
            linkedList.addAll(items); // Load the list with items
            
            long startTime = System.nanoTime();
            linkedList.clear();
            long endTime = System.nanoTime();

            totalTime += (endTime - startTime);
        }

        long averageTime = totalTime / NUM_TESTS;
        System.out.println("LinkedList - Clear: " + averageTime + " ns");
    }

    private static Collection<Integer> generateRandomItems() {
        Collection<Integer> items = new LinkedList<>();

        for (int i = 0; i < COLLECTION_SIZE; i++) {
            items.add((int) (Math.random() * 100000));
        }

        return items;
    }
}

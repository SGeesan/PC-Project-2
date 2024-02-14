package testingCollections;

import java.util.LinkedHashSet;
import java.util.Collection;

public class LinkedHashSetPerformanceTest {

    private static final int COLLECTION_SIZE = 100000;
    private static final int NUM_TESTS = 100;

    public static void main(String[] args) {
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();

        // Test "add" performance
        testAdd(linkedHashSet);

        // Test "contains" performance
        testContains(linkedHashSet);

        // Test "remove" performance
        testRemove(linkedHashSet);

        // Test "clear" performance
        testClear(linkedHashSet);
    }

    private static void testAdd(LinkedHashSet<Integer> linkedHashSet) {
        System.out.println("Add Performance Test");
        long totalTime = 0;

        for (int i = 0; i < NUM_TESTS; i++) {
            Collection<Integer> items = generateRandomItems();
            linkedHashSet.addAll(items);
            
            int elementToAdd = (int) (Math.random() * 100000);

            long startTime = System.nanoTime();
            linkedHashSet.add(elementToAdd);
            long endTime = System.nanoTime();

            totalTime += (endTime - startTime);
            linkedHashSet.clear(); // Clear the set for the next test
        }

        long averageTime = totalTime / NUM_TESTS;
        System.out.println("LinkedHashSet - Add: " + averageTime + " ns");
    }

    private static void testContains(LinkedHashSet<Integer> linkedHashSet) {
        System.out.println("Contains Performance Test");
        long totalTime = 0;

        for (int i = 0; i < NUM_TESTS; i++) {
        	Collection<Integer> items = generateRandomItems();
            linkedHashSet.addAll(items); // Load the set with items
            
            int itemToCheck = (int) (Math.random() * 100000);

            long startTime = System.nanoTime();
            linkedHashSet.contains(itemToCheck);
            long endTime = System.nanoTime();

            totalTime += (endTime - startTime);
            linkedHashSet.clear(); // Clear the set for the next test
        }

        long averageTime = totalTime / NUM_TESTS;
        System.out.println("LinkedHashSet - Contains: " + averageTime + " ns");
    }

    private static void testRemove(LinkedHashSet<Integer> linkedHashSet) {
        System.out.println("Remove Performance Test");
        long totalTime = 0;

        for (int i = 0; i < NUM_TESTS; i++) {
        	Collection<Integer> items = generateRandomItems();
            linkedHashSet.addAll(items); // Load the set with items
            
            int itemToRemove = (int) (Math.random() * 100000); // Get a random item to remove

            long startTime = System.nanoTime();
            linkedHashSet.remove(itemToRemove);
            long endTime = System.nanoTime();

            totalTime += (endTime - startTime);
            linkedHashSet.clear(); // Reload the set with items for the next test
        }

        long averageTime = totalTime / NUM_TESTS;
        System.out.println("LinkedHashSet - Remove: " + averageTime + " ns");
    }

    private static void testClear(LinkedHashSet<Integer> linkedHashSet) {
        System.out.println("Clear Performance Test");
        long totalTime = 0;

        for (int i = 0; i < NUM_TESTS; i++) {
        	Collection<Integer> items = generateRandomItems();
            linkedHashSet.addAll(items); // Load the set with items
            
            long startTime = System.nanoTime();
            linkedHashSet.clear();
            long endTime = System.nanoTime();

            totalTime += (endTime - startTime);
        }

        long averageTime = totalTime / NUM_TESTS;
        System.out.println("LinkedHashSet - Clear: " + averageTime + " ns");
    }

    private static Collection<Integer> generateRandomItems() {
        Collection<Integer> items = new LinkedHashSet<>();

        for (int i = 0; i < COLLECTION_SIZE; i++) {
            items.add((int) (Math.random() * 100000));
        }

        return items;
    }
}
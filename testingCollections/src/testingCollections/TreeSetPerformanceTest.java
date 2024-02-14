package testingCollections;

import java.util.TreeSet;
import java.util.Collection;

public class TreeSetPerformanceTest {

    private static final int COLLECTION_SIZE = 100000;
    private static final int NUM_TESTS = 100;

    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();

        // Test "add" performance
        testAdd(treeSet);

        // Test "contains" performance
        testContains(treeSet);

        // Test "remove" performance
        testRemove(treeSet);

        // Test "clear" performance
        testClear(treeSet);
    }

    private static void testAdd(TreeSet<Integer> treeSet) {
        System.out.println("Add Performance Test");
        long totalTime = 0;

        for (int i = 0; i < NUM_TESTS; i++) {
            Collection<Integer> items = generateRandomItems();
            treeSet.addAll(items);
            
            int elementToAdd = (int) (Math.random() * 100000);
            
            long startTime = System.nanoTime();
            treeSet.add(elementToAdd);
            long endTime = System.nanoTime();

            totalTime += (endTime - startTime);
            treeSet.clear(); // Clear the set for the next test
        }

        long averageTime = totalTime / NUM_TESTS;
        System.out.println("TreeSet - Add: " + averageTime + " ns");
    }

    private static void testContains(TreeSet<Integer> treeSet) {
        System.out.println("Contains Performance Test");
        long totalTime = 0;

        for (int i = 0; i < NUM_TESTS; i++) {
        	Collection<Integer> items = generateRandomItems();
            treeSet.addAll(items); // Load the set with items
            
            int itemToCheck = (int) (Math.random() * 100000); // Get the first item from the set

            long startTime = System.nanoTime();
            treeSet.contains(itemToCheck);
            long endTime = System.nanoTime();

            totalTime += (endTime - startTime);
            treeSet.clear();
        }

        long averageTime = totalTime / NUM_TESTS;
        System.out.println("TreeSet - Contains: " + averageTime + " ns");
    }

    private static void testRemove(TreeSet<Integer> treeSet) {
        System.out.println("Remove Performance Test");
        long totalTime = 0;

        for (int i = 0; i < NUM_TESTS; i++) {
            Collection<Integer> items = generateRandomItems();
            treeSet.addAll(items); // Load the set with items
            
            int itemToRemove = (int) (Math.random() * 100000); // Get a random item to remove

            long startTime = System.nanoTime();
            treeSet.remove(itemToRemove);
            long endTime = System.nanoTime();

            totalTime += (endTime - startTime);
            treeSet.clear();
        }

        long averageTime = totalTime / NUM_TESTS;
        System.out.println("TreeSet - Remove: " + averageTime + " ns");
    }

    private static void testClear(TreeSet<Integer> treeSet) {
        System.out.println("Clear Performance Test");
        long totalTime = 0;

        for (int i = 0; i < NUM_TESTS; i++) {
        	Collection<Integer> items = generateRandomItems();
            treeSet.addAll(items); // Load the set with items
            
            long startTime = System.nanoTime();
            treeSet.clear();
            long endTime = System.nanoTime();

            totalTime += (endTime - startTime);
        }

        long averageTime = totalTime / NUM_TESTS;
        System.out.println("TreeSet - Clear: " + averageTime + " ns");
    }

    private static Collection<Integer> generateRandomItems() {
        Collection<Integer> items = new TreeSet<>();

        for (int i = 0; i < COLLECTION_SIZE; i++) {
            items.add((int) (Math.random() * 100000));
        }

        return items;
    }
}
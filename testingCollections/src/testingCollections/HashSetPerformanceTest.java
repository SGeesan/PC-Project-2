package testingCollections;

import java.util.HashSet;
import java.util.Collection;

public class HashSetPerformanceTest {

    private static final int COLLECTION_SIZE = 100000;
    private static final int NUM_TESTS = 100;

    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();

        // Test "add" performance
        testAdd(hashSet);

        // Test "contains" performance
        testContains(hashSet);

        // Test "remove" performance
        testRemove(hashSet);

        // Test "clear" performance
        testClear(hashSet);
    }

    private static void testAdd(HashSet<Integer> hashSet) {
        System.out.println("Add Performance Test");
        long totalTime = 0;

        for (int i = 0; i < NUM_TESTS; i++) {
        	Collection<Integer> items = generateRandomItems();
        	hashSet.addAll(items);
        	
            int elementToAdd = (int) (Math.random() * 100000);

            long startTime = System.nanoTime();
            hashSet.add(elementToAdd);
            long endTime = System.nanoTime();

            totalTime += (endTime - startTime);
            hashSet.clear(); // Clear the set for the next test
        }

        long averageTime = totalTime / NUM_TESTS;
        System.out.println("HashSet - Add: " + averageTime + " ns");
    }

    private static void testContains(HashSet<Integer> hashSet) {
        System.out.println("Contains Performance Test");
        long totalTime = 0;

        for (int i = 0; i < NUM_TESTS; i++) {
        	Collection<Integer> items = generateRandomItems();
        	hashSet.addAll(items);
        	
            int itemToCheck = (int) (Math.random() * 100000); // Get a random item to check

            long startTime = System.nanoTime();
            hashSet.contains(itemToCheck);
            long endTime = System.nanoTime();

            totalTime += (endTime - startTime);
            hashSet.clear(); // Clear the set for the next test
        }

        long averageTime = totalTime / NUM_TESTS;
        System.out.println("HashSet - Contains: " + averageTime + " ns");
    }

    private static void testRemove(HashSet<Integer> hashSet) {
        System.out.println("Remove Performance Test");
        long totalTime = 0;

        for (int i = 0; i < NUM_TESTS; i++) {
        	Collection<Integer> items = generateRandomItems();
            hashSet.addAll(items); // Load the set with items
            
            int itemToRemove =  (int) (Math.random() * 100000); // Get a random item to remove

            long startTime = System.nanoTime();
            hashSet.remove(itemToRemove);
            long endTime = System.nanoTime();

            totalTime += (endTime - startTime);
            hashSet.clear();
            
        }

        long averageTime = totalTime / NUM_TESTS;
        System.out.println("HashSet - Remove: " + averageTime + " ns");
    }

    private static void testClear(HashSet<Integer> hashSet) {
        System.out.println("Clear Performance Test");
        long totalTime = 0;

        for (int i = 0; i < NUM_TESTS; i++) {
        	Collection<Integer> items = generateRandomItems();
            hashSet.addAll(items); // Load the set with items
            
            long startTime = System.nanoTime();
            hashSet.clear();
            long endTime = System.nanoTime();

            totalTime += (endTime - startTime);
        }

        long averageTime = totalTime / NUM_TESTS;
        System.out.println("HashSet - Clear: " + averageTime + " ns");
    }

    private static Collection<Integer> generateRandomItems() {
        Collection<Integer> items = new HashSet<>();

        for (int i = 0; i < COLLECTION_SIZE; i++) {
            items.add((int) (Math.random() * 100000));
        }

        return items;
    }
}
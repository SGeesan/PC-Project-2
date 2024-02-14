package testingCollections;

import java.util.HashMap;
import java.util.Collection;
import java.util.HashSet;

public class HashMapPerformanceTest {

    private static final int COLLECTION_SIZE = 100000;
    private static final int NUM_TESTS = 100;

    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        // Test "put" performance with all elements
        testPut(hashMap);

        // Test "get" performance
        testContains(hashMap);

        // Test "remove" performance
        testRemove(hashMap);

        // Test "clear" performance
        testClear(hashMap);
    }

    private static void testPut(HashMap<Integer, Integer> hashMap) {
        System.out.println("Put Performance Test");
        long totalTime = 0;

        for (int i = 0; i < NUM_TESTS; i++) {
            Collection<Integer> values = generateRandomItems();
            for (int j = 0; j < COLLECTION_SIZE; j++) {
                hashMap.put(j, values.iterator().next());
            }
            
            int keyToAdd = (int) (Math.random() * 100000);
            int valueToAdd = (int) (Math.random() * 100000);

            long startTime = System.nanoTime();
            hashMap.put(keyToAdd, valueToAdd);
            long endTime = System.nanoTime();

            totalTime += (endTime - startTime);
            hashMap.clear(); // Clear the map for the next test
        }

        long averageTime = totalTime / NUM_TESTS;
        System.out.println("HashMap - Put: " + averageTime + " ns");
    }

    private static void testContains(HashMap<Integer, Integer> hashMap) {
        System.out.println("Contains Performance Test");
        Collection<Integer> values = generateRandomItems();

        for (int i = 0; i < COLLECTION_SIZE; i++) {
            hashMap.put(i, values.iterator().next());
        }

        long totalTime = 0;

        for (int i = 0; i < NUM_TESTS; i++) {
        	int itemToCheck = (int) (Math.random() * 100000); // Get the first item from the queue

            long startTime = System.nanoTime();
            hashMap.containsValue(itemToCheck);
            long endTime = System.nanoTime();

            totalTime += (endTime - startTime);
        }

        long averageTime = totalTime / NUM_TESTS;
        System.out.println("HashMap - Get: " + averageTime + " ns");
    }

    private static void testRemove(HashMap<Integer, Integer> hashMap) {
        System.out.println("Remove Performance Test");
        long totalTime = 0;

        for (int i = 0; i < NUM_TESTS; i++) {
        	Collection<Integer> values = generateRandomItems();
            for (int j = 0; j < COLLECTION_SIZE; j++) {
                hashMap.put(j, values.iterator().next());
            }
            
            int keyToRemove = (int) (Math.random() * 100000);
            
            long startTime = System.nanoTime();
            hashMap.remove(keyToRemove);
            long endTime = System.nanoTime();

            totalTime += (endTime - startTime);
            hashMap.clear();
        }

        long averageTime = totalTime / NUM_TESTS;
        System.out.println("HashMap - Remove: " + averageTime + " ns");
    }

    private static void testClear(HashMap<Integer, Integer> hashMap) {
        System.out.println("Clear Performance Test");
        long totalTime = 0;

        for (int i = 0; i < NUM_TESTS; i++) {
        	Collection<Integer> values = generateRandomItems();
            for (int j = 0; j < COLLECTION_SIZE; j++) {
                hashMap.put(j, values.iterator().next());
            }
            
            long startTime = System.nanoTime();
            hashMap.clear();
            long endTime = System.nanoTime();

            totalTime += (endTime - startTime);
            hashMap.clear();
        }

        long averageTime = totalTime / NUM_TESTS;
        System.out.println("HashMap - Clear: " + averageTime + " ns");
    }

    private static Collection<Integer> generateRandomItems() {
        Collection<Integer> items = new HashSet<>();

        for (int i = 0; i < COLLECTION_SIZE; i++) {
            items.add((int) (Math.random() * 100000));
        }

        return items;
    }
}
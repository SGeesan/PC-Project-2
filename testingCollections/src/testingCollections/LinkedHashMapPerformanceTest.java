package testingCollections;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.HashSet;

public class LinkedHashMapPerformanceTest {

    private static final int COLLECTION_SIZE = 100000;
    private static final int NUM_TESTS = 100;

    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();

        // Test "put" performance with all elements
        testPut(linkedHashMap);

        // Test "get" performance
        testContains(linkedHashMap);

        // Test "remove" performance
        testRemove(linkedHashMap);

        // Test "clear" performance
        testClear(linkedHashMap);
    }

    private static void testPut(LinkedHashMap<Integer, Integer> linkedHashMap) {
        System.out.println("Put Performance Test");
        long totalTime = 0;

        for (int i = 0; i < NUM_TESTS; i++) {
            Collection<Integer> values = generateRandomItems();
            for (int j = 0; j < COLLECTION_SIZE; j++) {
            	linkedHashMap.put(j, values.iterator().next());
            }
            
            int keyToAdd = (int) (Math.random() * 100000);
            int valueToAdd = (int) (Math.random() * 100000);

            long startTime = System.nanoTime();
            linkedHashMap.put(keyToAdd,valueToAdd);
            long endTime = System.nanoTime();

            totalTime += (endTime - startTime);
            linkedHashMap.clear(); // Clear the map for the next test
        }

        long averageTime = totalTime / NUM_TESTS;
        System.out.println("LinkedHashMap - Put: " + averageTime + " ns");
    }

    private static void testContains(LinkedHashMap<Integer, Integer> linkedHashMap) {
        System.out.println("Get Performance Test");
        Collection<Integer> values = generateRandomItems();

        for (int i = 0; i < COLLECTION_SIZE; i++) {
            linkedHashMap.put(i, values.iterator().next());
        }

        long totalTime = 0;

        for (int i = 0; i < NUM_TESTS; i++) {
        	int itemToCheck = (int) (Math.random() * 100000); // Get the first item from the queue

            long startTime = System.nanoTime();
            linkedHashMap.containsValue(itemToCheck);
            long endTime = System.nanoTime();

            totalTime += (endTime - startTime);
        }

        long averageTime = totalTime / NUM_TESTS;
        System.out.println("LinkedHashMap - Get: " + averageTime + " ns");
    }

    private static void testRemove(LinkedHashMap<Integer, Integer> linkedHashMap) {
        System.out.println("Remove Performance Test");
        long totalTime = 0;

        for (int i = 0; i < NUM_TESTS; i++) {
        	Collection<Integer> values = generateRandomItems();
        	for (int j = 0; j < COLLECTION_SIZE; j++) {
                linkedHashMap.put(j, values.iterator().next());
            }
        	
            int keyToRemove = (int) (Math.random() * 100000);
            
            long startTime = System.nanoTime();
            linkedHashMap.remove(keyToRemove);
            long endTime = System.nanoTime();

            totalTime += (endTime - startTime);
            linkedHashMap.clear(); // Reload the map for the next test
        }

        long averageTime = totalTime / NUM_TESTS;
        System.out.println("LinkedHashMap - Remove: " + averageTime + " ns");
    }

    private static void testClear(LinkedHashMap<Integer, Integer> linkedHashMap) {
        System.out.println("Clear Performance Test");
        long totalTime = 0;

        for (int i = 0; i < NUM_TESTS; i++) {
        	Collection<Integer> values = generateRandomItems();
            for (int j = 0; j < COLLECTION_SIZE; j++) {
                linkedHashMap.put(j, values.iterator().next());
            }
            
            long startTime = System.nanoTime();
            linkedHashMap.clear();
            long endTime = System.nanoTime();

            totalTime += (endTime - startTime);
            linkedHashMap.clear();
        }

        long averageTime = totalTime / NUM_TESTS;
        System.out.println("LinkedHashMap - Clear: " + averageTime + " ns");
    }

    private static Collection<Integer> generateRandomItems() {
        Collection<Integer> items = new HashSet<>();

        for (int i = 0; i < COLLECTION_SIZE; i++) {
            items.add((int) (Math.random() * 100000));
        }

        return items;
    }
}
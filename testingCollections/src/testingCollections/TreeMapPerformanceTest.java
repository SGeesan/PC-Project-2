package testingCollections;

import java.util.TreeMap;
import java.util.Collection;
import java.util.TreeSet;

public class TreeMapPerformanceTest {

    private static final int COLLECTION_SIZE = 100000;
    private static final int NUM_TESTS = 100;

    public static void main(String[] args) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        // Test "put" performance with all elements
        testPut(treeMap);

        // Test "get" performance
        testContains(treeMap);

        // Test "remove" performance
        testRemove(treeMap);

        // Test "clear" performance
        testClear(treeMap);
    }

    private static void testPut(TreeMap<Integer, Integer> treeMap) {
        System.out.println("Put Performance Test");
        long totalTime = 0;

        for (int i = 0; i < NUM_TESTS; i++) {
            Collection<Integer> values = generateRandomItems();
            for (int j = 0; j < COLLECTION_SIZE; j++) {
                treeMap.put(j, values.iterator().next());
            }
            
            int keyToAdd = (int) (Math.random() * 100000);
            int valueToAdd = (int) (Math.random() * 100000);

            long startTime = System.nanoTime();
            treeMap.put(keyToAdd, valueToAdd);
            long endTime = System.nanoTime();

            totalTime += (endTime - startTime);
            treeMap.clear(); // Clear the map for the next test
        }

        long averageTime = totalTime / NUM_TESTS;
        System.out.println("TreeMap - Put: " + averageTime + " ns");
    }

    private static void testContains(TreeMap<Integer, Integer> treeMap) {
        System.out.println("Get Performance Test");
        Collection<Integer> values = generateRandomItems();

        for (int i = 0; i < COLLECTION_SIZE; i++) {
            treeMap.put(i, values.iterator().next());
        }

        long totalTime = 0;

        for (int i = 0; i < NUM_TESTS; i++) {
        	int itemToCheck = (int) (Math.random() * 100000); // Get the first item from the queue

            long startTime = System.nanoTime();
            treeMap.containsValue(itemToCheck);
            long endTime = System.nanoTime();

            totalTime += (endTime - startTime);
        }

        long averageTime = totalTime / NUM_TESTS;
        System.out.println("TreeMap - Get: " + averageTime + " ns");
    }

    private static void testRemove(TreeMap<Integer, Integer> treeMap) {
        System.out.println("Remove Performance Test");
        long totalTime = 0;

        for (int i = 0; i < NUM_TESTS; i++) {
        	Collection<Integer> values = generateRandomItems();
        	for (int j = 0; j < COLLECTION_SIZE; j++) {
                treeMap.put(j, values.iterator().next());
            }
        	
            int keyToRemove = (int) (Math.random() * 100000);

            long startTime = System.nanoTime();
            treeMap.remove(keyToRemove);
            long endTime = System.nanoTime();

            totalTime += (endTime - startTime);
            treeMap.clear(); // Reload the map for the next test
        }

        long averageTime = totalTime / NUM_TESTS;
        System.out.println("TreeMap - Remove: " + averageTime + " ns");
    }

    private static void testClear(TreeMap<Integer, Integer> treeMap) {
        System.out.println("Clear Performance Test");
        long totalTime = 0;

        for (int i = 0; i < NUM_TESTS; i++) {
        	Collection<Integer> values = generateRandomItems();
            for (int j = 0; j < COLLECTION_SIZE; j++) {
                treeMap.put(j, values.iterator().next());
            }
            
            long startTime = System.nanoTime();
            treeMap.clear();
            long endTime = System.nanoTime();

            totalTime += (endTime - startTime);
            treeMap.clear();
        }

        long averageTime = totalTime / NUM_TESTS;
        System.out.println("TreeMap - Clear: " + averageTime + " ns");
    }

    private static Collection<Integer> generateRandomItems() {
        Collection<Integer> items = new TreeSet<>();

        for (int i = 0; i < COLLECTION_SIZE; i++) {
            items.add((int) (Math.random() * 100000));
        }

        return items;
    }
}
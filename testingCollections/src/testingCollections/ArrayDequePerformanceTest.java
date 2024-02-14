package testingCollections;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.HashSet;

public class ArrayDequePerformanceTest {

    private static final int COLLECTION_SIZE = 100000;
    private static final int NUM_TESTS = 100;

    public static void main(String[] args) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        // Test "add" performance with all elements
        testAdd(arrayDeque);
        
        // Test "get" performance
        testContains(arrayDeque);
        
        // Test "remove" performance
        testRemove(arrayDeque);

        // Test "clear" performance
        testClear(arrayDeque);
    }


	private static void testAdd(ArrayDeque<Integer> arrayDeque) {
        System.out.println("Add Performance Test");
        long totalTime = 0;

        for (int i = 0; i < NUM_TESTS; i++) {
            Collection<Integer> items = generateRandomItems();
            arrayDeque.addAll(items);
            
            int elementToAdd = (int) (Math.random() * 100000);

            long startTime = System.nanoTime();
            arrayDeque.add(elementToAdd);
            long endTime = System.nanoTime();

            totalTime += (endTime - startTime);
            arrayDeque.clear(); // Clear the deque for the next test
        }

        long averageTime = totalTime / NUM_TESTS;
        System.out.println("ArrayDeque - Add: " + averageTime + " ns");
    }
	
    private static void testContains(ArrayDeque<Integer> arrayDeque) {
    	System.out.println("Contains Performance Test");
        long totalTime = 0;

        for (int i = 0; i < NUM_TESTS; i++) {
        	Collection<Integer> items = generateRandomItems();
            arrayDeque.addAll(items); // Load the queue with items
            
            int itemToCheck = (int) (Math.random() * 100000); // Get the first item from the queue

            long startTime = System.nanoTime();
            arrayDeque.contains(itemToCheck);
            long endTime = System.nanoTime();

            totalTime += (endTime - startTime);
            arrayDeque.clear(); // Clear the queue for the next test
        }

        long averageTime = totalTime / NUM_TESTS;
        System.out.println("ArrayDeque - Contains: " + averageTime + " ns");
    }
    
    private static void testRemove(ArrayDeque<Integer> arrayDeque) {
        System.out.println("Remove Performance Test");
        long totalTime = 0;

        for (int i = 0; i < NUM_TESTS; i++) {
        	Collection<Integer> items = generateRandomItems();
            arrayDeque.addAll(items); // Load the deque with items
            
            int itemToRemove = (int) (Math.random() * 100000);

            long startTime = System.nanoTime();
            arrayDeque.remove(itemToRemove);
            long endTime = System.nanoTime();

            totalTime += (endTime - startTime);
            arrayDeque.clear();
        }

        long averageTime = totalTime / NUM_TESTS;
        System.out.println("ArrayDeque - Remove: " + averageTime + " ns");
    }

    private static void testClear(ArrayDeque<Integer> arrayDeque) {
        System.out.println("Clear Performance Test");
        long totalTime = 0;

        for (int i = 0; i < NUM_TESTS; i++) {
        	Collection<Integer> items = generateRandomItems();
            arrayDeque.addAll(items); // Load the deque with items
            
            long startTime = System.nanoTime();
            arrayDeque.clear();
            long endTime = System.nanoTime();

            totalTime += (endTime - startTime);
        }

        long averageTime = totalTime / NUM_TESTS;
        System.out.println("ArrayDeque - Clear: " + averageTime + " ns");
    }

    private static Collection<Integer> generateRandomItems() {
        Collection<Integer> items = new HashSet<>();

        for (int i = 0; i < COLLECTION_SIZE; i++) {
            items.add((int) (Math.random() * 100000));
        }

        return items;
    }
}
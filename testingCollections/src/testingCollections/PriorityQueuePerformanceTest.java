package testingCollections;
import java.util.Collection;
import java.util.HashSet;
import java.util.PriorityQueue;

public class PriorityQueuePerformanceTest {

    private static final int COLLECTION_SIZE = 100000;
    private static final int NUM_TESTS = 100;

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        // Test "add" performance with all elements
        testAdd(priorityQueue);

        // Test "contains" performance
        testContains(priorityQueue);

        // Test "remove" performance
        testRemove(priorityQueue);

        // Test "clear" performance
        testClear(priorityQueue);
    }

    private static void testAdd(PriorityQueue<Integer> priorityQueue) {
        System.out.println("Add Performance Test");
        long totalTime = 0;

        for (int i = 0; i < NUM_TESTS; i++) {
            Collection<Integer> items = generateRandomItems();
            priorityQueue.addAll(items);
            
            int elementToAdd = (int) (Math.random() * 100000);

            long startTime = System.nanoTime();
            priorityQueue.add(elementToAdd);
            long endTime = System.nanoTime();

            totalTime += (endTime - startTime);
            priorityQueue.clear(); // Clear the queue for the next test
        }

        long averageTime = totalTime / NUM_TESTS;
        System.out.println("PriorityQueue - Add: " + averageTime + " ns");
    }
    
    private static void testContains(PriorityQueue<Integer> priorityQueue) {
        System.out.println("Contains Performance Test");
        long totalTime = 0;

        for (int i = 0; i < NUM_TESTS; i++) {
        	Collection<Integer> items = generateRandomItems();
            priorityQueue.addAll(items); // Load the queue with items
            
            int itemToCheck = (int) (Math.random() * 100000); // Get the first item from the queue

            long startTime = System.nanoTime();
            priorityQueue.contains(itemToCheck);
            long endTime = System.nanoTime();

            totalTime += (endTime - startTime);
            priorityQueue.clear(); // Clear the queue for the next test
        }

        long averageTime = totalTime / NUM_TESTS;
        System.out.println("PriorityQueue - Contains: " + averageTime + " ns");
    }

    private static void testRemove(PriorityQueue<Integer> priorityQueue) {
        System.out.println("Remove Performance Test");

        long totalTime = 0;

        for (int i = 0; i < NUM_TESTS; i++) {
            Collection<Integer> items = generateRandomItems();
            priorityQueue.addAll(items); // Load the queue with items
            
            int itemToRemove = (int) (Math.random() * 100000); // Get a random item to remove

            long startTime = System.nanoTime();
            priorityQueue.remove(itemToRemove);
            long endTime = System.nanoTime();

            totalTime += (endTime - startTime);
            priorityQueue.clear();
        }

        long averageTime = totalTime / NUM_TESTS;
        System.out.println("PriorityQueue - Remove: " + averageTime + " ns");
    }

    private static void testClear(PriorityQueue<Integer> priorityQueue) {
        System.out.println("Clear Performance Test");
        long totalTime = 0;

        for (int i = 0; i < NUM_TESTS; i++) {
            Collection<Integer> items = generateRandomItems();
            priorityQueue.addAll(items); // Load the queue with items
            
            long startTime = System.nanoTime();
            priorityQueue.clear();
            long endTime = System.nanoTime();

            totalTime += (endTime - startTime);
        }

        long averageTime = totalTime / NUM_TESTS;
        System.out.println("PriorityQueue - Clear: " + averageTime + " ns");
    }

    private static Collection<Integer> generateRandomItems() {
        Collection<Integer> items = new HashSet<>();

        for (int i = 0; i < COLLECTION_SIZE; i++) {
            items.add((int) (Math.random() * 100000));
        }

        return items;
    }
}
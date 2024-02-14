package testingCollections;

import java.util.ArrayList;
import java.util.Collection;

public class ArrayListPerformanceTest {

    private static final int COLLECTION_SIZE = 100000;
    private static final int NUM_TESTS = 100;

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        // Test "add" performance
        testAdd(arrayList);

        // Test "contains" performance
        testContains(arrayList);

        // Test "remove" performance
        testRemove(arrayList);

        // Test "clear" performance
        testClear(arrayList);
    }

    private static void testAdd(ArrayList<Integer> arrayList) {
        System.out.println("Add Performance Test");
        long totalTime = 0;

        for (int i = 0; i < NUM_TESTS; i++) {
            Collection<Integer> items = generateRandomItems();
            arrayList.addAll(items);
            
            int elementToAdd = (int) (Math.random() * 100000);
            
            long startTime = System.nanoTime();
            arrayList.add(elementToAdd); //add a value for array list;
            long endTime = System.nanoTime();

            totalTime += (endTime - startTime);
            arrayList.clear(); // Clear the list for the next test
        }

        long averageTime = totalTime / NUM_TESTS;
        System.out.println("ArrayList - Add: " + averageTime + " ns");
    }

    private static void testContains(ArrayList<Integer> arrayList) {
        System.out.println("Contains Performance Test");
        long totalTime = 0;

        for (int i = 0; i < NUM_TESTS; i++) {
        	Collection<Integer> items = generateRandomItems();
        	arrayList.addAll(items); // Load the list with items
        	
        	Integer itemToCheck = (int) (Math.random() * 100000);
        	
        	long startTime = System.nanoTime();
            arrayList.contains(itemToCheck);
            long endTime = System.nanoTime();

            totalTime += (endTime - startTime);
            arrayList.clear(); // Clear the list for the next test
        }

        long averageTime = totalTime / NUM_TESTS;
        System.out.println("ArrayList - Contains: " + averageTime + " ns");
    }

    private static void testRemove(ArrayList<Integer> arrayList) {
        System.out.println("Remove Performance Test");
        long totalTime = 0;

        for (int i = 0; i < NUM_TESTS; i++) {
        	 // Get the first item from the iterator
        	Collection<Integer> items = generateRandomItems();
        	arrayList.addAll(items);// Load the list with items
        	
            Integer itemToRemove= (int) (Math.random() * 100000);
            
            long startTime = System.nanoTime();
            arrayList.remove(itemToRemove);
            long endTime = System.nanoTime();

            totalTime += (endTime - startTime);
            arrayList.clear(); // Clear the list for the next test
        }

        long averageTime = totalTime / NUM_TESTS;
        System.out.println("ArrayList - Remove: " + averageTime + " ns");
    }

    private static void testClear(ArrayList<Integer> arrayList) {
        System.out.println("Clear Performance Test");
        long totalTime = 0;

        for (int i = 0; i < NUM_TESTS; i++) {
        	Collection<Integer> items = generateRandomItems();
        	arrayList.addAll(items); // Load the list with items
        	
            long startTime = System.nanoTime();
            arrayList.clear();
            long endTime = System.nanoTime();

            totalTime += (endTime - startTime);
        }

        long averageTime = totalTime / NUM_TESTS;
        System.out.println("ArrayList - Clear: " + averageTime + " ns");
    }

    private static Collection<Integer> generateRandomItems() {
        Collection<Integer> items = new ArrayList<>();

        for (int i = 0; i < COLLECTION_SIZE; i++) {
            items.add((int) (Math.random() * 100000));
        }

        return items;
    }
}
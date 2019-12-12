package edu.isu.cs2235.algorithms.impl;

/**
 * @author Katherine Wilsdon
 */
public class BinarySearch extends Algorithm {
    /**
     * Generates a binary search class
     */
    public BinarySearch() {
    }

    /**
     * Generic array search method.
     *
     * @param <E> Type of data searched must implement Comparable interface.
     * @param array Array to be search for the provided item
     * @param item Item to be found
     * @return The index of the provided item in the array. Returns -1 if any of
     * the following conditions are met:
     * <ul>
     * <li>The provided array is null</li>
     * <li>The provided array is empty</li>
     * <li>The provided item is null</li>
     * <li>The provided array does not contain the item</li>
     * </ul>
     */
    @Override
    public <E extends Comparable> int search(E[] array, E item){
        if (array == null || item == null)
            return -1;
        else
            return iterBinarySearch(array, item);
    }

    /**
     * Iterative binary search method.
     *
     * @param <E> Type of data searched must implement Comparable interface.
     * @param array Array to be search for the provided item
     * @param item Item to be found
     * @return The index of the provided item in the array. Returns -1 if any of
     * the following conditions are met:
     * <ul>
     * <li>The provided array is null</li>
     * <li>The provided array is empty</li>
     * <li>The provided item is null</li>
     * <li>The provided array does not contain the item</li>
     * </ul>
     */
    private <E extends Comparable> int iterBinarySearch(E[] array, E item){
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int index = (low + high) / 2;
            if (item == array[index])
                return index;
            else if (item.compareTo(array[index]) < 0)
                high = index - 1;
            else
                low = index + 1;
        }
        return -1;
    }
}

package edu.isu.cs2235.algorithms.impl;

/**
 * @author Katherine Wilsdon
 */
public class LinearSearch extends Algorithm {

    /**
     * Generates a linear search class
     */
    public LinearSearch() {
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
            return iterLinearSearch(array, item);
    }

    /**
     * Iterative linear search method.
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
    private <E extends Comparable> int iterLinearSearch(E[] array, E item){
        for (int i = 0; i < array.length; ++i){
            if (array[i] == item)
                return i;
        }
        return -1;
    }
}

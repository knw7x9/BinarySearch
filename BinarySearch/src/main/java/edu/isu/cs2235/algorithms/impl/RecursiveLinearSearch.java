package edu.isu.cs2235.algorithms.impl;

/**
 * @author Katherine Wilsdon
 */
public class RecursiveLinearSearch extends Algorithm {

    /**
     * Generates a recursive linear search class
     */
    public RecursiveLinearSearch() {
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
            return linearSearch(array, item);
    }



    /**
     * Linear search method.
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
    private <E extends Comparable> int linearSearch(E[] array, E item){
        return recLinearSearch(array, item, 0);
    }

    /**
     * Recursive linear search method.
     *
     * @param <E> Type of data searched must implement Comparable interface.
     * @param array Array to be search for the provided item
     * @param item Item to be found
     * @param index Index in the array
     * @return The index of the provided item in the array. Returns -1 if any of
     * the following conditions are met:
     * <ul>
     * <li>The provided array is null</li>
     * <li>The provided array is empty</li>
     * <li>The provided item is null</li>
     * <li>The provided array does not contain the item</li>
     * </ul>
     */
    private <E extends Comparable> int recLinearSearch(E[] array, E item, int index){
        if (index >= array.length)
            return -1;
        else if (array[index] == item)
            return index;
        return recLinearSearch(array, item, index +1);
    }
}

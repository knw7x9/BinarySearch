package edu.isu.cs2235.algorithms.impl;

/**
 * @author Katherine Wilsdon
 */
public class RecursiveBinarySearch extends Algorithm {

    /**
     * Generates a recursive binary search class
     */
    public RecursiveBinarySearch() {
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
            return binarySearch(array, item);
    }

    /**
     * Binary search method.
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
    private <E extends Comparable> int binarySearch(E[] array, E item){
        return recBinarySearch(array, item, 0, array.length);
    }

    /**
     * Generic array search method.
     *
     * @param <E> Type of data searched must implement Comparable interface.
     * @param array Array to be search for the provided item
     * @param item Item to be found
     * @param low Lowest index in an array
     * @param high Highest index in an array
     * @return The index of the provided item in the array. Returns -1 if any of
     * the following conditions are met:
     * <ul>
     * <li>The provided array is null</li>
     * <li>The provided array is empty</li>
     * <li>The provided item is null</li>
     * <li>The provided array does not contain the item</li>
     * </ul>
     */
    private <E extends Comparable> int recBinarySearch(E[] array, E item, int low, int high){
        int index = (low + high) / 2;
        if (low >= high)
            return -1;
        else if (item == array[index])
            return index;
        else if (item.compareTo(array[index]) < 0)
            return recBinarySearch(array, index, low, index - 1);
        else
            return recBinarySearch(array,item, index + 1, high);

    }
}

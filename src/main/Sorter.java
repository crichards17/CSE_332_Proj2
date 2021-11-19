package main;
import providedCode.Comparator;


/** 
 *  TODO: REPLACE this comment with your own as appropriate.
 *  Implement the sorting methods below. Do not change the provided
 *  method signature, but you may add as many other methods as you
 *  want.
 */
public class Sorter {
	
	/**
     * Sort the count array in descending order of count. If two elements have
     * the same count, they should be ordered according to the comparator.
     * This code uses insertion sort. The code is generic, but in this project
     * we use it with DataCount<String> and DataCountStringComparator.
     * @param counts array to be sorted.
     * @param comparator for comparing elements.
     */
    public static <E> void insertionSort(E[] array, Comparator<E> comparator) {
        for (int i = 1; i < array.length; i++) {
            E x = array[i];
            int j;
            for (j=i-1; j>=0; j--) {
                if (comparator.compare(x,array[j]) >= 0) { break; }
                array[j + 1] = array[j];
            }
            array[j + 1] = x;
        }
    }
    
    public static <E> void heapSort(E[] array, Comparator<E> comparator) {
    	// TODO: To-be implemented
    }
    
    /**
     * TODO: REPLACE this comment with your own as appropriate.  In
     * topKSort, you will need to use a different comparator which
     * considers the element with the lowest count to be the
     * "smallest". You should *NOT* change how your FourHeap
     * interprets the comparator result.  The heap should always interpret
     * a negative number from the comparator as the first argument being
     * "smaller" than the second.
     * 
     * Make sure topK sort only prints the first k elements. In 
     * WordCount, you can either modify the signature of the existing
     * print method or add another print method for topKSort.
     */
    public static <E> void topKSort(E[] array, Comparator<E> comparator, int k) {
    	// TODO: To-be implemented (the order of elements at index >= k does not matter)
    }
    
    public static <E> void otherSort(E[] array, Comparator<E> comparator) {
    	// TODO: To-be implemented (either mergeSort or QuickSort)
    }

}

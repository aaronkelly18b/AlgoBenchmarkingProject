package ATU;

/**
 * The SortingAlgorithm interface provides a structure for implementing various
 * sorting algorithms. This interface requires the implementation of a single
 * method called sort, which takes an integer array as input and sorts it in
 * place.
 */
public interface SortingAlgorithm {

    /**
     * Sorts an array of integers in place, using the specific sorting algorithm
     * implemented by the class.
     *
     * @param arr the array of integers to be sorted
     */
    void sort(int[] arr);
}

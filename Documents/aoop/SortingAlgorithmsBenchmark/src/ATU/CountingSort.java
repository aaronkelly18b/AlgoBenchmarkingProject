package ATU;

public class CountingSort implements SortingAlgorithm {

	/**
	 * Sorts the given integer array using the Counting Sort algorithm.
	 *
	 * @param arr The integer array to be sorted.
	 */
	@Override
	public void sort(int[] arr) {
		// Find the maximum element in the array
		int max = findMax(arr);

		// Create a count array to store the frequency of each element
		int[] count = new int[max + 1];

		// Count the frequency of each element in the array
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}

		// Calculate the number of elements before each element in the count array
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}

		// Create a temporary array to hold the sorted elements
		int[] temp = new int[arr.length];

		// Sort the elements into the temporary array in descending order
		for (int i = arr.length - 1; i >= 0; i--) {
			int index = count[arr[i]] - 1;
			temp[index] = arr[i];
			count[arr[i]]--;
		}

		// Copy the sorted elements back into the original array
		for (int i = 0; i < arr.length; i++) {
			arr[i] = temp[i];
		}
	}

	/**
	 * Finds the maximum element in the given integer array.
	 *
	 * @param arr The integer array to be searched.
	 * @return The maximum element in the array.
	 */
	private static int findMax(int[] arr) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}
}

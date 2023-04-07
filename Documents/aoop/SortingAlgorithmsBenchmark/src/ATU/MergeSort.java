package ATU;

public class MergeSort implements SortingAlgorithm {

	@Override
	public void sort(int[] array) {
		mergeSort(array, 0, array.length - 1);
	}

	public static void mergeSort(int[] arr, int left, int right) {
		if (left < right) {
			// Find the middle index of the array
			int mid = (left + right) / 2;

			// Recursively sort the left half of the array
			mergeSort(arr, left, mid);

			// Recursively sort the right half of the array
			mergeSort(arr, mid + 1, right);

			// Merge the two sorted halves of the array
			merge(arr, left, mid, right);
		}
	}

	public static void merge(int[] arr, int left, int mid, int right) {
		// Determine the sizes of the two subarrays to be merged
		int leftSize = mid - left + 1;
		int rightSize = right - mid;

		// Create temporary arrays to hold the left and right subarrays
		int[] leftArr = new int[leftSize];
		int[] rightArr = new int[rightSize];

		// Copy the left and right subarrays into their respective temporary arrays
		for (int i = 0; i < leftSize; i++) {
			leftArr[i] = arr[left + i];
		}
		for (int j = 0; j < rightSize; j++) {
			rightArr[j] = arr[mid + 1 + j];
		}

		// Merge the left and right subarrays back into the original array
		int i = 0; // Index for left subarray
		int j = 0; // Index for right subarray
		int k = left; // Index for merged array
		while (i < leftSize && j < rightSize) {
			if (leftArr[i] <= rightArr[j]) {
				arr[k] = leftArr[i];
				i++;
			} else {
				arr[k] = rightArr[j];
				j++;
			}
			k++;
		}

		// Copy any remaining elements from the left subarray
		while (i < leftSize) {
			arr[k] = leftArr[i];
			i++;
			k++;
		}

		// Copy any remaining elements from the right subarray
		while (j < rightSize) {
			arr[k] = rightArr[j];
			j++;
			k++;
		}
	}
}

package ATU;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class Benchmark {

	private static final int NUM_RUNS = 10;

	public static void main(String[] args) {
		int[] inputSizes = { 100, 250, 500, 750, 1000, 1250, 2500, 3750, 5000, 6250, 7500, 8750, 10000 };

		// Create a map to store the results of each sorting algorithm
		Map<String, List<Double>> results = new HashMap<>();

		for (int n : inputSizes) {
			System.out.println("Benchmarking with input size " + n + "...");
			Map<String, Double> runResults = benchmarkSortingAlgorithms(n);

			// Store the results of the current run
			for (Map.Entry<String, Double> entry : runResults.entrySet()) {
				results.computeIfAbsent(entry.getKey(), k -> new ArrayList<>()).add(entry.getValue());
			}

			System.out.println();
		}

		// Write the results to a CSV file
		writeResultsToCSV(results, inputSizes, "benchmark_results.csv");
	}

	// This method benchmarks the sorting algorithms for a given input size (n) and
	// returns a map with the results.
	private static Map<String, Double> benchmarkSortingAlgorithms(int n) {
		// Create a map of algorithm names to SortingAlgorithm instances.
		Map<String, SortingAlgorithm> algorithms = new HashMap<>();
		algorithms.put("Bubble Sort", new BubbleSort());
		algorithms.put("Selection Sort", new SelectionSort());
		algorithms.put("Insertion Sort", new InsertionSort());
		algorithms.put("Merge Sort", new MergeSort());
		algorithms.put("Counting Sort", new CountingSort());

		// Create a map to store the benchmark results for each algorithm.
		Map<String, Double> runResults = new HashMap<>();

		// Iterate through the map of algorithms.
		for (String algorithmName : algorithms.keySet()) {
			// Get the SortingAlgorithm instance for the current algorithm.
			SortingAlgorithm algorithm = algorithms.get(algorithmName);

			// Benchmark the current algorithm and store the execution time.
			double executionTime = benchmarkAlgorithm(algorithm, n);

			// Add the execution time to the results map using the algorithm name as the
			// key.
			runResults.put(algorithmName, executionTime);
		}

		// Return the map containing the benchmark results for all the algorithms.
		return runResults;
	}

	private static double benchmarkAlgorithm(SortingAlgorithm algorithm, int n) {
		// Initialize variable to keep track of total time
		long totalTime = 0;

		// Run sorting algorithm NUM_RUNS times
		for (int i = 0; i < NUM_RUNS; i++) {
			// Generate random array of length n
			int[] array = generateRandomArray(n);

			// Record start time
			long startTime = System.currentTimeMillis();

			// Sort the array using the provided sorting algorithm
			algorithm.sort(array);

			// Record end time and calculate elapsed time
			long endTime = System.currentTimeMillis();
			totalTime += (endTime - startTime);
		}

		// Calculate and return average time
		return totalTime / (double) NUM_RUNS;
	}

	private static int[] generateRandomArray(int n) {
		// Create a new Random object
		Random random = new Random();

		// Initialize array
		int[] array = new int[n];

		// Fill array with random integers between 0 and 9999
		for (int i = 0; i < n; i++) {
			array[i] = random.nextInt(10000);
		}

		// Return array
		return array;
	}

	public static void writeResultsToCSV(Map<String, List<Double>> results, int[] inputSizes, String filename) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
			// Write header row
			writer.write("Input Size");
			for (String algorithm : results.keySet()) {
				writer.write("," + algorithm);
			}
			writer.newLine();

			// Write data rows
			int numInputSizes = results.values().iterator().next().size();
			for (int i = 0; i < numInputSizes; i++) {
				writer.write(Integer.toString(inputSizes[i]));
				for (List<Double> times : results.values()) {
					writer.write("," + times.get(i));
				}
				writer.newLine();
			}
		} catch (IOException e) {
			// Print stack trace if an error occurs while writing to file
			e.printStackTrace();
		}
	}

}

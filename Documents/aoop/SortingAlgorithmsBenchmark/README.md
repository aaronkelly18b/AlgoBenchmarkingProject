# Sorting Algorithms Benchmark

This project is a benchmarking tool to compare the performance of various sorting algorithms. The implemented sorting algorithms include:

- Bubble Sort
- Counting Sort
- Insertion Sort
- Merge Sort
- Selection Sort

## How to Run

To run the benchmark, simply compile and execute the `Benchmark.java` file. The benchmark will perform multiple runs for each sorting algorithm with various input sizes. The results will be output to the console and saved in a CSV file named `benchmark_results.csv`.

## Structure

The project is organized into the following packages and classes:

- `ATU` package:
  - `SortingAlgorithm.java`: An interface that defines the structure for implementing different sorting algorithms.
  - `BubbleSort.java`: Implements the Bubble Sort algorithm.
  - `CountingSort.java`: Implements the Counting Sort algorithm.
  - `InsertionSort.java`: Implements the Insertion Sort algorithm.
  - `MergeSort.java`: Implements the Merge Sort algorithm.
  - `SelectionSort.java`: Implements the Selection Sort algorithm.
  - `Benchmark.java`: Contains the main method that runs the benchmark and saves the results to a CSV file.

## Results

The benchmark will output the average execution time for each sorting algorithm and input size. These results will be saved in a CSV file named `benchmark_results.csv`. You can use this file to analyze the performance of each sorting algorithm and compare them to each other.

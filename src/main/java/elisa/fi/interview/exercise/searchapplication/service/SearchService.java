package elisa.fi.interview.exercise.searchapplication.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

import org.springframework.stereotype.Service;

@Service
public class SearchService {

  // 1.Using java 17 Stream API - Its good choice while working with large data as it allows us to
  // process data on-the-fly and no need to load entire data.
  // Time complexity is O(n) for filtering streams
  // Space complexity is O(1) as streams are processed lazily and only one element is kept in memory
  // regardless of array size.
  public int findMinPositiveValueUsingStreamAPI(int[] array) {
    return Arrays.stream(array)
        .filter(x -> x > 0).distinct()
        .sorted()
        .reduce(1, (prev, curr) -> (prev == curr) ? curr + 1 : prev);
  }

  // 2.Sorting method: Sort the input array first in asc order and then find the first positive
  // element from sorted array.
  // Time and Space complexity is O(n log n) as Arrays.sort() depends on Dual-Pivot Quicksort
  // algorithm
  public int findMinPositiveValueUsingSortMethod(int[] array) {
    Arrays.sort(array);
    int missPositive = 1;
    for (int i : array) {
      if (i == missPositive) {
        missPositive++;
      } else if (i > missPositive) {
        break;
      }
    }
    return missPositive;
  }

  // 3.Brute Force method:
  // Time complexity is O(n) as it iterates through entire array.
  // Space complexity is O(1) as amount of memory used in this method is constant.
  public int findMinPositiveValueUsingBruteForce(int array[]) {
    int len = array.length;
    int index = 0;
    // usecase for validating 1 exists in array
    for (int i = 0; i < len; i++) {
      if (array[i] == 1) {
        index = 1;
        break;
      }
    }
    // If 1 is not present
    if (index == 0) return (1);
    // Changing values to 1
    for (int i = 0; i < len; i++) if (array[i] <= 0 || array[i] > len) array[i] = 1;
    // update indexes as per values
    for (int i = 0; i < len; i++) array[(array[i] - 1) % len] += len;
    // search for index less than len
    for (int i = 0; i < len; i++) if (array[i] <= len) return (i + 1);
    // If array has values from 1 to len
    return (len + 1);
  }

  // 4.Using HashSet: Add all positive ints to hashset and then iterate to find min int
  // Time complexity is O(n) for adding and O(1) for finding.
  // Space complexity is O(n) as amount of memory used in this method is constant.
  public int findMinPositiveValueUsingHashSet(int[] array) {

    HashSet<Integer> hashSet = new HashSet<Integer>();
    int minValue = 1;
    int len = array.length;
    for (int i = 0; i < len; i++) {
      hashSet.add(array[i]);
    }
    while (hashSet.contains(minValue)) {
      minValue++;
    }
    return minValue;
  }

  // 5. Using min-heap : Adding all positive values to min-heap, where root element of heap will
  // contain min int.
  // Time complexity O(n log(n))
  // Space complexity O(n)
  public int findMinPositiveValueUsingMinHeap(int[] nums) {

    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    for (int i : nums) {
      if (i > 0) {
        minHeap.add(i);
      }
    }
    int nextMissingNum =1;
    while (!minHeap.isEmpty()){
      int polled = minHeap.poll();
      if (polled == nextMissingNum){
        nextMissingNum++;
    }
      else {
        if (polled > nextMissingNum){
          return nextMissingNum;
        }
           }
      }
    return nextMissingNum;}
}

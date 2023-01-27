# Search minimum positive number API

#0d117 Below Five ways have been used for this usecase :
```
1. Using java 17 Stream API - Its good choice while working with large data as it allows us to process data on-the-fly and no need to load entire data.
Time complexity is O(n) for filtering streams
Space complexity is O(1) as streams are processed lazily and only one element is kept in memory regardless of array size.

2. Sorting method: Sort the input array first in asc order and then find the first positive element from sorted array.
Time and Space complexity is O(n log n) as Arrays.sort() depends on Dual-Pivot Quicksort algorithm

3. Brute Force method:
Time complexity is O(n) as it iterates through entire array.
Space complexity is O(1) as amount of memory used in this method is constant.

4. Using HashSet: Add all positive ints to hashset and then iterate to find min int
Time complexity is O(n) for adding and O(1) for finding.
Space complexity is O(n) as amount of memory used in this method is constant.

5. Using min-heap : Adding all positive values to min-heap, where root element of heap will contain min int.
Time complexity O(n log(n))
Space complexity O(n)
```

## Build and run command:
```
mvn clean install
Application will run on default port 8080
mvn spring-boot:run
```

## Swagger Open Api url:
```
http://localhost:8080/swagger-ui/index.html
```


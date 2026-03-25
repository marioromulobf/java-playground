# Problem
This is a table test for *DPK02*:

**A function that can revert a list.**

```bash
revert([1,2,3,4,5]) -> [5,4,3,2,1]
```

## Table Test - Implementation 1

1. Line 21 (main): the DPK02Impl1 class is instantiated.
2. Line 23 (main): the input array [1,2,3,4,5] is defined.
3. Line 24 (main): the output "Before revert: [1, 2, 3, 4, 5]" is printed to the console.
4. Line 26 (main): the `revert` method is called with the input array.
5. Line 7-9 (revert): if the input array is null or its length is less than or equal to 1, the flow is stopped with a return.
6. Line 11 (revert): a variable `max` of type int is initialized with the length of the input divided by 2.
7. Line 12 (revert): a for loop iterates over the input array, starting from 0 to value of `max`.
8. Line 13 (revert): during each iteration, a viable `aux` is initialized with the i-th character of the input array.
9. Line 14 (revert): during each iteration, the i-th position of the array is assigned the value at the `length - 1 - i` position.
10. Line 15 (revert): during each iteration, the `length - 1 - i` position of the array is assigned the value of `aux`.
11. Line 28 (main): the output "After revert: [5, 4, 3, 2, 1]" is printed to the console.

## Table Test - Implementation 2

1. Line 21 (main): the DPK02Impl2 class is instantiated.
2. Line 23 (main): the input array [1,2,3,4,5] is defined.
3. Line 24 (main): the output "Before revert: [1, 2, 3, 4, 5]" is printed to the console.
4. Line 26 (main): the `revert` method is called with the input array.
5. Line 7-9 (revert): if the input array is null or its length is less than or equal to 1, the flow is stopped with a return.
6. Line 11 (revert): a variable `min` of type int is initialized with the length of the input divided by 2.
7. Line 12 (revert): a for loop iterates over the input array, starting from length to value of `min`.
8. Line 13 (revert): during each iteration, a viable `aux` is initialized with the i-th - 1 character of the input array.
9. Line 14 (revert): during each iteration, the i-th - 1 position of the array is assigned the value at the `length - i` position.
10. Line 15 (revert): during each iteration, the `length - i` position of the array is assigned the value of `aux`.
11. Line 28 (main): the output "After revert: [5, 4, 3, 2, 1]" is printed to the console.

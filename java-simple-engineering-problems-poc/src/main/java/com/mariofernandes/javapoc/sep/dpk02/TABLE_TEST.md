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

## Table Test - Implementation 3

1. Line 24 (main): the DPK02Impl3 class is instantiated.
2. Line 26 (main): the input array [1,2,3,4,5] is defined.
3. Line 27 (main): the output "Before revert: [1, 2, 3, 4, 5]" is printed to the console.
4. Line 29 (main): the `revert` method is called with the input array.
5. Line 7-9 (revert): if the input array is null or its length is less than or equal to 1, the flow is stopped with a return.
6. Line 11 (revert): a variable `begin` of type int is initialized with zero.
7. Line 12 (revert): a variable `end` of type int is initialized with the length of the input minus one.
8. Line 13 (revert): a while loop runs as long as `end` is greater than `begin`.
9. Line 14 (revert): during each iteration, a variable `aux` is initialized with the value at the `begin` position of the input array.
10. Line 15 (revert): during each iteration, the `begin` position of the array is assigned the value of its `end` position.
11. Line 16 (revert): during each iteration, the `end` position of the array is assigned the value of its `end` position.
12. Line 17 (revert): during each iteration, the variable `begin` is incremented by 1.
13. Line 18 (revert): during each iteration, the variable `end` is decremented by 1.
14. Line 31 (main): the output "After revert: [5, 4, 3, 2, 1]" is printed to the console.

## Table Test - Implementation 4

1. Line 28 (main): the DPK02Impl4 class is instantiated.
2. Line 30 (main): the input list [1, 2, 3, 4, 5] is defined.
3. Line 31 (main): the output "Before revert: [1, 2, 3, 4, 5]" is printed to the console.
4. Line 33 (main): the `revert` method is called with the input list.
5. Line 7-9 (revert): if the input list is null or its size is less than or equal to 1, the input list is returned as is.
6. Line 12 (revert): a variable `result` of type list is instantiated.
7. Line 13 (revert): a variable `count` of type int is initialized with the length of the input minus one.
8. Line 14 (revert): a while loop runs as long as `result` size is less than the input list size.
9. Line 15 (revert): during each iteration, the value at the `count` position of input is added to `result`
10. Line 16 (revert): during each iteration, the variable `count` is decremented by 1.
11. Line 19 (revert): after the loop completes, the `result` list is returned. In this case, it will return "[5, 4, 3, 2, 1]".
12. Line 31 (main): the output "After revert: [5, 4, 3, 2, 1]" is printed to the console.

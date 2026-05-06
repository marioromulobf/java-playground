# Problem
This is a table test for *DPK07 - Group Bu*:

**Create a function that can group a list of numbers by a given number.**
```
group_by([1,2,3,4,5,6,7,8,9,10], 3) -> [[1,2,3], [4,5,6], [7,8,9], [10]]
```

**Please make sure the same function works with strings as well.**
```
group_by(["a","b","c","d","e","f","g","h","i","j"], 3) -> [["a","b","c"], ["d","e","f"], ["g","h","i"], ["j"]]
```

**Can you refactor the code and create your own group by function, do not use any prebuild function.**

## Table Test - Implementation 1

1. Line 37 (main): the DPK07Impl1 class is instantiated.
2. Line 39 (main): the `groupBy` method is called with the list [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] and the `sizeGroup` 3.
3. Line 9 (groupBy): a variable `result` of type List of List is initialized.
4. Line 11 (groupBy): checks whether the size of the input list `items` is less than or equal to the input `sizeGroup`.
5. Lines 12-13 (groupBy): if a match is found, the input `items` are added to the `result` variable, and the variable is returned.
6. Line 16 (groupBy): a variable named `subList` of type List is initialized with the size `sizeGroup`.
7. Line 17 (groupBy): a variable named `countBySizeGroup` of type int is initialized with 0.
8. Line 18 (groupBy): a for loop iterates over the input list, starting from 0 up to the size of the list.
9. Line 19 (groupBy): during each iteration, it checks whether the size of the `subList` is equal to the input `sizeGroup`.
10. Line 20 (groupBy): if the condition is true, `subList` is added to the `result` variable.
11. Line 21 (groupBy): and `subList` is reinitialized with the size `sizeGroup`.
12. Line 22 (groupBy): and the variable `i` is set to zero.
13. Line 23 (groupBy): and the variable `countBySizeGroup` is set to the product of the size of `result` and `sizeGroup`.
14. Line 25 (groupBy): after the conditional block, the item at the position given by the sum of `countBySizeGroup` and `i` in the input `items` is added to `subList`.
15. Line 28 (groupBy): after the loop block, it checks whether the size of `subList` is greater than zero.
16. Line 29 (groupBy): if the condition is true, `subList` is added to the `result` variable.
17. Line 32 (groupBy): the `result` variable is returned, containing the grouped list of items.
18. Line 40 (main): the output of the `groupBy` method is printed, showing the list [[1, 2, 3], [4, 5, 6], [7, 8, 9], [10]].
19. Line 42 (main): the `groupBy` method is called again with the list ["a", "b", "c", "d", "e", "f", "g", "h", "i", "j"] and the `sizeGroup` 3.
20. Line 43 (main): the output of the `groupBy` method is printed, showing the list [["a", "b", "c"], ["d", "e", "f"], ["g", "h", "i"], ["j"]].

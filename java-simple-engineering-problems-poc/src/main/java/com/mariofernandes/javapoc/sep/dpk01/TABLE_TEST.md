# Problem
This is a table test for *DPK01*:

**A function that takes a string and reverses it.**

```bash
revert("Hello") -> "olleH"
```

## Table Test - Implementation 1

1. Line 16 (main): the input string is "Mario Romulo"
2. Line 17 (main): the `revertString` method is called with the input string.
3. Line 5 (revertString): a variable `reverted` is initialized as an empty string.
4. Line 7 (revertString): a for loop iterates over the input in reverse order, starting from the last character to the first.
5. Line 8 (revertString): during each iteration, the (i-th - 1) character of the input string is appended to the `reverted` variable.
6. Line 11 (revertString): after the loop completes, the `reverted` string is returned. In this case, it will return "olumoR oiraM".
7. Line 18 (main): the output "Original: Mario Romulo" is printed to the console.
8. Line 19 (main): the output "Reverted: olumoR oiraM" is printed to the console.

## Table Test - Implementation 2

1. Line 16 (main): the DPK01Impl2 class is instantiated.
2. Line 17 (main): the input string "Mario Romulo" is defined.
3. Line 19 (main): the `revertString` method is called with the input string.
4. Line 5 (revertString): a variable `length` of type int is initialized with the length of the input string.
5. Line 6 (revertString): a variable `reverted` of type char array is initialized with the same length as the input string.
6. Line 8 (revertString): a for loop iterates over the input string, starting from zero to the length of the string.
7. Line 9 (revertString): during each iteration, the i-th character of the input string is assigned to the `length - i - 1` position in the array.
8. Line 12 (revertString): after the loop completes, a new string is created from the `reverted` char array and returned. In this case, it will return "olumoR oiraM".
9. Line 21 (main): the output "Original: Mario Romulo" is printed to the console.
10. Line 22 (main): the output "Reverted: olumoR oiraM" is printed to the console.



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

## Table Test - Implementation 3

1. Line 18 (main): the DPK01Impl3 class is instantiated.
2. Line 19 (main): the input string "Mario Romulo" is defined.
3. Line 21 (main): the `revertString` method is called with the input string.
4. Line 5 (revertString): a variable `length` of type int is initialized with the length of the input string.
5. Line 6 (revertString): a variable `lengthMinusOne` of type int is initialized with the value of `length` minus 1.
6. Line 7 (revertString): a variable `reverted` of type char array is initialized with the same length as the input string.
7. Line 10 (revertString): a for loop iterates over the input string, starting from 0 to the length of the string.
8. Line 11 (revertString): during each iteration, the i-th character of the input string is assigned to the `lengthMinusOne - i` position in the array.
9. Line 14 (revertString): after the loop completes, a new string is created from the `reverted` char array and returned. In this case, it will return "olumoR oiraM".
10. Line 23 (main): the output "Original: Mario Romulo" is printed to the console.
11. Line 24 (main): the output "Reverted: olumoR oiraM" is printed to the console.

## Table Test - Implementation 4

1. Line 18 (main): the DPK01Impl4 class is instantiated.
2. Line 19 (main): the input string "Mario Romulo" is defined.
3. Line 21 (main): the `revertString` method is called with the input string.
4. Line 5 (revertString): a variable `reverted` is initialized as an empty string.
5. Line 6 (revertString): a variable `count` of type int is initialized with 1.
6. Line 8 (revertString): a while loop runs until `count` reaches the length of the input string.
7. Line 9 (revertString): during each iteration, the (input length minus `count`) character of the input string is appended to the `reverted` variable.
8. Line 10 (revertString): during each iteration, the `count` variable is incremented by 1.
9. Line 13 (revertString): after the loop completes, the `reverted` string is returned. In this case, it will return "olumoR oiraM".
10. Line 23 (main): the output "Original: Mario Romulo" is printed to the console.
11. Line 24 (main): the output "Reverted: olumoR oiraM" is printed to the console.

## Table Test - Implementation 5

1. Line 16 (main): the DPK01Impl5 class is instantiated.
2. Line 17 (main): the input string "Mario Romulo" is defined.
3. Line 19 (main): the `revertString` method is called with the input string.
4. Line 5 (revertString): a variable `reverted` is initialized as an empty string.
5. Line 7 (revertString): a for loop iterates over the input string in reverse order, starting from length of input minus 1 to the 0.
6. Line 8 (revertString): during each iteration, the i-th character of the input string is appended to the `reverted` variable.
7. Line 11 (revertString): after the loop completes, the `reverted` string is returned. In this case, it will return "olumoR oiraM".
8. Line 21 (main): the output "Original: Mario Romulo" is printed to the console.
9. Line 22 (main): the output "Reverted: olumoR oiraM" is printed to the console.

## Table Test - Implementation 6

1. Line 17 (main): the DPK01Impl6 class is instantiated.
2. Line 18 (main): the input string "Mario Romulo" is defined.
3. Line 20 (main): the `revertString` method is called with the input string.
4. Line 5 (revertString): a variable `length` of type int is initialized with the length of the input string.
5. Line 6 (revertString): a variable `reverted` of type char array is initialized with the same length as the input string.
6. Line 8 (revertString): a for loop iterates over the input string, starting from zero to the length of the string.
7. Line 9 (revertString): during each iteration, the `length - i - 1` character of the input string is assigned to the i-th position in the array.
8. Line 12 (revertString): after the loop completes, a new string is created from the `reverted` char array and returned. In this case, it will return "olumoR oiraM".
9. Line 22 (main): the output "Original: Mario Romulo" is printed to the console.
10. Line 23 (main): the output "Reverted: olumoR oiraM" is printed to the console.

## Table Test - Implementation 7

1. Line 18 (main): the DPK01Impl7 class is instantiated.
2. Line 19 (main): the input string "Mario Romulo" is defined.
3. Line 21 (main): the `revertString` method is called with the input string.
4. Line 5 (revertString): a variable `length` of type int is initialized with the length of the input string.
5. Line 6 (revertString): a variable `lengthMinusOne` of type int is initialized with the value of `length` minus 1.
6. Line 7 (revertString): a variable `reverted` of type char array is initialized with the same length as the input string.
7. Line 9 (revertString): a for loop iterates over the input string, starting from 0 to the length of the string.
8. Line 10 (revertString): during each iteration, the `lengthMinusOne - i` character of the input string is assigned to the i-th position in the array.
9. Line 13 (revertString): after the loop completes, a new string is created from the `reverted` char array and returned. In this case, it will return "olumoR oiraM".
10. Line 23 (main): the output "Original: Mario Romulo" is printed to the console.
11. Line 24 (main): the output "Reverted: olumoR oiraM" is printed to the console.

## Table Test - Implementation 8

1. Line 22 (main): the DPK01Impl8 class is instantiated.
2. Line 23 (main): the input string "Mario Romulo" is defined.
3. Line 25 (main): the `revertString` method is called with the input string.
4. Line 5-7 (revertString): if the input string is null or its length is less than or equal to 1, it is returned as is. 
5. Line 9 (revertString): a variable `reverted` of type char array is initialized with the char array of the input string.
6. Line 11 (revertString): a for loop iterates over the array, starting from 0 to the length of the string divided by 2.
7. Line 12 (revertString): during each iteration, a viable `auxChar` of type char is initialized with the i-th character of the `reverted` array. 
8. Line 13 (revertString): during each iteration, the i-th position of the array is assigned the character at the `length - 1 - i` position.
9. Line 14 (revertString): during each iteration, the `length - 1 - i` position of the array is assigned the value of `auxChar`.
10. Line 17 (revertString): after the loop completes, a new string is created from the `reverted` char array and returned. In this case, it will return "olumoR oiraM".
11. Line 27 (main): the output "Original: Mario Romulo" is printed to the console.
12. Line 28 (main): the output "Reverted: olumoR oiraM" is printed to the console.

## Table Test - Implementation 9

1. Line 24 (main): the DPK01Impl9 class is instantiated.
2. Line 25 (main): the input string "Mario Romulo" is defined.
3. Line 27 (main): the `revertString` method is called with the input string.
4. Line 5-7 (revertString): if the input string is null or its length is less than or equal to 1, it is returned as is.
5. Line 9 (revertString): a variable `limit` of type int is initialized with the length of the input divided by 2.
6. Line 10 (revertString): a variable `lengthMinusOne` of type int is initialized with the value of input string length minus 1.
7. Line 11 (revertString): a variable `reverted` of type char array is initialized with the char array of the input string.
8. Line 13 (revertString): a for loop iterates over the array, starting from 0 to `limit`.
9. Line 14 (revertString): during each iteration, a viable `auxChar` of type char is initialized with the i-th character of the `reverted` array.
10. Line 15 (revertString): during each iteration, the i-th position of the array is assigned the character at the `lengthMinusOne - i` position.
11. Line 16 (revertString): during each iteration, the `lengthMinusOne - i` position of the array is assigned the value of `auxChar`.
12. Line 19 (revertString): after the loop completes, a new string is created from the `reverted` char array and returned. In this case, it will return "olumoR oiraM".
13. Line 29 (main): the output "Original: Mario Romulo" is printed to the console.
14. Line 30 (main): the output "Reverted: olumoR oiraM" is printed to the console.

## Table Test - Implementation 10

1. Line 24 (main): the DPK01Impl10 class is instantiated.
2. Line 25 (main): the input string "Mario Romulo" is defined.
3. Line 27 (main): the `revertString` method is called with the input string.
4. Line 5-7 (revertString): if the input string is null or its length is less than or equal to 1, it is returned as is.
5. Line 9 (revertString): a variable `begin` of type int is initialized with the length of the input divided by 2.
6. Line 10 (revertString): a variable `lengthMinusOne` of type int is initialized with the value of input string length minus 1.
7. Line 11 (revertString): a variable `reverted` of type char array is initialized with the char array of the input string.
8. Line 13 (revertString): a for loop iterates over the array, starting from `begin` to value of input string length.
9. Line 14 (revertString): during each iteration, a viable `auxChar` of type char is initialized with the i-th character of the `reverted` array.
10. Line 15 (revertString): during each iteration, the i-th position of the array is assigned the character at the `lengthMinusOne - i` position.
11. Line 16 (revertString): during each iteration, the `lengthMinusOne - i` position of the array is assigned the value of `auxChar`.
12. Line 19 (revertString): after the loop completes, a new string is created from the `reverted` char array and returned. In this case, it will return "olumoR oiraM".
13. Line 29 (main): the output "Original: Mario Romulo" is printed to the console.
14. Line 30 (main): the output "Reverted: olumoR oiraM" is printed to the console.

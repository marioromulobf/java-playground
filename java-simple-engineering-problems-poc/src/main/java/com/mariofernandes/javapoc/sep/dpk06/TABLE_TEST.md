# Problem
This is a table test for *DPK06 - Tokenizer*:

**Create a function that can tokenize a string based on a token.**
```
tokenize("Hello,World,How,Are,You", ",") -> ["Hello", "World", "How", "Are", "You"]
tokenize("Hello World How Are You", " ") -> ["Hello", "World", "How", "Are", "You"]
tokenize("Hello-World-How-Are-You", "-") -> ["Hello", "World", "How", "Are", "You"]
```
**Can you refactor your code and do that without using any prebuild function like split?**

## Table Test - Implementation 1

1. Line 25 (main): the DPK06Impl1 class is instantiated.
2. Line 27 (main): the tokenize method is called with the string "Hello,World,How,Are,You" and the token ",".
3. Line 9 (tokenize): a variable `startIndex` is initialized to 0.
4. Line 10 (tokenize): a variable `result` is initialized as an empty list.
5. Line 12 (tokenize): a for loop iterates through each character in the input data string.
6. Line 13 (tokenize): checks if the current character matches the input token.
7. Line 14 (tokenize): if a match is found, the substring from `startIndex` to the current index is added to the `result` list.
8. Line 15 (tokenize): `startIndex` is updated to the index after the current token.
9. Line 18 (tokenize): after the loop, the last substring from `startIndex` to the end of the string is added to the `result` list.
10. Line 20 (tokenize): the `result` list is returned, containing the tokenized strings.
11. Line 28 (main): the output of the tokenize method is printed, showing the list ["Hello", "World", "How", "Are", "You"].
12. Line 30 (main): the tokenize method is called again with the string "Hello World How Are You" and the token " ".
13. Line 31 (main): the output of the tokenize method is printed, showing the list ["Hello", "World", "How", "Are", "You"].
14. Line 33 (main): the tokenize method is called again with the string "Hello-World-How-Are-You" and the token "-".
15. Line 34 (main): the output of the tokenize method is printed, showing the list ["Hello", "World", "How", "Are", "You"].

## Table Test - Implementation 2

1. Line 30 (main): the DPK06Impl2 class is instantiated.
2. Line 32 (main): the tokenize method is called with the string "Hello,World,How,Are,You" and the token ",".
3. Line 9 (tokenize): a variable `result` is initialized as an empty list.
4. Line 10 (tokenize): checks if the input data string or input token is null or empty.
5. Line 11 (tokenize): if either is null or empty, an empty list is returned.
6. Line 15 (tokenize): a variable `start` is initialized to 0.
7. Line 17 (tokenize): a for loop iterates through each character in the input data string.
8. Line 18 (tokenize): checks if the current character matches the input token.
9. Line 19 (tokenize): if a match is found, the substring from `start` to the current index is added to the `result` list.
10. Line 20 (tokenize): `start` is updated to the index after the current token.
11. Line 23 (tokenize): after the loop, the last substring from `start` to the end of the string is added to the `result` list.
12. Line 25 (tokenize): the `result` list is returned, containing the tokenized strings.
13. Line 33 (main): the output of the tokenize method is printed, showing the list ["Hello", "World", "How", "Are", "You"].
14. Line 35 (main): the tokenize method is called again with the string "Hello World How Are You" and the token " ".
15. Line 36 (main): the output of the tokenize method is printed, showing the list ["Hello", "World", "How", "Are", "You"].
16. Line 38 (main): the tokenize method is called again with the string "Hello-World-How-Are-You" and the token "-".
17. Line 39 (main): the output of the tokenize method is printed, showing the list ["Hello", "World", "How", "Are", "You"].

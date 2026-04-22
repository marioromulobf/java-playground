# Problem
This is a table test for *DPK05 - Pointers*:

**Considering the following hash map:**
```
power = {
  "John": 100,
  "Paul": 90,
  "George": 80,
  "Ringo": 70
}
```
**Create three functions.**
1. Function one should return the power of a given person.
2. Function two should receive 2 names and the with one is the most powerful(should use function one).
3. Function three should receive 2 names and update the leaderboard.

**Now the third function that will update the leaderboard after all the matches. i.e Leaderboard should be:**
```
leaderboard = {
  "John": 0,
  "Paul": 0,
  "George": 0,
  "Ringo": 0
}
```
**Every time a play wins, he scores +10 points, if there is a draw, both players score +5 points. IF one player loses, he scores -5 points.**
```
play("John", "Paul") -> "John"
leaderboard -> {
  "John": 10,
  "Paul": -5,
  "George": 0,
  "Ringo": 0
}
```
**Let's do another round:**
```
play("John", "Ringo") -> "John"
leaderboard -> {
  "John": 20,
  "Paul": -5,
  "George": 0,
  "Ringo": -5
}
```
**Now can you refactor your code and do less ifs? Maybe introduce pointers?**

## Table Test - Implementation 1


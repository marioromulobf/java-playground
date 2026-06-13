# Problem
This is a table test for *DPK15 - OOP with Classes*:

**Create a class that can represent a person. The person should have a name, age and a list of friends.**
```
person = new Person("John", 30)
person.addFriend("Paul")
person.addFriend("George")
person.addFriend("Ringo")
```

**The person should have a method that can return the name of the person and the list of friends.**
```
person.getFriends() -> ["Paul", "George", "Ringo"]
```

**The person should have a method that can return the age.**
```
person.getAge() -> 30
```

**The person should have a method that can return the name of the person.**
```
person.getName() -> "John"
```
**Refactoring time:**
1. **Now could you refactor the code and move the list of friends to a separate class?**
2. **Refactor the code so you don't allow the same friend to be added twice.**
3. **Refactor the code so you can remove a friend from the list.**

**More Refactoring:**
1. **In one of your classes, could you create a method that tell who is the person with more friends?**
2. **In one of your classes, could you create a method that tell who is the person with less friends?**
3. **In one of your classes, could you create a method that tell who is the person with the oldest friend?**

## Table Test - Implementation 1

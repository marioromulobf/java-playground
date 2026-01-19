### Java Streams API POC

**Core Java - Streams API**

Demonstrates Java Streams API capabilities:
* **Lists**: Creating streams from List, ArrayList, Set
* **Arrays**: Creating streams from Arrays with Arrays.stream() and Stream.of()
* **Map**: Working with Map: map(), mapToInt(), mapToDouble(), mapToLong(), mapMulti(), flatMap()
* **Filter**: 
* **Predicates**: 
* **Supplier**: 
* **Consumer**: 
* **BinaryOperator**: 
* **UnaryOperator**: 

### Tech Stack
* Java 25 (LTS)
* Maven 3.x

### How to Build
```bash
mvn clean compile
```

### How to Run
```bash
mvn exec:java
```

Or run directly:
```bash
java -cp target/classes com.mariofernandes.javapoc.stream.Main
```

### Java Streams API POC

**Core Java - Streams API**

Demonstrates Java Streams API capabilities:
* **Lists**: Creating streams from List, ArrayList, Set
* **Arrays**: Creating streams from Arrays with Arrays.stream() and Stream.of()
* **Map**: Working with Map: map(), mapToInt(), mapToDouble(), mapToLong(), mapMulti(), flatMap()
* **Filter**: Working with Filter: filter(), findFirst(), findAny() 
* **Predicates**: Working with Predicates: and(), or(), negate()
* **Supplier**: Working with Supplier on generate(), collect()
* **Consumer**: Working with BiConsumer on mapMult(), mapMultiToDouble(), mapMultiToInt(), mapMultiToLong()
* **BinaryOperator**: Working with BinaryOperator on reduce()
* **UnaryOperator**: Working with UnaryOperator on Stream.iterate()

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

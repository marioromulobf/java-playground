### Java Functional Interfaces POC

**Core Java - Functional Interfaces**

Demonstrates Java Functional Interfaces capabilities:
* **Built-in Interfaces**: Predicate, Function, Consumer, Supplier, BiFunction, UnaryOperator, BinaryOperator
* **Primitive Specializations**: IntPredicate, IntFunction, IntConsumer, etc.
* **Method References**: Static, instance, constructor references
* **Custom Interfaces**: Creating and using custom functional interfaces
* **Real-world Usage**: Streams API, Comparators, chaining operations

### Project Structure
- **Main.java** - Complete demonstrations of all functional interface types
- **StringProcessor.java** - Custom functional interface for string operations
- **Calculator.java** - Custom functional interface for mathematical operations

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
java -cp target/classes com.mariofernandes.javapoc.functional.Main
```

### What it demonstrates

#### 1. Predicate<T> - Test Conditions
```java
Predicate<String> isEmpty = String::isEmpty;
Predicate<Integer> isEven = n -> n % 2 == 0;

// Combining predicates
Predicate<Integer> isPositiveEven = isEven.and(n -> n > 0);
boolean result = isPositiveEven.test(4);
```

#### 2. Function<T, R> - Transform Data
```java
Function<String, Integer> stringLength = String::length;
Function<String, String> toUpper = String::toUpperCase;

// Chaining functions
Function<String, String> trimAndUpper = 
    String::trim.andThen(String::toUpperCase);
```

#### 3. Consumer<T> - Perform Actions
```java
Consumer<String> printer = System.out::println;
printer.accept("Hello");

// Chaining consumers
Consumer<String> combined = printer.andThen(s -> logToFile(s));
```

#### 4. Supplier<T> - Provide Values
```java
Supplier<Double> random = Math::random;
Supplier<String> uuid = () -> UUID.randomUUID().toString();

Double value = random.get();
```

#### 5. BiFunction<T, U, R> - Two Input Transform
```java
BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
BiFunction<String, Integer, String> repeat = (s, n) -> s.repeat(n);

int sum = add.apply(5, 3);
```

#### 6. UnaryOperator<T> - Same Type Transform
```java
UnaryOperator<Integer> square = n -> n * n;
UnaryOperator<String> toUpper = String::toUpperCase;

// Use with List.replaceAll()
list.replaceAll(String::toUpperCase);
```

#### 7. BinaryOperator<T> - Combine Two Same Type
```java
BinaryOperator<Integer> max = Math::max;
BinaryOperator<String> concat = (s1, s2) -> s1 + s2;

// Use with Stream.reduce()
int sum = numbers.stream().reduce(0, (a, b) -> a + b);
```

#### 8. Primitive Specializations
```java
// Avoid boxing/unboxing overhead
IntPredicate isEven = n -> n % 2 == 0;
IntFunction<String> intToString = i -> "Number: " + i;
IntConsumer printer = System.out::println;
IntSupplier random = () -> (int) (Math.random() * 100);
IntUnaryOperator square = n -> n * n;
IntBinaryOperator add = (a, b) -> a + b;
```

#### 9. Method References
```java
// Static method
Function<String, Integer> parseInt = Integer::parseInt;

// Instance method of particular object
String prefix = "Hello ";
Function<String, String> addPrefix = prefix::concat;

// Instance method of arbitrary object
Function<String, String> toUpper = String::toUpperCase;

// Constructor
Supplier<ArrayList<String>> listSupplier = ArrayList::new;
BiFunction<String, Integer, Person> personCreator = Person::new;
```

#### 10. Custom Functional Interfaces
```java
@FunctionalInterface
public interface StringProcessor {
    String process(String input);
    
    default StringProcessor andThen(StringProcessor after) {
        return input -> after.process(this.process(input));
    }
    
    static StringProcessor trim() {
        return String::trim;
    }
}

// Usage
StringProcessor pipeline = StringProcessor.trim()
    .andThen(String::toUpperCase);
String result = pipeline.process("  hello  ");
```

#### 11. Streams API Integration
```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

List<String> result = names.stream()
    .filter(s -> s.length() > 3)      // Predicate
    .map(String::toUpperCase)          // Function
    .collect(Collectors.toList());

names.forEach(System.out::println);    // Consumer
```

#### 12. Comparators
```java
List<Person> people = Arrays.asList(...);

// Sort by age
people.sort(Comparator.comparing(Person::getAge));

// Sort by age, then name
people.sort(
    Comparator.comparing(Person::getAge)
             .thenComparing(Person::getName)
);

// Reversed
people.sort(Comparator.comparing(Person::getAge).reversed());
```

### Key Concepts

**Functional Interface Rules:**
- Exactly ONE abstract method (SAM - Single Abstract Method)
- Can have multiple default methods
- Can have multiple static methods
- Can inherit from Object methods (toString, equals, hashCode)
- `@FunctionalInterface` annotation is optional but recommended

**Lambda Expression Syntax:**
```java
// No parameters
() -> expression
() -> { statements; }

// One parameter (parentheses optional)
x -> expression
x -> { statements; }

// Multiple parameters
(x, y) -> expression
(x, y) -> { statements; }

// Type inference
(String x, Integer y) -> expression
```

**Method Reference Types:**
1. **Static method**: `ClassName::staticMethod`
2. **Instance method of particular object**: `object::instanceMethod`
3. **Instance method of arbitrary object**: `ClassName::instanceMethod`
4. **Constructor**: `ClassName::new`

**Chaining Operations:**
- `Predicate`: `and()`, `or()`, `negate()`
- `Function`: `andThen()`, `compose()`
- `Consumer`: `andThen()`
- `Comparator`: `thenComparing()`, `reversed()`

### Built-in Functional Interfaces Summary

| Interface | Method | Input | Output | Use Case |
|-----------|--------|-------|--------|----------|
| `Predicate<T>` | `test(T)` | T | boolean | Filtering/testing |
| `Function<T,R>` | `apply(T)` | T | R | Transformation |
| `Consumer<T>` | `accept(T)` | T | void | Side effects |
| `Supplier<T>` | `get()` | - | T | Factory/generation |
| `BiFunction<T,U,R>` | `apply(T,U)` | T, U | R | Two-input transform |
| `UnaryOperator<T>` | `apply(T)` | T | T | Same type transform |
| `BinaryOperator<T>` | `apply(T,T)` | T, T | T | Combine two values |
| `BiPredicate<T,U>` | `test(T,U)` | T, U | boolean | Two-input test |
| `BiConsumer<T,U>` | `accept(T,U)` | T, U | void | Two-input action |

### Primitive Specializations

For `int`, `long`, and `double` to avoid boxing:
- `IntPredicate`, `LongPredicate`, `DoublePredicate`
- `IntFunction<R>`, `IntToLongFunction`, `IntToDoubleFunction`
- `IntConsumer`, `LongConsumer`, `DoubleConsumer`
- `IntSupplier`, `LongSupplier`, `DoubleSupplier`
- `IntUnaryOperator`, `LongUnaryOperator`, `DoubleUnaryOperator`
- `IntBinaryOperator`, `LongBinaryOperator`, `DoubleBinaryOperator`
- `ToIntFunction<T>`, `ToLongFunction<T>`, `ToDoubleFunction<T>`

### Common Patterns

**1. Filtering Collections:**
```java
list.stream()
    .filter(predicate)
    .collect(Collectors.toList());
```

**2. Transforming Collections:**
```java
list.stream()
    .map(function)
    .collect(Collectors.toList());
```

**3. Reducing Collections:**
```java
list.stream()
    .reduce(identity, binaryOperator);
```

**4. Lazy Evaluation:**
```java
Supplier<ExpensiveObject> lazy = () -> new ExpensiveObject();
// Only created when get() is called
ExpensiveObject obj = lazy.get();
```

**5. Chaining Operations:**
```java
Function<String, String> pipeline = 
    String::trim
    .andThen(String::toUpperCase)
    .andThen(s -> s.replaceAll("\\s+", ""));
```

### Benefits

1. **Concise Code** - Less boilerplate than anonymous classes
2. **Functional Programming** - First-class functions in Java
3. **Lazy Evaluation** - Deferred execution with Supplier
4. **Composability** - Chain operations together
5. **Streams Integration** - Powers modern collection processing
6. **Type Safety** - Compile-time type checking
7. **Readability** - Clear, declarative code
8. **Reusability** - Define once, use multiple times

### Performance Note

**Primitive specializations** avoid boxing/unboxing overhead:
```java
// Slower (boxing)
Function<Integer, Integer> square = n -> n * n;

// Faster (no boxing)
IntUnaryOperator square = n -> n * n;
```

### Common Use Cases

- **Stream Operations** - filter, map, reduce, forEach
- **Event Handling** - Button clicks, listeners
- **Callbacks** - Asynchronous operations
- **Strategy Pattern** - Pluggable behavior
- **Template Method** - Customizable algorithms
- **Dependency Injection** - Provide dependencies
- **Lazy Initialization** - Defer expensive operations
- **Validation** - Complex validation rules
- **Sorting/Comparing** - Custom sort orders

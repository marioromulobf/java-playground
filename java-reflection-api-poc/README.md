### Java Reflection API POC

**Core Java - Reflection API**

Demonstrates the Java Reflection API capabilities:
* **Read**: Inspecting classes, fields, methods, and constructors at runtime
* **Invoke**: Dynamically calling methods and creating instances
* **Modify**: Changing field values and accessing private members

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
java -cp target/classes com.mariofernandes.javapocs.Main
```

### What it demonstrates

#### 1. Read - Class Information
```java
Class<?> clazz = Class.forName("com.example.Person");
System.out.println("Class Name: " + clazz.getName());
System.out.println("Package: " + clazz.getPackage().getName());
System.out.println("Superclass: " + clazz.getSuperclass().getName());
```

#### 2. Read - Fields
```java
// Get all public fields
Field[] publicFields = clazz.getFields();

// Get all declared fields (including private)
Field[] allFields = clazz.getDeclaredFields();

// Get specific field
Field field = clazz.getDeclaredField("name");
```

#### 3. Read - Methods
```java
// Get all public methods
Method[] publicMethods = clazz.getMethods();

// Get all declared methods (including private)
Method[] allMethods = clazz.getDeclaredMethods();

// Get specific method
Method method = clazz.getMethod("getName");
```

#### 4. Read - Constructors
```java
// Get all constructors
Constructor<?>[] constructors = clazz.getDeclaredConstructors();

// Get specific constructor
Constructor<?> constructor = clazz.getConstructor(String.class, int.class);
```

#### 5. Invoke - Methods
```java
Object obj = clazz.getDeclaredConstructor().newInstance();
Method method = clazz.getMethod("setName", String.class);
method.invoke(obj, "John");
```

#### 6. Invoke - Constructors
```java
// Using default constructor
Constructor<?> constructor = clazz.getConstructor();
Object instance = constructor.newInstance();

// Using parameterized constructor
Constructor<?> paramConstructor = clazz.getConstructor(String.class, int.class);
Object instance2 = paramConstructor.newInstance("Alice", 30);
```

#### 7. Modify - Field Values
```java
Field field = clazz.getDeclaredField("name");
field.setAccessible(true);
field.set(obj, "New Value");
Object value = field.get(obj);
```

#### 8. Modify - Private Members
```java
// Access private field
Field privateField = clazz.getDeclaredField("privateField");
privateField.setAccessible(true);
privateField.set(obj, "value");

// Invoke private method
Method privateMethod = clazz.getDeclaredMethod("privateMethod");
privateMethod.setAccessible(true);
Object result = privateMethod.invoke(obj);
```

### Key Concepts

**Class Object**: Entry point for reflection
```java
Class<?> clazz1 = Class.forName("com.example.MyClass");
Class<?> clazz2 = MyClass.class;
Class<?> clazz3 = obj.getClass();
```

**Field Access**: Read and modify field values
- `getFields()` - public fields only
- `getDeclaredFields()` - all fields (including private)
- `setAccessible(true)` - access private members

**Method Invocation**: Call methods dynamically
- `getMethods()` - public methods
- `getDeclaredMethods()` - all methods
- `invoke(object, args)` - execute method

**Constructor Access**: Create instances dynamically
- `getConstructors()` - public constructors
- `getDeclaredConstructors()` - all constructors
- `newInstance(args)` - create object

**Modifiers**: Check access modifiers
- `Modifier.isPublic()`
- `Modifier.isPrivate()`
- `Modifier.isStatic()`
- `Modifier.isFinal()`

### Security Considerations

⚠️ **Important Notes:**
- Reflection bypasses normal access controls
- Use `setAccessible(true)` with caution
- May break encapsulation
- Can have performance overhead
- Not all operations work in restricted security environments
- Modifying final fields is not recommended

### Common Use Cases

- **Frameworks**: Spring, Hibernate use reflection for dependency injection and ORM
- **Testing**: JUnit uses reflection to discover and run tests
- **Serialization**: JSON/XML libraries inspect objects
- **Dependency Injection**: IoC containers wire dependencies
- **Plugin Systems**: Load and instantiate classes dynamically
- **ORMs**: Map objects to database tables

### Performance Note

Reflection is slower than direct code execution. Cache reflected objects when possible:
```java
// Cache Method objects
private static final Method cachedMethod = MyClass.class.getMethod("myMethod");
```
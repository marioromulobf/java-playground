package com.mariofernandes.javapoc.reflection;

import java.lang.reflect.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException,
            NoSuchMethodException, InstantiationException, NoSuchFieldException {
        // 1. READ - Class Info
        System.out.println("=== CLASS INFORMATION ===");
        readClassInformation();
        System.out.println("\n=========================");

        // 2. READ - Fields
        System.out.println("=== FIELDS ===");
        readFields();
        System.out.println("\n=========================");

        // 3. READ - Methods
        System.out.println("=== METHODS ===");
        readMethods();
        System.out.println("\n=========================");

        // 4. READ - Constructors
        System.out.println("=== CONSTRUCTORS ===");
        readConstructors();
        System.out.println("\n=========================");

        // 5. INVOKE - Methods
        System.out.println("=== INVOKE METHODS ===");
        invokeMethods();
        System.out.println("\n=========================");

        // 6. INVOKE - Constructors
        System.out.println("=== INVOKE CONSTRUCTORS ===");
        invokeConstructors();
        System.out.println("\n=========================");

        // 7. MODIFY - Fields
        System.out.println("=== MODIFY FIELDS ===");
        modifyFields();
        System.out.println("\n=========================");

        // 8. MODIFY - Private Members
        System.out.println("=== MODIFY PRIVATE MEMBERS ===");
        accessPrivateMembers();
        System.out.println("\n=========================");
    }

    private static void readClassInformation() {
        Class<?> personClass = Person.class;

        // Extract basic info
        System.out.println("Class Name: " + personClass.getName());
        System.out.println("Package: " + personClass.getPackage().getName());
        System.out.println("Superclass: " + personClass.getSuperclass().getName());

        // Check modifiers
        System.out.println("Is Interface: " + personClass.isInterface());
        System.out.println("Is Abstract: " + Modifier.isAbstract(personClass.getModifiers()));
    }

    private static void readFields() {
        Class<?> personClass = Person.class;

        // Get all public fields (including inherited)
        System.out.println("\nPublic Fields:");
        Field[] publicFields = personClass.getFields();
        for (var field : publicFields) {
            String modifiers = Modifier.toString(field.getModifiers());
            System.out.println(" - " + modifiers + " : " + field.getName() + " : " + field.getType().getName());
        }

        // Get all declared fields (including private)
        System.out.println("\nAll Declared Fields:");
        Field[] allFields = personClass.getDeclaredFields();
        for (var field : allFields) {
            String modifiers = Modifier.toString(field.getModifiers());
            System.out.println(" - " + modifiers + " : " + field.getName() + " : " + field.getType().getName());
        }
    }

    private static void readMethods() {
        Class<?> personClass = Person.class;

        // Get all public methods (including inherited)
        System.out.println("\nPublic Methods:");
        Method[] publicMethods = personClass.getMethods();
        for (var method : publicMethods) {
            String params = Arrays.toString(method.getParameterTypes());
            System.out.println(" - " + method.getName()
                    + " : " + params + " : " + method.getReturnType().getSimpleName()
                    + " : " + (method.getDeclaringClass() == Person.class));
        }

        // Get all declared methods (including private)
        System.out.println("\nAll Declared Methods:");
        Method[] allMethods = personClass.getDeclaredMethods();
        for (var method : allMethods) {
            String params = Arrays.toString(method.getParameterTypes());
            System.out.println(" - " + method.getName()
                    + " : " + params + " : " + method.getReturnType().getSimpleName()
                    + " : " + (method.getDeclaringClass() == Person.class));
        }
    }

    private static void readConstructors() {
        Class<?> personClass = Person.class;

        // Get all public constructors
        System.out.println("\nPublic Constructors:");
        var publicConstructors = personClass.getConstructors();
        for (var constructor : publicConstructors) {
            String params = Arrays.toString(constructor.getParameterTypes());
            System.out.println(" - " + constructor.getName() + " : " + params);
        }

        // Get all declared constructors (including private)
        System.out.println("\nAll Declared Constructors:");
        var allConstructors = personClass.getDeclaredConstructors();
        for (var constructor : allConstructors) {
            String params = Arrays.toString(constructor.getParameterTypes());
            System.out.println(" - " + constructor.getName() + " : " + params);
        }
    }

    private static void invokeMethods() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Person personInstance = new Person("Bob", 25);
        Class<?> personClass = Person.class;

        // Invoke public method getName
        Method getNameMethod = personClass.getMethod("getName");
        String modifiers = Modifier.toString(getNameMethod.getModifiers());
        String name = (String) getNameMethod.invoke(personInstance);
        System.out.println("\nInvoked " + modifiers + " getName(): " + name);

        // Invoke public method setName
        Method setNameMethod = personClass.getMethod("setName", String.class);
        modifiers = Modifier.toString(setNameMethod.getModifiers());
        setNameMethod.invoke(personInstance, "Alice");
        System.out.println("Invoked " + modifiers + " setName(\"Alice\")");

        // Invoke private method getSecretInfo
        Method getSecretInfoMethod = personClass.getDeclaredMethod("getSecretInfo");
        modifiers = Modifier.toString(getSecretInfoMethod.getModifiers());
        getSecretInfoMethod.setAccessible(true); // Bypass private access
        String secret = (String) getSecretInfoMethod.invoke(personInstance);
        System.out.println("Invoked " + modifiers + " getSecretInfo(): " + secret);

        // Invoke public static method getPersonCount
        Method getPersonCountMethod = personClass.getMethod("getPersonCount");
        modifiers = Modifier.toString(getPersonCountMethod.getModifiers());
        int count = (int) getPersonCountMethod.invoke(null);
        System.out.println("Invoked " + modifiers + " getPersonCount(): " + count);
    }

    private static void invokeConstructors() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> personClass = Person.class;
        // Invoke public no-arg constructor
        Constructor<?> defaultConstructor = personClass.getConstructor();
        String modifiers = Modifier.toString(defaultConstructor.getModifiers());
        Person person1 = (Person) defaultConstructor.newInstance();
        System.out.println("\nInvoked " + modifiers + " constructor(): " + person1.getId() + ", " + person1.getName()
                + ", " + person1.getAge() + ", " + Person.getPersonCount());

        // Invoke public parameterized constructor
        var paramConstructor = personClass.getConstructor(String.class, int.class);
        modifiers = Modifier.toString(paramConstructor.getModifiers());
        Person person2 = (Person) paramConstructor.newInstance("Charlie", 28);
        System.out.println("Invoked " + modifiers + " constructor(String, int): " + person2.getId() + ", "
                + person2.getName() + ", " + person2.getAge() + ", " + Person.getPersonCount());

        // Invoke private constructor
        var privateConstructor = personClass.getDeclaredConstructor(String.class, int.class, String.class);
        modifiers = Modifier.toString(privateConstructor.getModifiers());
        privateConstructor.setAccessible(true); // Bypass private access
        Person person3 = (Person) privateConstructor.newInstance("Dave", 35, "dave@davemail.com");
        System.out.println("Invoked " + modifiers + " constructor(String, int, String): " + person3.getId() + ", "
                + person3.getName() + ", " + person3.getAge() + ", " + Person.getPersonCount());
    }

    private static void modifyFields() throws NoSuchFieldException, IllegalAccessException {
        Person personInstance = new Person("Eve", 22);
        Class<?> personClass = Person.class;

        // Access and modify public field 'publicField'
        Field publicFieldField = personClass.getField("publicField");
        String modifiers = Modifier.toString(publicFieldField.getModifiers());
        System.out.println("\nBefore modification: " + personInstance.publicField);
        publicFieldField.set(personInstance, "Modified public field");
        System.out.println("After modification via " + modifiers + " field 'publicField': " + personInstance.publicField);

        // Access and modify private field 'name'
        Field nameField = personClass.getDeclaredField("name");
        modifiers = Modifier.toString(nameField.getModifiers());
        nameField.setAccessible(true); // Bypass private access
        System.out.println("Before modification: " + personInstance.getName());
        nameField.set(personInstance, "Evelyn");
        System.out.println("After modification via " + modifiers + " field 'name': " + personInstance.getName());
    }

    private static void accessPrivateMembers() throws IllegalAccessException, NoSuchFieldException {
        Person personInstance = new Person("Frank", 40);
        Class<?> personClass = Person.class;

        // Access and modify private final field 'id'
        Field idField = personClass.getDeclaredField("id");
        String modifiers = Modifier.toString(idField.getModifiers());
        idField.setAccessible(true); // Bypass private access
        System.out.println("\nAccessing " + modifiers + " field 'id': " + idField.get(personInstance));
        // Note: Modifying a final field is not recommended and may not work as expected
        idField.set(personInstance, "NEW-ID-12345"); // This line is commented out intentionally
        System.out.println("After modification " + modifiers + " field 'id': " + idField.get(personInstance));

        // Access and modify static field 'personCount'
        Field personCountField = personClass.getDeclaredField("personCount");
        modifiers = Modifier.toString(personCountField.getModifiers());
        personCountField.setAccessible(true); // Bypass private access
        System.out.println("Before modification: " + Person.getPersonCount());
        personCountField.set(null, 100); // Static field, so instance is null
        System.out.println("After modification via " + modifiers + " static field 'personCount': " + Person.getPersonCount());
    }
}

## Java Properties API POC

**Core Java - Properties API**

Demonstrates the Java Properties API capabilities:
* **Create**: Creating and populating Properties objects
* **Store**: Saving properties to files with comments (standard and XML formats)
* **Read**: Loading properties from files (standard and XML formats)
* **System**: Working with System Properties

### Tech Stack
* Java 25 (LTS)
* Maven 3.x

### How to Build
``` bash
mvn clean compile
```

### How to Run
``` bash
 mvn exec:java -Dexec.mainClass="com.mariofernandes.javapoc.Main"
```

#### Or run directly:
``` bash
java -cp target/classes com.mariofernandes.javapoc.Main
```

### What it demonstrates
#### 1. Creating Properties
``` java
Properties props = new Properties();
props.setProperty("app.name", "Properties POC");
props.setProperty("app.version", "1.0.0");
```

#### 2. Storing Properties
Saves properties to `.properties` file:
``` java
props.store(new FileOutputStream("app.properties"), "Comments");
```

Saves properties to XML format:
``` java
props.storeToXML(new FileOutputStream("app.xml"), "XML Config", "UTF-8");
```

#### 3. Reading Properties
``` java
Properties props = new Properties();
props.load(new FileInputStream("app.properties"));
String value = props.getProperty("key", "defaultValue");
```

Loading from XML:
``` java
props.loadFromXML(new FileInputStream("app.xml"));
```

#### 4. System Properties
``` java
System.getProperty("java.version");
System.getProperty("user.home");
System.setProperty("custom.key", "custom.value");
Properties sysProps = System.getProperties();
```

### Generated Files

After running, you'll see:

* `application.properties` - Standard properties file
* `application.xml` - XML format properties file

### Key Concepts

* Properties are String key-value pairs
* Support for comments in files
* Default values for missing properties
* Multiple iteration methods
* Both standard and XML formats
* Integration with System properties

```
This README provides:
- Clear description of what the POC demonstrates
- Tech stack information (Java 25 LTS + Maven)
- Build and run instructions
- Code examples for each feature
- Information about generated files
- Key concepts covered
```

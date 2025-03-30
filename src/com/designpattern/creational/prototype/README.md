### **Prototype Pattern**

The **Prototype Pattern** is a **creational design pattern** that allows cloning of existing objects instead of creating new instances from scratch. This is useful when object creation is costly or complex.

---

### **Problem with Naïve Approach**
Imagine we have a **Document** class that has multiple attributes, such as title, content, and formatting style. Suppose we need to create multiple similar documents with minor modifications.

#### **Naïve Approach: Creating Objects from Scratch**
We might do something like this:

```java
class Document {
    private String title;
    private String content;
    private String formatting;

    public Document(String title, String content, String formatting) {
        this.title = title;
        this.content = content;
        this.formatting = formatting;
    }

    public void display() {
        System.out.println("Title: " + title + ", Content: " + content + ", Formatting: " + formatting);
    }
}

public class Main {
    public static void main(String[] args) {
        Document doc1 = new Document("Report", "This is a report", "Bold");
        Document doc2 = new Document("Report", "This is a report", "Bold"); // Duplicate effort
        doc1.display();
        doc2.display();
    }
}
```

### **Problems with This Approach**
1. **Inefficient:** We create new objects even when existing ones are nearly identical.
2. **Error-prone:** Manually copying attributes increases the chance of mistakes.
3. **Performance Overhead:** If the object creation involves database calls or complex processing, it becomes **slow** and **costly**.

---

### **Solution: Using Prototype Pattern**
The **Prototype Pattern** allows us to create a copy of an existing object using the **clone()** method.

#### **How Prototype Solves the Problem**
- **Avoids reinitialization**: Instead of recreating an object from scratch, we duplicate an existing one.
- **Performance boost**: Reduces object creation cost.
- **Less error-prone**: Ensures consistent object duplication.

#### **Implementation in Java**
Let's modify our **Document** class to implement `Cloneable`.

```java
// Step 1: Implement Cloneable Interface
class Document implements Cloneable {
    private String title;
    private String content;
    private String formatting;

    public Document(String title, String content, String formatting) {
        this.title = title;
        this.content = content;
        this.formatting = formatting;
    }

    // Step 2: Implement clone() method
    @Override
    public Document clone() {
        try {
            return (Document) super.clone(); // Shallow copy
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone not supported", e);
        }
    }

    public void display() {
        System.out.println("Title: " + title + ", Content: " + content + ", Formatting: " + formatting);
    }

    // Setters for modifying cloned object
    public void setTitle(String title) {
        this.title = title;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create original document
        Document original = new Document("Report", "This is a report", "Bold");

        // Clone the document instead of creating a new one
        Document copy = original.clone();
        copy.setTitle("Summary Report"); // Modify the cloned object

        // Display both
        original.display();
        copy.display();
    }
}
```

### **Advantages of Prototype Pattern**
✅ **Avoids expensive object creation**  
✅ **Easier to modify without affecting original object**  
✅ **Reduces memory usage when creating similar objects**

---

### **Real-World Use Case: Game Character Cloning**
Imagine a game where **multiple enemy NPCs** have the same base attributes but different names or weapons. Instead of creating each NPC from scratch, we can use the **Prototype Pattern** to clone a base enemy and modify it slightly.

Would you like me to demonstrate that as well? 🚀
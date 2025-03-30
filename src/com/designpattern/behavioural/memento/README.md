The Memento Pattern is a behavioral design pattern used in software development to provide the ability to restore an object to its previous state. It is especially useful for implementing undo/redo functionality without exposing the internal details of the objects involved.

### Naive Approach
In a naive approach to implement undo/redo functionality, you might directly expose and manipulate the internal state of an object. For example, you might save copies of the entire object state whenever changes occur. This approach can lead to several problems:

1. **Encapsulation Breach**: Direct manipulation of an object's internal state breaks encapsulation, which can lead to code that is difficult to maintain and error-prone.
2. **Inefficiency**: Storing entire objects can be memory inefficient, especially if only a small part of the state changes.
3. **Complexity**: Managing multiple copies of object states can become complex and error-prone.

### Memento Pattern Solution
The Memento Pattern addresses these issues by encapsulating the state of the object to be restored inside a "Memento" object. The main object (originator) creates a memento of its current state and can restore its state from a memento when needed. This keeps the internal state private and maintains encapsulation.

### Real-World Scenario
Consider a text editor that allows users to type text and undo their changes. Using the Memento Pattern, the editor can save snapshots of the text at various points without exposing the text's underlying representation.

#### Memento Pattern Implementation in Java

```java
// Memento class
class TextEditorMemento {
    private final String text;

    public TextEditorMemento(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

// Originator class
class TextEditor {
    private String text = "";

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public TextEditorMemento save() {
        return new TextEditorMemento(text);
    }

    public void restore(TextEditorMemento memento) {
        this.text = memento.getText();
    }
}

// Caretaker class
class Caretaker {
    private List<TextEditorMemento> mementos = new ArrayList<>();

    public void addMemento(TextEditorMemento memento) {
        mementos.add(memento);
    }

    public TextEditorMemento getMemento(int index) {
        return mementos.get(index);
    }
}

// Usage example
public class MementoPatternDemo {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Caretaker caretaker = new Caretaker();

        editor.setText("Version 1");
        caretaker.addMemento(editor.save());

        editor.setText("Version 2");
        caretaker.addMemento(editor.save());

        editor.setText("Version 3");

        // Undo to Version 2
        editor.restore(caretaker.getMemento(1));
        System.out.println("Current Text: " + editor.getText());

        // Undo to Version 1
        editor.restore(caretaker.getMemento(0));
        System.out.println("Current Text: " + editor.getText());
    }
}
```

### How Memento Solves the Problem
- **Encapsulation**: The Memento Pattern maintains encapsulation by not exposing the internal state directly.
- **Efficiency**: Only the necessary state is stored in the memento, which can be more efficient than storing entire objects.
- **Simplification**: It simplifies the process of undo/redo by managing state changes in a controlled manner.

### Notes
- **Memory Use**: Care should be taken regarding memory usage when storing many mementos.
- **State Management**: The originator should manage what state is captured and restored through the memento.


Integrating the `addMemento` method inside the `save` method of the `TextEditor` class could simplify the process by automatically saving the state whenever a save operation is performed. However, there are reasons for keeping them separate:

### Separation of Concerns
1. **Single Responsibility**: By keeping the `save` method responsible only for creating a memento, and the `addMemento` method for adding it to the caretaker, each method has a single responsibility. This adheres to the Single Responsibility Principle, making the code easier to maintain and understand.

2. **Flexibility**: Separating these operations provides more flexibility. The application can decide when and whether to store a memento. For example, it might choose to save only certain states or limit the number of saved states to optimize memory usage.

3. **Control**: It gives more control over how and where mementos are stored. The developer can implement different strategies for managing the history of states, such as limiting the number of mementos or selectively saving states based on specific criteria.

### Implementation Consideration
If you still want to integrate the `addMemento` within the `save` method, you would need to pass a reference of the `Caretaker` to the `TextEditor`, which may create tighter coupling between these classes. Here's how it could look:

```java
class TextEditor {
    private String text = "";
    private Caretaker caretaker;

    public TextEditor(Caretaker caretaker) {
        this.caretaker = caretaker;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void save() {
        TextEditorMemento memento = new TextEditorMemento(text);
        caretaker.addMemento(memento);
    }

    public void restore(TextEditorMemento memento) {
        this.text = memento.getText();
    }
}

// Usage example
public class MementoPatternDemo {
    public static void main(String[] args) {
        Caretaker caretaker = new Caretaker();
        TextEditor editor = new TextEditor(caretaker);

        editor.setText("Version 1");
        editor.save();

        editor.setText("Version 2");
        editor.save();

        editor.setText("Version 3");

        // Undo to Version 2
        editor.restore(caretaker.getMemento(1));
        System.out.println("Current Text: " + editor.getText());

        // Undo to Version 1
        editor.restore(caretaker.getMemento(0));
        System.out.println("Current Text: " + editor.getText());
    }
}
```

### Considerations
- **Coupling**: Integrating the `addMemento` function inside `save` increases coupling between the `TextEditor` and `Caretaker`, which might reduce modularity and flexibility.
- **Use Case Specificity**: The decision to integrate these functions should be guided by the specific needs and constraints of the application being developed. For applications where states are always saved immediately, this integration might simplify the code.
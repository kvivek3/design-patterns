In the Flyweight Pattern, the handling of intrinsic and extrinsic states is crucial for minimizing memory usage and ensuring efficient object management. Let's clarify how these states are managed:

### Intrinsic State

- **Storage Location**: The intrinsic state is stored within the flyweight class itself. In the context of the text editor example, this would be the `Character` class, which implements the `CharacterFlyweight` interface.
- **Purpose**: These are the shared properties common to many instances, such as font type, font style, and possibly font size and color if they don't change frequently.
- **Benefits**: By storing these properties in the flyweight objects, you can share them across multiple character instances, reducing redundant storage.

### Extrinsic State

- **Storage Location**: The extrinsic state is not stored within the flyweight class. Instead, it is passed to the flyweight object whenever it's needed. This is typically done when the object is used or displayed.
- **Purpose**: These are the unique properties that differ between instances, such as the position of a character in the document or its specific color if it varies frequently.
- **Usage**: In the `CharacterFlyweight` interface (and implemented in `Character`), methods like `display()` take extrinsic states as parameters. This allows the flyweight to be used flexibly without holding unnecessary data internally.

### Implementation Details

In the Java implementation provided:

- **Intrinsic State in `Character` Class**:
  ```java
  class Character implements CharacterFlyweight {
      private final char symbol; // Example of intrinsic state
      // Additional intrinsic properties like font, style could be added here
  }
  ```

- **Extrinsic State Passed via Method**:
  ```java
  @Override
  public void display(int size, String color) { // Extrinsic state passed here
      System.out.println("Character: " + symbol + ", Size: " + size + ", Color: " + color);
  }
  ```

In summary, the intrinsic state is stored within the flyweight objects to share common data efficiently, while the extrinsic state is passed to these objects as needed, keeping the flyweight objects lightweight and reusable. This separation allows the Flyweight Pattern to reduce memory usage and improve performance in scenarios with many similar objects.
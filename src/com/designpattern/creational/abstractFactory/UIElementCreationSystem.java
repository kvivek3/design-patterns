package com.designpattern.creational.abstractFactory;


interface Button {
    void click();
}
interface Checkbox {
    void check();
}

class MacButton implements Button {

    @Override
    public void click() {
        System.out.println("Mac Button Clicked");
    }
}
class WindowsButton implements Button {

    @Override
    public void click() {
        System.out.println("Windows Button Clicked");
    }
}

class MacCheckbox implements Checkbox {

    @Override
    public void check() {
        System.out.println("Mac check box checked");
    }
}

class WindowsCheckbox implements Checkbox {

    @Override
    public void check() {
        System.out.println("windows check box checked");
    }
}
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

class WindowsFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

class MacFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory guiFactory) {
        button = guiFactory.createButton();
        checkbox = guiFactory.createCheckbox();
    }
    public void run() {
        button.click();
        checkbox.check();
    }
}
public class UIElementCreationSystem {

    public static void main(String[] args) {

        GUIFactory factory = null;
        String osType = "Windows";
        
        if(osType.equalsIgnoreCase("WINDOWS")) {
            factory = new WindowsFactory();
        }
        else if(osType.equalsIgnoreCase("MAC"))
        {
            factory = new MacFactory();
        }
            
        Application application = new Application(factory);
        application.run();
    }
}
